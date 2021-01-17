import React, { Component } from 'react';
import Data from '../../services/Data';

class AppointmentItem extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name:"",
            surname:"",
            specialisation:""
        }
        this.cancelAppointment = this.cancelAppointment.bind(this)
        this.goToAppointment = this.goToAppointment.bind(this)
    }

    componentDidMount(){
        Data.getDoctorData({id:this.props.doc}).then(res=>{
            console.log(res.data)
        })
        
    }

    cancelAppointment() {
        if (window.confirm('Czy napewno chcesz zrezygnować z wizyty?')) {
            console.log(this.props.id);
        } else {
            console.log('nie zrezygnowano');
        }
    }

    goToAppointment() {
        let date= this.props.date.split(" ")[0]
        let day= date.split(".")[0]
        let month= (parseInt(date.split(".")[1])-1)
        let year= date.split(".")[2]
        let time = this.props.date.split(" ")[1]
        let hour= time.split(":")[0]
        let minute = time.split(":")[1]

        let appointmentDateStart= new Date(year, month, day, hour, minute)
        let appointmentDateEnd= new Date(year, month, day, hour, minute+30)
        let today = new Date()

        if(appointmentDateEnd.getTime()>=today.getTime() && appointmentDateStart.getTime()<=today.getTime()){
            alert("Dołączyłeś")
        }else{
            alert("Wizyta jeszcze się nie rozpoczeła")
        }

    }

    render() {
        return (
            <div className="el">
                <span className="spanstyle">{this.props.name}</span>
                <span className="spanstyle">{this.props.surname}</span>
                <span className="spanstyle">{this.props.specialisation}</span>
                <span className="spanstyle">{this.props.date}</span>
                {this.props.future
                    ? <div className="registrationbuttons" onClick={this.goToAppointment} style={{ width: "3%", marginRight: "0.5%", marginTop: "0" }}>-&gt;</div>
                    : <div></div>
                }
                {this.props.future
                    ? <div className="registrationbuttons" onClick={this.cancelAppointment} style={{ width: "3%", marginRight: "0.5%", marginTop: "0" }}>X</div>
                    : <div></div>
                }
            </div>
        );
    }
}

export default AppointmentItem;