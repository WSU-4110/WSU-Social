public class Messages
{
    public int messageID;
    public String message;
    public static int objCreate = 0;

    Messages()
    {
        messageID = -1;
        message = "";
    }

    Messages(String message)
    {
        this.message = message;
        objCreate++;
        messageID = objCreate;
    }

    int getMessageID()
    {
        return messageID;
    }

    String getMessage()
    {
        return message;
    }

    void editMessage(String newMessage)
    {
        message = newMessage;
    }

    boolean isAllCaps()
    {
        int Upper = 0;
        for(int i = 0; i < message.length(); i++)
        {
            if(Character.isUpperCase(message.charAt(i)))
            {
                Upper++;
            }
            else if(message.charAt(i) == ' ')
            {

            }
            else
            {
                return false;
            }
        }
        if(Upper != 0) {
            return true;
        }
        return false;
    }

    void clone(Messages inpMessage)
    {
        this.message = inpMessage.message;
        this.messageID = inpMessage.messageID;
    }

    boolean isOverLimit()
    {
        if(message.length() > 255)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    boolean noSpacing()
    {
        for(int i = 0; i < message.length(); i++)
        {
            if(Character.isSpaceChar(message.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }

    boolean hasHashtag()
    {
        for(int i = 0; i < message.length(); i++)
        {
            if(message.charAt(i) == '#')
            {
                if(i == 0)
                {
                    return true;
                }
                else if(message.charAt(i-1) == ' ')
                {
                    return true;
                }
            }
        }
        return false;
    }
}
