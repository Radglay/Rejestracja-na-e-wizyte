import React, { Component } from 'react';
import { Route, Switch } from "react-router-dom"
import MainPage from "./pages/MainPage/MainPage"
import LoginPage from "./pages/LoginPage/LoginPage"
import DoctorsListPage from "./pages/DoctorsListPage/DoctorsListPage"
import RegistrationPage from './pages/RegistrationPage/RegistrationPage';
import PatientCardPage from './pages/PatientCardPage/PatientCardPage';
import DoctorPage from "./pages/DoctorPage/DoctorPage"
import AppointmentPage from "./pages/AppointmentPage/AppointmentPage"


class App extends Component {
    render() {
        return (
            <Switch>
                <Route exact path="/" component={MainPage} />
                <Route exact path="/lista-lekarzy" component={DoctorsListPage} />
                <Route exact path="/kalendarz" component={AppointmentPage} />
                <Route exact path="/zaloguj" component={LoginPage} />
                <Route exact path="/karta-pacjenta" component={PatientCardPage} />
                <Route exact path="/zarzadzaj-wizytami" component={DoctorPage} />
                <Route exact path="/rejestracja" component={RegistrationPage} />
            </Switch>
        );
    }
}

export default App