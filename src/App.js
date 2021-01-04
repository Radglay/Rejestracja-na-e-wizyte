import React, { Component } from 'react';
import { Route, Switch } from "react-router-dom"
import MainPage from "./pages/MainPage/MainPage"
import LoginPage from "./pages/LoginPage/LoginPage"
import RegistrationPage from './pages/RegistrationPage/RegistrationPage';





class App extends Component {
    render() {
        return (
            <Switch>
                <Route exact path="/" component={MainPage} />
                <Route exact path="/zaloguj" component={LoginPage} />
                <Route exact path="/rejestracja" component={RegistrationPage} />
            </Switch>
        );
    }
}

export default App