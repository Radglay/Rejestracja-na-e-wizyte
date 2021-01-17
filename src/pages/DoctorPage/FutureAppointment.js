import React, { Component } from 'react';
import Data from '../../services/Data';

class FutureAppointment extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: "",
            surname: "",
            phoneNumber: "",
            check: false,
            year: "",
            month: "",
            day: "",
            hour: "",
            minute: "",
        }
        this.goToAppointment = this.goToAppointment.bind(this)
        this.cancelAppointment = this.cancelAppointment.bind(this)
        this.showInput = this.showInput.bind(this)
        this.getNewAppointmentDate = this.getNewAppointmentDate.bind(this)
        this.changeAppointmentDate = this.changeAppointmentDate.bind(this)
    }

    componentDidMount() {
        Data.getUserData({ id: this.props.doc }).then(res => {
            this.setState({
                name: res.data.name,
                surname: res.data.surname,
                phoneNumber: res.data.telephone
            })
        })

    }

    cancelAppointment() {
        if (window.confirm('Czy napewno chcesz anulować wizytę?')) {
            Data.cancelAppointment({ id: this.props.id }).then(res => {
                window.location.reload()
            })
        }
    }

    goToAppointment() {
        let date = this.props.date.split(" ")[0]
        let day = date.split(".")[0]
        let month = (parseInt(date.split(".")[1]) - 1)
        let year = date.split(".")[2]
        let time = this.props.date.split(" ")[1]
        let hour = time.split(":")[0]
        let minute = time.split(":")[1]

        let appointmentDateStart = new Date(year, month, day, hour, minute)
        let appointmentDateEnd = new Date(year, month, day, hour, minute + 30)
        let today = new Date()

        if (appointmentDateEnd.getTime() >= today.getTime() && appointmentDateStart.getTime() <= today.getTime()) {
            alert("Dołączyłeś")
        } else {
            alert("Wizyta jeszcze się nie rozpoczeła")
        }

    }

    showInput() {
        this.setState({
            check: !this.state.check
        })
    }

    getNewAppointmentDate(e) {
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

    changeAppointmentDate() {
        if (this.state.minute === "00" || this.state.minute === "30") {
            let appDate = new Date(this.props.date.split(" ")[0].split(".")[2], (parseInt(this.props.date.split(" ")[0].split(".")[1]) - 1), this.props.date.split(" ")[0].split(".")[0], this.props.date.split(" ")[1].split(":")[0], this.props.date.split(" ")[1].split(":")[1])
            let helper = new Date(this.state.year, this.state.month, this.state.day, this.state.hour, this.state.minute)

            if (helper.getTime() < appDate.getTime()) {
                alert("Nie można ustawić daty z przeszłości.")
            } else {
                let data = {
                    id: this.props.id,
                    year: this.state.year,
                    month: this.state.month,
                    day: this.state.day,
                    hour: this.state.hour,
                    minute: this.state.minute,
                }

                Data.updateAppointmentDate(data).then(res => {
                    window.location.reload()
                })
            }

        } else {
            alert("Wizyta musi zaczynać sie o pełnej godzinie lub wpół do pełnej godziny.")
        }
    }

    render() {
        return (
            <div>
                <div className="el">
                    <span className="spanstyle">{this.state.name}</span>
                    <span className="spanstyle">{this.state.surname}</span>
                    <span className="spanstyle">{this.state.phoneNumber}</span>
                    <span className="spanstyle">{this.props.date}</span>
                    <div className="registrationbuttons" onClick={this.goToAppointment} style={{ width: "3%", marginRight: "0.5%", marginTop: "0" }}>-&gt;</div>
                    <div className="registrationbuttons" onClick={this.showInput} style={{ width: "3%", marginRight: "0.5%", marginTop: "0" }}>E</div>
                    <div className="registrationbuttons" onClick={this.cancelAppointment} style={{ width: "3%", marginRight: "0.5%", marginTop: "0" }}>X</div>
                </div>
                <div style={{ display: "flex", width: "100%", justifyContent: "flex-end", alignItems: "center" }}>
                    {this.state.check
                        ? <input type="datetime-local" style={{ marginTop: "1%", marginBottom: "1%" }} onChange={this.getNewAppointmentDate} />
                        : <div></div>
                    }
                    {this.state.check
                        ? <div className="appointmentbuttons" style={{ marginTop: "1%", marginBottom: "1%" }} onClick={this.changeAppointmentDate}>Zmień</div>
                        : <div></div>
                    }
                </div>
            </div>
        );
    }
}

export default FutureAppointment;