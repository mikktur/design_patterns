package mediator;

public class Message {

    private String Message;
    private String receiver;
    private String sender;

    public Message(String message, String sender, String receiver) {
        this.Message = message;
        this.receiver = receiver;
        this.sender = sender;
    }

    public String getMessage() {
        return Message;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSender() {
        return sender;
    }
    public void setMessage(String message) {
        this.Message = message;
    }


}
