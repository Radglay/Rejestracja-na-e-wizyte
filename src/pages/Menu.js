import React, { Component } from "react";
import { withRouter } from "react-router-dom"
import history from '../history'
import "../css/menu.css"

class Menu extends Component {
    constructor(props) {
        super(props);
        this.state = {
            scrollPosition: window.pageYOffset,
            visable: "0",
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
        window.addEventListener("scroll", this.scrollEvent)
        
    }

    componentWillUnmount() {
        window.removeEventListener("scroll", this.scrollEvent.bind);
    }

    goToPage(e){
        history.push(e.target.id)
    }
    
    goToMainPage(){
        history.push("/")
    }
    

    render() {
        const mystyle = {
            top: this.state.visable,
        }

        return (
            <div className="menudiv" style={mystyle}>
                <span onClick={this.goToMainPage} style={{ cursor:"pointer", marginRight: "auto", display: "flex", alignItems: "center", color: "white", fontSize: "30px", paddingLeft: "1.5%" }}>System rejestracji</span>
                <div className="menubutton">Lista lekarzy</div>
                <div className="menubutton" id="/zaloguj" onClick={this.goToPage}>Zaloguj się</div>
            </div>
        );
    }
}

export default withRouter(Menu);
