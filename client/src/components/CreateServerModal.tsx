export default function CreateServerModal() {
  return (
    <div className="modal-bg">
      <div className="modal-container">
        <div className="modal-header">
          <h2>Create a Server</h2>
          <p>
            Your server is where you and your friends hang out. Make yours and
            start talking.
          </p>
          <button className="create-server-btn">
            <div>
              <img
                className="create-server-img"
                src="https://discord.com/assets/f303eeb986430817ee8a52a9b81aea45.svg"
              />
              <p>Create My Own</p>
            </div>
          </button>
        </div>
        <div className="modal-body">
          <button>Gaming</button>
          <button>School Club</button>
          <button>Study Group</button>
        </div>
        <div className="modal-footer">
          <p>Have an invite already?</p>
          <button className="join-btn">Join a Server</button>
        </div>
      </div>
    </div>
  );
}
