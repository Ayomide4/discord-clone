export default function SocialHub() {
  return (
    <div className="social-hub-container">
      <div className="left">
        <div className="add-friend-container">
          <h3>ADD FRIEND</h3>
          <p>You can add friends with their discord username</p>
          <div className="add-friend-input">
            <input
              type="text"
              placeholder="You can add friends with their discord username"
            />
            <div className="submit-btn">Send Friend Request</div>
          </div>
          <div></div>
        </div>
        <div className="discover-container">
          <div className="test">
            <h3>OTHER PLACES TO MAKE FRIENDS</h3>
            <div className="discover-btn">
              <div className="explore-left">
                <div className="explore-icon">
                  <svg
                    aria-hidden="true"
                    role="img"
                    width="24"
                    height="24"
                    viewBox="0 0 24 24"
                  >
                    <path
                      fill="white"
                      d="M12 10.9C11.39 10.9 10.9 11.39 10.9 12C10.9 12.61 11.39 13.1 12 13.1C12.61 13.1 13.1 12.61 13.1 12C13.1 11.39 12.61 10.9 12 10.9ZM12 2C6.48 2 2 6.48 2 12C2 17.52 6.48 22 12 22C17.52 22 22 17.52 22 12C22 6.48 17.52 2 12 2ZM14.19 14.19L6 18L9.81 9.81L18 6L14.19 14.19Z"
                    ></path>
                  </svg>
                </div>
                <p>Explore Discoverable Servers</p>
              </div>
              <svg
                fill="none"
                height="20"
                viewBox="0 0 20 20"
                width="20"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  clip-rule="evenodd"
                  d="m5.41667 4.2625 5.66573 5.7375-5.66573 5.7375 1.74426 1.7625 7.42237-7.5-7.42237-7.5z"
                  fill="#DBDEE1"
                  fill-rule="evenodd"
                ></path>
              </svg>
            </div>
          </div>
        </div>
      </div>
      <div className="right">
        <div className="default-msg">
          <h3>Active Now</h3>
          <p className="quiet">It's quiet for now...</p>
          <p>
            When a friend starts an activity-like playing a game or hanging out
            on voice-we'll show it here!
          </p>
        </div>
      </div>
    </div>
  );
}
