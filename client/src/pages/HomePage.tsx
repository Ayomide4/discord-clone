import ServerNav from "../components/ServerNav";
import SocialNav from "../components/SocialNav";
import SocialDashboard from "../components/SocialDashboard";
import CreateServerModal from "../components/CreateServerModal";

export default function HomePage() {
  return (
    <div className="home-container">
      <ServerNav />
      <SocialNav />
      <SocialDashboard />
      <CreateServerModal />
    </div>
  );
}
