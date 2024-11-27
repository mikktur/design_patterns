package mediator;

import javafx.application.Application;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(javafx.stage.Stage primaryStage) throws Exception {

        IChatMediator chatMediator = new ChatMediator();
        new ClientController(chatMediator, "John");
        new ClientController(chatMediator, "Lisa");
        new ClientController(chatMediator, "David");
        new ClientController(chatMediator, "Alice");


    }

}
