import React, { Component } from 'react';
import Data from "../../services/Data"
import history from "../../history"

class RegistrationInputs extends Component {
    constructor(props) {
        super(props);
        this.state = {
            email: "",
            password: "",
            passwordConfirm: "",
            name: "",
            surname: "",
            pesel: "",
            phoneNumber: "",
        }
        this.change = this.change.bind(this)
        this.register = this.register.bind(this)
    }

    change(e) {
        this.setState({
            [e.target.name]: e.target.value
        })
    }
    register() {
        if (this.state.email !== "" && this.state.password !== "" && this.state.passwordConfirm !== "" && this.state.name !== "" && this.state.surname !== "" && this.state.pesel !== "" && this.state.phoneNumber !== "") {
            if (this.state.password === this.state.passwordConfirm) {
                let data = {
                    email: this.state.email,
                    password: this.state.password,
                    name: this.state.name,
                    surname: this.state.surname,
                    telephone: this.state.phoneNumber,
                    pesel: this.state.pesel
                }

                Data.register(data).then(res => {
                    history.push("/zaloguj")
                }).catch(err => {
                    this.setState({
                        email: "",
                        password: "",
                        passwordConfirm: "",
                        name: "",
                        surname: "",
                        pesel: "",
                        phoneNumber: "",
                    })
                })
            }
            else {
                alert("hasła nie są takie same")
            }
        }
    }

    render() {
        return (
            <div className="registrationdiv">
                <span className="registrationspan" style={{ fontSize: "32.5px", fontWeight: "bold", color: "#2c3a41", fontFamily: "Arial" }}>Rejestracja</span>
                <div className="regdiv">
                    <span className="regpanel">Imie:</span>
                    <input className="reginput" type="text" name="name" value={this.state.name} onChange={this.change} placeholder="imie" />
                </div>
                <div className="regdiv">
                    <span className="regpanel">Nazwisko:</span>
                    <input className="reginput" type="text" name="surname" value={this.state.surname} onChange={this.change} placeholder="nazwisko" />
                </div>
                <div className="regdiv">
                    <span className="regpanel">Pesel:</span>
                    <input className="reginput" type="text" name="pesel" value={this.state.pesel} onChange={this.change} placeholder="pesel" />
                </div>
                <div className="regdiv">
                    <span className="regpanel">Numer telefonu:</span>
                    <input className="reginput" type="text" name="phoneNumber" value={this.state.phoneNumber} onChange={this.change} placeholder="numer telefonu" />
                </div>
                <div className="regdiv">
                    <span className="regpanel">E-mail:</span>
                    <input className="reginput" type="text" name="email" value={this.state.email} onChange={this.change} placeholder="e-mail" />
                </div>
                <div className="regdiv">
                    <span className="regpanel">Hasło:</span>
                    <input className="reginput" type="password" name="password" value={this.state.password} onChange={this.change} placeholder="hasło" />
                </div>
                <div className="regdiv">
                    <span className="regpanel">Powtórz hasło:</span>
                    <input className="reginput" type="password" name="passwordConfirm" value={this.state.passwordConfirm} onChange={this.change} placeholder="powtórz hasło" />
                </div>
                <div className="regdiv" style={{ marginTop: "0" }}>
                    <div className="registrationbuttons" onClick={this.register} style={{ width: "50%", marginTop: "2.5%" }}>Zarejestruj</div>
                </div>
            </div>
        );
    }
}

export default RegistrationInputs;