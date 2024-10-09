package ChainOfRespon;


public abstract class Handler {

    private Handler nextHandler;

    public void handle(Message message) {
        if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }

    public void setNextHandler(Handler handler) {
        nextHandler = handler;
    }

    public Handler getNextHandler() {
        return nextHandler;
    }


}