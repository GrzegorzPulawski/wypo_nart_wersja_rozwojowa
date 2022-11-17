import axios from "axios";

const connection = axios.create({
    baseURL: "/"
});

export default connection;