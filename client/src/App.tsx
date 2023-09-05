import HomePage from "./pages/HomePage";
import LoginPage from "./pages/LoginPage";
import "./styles/App.scss";
import { Link, Route, Routes } from "react-router-dom";

function App() {
  return (
    <div className="app">
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/login" element={<LoginPage />} />
      </Routes>
    </div>
  );
}

export default App;
