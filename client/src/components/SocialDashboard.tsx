import SocialHub from "./SocialHub";
import Topbar from "./Topbar";

export default function SocialDashboard() {
  return (
    <div className="social-dash-container">
      <Topbar />
      <div className="line"></div>
      <SocialHub />
    </div>
  );
}
