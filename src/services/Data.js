import axios from "axios"

const SIGNIN_REST_API_URL = "http://localhost:8080/login"
const REGISTER_REST_API_URL = "http://localhost:8080/register"
const ROLE = sessionStorage.getItem("role")
class Data {
    signIn(data) {
        return axios.post(SIGNIN_REST_API_URL, data)
    }
    register(data){
        return axios.post(REGISTER_REST_API_URL,data)
    }
    getRole() {
        return ROLE
    }
}

export default new Data();