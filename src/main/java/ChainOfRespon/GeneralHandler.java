package ChainOfRespon;

public class GeneralHandler extends Handler {


    @Override
    public void handle(Message message) {
        if (message.getType() == Type.GENERAL) {
            System.out.println("GeneralHandler: " + message.getContent());
        } else {
            System.out.println("General handler cannot handle this message, sending it to the next handler " + getNextHandler().getClass().getSimpleName());
            getNextHandler().handle(message);
        }
    }
}
