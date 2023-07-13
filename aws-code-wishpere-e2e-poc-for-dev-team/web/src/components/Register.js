import React, { useState, useRef } from "react";
import { useNavigate } from "react-router-dom";

import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import { isEmail } from "validator";

import AuthService from "../services/auth.service";
const required = (value) => {
  if (!value) {
    return (
      <div className="invalid-feedback d-block">
        This field is required!
      </div>
    );
  }
};

const validEmail = (value) => {
  if (!isEmail(value)) {
    return (
      <div className="invalid-feedback d-block">
        This is not a valid email.
      </div>
    );
  }
};

const vusername = (value) => {
  if (value.length < 3 || value.length > 20) {
    return (
      <div className="invalid-feedback d-block">
        The username must be between 3 and 20 characters.
      </div>
    );
  }
};

const vpassword = (value) => {
  if (value.length < 6 || value.length > 40) {
    return (
      <div className="invalid-feedback d-block">
        The password must be between 6 and 40 characters.
      </div>
    );
  }
};

const Register = (props) => {
  const form = useRef();
  const checkBtn = useRef();

  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [successful, setSuccessful] = useState(false);
  const [message, setMessage] = useState("");
  const [qualification, setQualification] = useState("");
  const [skill, setSkill] = useState("");
  const [resume, setResume]=useState("");

  const onChangeUsername = (e) => {
    const username = e.target.value;
    setUsername(username);
  };
  
  const onChangeResume = (e) => {
    const resume = e.target.value;
    setResume(resume);
  };

  const onChangeEmail = (e) => {
    const email = e.target.value;
    setEmail(email);
  };

  const onChangeQualification=(e)=>{
      const qualification = e.target.value;
    setQualification(qualification);
  }

  const onChangePassword = (e) => {
    const password = e.target.value;
    setPassword(password);
  };

  const onChangeSkill = (e) => {
    const skill = e.target.value;
    setSkill(skill);
  };

  const handleRegister = (e) => {
    e.preventDefault();

    setMessage("");
    setSuccessful(false);

    form.current.validateAll();

    if (checkBtn.current.context._errors.length === 0) {
      AuthService.register(username, email, password,qualification,skill, resume).then(
        (response) => {
          setMessage(response.data.message);
          setSuccessful(true);
        },
        (error) => {
          const resMessage =
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();

          setMessage(resMessage);
          setSuccessful(false);
        }
      );
    }
  };
  const navigate = useNavigate();

  return (
    <center>
    <div className="col-md-12" >
      <div /*className="card card-container"*/  style={{width:450,backgroundColor:'#f4f4f4',padding:30,borderRadius:8, boxShadow: '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)'}}>
        <img
          src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
          alt="profile-img"
          className="profile-img-card"
        />

        <Form onSubmit={handleRegister} ref={form}>
          {!successful && (
            <div>
              <div className="form-group">
                <label htmlFor="username" style={{textAlign:"left"}}>Username</label>
                <Input
                  type="text"
                  className="form-control"
                  name="username"
                  value={username}
                  onChange={onChangeUsername}
                  validations={[required, vusername]}
                  
                />
              </div>

              <div className="form-group">
                <label htmlFor="email" style={{textAlign:"left"}}>Email</label>
                <Input
                  type="text"
                  className="form-control"
                  name="email"
                  value={email}
                  onChange={onChangeEmail}
                  validations={[required, validEmail]}
                />
              </div>

              <div className="form-group">
                <label htmlFor="password" style={{textAlign:"left"}}>Password</label>
                <Input
                  type="password"
                  className="form-control"
                  name="password"
                  value={password}
                  onChange={onChangePassword}
                  validations={[required, vpassword]}
                />
              </div>

              <div className="form-group">
                <label htmlFor="qualification" style={{textAlign:"left"}}>Qualification</label>
                <Input
                  type="text"
                  className="form-control"
                  name="qualification"
                  value={qualification}
                  onChange={onChangeQualification}
                  validations={[required]}
                />
              </div>

              <div className="form-group">
                <label htmlFor="skills" style={{textAlign:"left"}}>Skill</label>
                <Input
                  type="text"
                  className="form-control"
                  name="skills"
                  value={skill}
                  onChange={onChangeSkill}
                  validations={[required]}
                />
              </div>

              <div className="form-group">
                <label htmlFor="resume" style={{textAlign:"left"}}>Resume</label>
                <Input
                  type="file"
                 // className="form-control"
                  name="resume"
                  value={resume}
                  onChange={onChangeResume}
                  validations={[required]}
                  style={{height:'100%'}}
                />
              </div>

              <div className="form-group">
                <button className="btn btn-primary btn-block" onClick={()=>{navigate('/login')}}>Sign Up</button>
              </div>
            </div>
          )}

          {message && (
            <div className="form-group">
              <div
                className={
                  successful ? "alert alert-success" : "alert alert-danger"
                }
                role="alert"
              >
                {message}
              </div>
            </div>
          )}
          <CheckButton style={{ display: "none" }} ref={checkBtn} />
        </Form>
      </div>
    </div>
    </center>
  );
};

export default Register;
