import friendIcon from "../assets/result.svg";
export default function Message() {
  return (
    <div className="message">
      <div className="message-header">
        <img src={friendIcon} alt="friend-icon" className="friend-icon" />
        <p>Friends</p>
      </div>
      <div className="conversation"></div>
      <div className="message-box"></div>
    </div>
  );
}
