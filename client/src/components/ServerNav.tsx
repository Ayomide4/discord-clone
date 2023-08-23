import { BsDiscord } from "react-icons/bs";
import { AiOutlinePlus } from "react-icons/ai";
export default function ServerNav() {
  return (
    <div className="server-nav-container">
      <div className="discord-btn">
        <BsDiscord color="white" size={32} />
      </div>
      <div className="line"></div>
      <div className="add-btn">
        <AiOutlinePlus color="#23A559" size={26} />
      </div>
    </div>
  );
}
