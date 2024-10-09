package ChainOfRespon;

public class CompensationHandler extends Handler {



    @Override
    public void handle(Message message) {
        if (message.getType() == Type.COMPENSATION) {
            System.out.println("CompensationHandler: " + message.getContent());
        } else {
            getNextHandler().handle(message);
        }
    }
}
