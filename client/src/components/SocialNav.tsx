import settingsIcon from "../assets/settings.svg";
import microphone from "../assets/microphone.svg";
import deafen from "../assets/deafen.svg";
export default function SocialNav() {
  const placeholders = [...Array(10)].map((i, item) => {
    let opacity = 1 - item * 0.1;

    return (
      <div
        className="placeholder-container"
        key={item}
        style={{ opacity: opacity }}
      >
        <div className="icon-placeholder placeholder"></div>
        <div className="name-placeholder placeholder"></div>
      </div>
    );
  });

  return (
    <div className="social-nav-container">
      <div className="top-bar">
        <button className="search-btn">Find or start a conversation</button>
      </div>
      <div className="friend-tab">
        <svg
          className="friend-icon"
          aria-hidden="true"
          role="img"
          width="16"
          height="16"
          viewBox="0 0 24 24"
        >
          <g fill="none" fillRule="evenodd">
            <path
              fill="white"
              fillRule="nonzero"
              d="M0.5,0 L0.5,1.5 C0.5,5.65 2.71,9.28 6,11.3 L6,16 L21,16 L21,14 C21,11.34 15.67,10 13,10 C13,10 12.83,10 12.75,10 C8,10 4,6 4,1.5 L4,0 L0.5,0 Z M13,0 C10.790861,0 9,1.790861 9,4 C9,6.209139 10.790861,8 13,8 C15.209139,8 17,6.209139 17,4 C17,1.790861 15.209139,0 13,0 Z"
              transform="translate(2 4)"
            ></path>
            <path d="M0,0 L24,0 L24,24 L0,24 L0,0 Z M0,0 L24,0 L24,24 L0,24 L0,0 Z M0,0 L24,0 L24,24 L0,24 L0,0 Z"></path>
          </g>
        </svg>
        <p>Friends</p>
      </div>
      <div className="direct-message-container">
        <div className="title-container">
          <p className="direct-message-title">DIRECT MESSAGES</p>
          <svg
            x="0"
            y="0"
            className="poly"
            aria-hidden="true"
            role="img"
            width="16"
            height="16"
            viewBox="0 0 18 18"
          >
            <polygon
              fillRule="nonzero"
              fill="#B5BAC1"
              points="15 10 10 10 10 15 8 15 8 10 3 10 3 8 8 8 8 3 10 3 10 8 15 8"
            ></polygon>
          </svg>
        </div>
        <div className="message-list">{placeholders}</div>
      </div>
      <div className="user-info">
        <div className="user-icon-container">
          <div className="user-icon"></div>
          <div className="user-status-icon"></div>
        </div>
        <div className="user-info-container">
          <p className="user-name">Username</p>
          <p className="user-status">Online</p>
        </div>
        <div className="user-options">
          <img src={settingsIcon} alt="settings" className="icon" />
          <img src={microphone} alt="microphone" className="icon" />
          <img src={deafen} alt="deafen" className="icon" />
        </div>
      </div>
    </div>
  );
}
