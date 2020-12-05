import React, { Component } from 'react';
import { Route, Switch } from "react-router-dom"
import MainPage from "./pages/MainPage/MainPage"





class App extends Component {
    render() {
        return (
            <Switch>
                
                <Route exact path="/" component={MainPage} />
            </Switch>
        );
    }
}

export default App