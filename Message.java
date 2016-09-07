public class Message
{
    Subject   subject;
    String    messageText;
    User      from;
    User      to;

    public Message(Subject subject, User from, User to, String messageText)
    {
        this.subject        = subject;
        this.from           = from;
        this.to             = to;
        this.messageText    = messageText;
    } 

    public void displayMessage()
    {
        String nameFrom = from.firstName;
        String nameTo   = to.firstName;

        System.out.println("Message subject: " + subject + " " + nameFrom + " says \"" + messageText + "\" to " + nameTo + "\n");
    }

    public void displayMessageContent()
    {
        System.out.println(messageText);
    }
}