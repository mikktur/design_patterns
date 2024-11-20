package flyweight;


import flyweight.map.Map;
import flyweight.map.WildernessMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class View extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        StackPane pane = new StackPane();
        Canvas canvas = new Canvas(400, 400);
        pane.getChildren().add(canvas);
        new WildernessMap(400,400, canvas);

        Scene scene = new Scene(pane,400,400);
        stage.setScene(scene);
        stage.setTitle("Game Map");
        stage.show();
    }
}
