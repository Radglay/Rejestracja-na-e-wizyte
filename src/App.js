import React, { Component } from 'react';
import { Route, Switch, Redirect } from "react-router-dom"
import LoginPage from "./pages/LoginPage"




class App extends Component {
    render() {
        return (
            <Switch>
                <Route exact path="/" component={LoginPage} />
            </Switch>
        );
    }
}

export default App