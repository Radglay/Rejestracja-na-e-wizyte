import React, { Component } from 'react';
import Menu from "../Menu"
import DoctorsList from "./DoctorsList"
import "../../css/doctorlistpage.css"

class DoctorsListPage extends Component {
    render() {
        return (
            <div className="doctorlistpage">
                <Menu />
                <DoctorsList />
            </div>
        );
    }
}

export default DoctorsListPage;