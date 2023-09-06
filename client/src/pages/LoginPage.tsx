import { useState } from "react";
import Login from "../components/Login";
import Register from "../components/Register";

export default function LoginPage() {
  const [trigger, setTrigger] = useState(false);
  console.log(trigger);
  return (
    <div className="login-container">
      {trigger ? (
        <Register setTrigger={setTrigger} />
      ) : (
        <Login setTrigger={setTrigger} />
      )}
    </div>
  );
}
