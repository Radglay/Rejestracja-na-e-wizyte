import React, { Component } from 'react';
import Menu from "../Menu"
import Slider from "./Slider"
import "../../css/mainpage.css"

class MainPage extends Component {
    render() {
        return (
            <div className="mainpage">
                <Menu />
                <Slider />
                <div>
                    <span>E-rejestracja</span>
                </div>

            </div>
        );
    }
}

export default MainPage;