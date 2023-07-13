import React from "react";
import axios from "axios";
import { Alert } from "bootstrap";


//import JobService from "../services/job.service";

export default function Home() {  
/*
const [jobData, setAllJobs] = React.useState([]); 
//setAllJobs(JobService.allJobs());
setAllJobs(JobService.allJobs);

// call allJobs funtion fron JobService

*/

const baseURL = "http://localhost:8089/api/v1/jobs/all";

//export default function App() {
  const [jobData, setAllJobs] = React.useState([]); 

  React.useEffect(() => {
    axios.get(baseURL).then((response) => {
      setAllJobs(response.data);
    });
  }, []);


  return (
    <div>
      
      <br />
      
        <form action="">

        <div style={{flexDirection:'row',display:'flex', marginLeft:230}}>
          
          <div>
              <input
            type="text"
            className="form-control"
            placeholder="Search Job"
            style={{
              width: 700,
              height: 50,
              borderBottomColor: "black",
              borderBottomWidth: "1",
              borderColor: "#e4e4e4",
              borderWidth: 1,
              fontSize: 20,
            

            }}
          />
          </div>
            <button style={{color:'white',backgroundColor:'black',fontSize:20}}>Search</button>
          <div>
          </div>
        </div>
          
          <br />
        </form>
        <div
          style={{
            backgroundColor: "white",
            width: 1250,
            height: 'auto',
            marginTop: 70,
            paddingTop: 50,
            paddingBottom: 100,
           
          }}>

          {/**post block,  mapping - AWS tool*/}
          {
      jobData.map((item)=>{
        return(
          <div
            style={{
              flexDirection: "row",
              display: "flex",
              width: 1150,
              height: 350,
              backgroundColor: "white",
              marginBottom: 20,
              boxShadow:
                "0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)",
            }}>
            <div
              className="Image"
              style={{ width: 230, height: 230, margin: 10 }}>
              <img
                src= {item.img}
                alt=""
                style={{ width: 230, height: 230 }}
              />
            </div>
            <div
              className="Job-desc"
              style={{ width: 1030, height: 250, paddingLeft: 10 }}>
              
               {/**job title */}
              <div style={{display:'flex',flexDirection:'row'}}>
                <div style={{width:750}}><h2 style={{ textAlign: "left" }}>
                {item.jobTitle}
              </h2></div>
                <div>
                    <button style={{borderRadius:7,width:100,height:40,marginTop:20,backgroundColor:'black',color:'white',fontSize:20, borderColor:'white'}} onClick={()=>{alert("Job is successfully applied!")}}>Apply</button>
                </div>
              </div>

              
              <hr />

              {/** descriptiom */}
              <p style={{ textAlign: "left" }}>
                Description: {item.jobDescription}
              </p>
              {/**Location */}
              <p style={{ textAlign: "left" }}>
                Location: {item.location}
              </p>
              <p style={{ textAlign: "left" }}>Company: {item.company}</p>
              <p style={{ textAlign: "left" }}>Job Type: {item.jobTitle}</p>
            </div>
          </div>)})
        }
        </div>
      
    </div>
  );
}
