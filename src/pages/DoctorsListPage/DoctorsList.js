import React, { Component } from 'react';
import DoctorListItem from "./DoctorListItem"
import Data from "../../services/Data"

class DoctorsList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            doctors: [{ name: "Jan", surname: "Kowalski", email: "jkowalski@gmail.com", specialisation: "kardiolog" },{ name: "Jan", surname: "Kowalski", email: "jkowalski@gmail.com", specialisation: "kardiolog" },{ name: "Jan", surname: "Kowalski", email: "jkowalski@gmail.com", specialisation: "kardiolog" },{ name: "Jan", surname: "Kowalski", email: "jkowalski@gmail.com", specialisation: "kardiolog" },{ name: "Jan", surname: "Kowalski", email: "jkowalski@gmail.com", specialisation: "kardiolog" },{ name: "Jan", surname: "Kowalski", email: "jkowalski@gmail.com", specialisation: "kardiolog" },{ name: "Jan", surname: "Kowalski", email: "jkowalski@gmail.com", specialisation: "kardiolog" },{ name: "Jan", surname: "Kowalski", email: "jkowalski@gmail.com", specialisation: "kardiolog" },{ name: "Jan", surname: "Kowalski", email: "jkowalski@gmail.com", specialisation: "kardiolog" },{ name: "Jan", surname: "Kowalski", email: "jkowalski@gmail.com", specialisation: "kardiolog" },{ name: "Jan", surname: "Kowalski", email: "jkowalski@gmail.com", specialisation: "kardiolog" },]
        }
    }

    componentDidMount(){
        Data.getDoctors().then(res=>{
            console.log(res.data)
        })
    }

    render() {
        return (
            <div className="doctorlistdiv">
                <div className="listBox">
                    <span style={{ fontSize: "32.5px", fontWeight: "bold", color: "#2c3a41", fontFamily: "Arial", marginBottom: "2%", borderBottom: "solid 2.2px #2c3a41" }}>Lista lekarzy</span>
                    <div className="tabstyle">
                        <span className="spanstyle">Imie</span>
                        <span className="spanstyle">Nazwisko</span>
                        <span className="spanstyle">E-mail</span>
                        <span className="spanstyle">Specjalizacja</span>
                    </div>
                    {this.state.doctors.map((item, key) => (<DoctorListItem key={key} name={item.name} surname={item.surname} email={item.email} specialisation={item.specialisation}/>))}
                </div>
            </div>
        );
    }
}

export default DoctorsList;