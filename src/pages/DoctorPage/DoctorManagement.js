import React, { Component } from 'react';
import Data from '../../services/Data';
import FutureAppointment from "./FutureAppointment"

class DoctorManagement extends Component {
    constructor(props) {
        super(props);
        this.state = {
            futureAppointments: []
        }
    }

    componentDidMount() {
        Data.getAppointmentsForDoctors({ id: Data.getUserId() }).then(res => {
            let helper = []
            let helperStart = []

            for (let i = 0; i < res.data.length; i++) {
                helper[i] = new Date(res.data[i].year, res.data[i].month, res.data[i].day, res.data[i].hour, (res.data[i].minute + 30))
                helperStart[i] = [new Date(res.data[i].year, res.data[i].month, res.data[i].day, res.data[i].hour, res.data[i].minute), res.data[i].id, res.data[i].identyfikator_doctor]
            }

            helper = helper.sort(function (a, b) { return a.getTime() - b.getTime() })
            helperStart = helperStart.sort(function (a, b) { return a[0].getTime() - b[0].getTime() })

            let today = new Date()
            let futureAppointments = []
            let y = 0;

            for (let i = 0; i < helper.length; i++) {
                if (helper[i].getTime() > today.getTime()) {
                    futureAppointments[y] = [helperStart[i][0].toLocaleDateString() + " " + helperStart[i][0].toLocaleTimeString().slice(0, 5), helperStart[i][1], helperStart[i][2]]
                    y++
                }
            }

            this.setState({
                futureAppointments: futureAppointments,
            })
        })
    }
    render() {
        return (
            <div className="doctordiv">
                <div className="doctorBox">
                    <span style={{ fontSize: "32.5px", fontWeight: "bold", color: "#2c3a41", fontFamily: "Arial", marginBottom: "2%", borderBottom: "solid 2.2px #2c3a41" }}>Wizyty</span>
                    <div className="tabstyle">
                        <span className="spanstyle" style={{ width: "22.6%" }}>Imie</span>
                        <span className="spanstyle" style={{ width: "22.6%" }}>Nazwisko</span>
                        <span className="spanstyle" style={{ width: "22.6%" }}>Numer telefonu</span>
                        <span className="spanstyle" style={{ width: "22.6%" }}>Data wizyty</span>
                    </div>
                    {this.state.futureAppointments.map((item, key) => (<FutureAppointment key={key} id={item[1]} date={item[0]} doc={item[2]} />))}
                </div>
            </div>
        );
    }
}

export default DoctorManagement;