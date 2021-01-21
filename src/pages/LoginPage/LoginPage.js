import React, { Component } from 'react';
import Menu from "../Menu"
import LoginInputs from "./LoginInputs"
import "../../css/loginpage.css"

class LoginPage extends Component {

    render() {
        return (
            <div className="loginpage">
                <Menu />
                <LoginInputs />
            </div>
        );
    }
}

export default LoginPage;