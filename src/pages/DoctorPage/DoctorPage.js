import React, { Component } from 'react';
import Menu from "../Menu"
import DoctorManagement from"./DoctorManagement"
import "../../css/doctorpage.css"

class DoctorPage extends Component {
    render() {
        return (
            <div className="doctorpage">
                <Menu/>
                <DoctorManagement/>
            </div>
        );
    }
}

export default DoctorPage;