import DirectMessage from "./pages/DirectMessage";
import HomePage from "./pages/HomePage";
import LoginPage from "./pages/LoginPage";
import "./styles/App.scss";
import { Link, Route, Routes } from "react-router-dom";

function App() {
  return (
    <div className="app">
      <Routes>
        <Route path="/home" element={<HomePage />} />
        <Route path="/" element={<LoginPage />} />
        <Route path="/direct-message" element={<DirectMessage />} />
      </Routes>
    </div>
  );
}

export default App;
