import React, { Component } from 'react';
import history from "../../history"
import Data from "../../services/Data"

class LoginInputs extends Component {
    constructor(props) {
        super(props);
        this.state = {
            email: "",
            password: "",
        }
        this.change = this.change.bind(this)
        this.sendData = this.sendData.bind(this)
        this.goToRegister = this.goToRegister.bind(this)
    }

    change(e) {
        this.setState({
            [e.target.name]: e.target.value,
        })
    }

    sendData(e) {
        e.preventDefault()
        if (Data.getRole()) {
            sessionStorage.removeItem("role")
            sessionStorage.removeItem("user_id")
        }
        Data.signIn(this.state).then(res => {
            if (res.data.roles[0].role === "USER") {
                sessionStorage.setItem('role', 1)
                sessionStorage.setItem('user_id', res.data.id)
            } else {
                sessionStorage.setItem('role', 2)
                sessionStorage.setItem('user_id', res.data.id)
            }
            history.push("/")
        }).catch(err => {
            this.setState({
                email: "",
                password: ""
            })
        })
    }

    goToRegister() {
        history.push("/rejestracja")
    }

    render() {
        return (
            <div className="logindiv">
                <form onSubmit={this.sendData} className="loginBox">
                    <span style={{ marginRight: "auto", fontSize: "35px", fontWeight: "bold", color: "#2c3a41", fontFamily: "Arial", paddingLeft: "40px", marginBottom: "25px" }}>Logowanie</span>
                    <input onChange={this.change} name="email" value={this.state.email} style={{ marginBottom: "15px", width: "50%", height: "15%", }} placeholder="Tutaj wpisz swój login" type="email" />
                    <input onChange={this.change} name="password" value={this.state.password} style={{ marginBottom: "25px", width: "50%", height: "15%", }} type="password" placeholder="Tutaj wpisz swoje hasło" />
                    <button type="submit" className="loginButton">Zaloguj się</button>
                </form>
                <div className="loginButton" onClick={this.goToRegister} style={{ height: "2%", marginTop: "-30px", backgroundColor: "white", color: "black", fontSize: "10pxS" }}>Załóż konto</div>
            </div>
        );
    }
}

export default LoginInputs;