import React, { Component } from 'react';
import history from '../../history'
import Data from "../../services/Data"

class DoctorListItem extends Component {
    constructor(props) {
        super(props);
        this.getAppointment = this.getAppointment.bind(this)
    }

    getAppointment() {
        if (Data.getRole() !== null) {
            history.push({
                pathname: '/kalendarz',
                state: { doctorData: this.props }
            })
        }
    }

    render() {
        return (
            <div className="el" onClick={this.getAppointment}>
                <span className="spanstyle">{this.props.name}</span>
                <span className="spanstyle">{this.props.surname}</span>
                <span className="spanstyle">{this.props.email}</span>
                <span className="spanstyle">{this.props.specialisation}</span>
            </div>
        );
    }
}

export default DoctorListItem;