import { SlArrowDown } from "react-icons/sl";
export default function Register({ setTrigger }: any) {
  const handleClick = () => {
    setTrigger(false);
  };

  return (
    <div className="register-container">
      <h2>Create an account</h2>
      <div className="register-form">
        <form>
          <label htmlFor="email">Email</label>
          <input type="email" id="email" />
          <label htmlFor="displayName">Display Name</label>
          <input type="text" id="displayName" />
          <label htmlFor="username">Username</label>
          <input type="text" id="username" />
          <label htmlFor="password">Password</label>
          <input type="password" id="password" />
          <label htmlFor="dateOfBirth">Date of Birth</label>
          <div className="dateOfBirth">
            <div className="dateBlock">
              <p>Month</p>
              <SlArrowDown color="#b5bac1" size={12} />
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
