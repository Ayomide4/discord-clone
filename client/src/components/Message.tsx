import friendIcon from "../assets/result.svg";
import messageIcon from "../assets/messages.svg";
import questionIcon from "../assets/help.svg";
import inboxIcon from "../assets/inbox.svg";
import exploreIcon from "../assets/explore.svg";
import rightChevron from "../assets/right-chevron.svg";
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
          <div className="filter-container">
            <p>Online</p>
          </div>
          <div className="filter-container">
            <p>Pending</p>
          </div>
          <div className="filter-container">
            <p>All</p>
          </div>
          <div className="filter-container">
            <p>Blocked</p>
          </div>
          <p id="add-friend-tag">Add Friend</p>
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
      <div className="container">
        <section className="conversation">
          <div className="add-friend-container">
            <h2>ADD FRIEND</h2>
            <p>You can add friends with their Discord username.</p>
            <div className="friend-request-container">
              <input
                type="text"
                placeholder="You can add friends with their Discord username."
                id="add-friend-input"
              />
              <button className="add-friend-btn">Send Friend Request</button>
            </div>
          </div>
          <div className="extra">
            <div className="img-container">
              <div className="bg-img"></div>
              <p id="bg-img-subtitle">
                Wumpus is waiting of friends. You don't have to though!
              </p>
            </div>
            <h2>OTHER PLACES TO MAKE FRIENDS</h2>
            <div id="explore-btn">
              <div id="explore-icon-container">
                <img
                  src={exploreIcon}
                  alt="explore-icon"
                  id="explore-icon"
                  className="icon"
                />
              </div>
              <p>Explore Discoverable Servers</p>
              <img src={rightChevron} alt="right-chevron" className="icon" />
            </div>
          </div>
        </section>
        <section className="friend-activity">
          <h2>Active Now</h2>
          <div id="test">
            <h3>It's quiet for now...</h3>
            <div id="description-container">
              <p>
                When a friend starts an activity-like playing a game or hanging
                out on voice-we'll show it here!
              </p>
            </div>
          </div>
        </section>
      </div>
    </div>
  );
}
