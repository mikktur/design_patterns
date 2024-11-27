package mediator;

import java.util.List;

public interface IChatMediator {

    void sendMessage(Message message);

    void addClient(ClientController client);
    List<ClientController> getClients();
}
