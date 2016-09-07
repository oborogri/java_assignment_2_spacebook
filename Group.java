import java.util.ArrayList;
public class Group
{

    String groupName;
    ArrayList<User> members;
    /**
     * Create a new group
     * @param groupName
     */
    public Group(String groupName)
    {
        this.groupName = groupName;
        members = new ArrayList<>();
    }

    /**
     * Add a new user to group
     * @param user
     */
    public void addGroupMember(User user)
    {
        members.add(user);
    }

    /**
     * Send a message to the inbox of each group member
     * 
     * @param message
     */
    public void broadcastMessage(Message message)
    {
        for(int i = 0; i < members.size(); i++)
        {
            members.get(i).sendMessage(message);
        }
    }

    /*
     * @return all the group names in a single string
     * Use the \n between each name to ensure printed on separate lines
     */
    private String groupList()
    {
        String names = "";
        for(int i = 0; i < members.size(); i++)
        {
            names += members.get(i).firstName + "\n";
        }
        return names;
    }

    @Override
    public String toString() {
        return "GroupName=" + groupName + "\n" + groupList();
    } 
}