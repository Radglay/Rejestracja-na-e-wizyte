import React, { Component } from 'react';
import Menu from "../Menu"
import { Inject, ScheduleComponent, Day, Week, WorkWeek, Month, Agenda, } from '@syncfusion/ej2-react-schedule'
import history from '../../history'
import "../../css/appointmentpopup.css"

class AppointmentPage extends Component {
    constructor(props) {
        super(props);

        this.state = {
            EndTime: null,
            StartTime: null,
            Subject: "wizyta",
            dataSource: [{
                EndTime: new Date(2021, 0, 16, 4, 50),
                StartTime: new Date(2021, 0, 16, 4, 20),
                Subject: "test"
            }, {
                EndTime: new Date(2021, 0, 16, 3, 50),
                StartTime: new Date(2021, 0, 16, 3, 20),
                Subject: "test"
            }, {
                EndTime: new Date(2021, 0, 16, 5, 50),
                StartTime: new Date(2021, 0, 16, 5, 20),
                Subject: "test"
            }
            ]
        }

        this.EventSettingsModel = {
            dataSource: [{
                EndTime: new Date(2021, 0, 16, 4, 30),
                StartTime: new Date(2021, 0, 16, 4, 0),
                Subject: "test"
            }]
        }
        this.getAppointment = this.getAppointment.bind(this)
        this.sort = this.sort.bind(this)
    }

    sort(a, b) {
        var dateA = a.StartTime.getTime();
        var dateB = b.StartTime.getTime();
        return dateA > dateB ? 1 : -1;
    }

    getAppointment(e) {
        let date = e.target.value
        let year = date.split("-")[0]
        let month = parseInt(date.split("-")[1]) - 1
        let day = date.split("-")[2].split("T")[0]
        let hour = date.split("-")[2].split("T")[1].split(":")[0]
        let minutes = date.split("-")[2].split("T")[1].split(":")[1]
        this.setState({
            EndTime: new Date(year, month, day, hour, parseInt(minutes) + 30),
            StartTime: new Date(year, month, day, hour, minutes),
            Subject: "wizyta"
        }, () => {
            let helper = this.state.dataSource
            let data = {
                EndTime: this.state.EndTime,
                StartTime: this.state.StartTime,
                Subject: this.state.Subject
            }
            helper.sort(this.sort)

            let check = false
            for (let i = 0; i < helper.length; i++) {
                if (((data.StartTime.getTime() > helper[i].StartTime) && (data.StartTime.getTime() < helper[i].EndTime.getTime())) || (data.StartTime.getTime() === helper[i].EndTime.getTime() || data.StartTime.getTime() === helper[i].StartTime.getTime())) {
                    check = true
                    alert("zajęty termin")
                    break
                }
            }
            if (check === false) {
                helper[helper.length] = data
                this.setState({
                    EndTime: null,
                    StartTime: null,
                    Subject: "wizyta",
                    dataSource: helper
                })
            }
        })
    }

    render() {
        return (
            <div className="appointmentpage material">
                <Menu />
                <span style={{ marginRight: "auto", paddingLeft: "2%", marginTop: "5%", fontSize: "32.5px", fontWeight: "bold", color: "#2c3a41", fontFamily: "Arial", textDecoration: "underline" }}>{history.location.state.doctorData.name} {history.location.state.doctorData.surname} - {history.location.state.doctorData.specialisation}</span>
                <input type="datetime-local" onChange={this.getAppointment} />
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