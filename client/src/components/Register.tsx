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

  const toggleDropdown = (e: any) => {
    const dropdown = e.target.parentNode;
    const menu = dropdown.querySelector(".menu");
    menu?.classList.toggle("active");
  };

  const handleClick = () => {
    setTrigger(false);
  };

  const handleSubmit = (e: any) => {
    e.preventDefault();
    console.log(state);
  };

  const handleSelect = (e: any) => {
    dispatch({
      type: "CHANGE_INPUT",
      payload: { name: e.target.id, value: e.target.innerText },
    });
    const dropdown = e.target.parentNode.parentNode;
    const menu = dropdown.querySelector(".menu");
    dropdown.classList.remove("active");
  };

  const months = [
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December",
  ];
  const days = [];
  const years = [];

  for (let i = 1; i <= 31; i++) {
    days.push(i);
  }

  for (let i = 2020; i >= 1871; i--) {
    years.push(i);
  }

  const monthList = months.map((month) => {
    return (
      <ul className="testMonth" key={month}>
        <li id="month" onClick={(e) => handleSelect(e)}>
          {month}
        </li>
      </ul>
    );
  });

  const daysList = days.map((day) => {
    return (
      <ul key={day}>
        <li id="day" onClick={(e) => handleSelect(e)}>
          {day}
        </li>
      </ul>
    );
  });

  const yearsList = years.map((year) => {
    return (
      <ul key={year}>
        <li id="year" onClick={(e) => handleSelect(e)}>
          {year}
        </li>
      </ul>
    );
  });

  return (
    <div className="register-container">
      <h2>Create an account</h2>
      <div className="register-form">
        <form onSubmit={(e) => handleSubmit(e)}>
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
          <div className="date-of-birth">
            <div
              className="dropdown-container"
              onClick={(e) => toggleDropdown(e)}
            >
              <div className="dropdown-header noselect">
                {state.month ? <p>{state.month}</p> : <p>Month</p>}
                <SlArrowDown size={12} color="#DBDEE1" />
              </div>
              <div className="menu months">{monthList}</div>
            </div>

            <div
              className="dropdown-container"
              onClick={(e) => toggleDropdown(e)}
            >
              <div className="dropdown-header">
                {state.day ? <p>{state.day}</p> : <p>Day</p>}
                <SlArrowDown size={12} color="#DBDEE1" />
              </div>
              <div className="menu days">{daysList}</div>
            </div>
            <div
              className="dropdown-container"
              onClick={(e) => toggleDropdown(e)}
            >
              <div className="dropdown-header">
                {state.year ? <p>{state.year}</p> : <p>Year</p>}
                <SlArrowDown size={12} color="#DBDEE1" />
              </div>
              <div className="menu">{yearsList}</div>
            </div>
          </div>
          <button className="register-btn">Continue</button>
        </form>
        <span onClick={handleClick}>Already have an account?</span>
      </div>
    </div>
  );
}
