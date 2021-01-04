import React, { Component } from 'react';
import Menu from '../Menu';
import RegistrationInputs from './RegistrationInputs';
import "../../css/registrationpage.css"

class RegistrationPage extends Component {
    render() {
        return (
            <div className="registrationpage">
                <Menu/>
                <RegistrationInputs/>
            </div>
        );
    }
}

export default RegistrationPage;