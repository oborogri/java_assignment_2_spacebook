import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
public class User
{
    String firstName;
    String lastName;
    int age;
    String nationality;
    String email;
    String password;

    Status status;

    ArrayList<Friendship> friendships   = new ArrayList<>();
    ArrayList<Message> inbox            = new ArrayList<>();
    ArrayList<Message> outbox           = new ArrayList<>(); 

    HashMap<String, Group> groups = new HashMap<>();

    /**
     * Constructs an object intended for testing only
     * The firstName determined by caller
     * Remaining fields used default data
     */
    public User(String firstName)
    {
        setState(firstName, "Simpson", firstName+"@simpson.com", "secret");
    }

    /**
     * Constructs an object of type User with given parameters
     * @param firstName, lastName, email, password
     */
    public User(String firstName, String lastName, String email, String password)
    {
        setState(firstName, lastName, email, password);
    }  

    /**
     * Sets user paramaters to given parameters  
     * @param firstName, lastName, email, password
     */
    public void setState(String firstName, String lastName, String email, String password)
    {
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.email      = email;
        this.password   = password;
        // set user status to online 
        this.status    = Status.ONLINE;         
    }  

    public void setStatus(Status status)
    {
        //update user status to given status parameter
        this.status = status;
    }

    /**
     * Send a broadcast message to all friends
     * @param subject, messageText
     */
    public void broadcastMessage(Subject subject, String messageText)
    {
        for(Friendship f : friendships)
        {
            Message message = new Message(subject, this, f.targetUser, messageText);
            outbox.add(message);
            f.targetUser.inbox.add(message);
            //message is added to sender's outbox and all friends' inbox
        }
    }

    /**
     * Send message
     * @param message
     */
    public void sendMessage(Message message)
    {
        outbox.add(message);
        message.to.inbox.add(message);
    }

    /**
     * Send message 
     * @param subject
     *     message subject
     * @param to
     *     message receiver
     * @param messageText
     */
    public void sendMessage(Subject subject, User to, String messageText)
    {
        Message message = new Message(subject,this, to, messageText);
        outbox.add(message);
        to.inbox.add(message);
    }

    public void displayOutbox()
    {
        //display all messages in outbox
        for(Message msg : outbox)
        {
            msg.displayMessage();
        }
    }

    public void displayInbox()
    {
        //display all messages in inbox
        for(Message msg : inbox)
        {
            msg.displayMessage();
        }
    }

    public void befriend(User friend)
    {
        //adding a user to friends
        //display an error message if user trying to add himself or same user twice
        if(friend == this)
        {
            System.out.println("Opps! You seem to have made a mistake in attempting to befriend yourself");
        }
        else if(friendships.contains(friend))
        {
            System.out.println("You attempted to befriend " + friend.firstName +" who is already a friend");
        }
        else
        {
            //new friendship is created and added to friendship list
            Friendship friendship = new Friendship(this, friend);
            friendships.add(friendship);
        }
    }

    private boolean friendshipsContains(User friend)
    {
        //for (Friendship f : friendships) 
        //{
        //    if (f.targetUser == friend)
        //    {
        //        return true;
        //    }
       // }
       // return false;
       
       // *** this is verbose *** changed to :
       return friendships.contains(friend);
    }

    public void unfriendAll()
    {
        //remove all friends from friendships
        friendships.clear();
    }

    public void unfriend(User friend) 
    {
        //remove a given friand from friendships
        for(Friendship friendship : friendships)
        {
            if(friendship.targetUser == friend)
            {
                friendships.remove(friendship);
                return;
            }
        }
    }

    public void displayFriends() 
    {
        if(friendships.isEmpty())
        {
            System.out.println("Unfortunately you have no friends");
        }

        System.out.println("I'm " + this.firstName + " " + this.lastName + " and these are my \"friends\" hehe :-)");
        for(Friendship friendship : friendships)
        {
            System.out.println("My friend "+friendship.targetUser.firstName + " is " + friendship.targetUser.status);
        }
    }

    public void displayFriends(Status status) 
    {
        System.out.println("I'm " + this.firstName + " " + this.lastName + " and these are my " + status + " \"friends\" hehe :-) ");
        for(Friendship friendship : friendships){
            if(friendship.targetUser.status == status)
            {
                System.out.println("My friend " + friendship.targetUser.firstName + " is " + status);            
            }
        }
    }

    public void addGroup(String groupName)
    {
        //create a new group, group name
        groups.put(groupName, new Group(groupName));
    }

    public void addGroupMember(String groupName, User user)
    {
        //adding a new user to group, groupName 
        Group group = groups.get(groupName);
        group.addGroupMember(user);
    }

    public void broadcastMessage(String groupName, Message message)
    {
        //sending a message to all users in a group, groupName
        groups.get(groupName).broadcastMessage(message);
    }

    public void displayMessages(ArrayList<Message> messages)
    {
        for (int i = 0; i < messages.size(); i++)
        {
            messages.get(i).displayMessage();
        }
    }

    public void displayMessages(Subject subject, ArrayList<Message> messages)
    {
        //display messages with given subject
        for (int i = 0; i < messages.size(); i++)
        {
            if(messages.get(i).subject == subject)
            {
                messages.get(i).displayMessage();
            }
        }
    }

    /**
     * Seeking for a message with given content
     * @param content   the content sought
     * @param msg       the array Message objects to be searched
     * @return          returns the first Message containing content, else null
     */
    public Message search(String content, ArrayList<Message> msg)
    {
        int index = 0;
        while(index < msg.size())
        {
            Message thisMsg = msg.get(index);
            if(content.equals(thisMsg.messageText))
            {
                return thisMsg;
            }
            index += 1;
        }
        return null;
    }

    /**
     * Seeking for a message with given subject  
     * @param subject   seeking a Message object with Subject subject
     * @param msg       the array Message objects to be searched
     * @return          returns the first Message with subject matching param, else null
     */
    public Message search(Subject subject, ArrayList<Message> msg)
    {
        int index = 0;
        while(index < msg.size())
        {
            Message thisMsg = msg.get(index);
            if(subject == thisMsg.subject)
            {
                return thisMsg;
            }
            index += 1;
        }
        return null;        
    }
}