import React, { Component } from "react";
import { withRouter } from "react-router-dom"
import history from '../history'
import Data from "../services/Data"
import "../css/menu.css"

class Menu extends Component {
    constructor(props) {
        super(props);
        this.state = {
            scrollPosition: window.pageYOffset,
            visable: "0",
            isLoggedIn: false,
            isDoctor: false,
            isClient: false
        };
        this.scrollEvent = this.scrollEvent.bind(this)
        this.goToPage = this.goToPage.bind(this)
        this.goToMainPage = this.goToMainPage.bind(this)
    }



    scrollEvent() {
        let currentScrollPos = window.pageYOffset
        if (this.state.scrollPosition > currentScrollPos) {
            this.setState((state) => ({
                visable: "0"
            }));
        }
        else {
            this.setState((state) => ({
                visable: "-60"
            }));
        }

        this.setState((state) => ({
            scrollPosition: currentScrollPos,
        }));
    }

    componentDidMount() {
        if (Data.getRole() !== null) {
            if (Data.getRole() === "1") {
                this.setState({
                    isLoggedIn: true,
                    isClient: true,
                })
            } else {
                this.setState({
                    isLoggedIn: true,
                    isDoctor: true,
                })
            }

        }
        window.addEventListener("scroll", this.scrollEvent)
    }

    componentWillUnmount() {
        window.removeEventListener("scroll", this.scrollEvent.bind);
    }

    goToPage(e) {
        if (e.target.id === "/wyloguj") {
            sessionStorage.removeItem("role")
            sessionStorage.removeItem("user_id")
            history.push("/")
        } else {
            history.push(e.target.id)
        }
    }

    goToMainPage() {
        history.push("/")
    }


    render() {
        const mystyle = {
            top: this.state.visable,
        }

        return (
            <div className="menudiv" style={mystyle}>
                <span onClick={this.goToMainPage} style={{ cursor: "pointer", marginRight: "auto", display: "flex", alignItems: "center", color: "white", fontSize: "30px", paddingLeft: "1.5%" }}>System rejestracji</span>
                <div className="menubutton" id="/lista-lekarzy" onClick={this.goToPage}>Lista lekarzy</div>
                {this.state.isDoctor
                    ? <div className="menubutton" id={"/zarzadzaj-wizytami"} onClick={this.goToPage}>Zarządzaj</div>
                    : <div></div>
                }
                {this.state.isClient
                    ? <div className="menubutton" id={"/karta-pacjenta"} onClick={this.goToPage}>Karta pacjenta</div>
                    : <div></div>
                }
                {this.state.isLoggedIn
                    ? <div className="menubutton" id="/wyloguj" onClick={this.goToPage}>Wyloguj się</div>
                    : <div className="menubutton" id="/zaloguj" onClick={this.goToPage}>Zaloguj się</div>
                }

            </div>
        );
    }
}

export default withRouter(Menu);
