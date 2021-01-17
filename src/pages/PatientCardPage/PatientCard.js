import React, { Component } from 'react';
import Data from "../../services/Data"
import AppointmentItem from "./AppointmentItem"

class PatientCard extends Component {
    constructor(props) {
        super(props);
        this.state = {
            email: "",
            name: "",
            surname: "",
            pesel: "",
            phoneNumber: "",
            futureAppointments: [],
            historyOfAppointments: [],
        }
    }

    componentDidMount() {
        Data.getUserData({ id: Data.getUserId() }).then(res => {
            this.setState({
                email: res.data.email,
                name: res.data.name,
                surname: res.data.surname,
                pesel: res.data.pesel,
                phoneNumber: res.data.telephone,
            })
        })
        Data.getAppointmentsForClient({ id: Data.getUserId() }).then(res => {
            console.log(res.data)
            let helper = []
            let helperStart = []

            for (let i = 0; i < res.data.length; i++) {
                helper[i] = new Date(res.data[i].year, res.data[i].month, res.data[i].day, res.data[i].hour, (res.data[i].minute + 30))
                helperStart[i] = [new Date(res.data[i].year, res.data[i].month, res.data[i].day, res.data[i].hour, res.data[i].minute),res.data[i].id,res.data[i].identyfikator]
            }
            helper = helper.sort(function (a, b) { return a.getTime() - b.getTime() })
            helperStart = helperStart.sort(function (a, b) { return a[0].getTime() - b[0].getTime() })

            let today = new Date()
            let futureAppointments = []
            let historyOfAppointments = []
            let y = 0;
            let z = 0;

            for (let i = 0; i < helper.length; i++) {
                if (helper[i].getTime() > today.getTime()) {
                    futureAppointments[y] = [helperStart[i][0].toLocaleDateString() + " " + helperStart[i][0].toLocaleTimeString().slice(0, 5),helperStart[i][1],helperStart[i][2]]
                    y++
                } else {
                    historyOfAppointments[z] = [helperStart[i][0].toLocaleDateString() + " " + helperStart[i][0].toLocaleTimeString().slice(0, 5),helperStart[i][2]]
                    z++
                }
            }

            this.setState({
                futureAppointments: futureAppointments,
                historyOfAppointments: historyOfAppointments
            })
        })
    }

    render() {
        return (
            <div className="patientcarddiv">
                <div className="patientBox">
                    <span style={{ fontSize: "32.5px", fontWeight: "bold", color: "#2c3a41", fontFamily: "Arial", marginBottom: "2%", borderBottom: "solid 2.2px #2c3a41" }}>Karta pacjenta</span>
                    <div className="regdiv">
                        <span className="regpanel">Imie:</span>
                        <input className="reginput" type="text" name="name" value={this.state.name} disabled placeholder="imie" />
                    </div>
                    <div className="regdiv">
                        <span className="regpanel">Nazwisko:</span>
                        <input className="reginput" type="text" name="surname" value={this.state.surname} disabled placeholder="nazwisko" />
                    </div>
                    <div className="regdiv">
                        <span className="regpanel">Pesel:</span>
                        <input className="reginput" type="text" name="pesel" value={this.state.pesel} disabled placeholder="pesel" />
                    </div>
                    <div className="regdiv">
                        <span className="regpanel">Numer telefonu:</span>
                        <input className="reginput" type="text" name="phoneNumber" value={this.state.phoneNumber} disabled placeholder="numer telefonu" />
                    </div>
                    <div className="regdiv">
                        <span className="regpanel">E-mail:</span>
                        <input className="reginput" type="text" name="email" value={this.state.email} disabled placeholder="e-mail" />
                    </div>
                    <span style={{ fontSize: "32.5px", fontWeight: "bold", color: "#2c3a41", fontFamily: "Arial", marginBottom: "2%", marginTop: "2%", borderBottom: "solid 2.2px #2c3a41" }}>Najbliższe wizyty</span>
                    {this.state.futureAppointments.map((item, key) => (<AppointmentItem key={key} id={item[1]} future={true} name={"test"} surname={"test"} specialisation={"test"} date={item[0]} doc={item[2]}/>))}
                    <span style={{ fontSize: "32.5px", fontWeight: "bold", color: "#2c3a41", fontFamily: "Arial", marginBottom: "2%", marginTop: "2%", borderBottom: "solid 2.2px #2c3a41" }}>Historia wizyt</span>
                    {this.state.historyOfAppointments.map((item, key) => (<AppointmentItem key={key} future={false} id={item.id} name={"test"} surname={"test"} specialisation={"test"} date={item[0]} doc={item[1]} />))}
                </div>
            </div>
        );
    }
}

export default PatientCard;