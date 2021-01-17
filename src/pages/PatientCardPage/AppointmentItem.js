import React, { Component } from 'react';

class AppointmentItem extends Component {
    render() {
        return (
            <div className="el">
                <span className="spanstyle">{this.props.name}</span>
                <span className="spanstyle">{this.props.surname}</span>
                <span className="spanstyle">{this.props.specialisation}</span>
                <span className="spanstyle">{this.props.date}</span>
            </div>
        );
    }
}

export default AppointmentItem;