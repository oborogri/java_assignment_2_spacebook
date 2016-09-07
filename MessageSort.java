import java.util.ArrayList;
public class MessageSort
{
    public static void selectionSort(Message[] m)
    {
        for (int i = 0; i < m.length; i++)
        {
            for (int j = i + 1; j < m.length; j ++)
            {
                if(m[j].messageText.compareTo(m[i].messageText) < 0)
                {
                    swap(m, i, j);
                }
            }
        }
    }

    private static void swap(Message[] arMsg, int to, int from)
    {
        Message msg = arMsg [to];  
        arMsg[to] = arMsg[from];
        arMsg[from] = msg; 
    }
    
    public static void selectionSort(ArrayList<Message> m)
    {
        for (int i = 0; i < m.size(); i++)
        {
            for (int j = i + 1; j < m.size(); j ++)
            {
                if(m.get(j).messageText.compareTo(m.get(i).messageText) <0)
                {
                    swap(m, j, i);
                }
            }
        }
    }

    private static void swap(ArrayList<Message> list, int to, int from)
    {
        Message msg = list.get(to);
        list.set(to, list.get(from));
        list.set(from, msg);
    }
}