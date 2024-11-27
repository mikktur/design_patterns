package mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediator implements IChatMediator {
    private List<ClientController> clients;

    public ChatMediator() {
        this.clients = new ArrayList<>();
    }

    @Override
    public void sendMessage(Message message) {

        for (ClientController client : clients) {
            if (client.getName().equals(message.getReceiver())) {
                client.receiveMessage(message);
                System.out.println(client.getName());

            }
        }
    }
    public List<ClientController> getClients() {
        return clients;
    }
    @Override
    public void addClient(ClientController client) {
        clients.add(client);
        clients.forEach(ClientController::updateUserList);
    }

}
