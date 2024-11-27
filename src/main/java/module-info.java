module design_patterns {
    requires javafx.controls;
    requires javafx.fxml;

    opens flyweight to javafx.fxml;
    exports mediator;
    opens mediator to javafx.fxml;
    exports flyweight;
    exports flyweight.tile;
    opens flyweight.tile to javafx.fxml;
    exports flyweight.map;
    opens flyweight.map to javafx.fxml;
}