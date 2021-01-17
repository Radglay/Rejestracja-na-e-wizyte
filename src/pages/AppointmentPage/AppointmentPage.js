import React, { Component } from 'react';
import Menu from "../Menu"
import { Inject, ScheduleComponent, Day, Week, WorkWeek, Month, Agenda, } from '@syncfusion/ej2-react-schedule'
import history from '../../history'
import "../../css/appointmentpopup.css"
import Data from "../../services/Data"

class AppointmentPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            year: "",
            month: "",
            day: "",
            hour: "",
            minute: "",
            dataSource: []
        }

        this.getAppointment = this.getAppointment.bind(this)
        this.applyAppointment = this.applyAppointment.bind(this)
    }

    componentDidMount() {
        Data.getAppointmentsForDoctors({ id: history.location.state.doctorData.id, }).then(res => {
            let helper = []
            for (let i = 0; i < res.data.length; i++) {
                let dataSource = {
                    EndTime: new Date(res.data[i].year, res.data[i].month, res.data[i].day, res.data[i].hour, (res.data[i].minute + 30)),
                    StartTime: new Date(res.data[i].year, res.data[i].month, res.data[i].day, res.data[i].hour, res.data[i].minute),
                    Subject: "wizyta"
                }
                helper[i] = dataSource
            }
            this.setState({
                dataSource: helper
            })
        })
    }

    getAppointment(e) {
        let date = e.target.value
        let year = date.split("-")[0]
        let month = parseInt(date.split("-")[1]) - 1
        let day = date.split("-")[2].split("T")[0]
        let hour = date.split("-")[2].split("T")[1].split(":")[0]
        let minutes = date.split("-")[2].split("T")[1].split(":")[1]

        this.setState({
            year: year,
            month: month,
            day: day,
            hour: hour,
            minute: minutes,
        })
    }

    applyAppointment() {
        if (this.state.minute === "00" || this.state.minute === "30") {
            let helper = this.state.dataSource
            let check = false;

            let data = {
                EndTime: new Date(this.state.year, this.state.month, this.state.day, this.state.hour, (this.state.minute + 30)),
                StartTime: new Date(this.state.year, this.state.month, this.state.day, this.state.hour, this.state.minute),
                Subject: "wizyta"
            }

            for (let i = 0; i < helper.length; i++) {
                if (helper[i].StartTime.getTime() === data.StartTime.getTime()) {
                    check = true
                    alert("Termin jest zajęty")
                    break
                }
            }

            if (check === false) {
                let data = {
                    user_data: {
                        id: Data.getUserId()
                    },
                    doctor_data: {
                        id: history.location.state.doctorData.id
                    },
                    year: this.state.year,
                    month: this.state.month,
                    day: this.state.day,
                    hour: this.state.hour,
                    minute: this.state.minute,
                }

                Data.addAppointment(data).then(res => {
                    window.location.reload()
                })
            }
        } else {
            alert("Wizyta musi zaczynać sie o pełnej godzinie lub wpół do pełnej godziny.")
        }
    }

    render() {
        return (
            <div className="appointmentpage material">
                <Menu />
                <div style={{ marginTop: "5%", display: "flex", width: "100%", paddingRight: "2%", justifyContent: "center", alignItems: "center" }}>
                    <span style={{ paddingLeft: "3%", marginRight: "auto", fontSize: "32.5px", fontWeight: "bold", color: "#2c3a41", fontFamily: "Arial", textDecoration: "underline" }}>{history.location.state.doctorData.name} {history.location.state.doctorData.surname} - {history.location.state.doctorData.specialisation}</span>
                    <input type="datetime-local" onChange={this.getAppointment} />
                    <div className="appointmentbuttons" onClick={this.applyAppointment}>Zapisz się</div>
                </div>
                <div id="sample" className="padding">
                    <ScheduleComponent readonly={true} eventSettings={{ dataSource: this.state.dataSource }}>
                        <Inject services={[Day, Week, WorkWeek, Month, Agenda]} />
                    </ScheduleComponent>
                </div>
            </div>
        );
    }
}

export default AppointmentPage;