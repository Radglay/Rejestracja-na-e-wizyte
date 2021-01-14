import React, { Component } from 'react';
import Menu from "../Menu"
import PatientCard from "./PatientCard"
import "../../css/patientcardpage.css"

class PatientCardPage extends Component {
    render() {
        return (
            <div className="patientcardpage">
                <Menu />
                <PatientCard />
            </div>
        );
    }
}

export default PatientCardPage;