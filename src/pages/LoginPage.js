import React, { Component } from 'react';
import history from '../history'
import "../css/loginpage.css"

class LoginPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            login: "",
            password: "",
        }
        this.change = this.change.bind(this)
        this.sendData = this.sendData.bind(this)
    }

    change(e) {
        this.setState({
            [e.target.name]: e.target.value,
        })
    }

    sendData(e) {
        e.preventDefault()
       
    }

    render() {
        return (
            <div className="logindiv">
                <form onSubmit={this.sendData} className="loginBox">
                    <span style={{ marginRight: "auto", fontSize: "35px", fontWeight: "bold", color: "#2c3a41", fontFamily: "Arial", paddingLeft: "40px", marginBottom: "25px" }}>Logowanie</span>
                    <input onChange={this.change} name="login" value={this.state.login} style={{ marginBottom: "15px", width: "50%", height: "15%", }} placeholder="Tutaj wpisz swój login" type="text" />
                    <input onChange={this.change} name="password" value={this.state.password} style={{ marginBottom: "25px", width: "50%", height: "15%", }} type="password" placeholder="Tutaj wpisz swoje hasło" />
                    <button type="submit" style={{ textDecoration: "none", display: "flex", justifyContent: "center", alignItems: "center", backgroundColor: "#2c3a41", border: "none", color: "white", width: "20%", height: "10%", }}>Zaloguj się</button>
                </form>
            </div>
        );
    }
}

export default LoginPage;