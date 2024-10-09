package ChainOfRespon;

public class DevelopmentHandler extends Handler {



        @Override
        public void handle(Message message) {
            if (message.getType() == Type.DEVELOPMENT) {
                System.out.println("DevelopmentHandler: " + message.getContent());
            } else {
                // never triggers since it is the last handler in the chain
                System.out.println("Development handler cannot handle this message, sending it to the next handler");
                getNextHandler().handle(message);
            }
        }
}
