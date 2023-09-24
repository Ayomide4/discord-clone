import { SlArrowDown } from "react-icons/sl";
import { useReducer } from "react";
import { INITIAL_STATE, FormReducer } from "./FormReducer";
export default function Register({ setTrigger }: any) {
  const [state, dispatch] = useReducer(FormReducer, INITIAL_STATE);

  const handleChange = (e: any) => {
    dispatch({
      type: "CHANGE_INPUT",
      payload: { name: e.target.name, value: e.target.value },
    });
  };

  console.log(state);

  const handleClick = () => {
    setTrigger(false);
  };

  return (
    <div className="register-container">
      <h2>Create an account</h2>
      <div className="register-form">
        <form>
          <label htmlFor="email">Email</label>
          <input type="email" id="email" name="email" onChange={handleChange} />
          <label htmlFor="displayName">Display Name</label>
          <input
            type="text"
            id="displayName"
            name="displayName"
            onChange={handleChange}
          />
          <label htmlFor="username">Username</label>
          <input
            type="text"
            id="username"
            name="username"
            onChange={handleChange}
          />
          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            name="password"
            onChange={handleChange}
          />
          <label htmlFor="dateOfBirth">Date of Birth</label>
          <div className="dateOfBirth">
            <div className="dateBlock">
              <p>Month</p>
              <SlArrowDown color="#b5bac1" size={12} />
            </div>
            <div className="months">
              <div>
                <p>January</p>
              </div>
              <div>
                <p>February</p>
              </div>
              <div>
                <p>March</p>
              </div>
              <div>
                <p>April</p>
              </div>
              <div>
                <p>May</p>
              </div>
              <div>
                <p>June</p>
              </div>
              <div>
                <p>July</p>
              </div>
              <div>
                <p>August</p>
              </div>
              <div>
                <p>September</p>
              </div>
              <div>
                <p>October</p>
              </div>
              <div>
                <p>November</p>
              </div>
              <div>
                <p>December</p>
              </div>
            </div>
            <div className="dateBlock">
              <p>Day</p>
              <SlArrowDown color="#b5bac1" size={12} />
            </div>
            <div className="dateBlock">
              <p>Year</p>
              <SlArrowDown color="#b5bac1" size={12} />
            </div>
          </div>
          <button className="register-btn">Continue</button>
        </form>
        <span onClick={handleClick}>Already have an account?</span>
      </div>
    </div>
  );
}
