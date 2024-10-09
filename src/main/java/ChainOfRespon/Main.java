package ChainOfRespon;

public class Main {

    public static void main(String[] args) {

        Handler generalHandler = new GeneralHandler();
        Handler contactReqHandler = new ContactReqHandler();
        Handler compensationHandler = new CompensationHandler();
        Handler developmentHandler = new DevelopmentHandler();

        // Sets the chain of responsibility.
        generalHandler.setNextHandler(contactReqHandler);
        contactReqHandler.setNextHandler(compensationHandler);
        compensationHandler.setNextHandler(developmentHandler);


        Message message1 = new Message("General message", "email1", Type.GENERAL);
        Message message2 = new Message("Contact request message", "email2", Type.CONTACTREQ);
        Message message3 = new Message("Compensation message", "email3", Type.COMPENSATION);
        Message message4 = new Message("Development message", "email4", Type.DEVELOPMENT);

        System.out.println("=====================================");
        System.out.println("Testing GeneralHandler");
        System.out.println("=====================================");
        generalHandler.handle(message1);
        System.out.println();
        System.out.println("=====================================");
        System.out.println("Testing ContactReqHandler");
        System.out.println("=====================================");
        generalHandler.handle(message2);
        System.out.println();
        System.out.println("=====================================");
        System.out.println("Testing CompensationHandler");
        System.out.println("=====================================");
        generalHandler.handle(message3);
        System.out.println();
        System.out.println("=====================================");
        System.out.println("Testing DevelopmentHandler");
        System.out.println("=====================================");
        generalHandler.handle(message4);
    }
}
