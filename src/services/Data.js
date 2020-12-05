import axios from "axios"

const SIGNIN_REST_API_URL = "http://localhost:8080/users"

class Data {
    signIn(data) {
        return axios.post(SIGNIN_REST_API_URL, data)
    }
}

export default new Data();