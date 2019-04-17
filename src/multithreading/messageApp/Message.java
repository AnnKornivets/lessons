package multithreading.messageApp;

import java.io.Serializable;

public class Message implements Serializable {
    private String Message;
    private String sender;


    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Message(String message, String sender) {
        Message = message;
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Message{" +
                "Message='" + Message + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }
}
