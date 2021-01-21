import axios from "axios"

const SIGNIN_REST_API_URL = "http://localhost:8080/login"
const REGISTER_REST_API_URL = "http://localhost:8080/register"
const GETDOCTORS_REST_API_URL = "http://localhost:8080/api/doctors"
const GETAPPOINTMENTSFORDOCTORS_REST_API_URL = "http://localhost:8080/api/wizyty_doctor"
const ADDAPPOINTMENT_REST_API_URL = "http://localhost:8080/api/wizyta_add"
const GETAPPOINTMENTSFORCLIENT_REST_API_URL = "http://localhost:8080/api/wizyty_user"
const GETUSERDATA_REST_API_URL = "http://localhost:8080/api/user"
const GETDOCTORDATA_REST_API_URL = "http://localhost:8080/api/doctor"
const CANCELAPPOINTMENT_REST_API_URL = "http://localhost:8080/api/wizyta_delete"
const UPDATEAPPOINTMENTDATE_REST_API_URL = "http://localhost:8080/api/wizyta_update"
const ROLE = sessionStorage.getItem("role")
const USER_ID = sessionStorage.getItem("user_id")

class Data {
    signIn(data) {
        return axios.post(SIGNIN_REST_API_URL, data)
    }
    register(data) {
        return axios.post(REGISTER_REST_API_URL, data)
    }
    getDoctors() {
        return axios.get(GETDOCTORS_REST_API_URL)
    }
    getAppointmentsForDoctors(data) {
        return axios.post(GETAPPOINTMENTSFORDOCTORS_REST_API_URL, data)
    }
    getAppointmentsForClient(data) {
        return axios.post(GETAPPOINTMENTSFORCLIENT_REST_API_URL, data)
    }
    addAppointment(data) {
        return axios.post(ADDAPPOINTMENT_REST_API_URL, data)
    }
    getUserData(data) {
        return axios.post(GETUSERDATA_REST_API_URL, data)
    }
    getDoctorData(data) {
        return axios.post(GETDOCTORDATA_REST_API_URL, data)
    }
    cancelAppointment(data) {
        return axios.post(CANCELAPPOINTMENT_REST_API_URL, data)
    }
    updateAppointmentDate(data) {
        return axios.post(UPDATEAPPOINTMENTDATE_REST_API_URL, data)
    }
    getRole() {
        return ROLE
    }
    getUserId() {
        return USER_ID
    }
}

export default new Data();