import ServerNav from "../components/ServerNav";
import SocialNav from "../components/SocialNav";
import Message from "../components/Message";

export default function DirectMessage() {
  return (
    <div className="direct-message-container">
      <ServerNav />
      <SocialNav />
      <Message/> 
    </div>
  );
}
