import axios from "axios";

const API_URL = "http://localhost:8089/api/v1/jobs/all";



const allJobs = () => {
    return axios.get(API_URL)
          .then((response) => 
          { 
            console.log(response.data)
            return response.data
         });
        }

       
const JobService = {
    allJobs
  }

export default JobService;
