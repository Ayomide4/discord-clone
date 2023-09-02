export default function MessageList() {
  const defaultArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
  const defaultMessages = defaultArray.map(() => (
    <div className="contact">
      <div className="contact-avatar"></div>
      <div className="contact-name"></div>
    </div>
  ));

  return <div className="message-list">{defaultMessages}</div>;
}
