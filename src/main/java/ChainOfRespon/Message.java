package ChainOfRespon;

public class Message {
    String content;
    String email;
    Type type;

    public Message(String content, String email, Type type) {
        this.content = content;
        this.email = email;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public String getEmail() {
        return email;
    }

    public Type getType() {
        return type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
