import { useNavigate } from "react-router-dom";

export default function Login({ setTrigger }: any) {
  const handleClick = () => {
    setTrigger((prev: boolean) => !prev);
  };

  const navigate = useNavigate();
  const handleLogin = () => {
    navigate("/");
  };

  return (
    <div className="form-container">
      <div className="test">
        <div className="title-container">
          <h3 className="login-title">Welcome back!</h3>
          <h4>We're so excited to see you again!</h4>
        </div>
        <form className="form">
          <label htmlFor="email">Email</label>
          <input type="email" id="email" />
          <label htmlFor="password">Password</label>
          <input type="password" id="password" />
          <button className="login-btn" onClick={handleLogin}>
            Log In
          </button>
        </form>
        <p>
          Need an account?
          <span onClick={handleClick}> Register</span>
        </p>
      </div>
    </div>
  );
}
