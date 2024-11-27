package mediator;

public class ClientController {

    private IChatMediator mediator;
    private String name;
    private ClientView view;

    public ClientController(IChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        this.view = new ClientView();
        this.view.getSendButton().setOnAction(event -> {
            String message = view.getMessageBox().getText();
            String recipient = view.getUserBox().getSelectionModel().getSelectedItem().toString();
            if (!message.isEmpty() && !recipient.isEmpty()) {
                System.out.println("Sending message");

                sendMessage(message,this.name, recipient);
                view.getMessageBox().clear();
            } else {
                System.out.println("Please enter a message and select a recipient");
            }

        });
        view.setTitle(name);
        view.display();
        mediator.addClient(this);
        updateUserList();
    }

    public void sendMessage(String message,String sender ,String recipient) {
        Message msg = new Message(message, sender, recipient);
        mediator.sendMessage(msg);

        view.updateChatBox(msg);
    }



    public void receiveMessage(Message message) {
        view.updateChatBox(message);
    }

    public String getName() {
        return name;
    }
    public void updateUserList() {
        view.getUserBox().getItems().clear();
        mediator.getClients().forEach(client -> {
            if (!client.getName().equals(this.name) && !view.getUserBox().getItems().contains(client.getName())) {
                view.getUserBox().getItems().add(client.getName());
            }
        });
    }
}
