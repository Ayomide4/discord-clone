import friendIcon from "../assets/result.svg";
import messageIcon from "../assets/messages.svg";
import questionIcon from "../assets/help.svg";
import inboxIcon from "../assets/inbox.svg";
export default function Message() {
  return (
    <div className="message">
      <div className="message-header">
        <div className="header-left">
          <img src={friendIcon} alt="friend-icon" className="icon" />
          <p className="selected">Friends</p>
          <div className="separator"></div>
        </div>
        <div className="message-header-filters">
          <p>Online</p>
          <p>Pending</p>
          <p>All</p>
          <p>Blocked</p>
          <p>Add Friend</p>
        </div>
        <div className="message-header-options">
          <img src={messageIcon} alt="message-icon" className="icon toolbar" />
          <div className="separator"></div>
          <img src={inboxIcon} alt="inbox-icon" className="icon toolbar" />
          <img
            src={questionIcon}
            alt="question-icon"
            className="icon toolbar"
          />
        </div>
      </div>
      <div className="conversation"></div>
      <div className="message-box"></div>
      <section className="direct-message-container">
        <div className="direct-message"></div>
        <div className="friend-profile"></div>
      </section>
    </div>
  );
}
