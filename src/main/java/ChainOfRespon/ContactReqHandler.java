package ChainOfRespon;

public class ContactReqHandler  extends Handler {



    @Override
    public void handle(Message message) {
        if (message.getType() == Type.CONTACTREQ) {
            System.out.println("ContactReqHandler: " + message.getContent());
        } else {
            System.out.println("ContactReq handler cannot handle this message, sending it to "+getNextHandler().getClass().getSimpleName());
            getNextHandler().handle(message);
        }
    }
}
