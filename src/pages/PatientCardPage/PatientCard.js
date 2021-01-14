import React, { Component } from 'react';

class PatientCard extends Component {
    render() {
        return (
            <div className="patientcarddiv">
                <div className="patientBox">
                <span style={{ fontSize: "32.5px", fontWeight: "bold", color: "#2c3a41", fontFamily: "Arial", marginBottom: "2%", borderBottom: "solid 2.2px #2c3a41" }}>Karta pacjenta</span>
                </div>
            </div>
        );
    }
}

export default PatientCard;