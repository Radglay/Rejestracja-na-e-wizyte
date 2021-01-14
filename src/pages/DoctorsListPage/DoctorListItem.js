import React, { Component } from 'react';


class DoctorListItem extends Component {
    render() {
        return (
            <div className="el">
                <span className="spanstyle">{this.props.name}</span>
                <span className="spanstyle">{this.props.surname}</span>
                <span className="spanstyle">{this.props.email}</span>
                <span className="spanstyle">{this.props.specialisation}</span>
            </div>
        );
    }
}

export default DoctorListItem;