import axios from "axios";
import { useReducer } from "react";
import { useNavigate } from "react-router-dom";
import { INITIAL_STATE, FormReducer } from "./FormReducer";

export default function Login({ setTrigger }: any) {
  const [state, dispatch] = useReducer(FormReducer, INITIAL_STATE);

  const handleClick = () => {
    setTrigger((prev: boolean) => !prev);
  };

  const handleChange = (e: any) => {
    dispatch({
      type: "CHANGE_INPUT",
      payload: { name: e.target.name, value: e.target.value },
    });
  };

  console.log(state);

  const handleSubmit = (e: any) => {
    e.preventDefault();
    console.log("submit");
  };

  const handleLogin = (e: any) => {
    e.preventDefault();

    // axios.get("http://localhost:8080/api/v1/registration/hello").then((res) => {
    //   console.log(res.data);
    // });
  };

  return (
    <div className="form-container">
      <div className="test">
        <div className="title-container">
          <h3 className="login-title">Welcome back!</h3>
          <h4>We're so excited to see you again!</h4>
        </div>
        <form className="form" onSubmit={handleSubmit}>
          <label htmlFor="email">Email</label>
          <input
            type="email"
            name="email"
            id="email"
            onChange={(e) => handleChange(e)}
          />
          <label htmlFor="password">Password</label>
          <input
            type="password"
            name="password"
            id="password"
            onChange={handleChange}
          />
          <button className="login-btn">Log In</button>
        </form>
        <p>
          Need an account?
          <span onClick={handleClick}> Register</span>
        </p>
      </div>
    </div>
  );
}
