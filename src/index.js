import React from "react"
import ReactDOM from "react-dom"
import App from "./App"
import { Router } from "react-router-dom"
import history from './history'
import "./css/reset.css"

ReactDOM.render(
    <Router history={history}>
        <App />
    </Router>
    , document.getElementById("root"));
