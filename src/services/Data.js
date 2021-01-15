import axios from "axios"

const SIGNIN_REST_API_URL = "http://localhost:8080/login"
const REGISTER_REST_API_URL = "http://localhost:8080/register"
const GETDOCTORS_REST_API_URL ="http://localhost:8080/api/doctors"
const ROLE = sessionStorage.getItem("role")
class Data {
    signIn(data) {
        return axios.post(SIGNIN_REST_API_URL, data)
    }
    register(data){
        return axios.post(REGISTER_REST_API_URL,data)
    }
    getDoctors(){
        return axios.get(GETDOCTORS_REST_API_URL)
    }
    getRole() {
        return ROLE
    }
}

export default new Data();