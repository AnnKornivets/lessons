package lesson9.enums;


import java.util.*;

enum MessagePriority{

    LOW ,MEDIUM,HIGH,URGENT;

 public  static MessagePriority getPriority(int ord){

   for (MessagePriority mp:values()){
       if(ord==mp.ordinal()){
           return  mp;
       }
   }
   throw new AssertionError("wrong ordinary"+ord);
 }
}





///////////////////////////////////////
public class Message {
    private int code;
    private  MessagePriority priority;

    public Message(int code, MessagePriority priority) {
        this.code = code;
        this.priority = priority;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public MessagePriority getPriority() {
        return priority;
    }

    public void setPriority(MessagePriority priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message = (Message) o;

        if (getCode() != message.getCode()) return false;
        return getPriority() == message.getPriority();
    }

    @Override
    public int hashCode() {
        int result = getCode();
        result = 31 * result + (getPriority() != null ? getPriority().hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(MessagePriority.HIGH);
        List<Message> messages = MessageGenerator.generate(12);
    }
}


class MessageGenerator{

    public static List<Message> generate(int num){
        if (num<=0){ return Collections.emptyList();

        }
        Random random = new Random();
        List<Message> messages=new ArrayList<>(num);
       //  values() - вернет массив констант
        int typesCount =MessagePriority.values().length;
        for (int i=0;i<num;i++){
            messages.add(new Message(random.nextInt(10),
                    MessagePriority.getPriority(random.nextInt(typesCount))));
        }
        return messages;

    }
}
