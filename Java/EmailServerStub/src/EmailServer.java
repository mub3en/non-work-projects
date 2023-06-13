import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.Objects.isNull;

/**
 A class that stores e-mail messages.
 */
class Mailbox
{
    private String user;
    private ArrayList<Message> messages;
    private  ArrayList<Message> sentMessages;

    public String getUser() {
        return user;
    }

    /**
     Initializes an empty mailbox.
     */
    public Mailbox(String user)
    {
        this.user = user;
        messages = new ArrayList<Message>();
        sentMessages = new ArrayList<Message>();
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public ArrayList<Message> getSentMessages() {
        return sentMessages;
    }

    /**
     Adds a new message.
     @param m the message
     */
    public void addMessage(Message m)
    {
        // Implement me
//    	this.messages.addAll(Arrays.asList(m));
    	this.messages.add(m);
    }

    public void addSentMessage(Message m)
    {
        // Implement me
//    	this.sentMessages.addAll(Arrays.asList(m));
    	this.sentMessages.add(m);
    }

    /**
     Gets the ith message.
     @param i the message number to get
     @return the ith message
     */
    public Message getMessage(int i)
    {
    	
        // Implement me - return a message
        return this.messages.get(i);
    }

    public Message getSentMessage(int i)
    {
        // Implement me - return a message
    	return this.sentMessages.get(i);
    }

    /**
     Removes the ith message.
     @param i the message number to remove
     */
    public void removeMessage(int i)
    {
        // Implement me
    	this.messages.remove(i);

    }

    public void removeSentMessage(int i)
    {
        // Implement me
    	this.sentMessages.remove(i);

    }

}


/**
 A class that models an e-mail message.
 */
class Message
{
    private String recipient;
    private String sender;
    private String subject;
    private String messageText;
    private Date date;

    /**
     Takes the sender and recipient
     @param recipient the recipient
     @param sender the sender
     */
    public Message(String recipient, String sender, String subject)
    {
        this.recipient = recipient;
        this.sender = sender;
        this.subject = subject;
        messageText = "";
        this.date = Calendar.getInstance().getTime();
    }

    /**
     Appends a line of text to the message body.
     @param line the line to append
     */
    public void append(String line)
    {
        if (messageText.length() > 0)
            messageText = messageText + "\n" + line;
        else
            messageText = line;
    }

    /**
     Makes the message into one long string.
     */
    public String toString()
    {
        return "The code To:"+recipient+"\nFrom:"+sender+"\nSubject:"+subject+"\nDate:"+date+"\nMessageText:"+messageText;
    }

    public String getMessageHeader() {
        SimpleDateFormat sdf = new SimpleDateFormat("\t\tEEE MM dd");
        return sender + "\nSubject: "  + subject +  " " + sdf.format(date) +
                "\n" +  messageText.split("\\n")[0] + "\n";
    }

    /**
     Prints the message text.
     */
    public void print()
    {
        System.out.print(this.toString());
    }

    public void send(Mailbox sender, Mailbox recipient, Message message) {
        //Implement me
    	if(sender.getUser() != null && recipient.getUser() != null ) {
    		sender.addSentMessage(message);
    		recipient.addMessage(message);
    	}

    }

}
class MailboxList {

    private MailboxList() {}

    private  static ArrayList<Mailbox> mailboxList = new ArrayList<>();
    public static Mailbox GetUserMailbox(String user) {
        for (Mailbox mailbox: mailboxList) {
            if (mailbox.getUser().equals(user))
                return mailbox;
        }
        // user doesn't exist so create this user
        Mailbox mailbox = new Mailbox(user);
        mailboxList.add(mailbox);
        return mailbox;
    }
}

public class EmailServer
{
    public static void main(String[] args)
    {
        //     MailboxList mailboxOwners = new MailboxList();
        /* Mailbox sender = MailboxList.GetUserMailbox("Tobias");
        Mailbox recipient = MailboxList.GetUserMailbox("Rolf");
         */

        Mailbox tobias = MailboxList.GetUserMailbox("Tobias");
        Mailbox rolf = MailboxList.GetUserMailbox("Rolf");

        Message email = new Message("Rolf", "Tobias", "First Joke");
        email.append("What do you call an alligator in a vest?");
        email.append("An investigator!");

        email.print();
        email.send(tobias, rolf, email);

        email = new Message("Rolf", "Tobias",  "Second Joke");
        email.append("Did you hear about the two antennae that got married?");
        email.append("The ceremony was terrible but the reception was amazing.");
        email.print();
        email.send(rolf, tobias, email);


//           rolf = MailboxList.GetUserMailbox("Rolf");
//           tobias = MailboxList.GetUserMailbox("Tobias");
           


        Message emailResponse = new Message("Tobias", "Rolf", "New Joke");
        emailResponse.append("When is it time to go to the dentist?");
        emailResponse.append("Tooth hurty");
        emailResponse.print();
        emailResponse.send(rolf, tobias, emailResponse);

        System.out.println("\n\nInbox:");
        for (Message msg: rolf.getMessages()) {
            System.out.println(msg.getMessageHeader());
        }
        System.out.println("Sent:");
        for (Message msg: rolf.getSentMessages()) {
            System.out.println(msg.getMessageHeader());
        }

        System.out.println("Inbox:");
        for (Message msg: tobias.getMessages()) {
            System.out.println(msg.getMessageHeader());
        }
        System.out.println("Sent:");
        for (Message msg: tobias.getSentMessages()) {
            System.out.println(msg.getMessageHeader());
        }

    }
}


