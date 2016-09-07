import java.util.ArrayList;
public class TestMessaging
{
    User homer = new User("Homer","Simpson","h@s.com","secret");
    User barney = new User("Barney","Gumble","b@s.com","secret");
    int numberMessages = 14;
    Message[] messages = new Message[numberMessages];
    ArrayList<Message> messageList = new ArrayList<>();
    
    public TestMessaging()
    {
        
        messages[0] = new Message(Subject.PERSONAL, homer, barney,"hi");
        messages[1] = new Message(Subject.PERSONAL, homer, barney,"aloha");
        messages[2] = new Message(Subject.PERSONAL, homer, barney,"bonjour");
        messages[3]= new Message(Subject.PERSONAL,  homer, barney,"howdy");
        messages[4]= new Message(Subject.PERSONAL,  homer, barney,"so long");
        messages[5]= new Message(Subject.PERSONAL,  homer, barney,"adios");
        messages[6]= new Message(Subject.FAMILY,  homer, barney,"shalom");
        messages[7]= new Message(Subject.FAMILY,  homer, barney,"ciao");
        messages[8]= new Message(Subject.FAMILY,  homer, barney,"hola");
        messages[9]= new Message(Subject.WORK,  homer, barney,"tja");
        messages[10]= new Message(Subject.WORK,  homer, barney,"god dag");
        messages[11]= new Message(Subject.GENERAL,  homer, barney,"conas ta tu");
        messages[12]= new Message(Subject.GENERAL,  homer, barney,"xin chao");
        messages[13]= new Message(Subject.WORK,  homer, barney,"ni hao");
        
        for(int i = 0; i < messages.length; i += 1)
        {
        	messageList.add(messages[i]);
        }
    }

    public void sortArrayMessages()
    {     
        System.out.println("\nMessages");
        System.out.println("-------------------------------------------");
        System.out.println("Message[] Unsorted");
        for(Message message : messages)
        {
            message.displayMessageContent();
        }
        
        MessageSort.selectionSort(messages);

        System.out.println("\nMessage[] Sorted");

        for(Message message : messages)
        {
            message.displayMessageContent();
        }
    }

    public void sortArrayListMessages()
    {
        //First populate message in & out boxes
        for(Message message : messages)
        {
            homer.sendMessage(message);
        }
        //Unsorted
        System.out.println("ArrayList<Message> Unsorted");
        homer.displayOutbox();
        MessageSort.selectionSort(homer.outbox);
        //Sorted
        System.out.println("\nArrayList Sorted");
        homer.displayOutbox();  
    }

    public void displayMessageList()
    {
    	homer.displayMessages(messageList);
    }
    
    public void displayMessageList(Subject subject)
    {
    	homer.displayMessages(subject, messageList);
    }

    public static void testAll()
    {
         TestMessaging test = new TestMessaging();
         test.displayMessageList();
         test.displayMessageList(Subject.WORK);
         test.sortArrayListMessages();
         test.sortArrayMessages();         
    }
}