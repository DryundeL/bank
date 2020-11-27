package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Admin {
    private static Stage primaryStage = new Stage();
    public static void SAMenu() {
        GridPane grid = new GridPane();

        grid.setHgap(0);
        grid.setVgap(10);
        grid.setPadding(new Insets(30, 30, 29, 30));
        //  grid.setGridLinesVisible(true);


        Image inpstr = new Image  ("file:superadm.png");
        ImageView image1= new ImageView(new Image("file:superadm.png"));
        image1.setId("box1");
        GridPane.setHalignment(image1, HPos.CENTER);
        GridPane.setValignment(image1, VPos.CENTER);
        grid.getChildren().add(image1);




        Label admin = new Label("Администратор");
        admin.setId("admin");
        GridPane.setHalignment(admin, HPos.CENTER);
        grid.add(admin, 0, 1);


        Label text = new Label("Добро пожаловать!\nУдачного рабочего дня!");
        text.setId("text"); //для CSS
        grid.add(text, 0, 7);//добавляем текст в Grid
        GridPane.setHalignment(text, HPos.CENTER);


        HBox box = new HBox();

        Button func1 = new Button("зарегистрировать нового сотрудника");
        func1.setPrefSize(500, 60);
        func1.setId("functions");
        box.getChildren().add(func1);
        grid.add(func1, 0, 10);
        func1.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHgrow(func1, Priority.ALWAYS);


        Button func2 = new Button("оформить заявку на ипотеку");
        func2.setPrefSize(500, 60);
        func2.setId("functions");
        box.getChildren().add(func2);
        grid.add(func2, 0, 12);
        func2.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHgrow(func2, Priority.ALWAYS);


        Button func3 = new Button("оформить заявку на кредит");
        func3.setPrefSize(500, 60);
        func3.setId("functions");
        box.getChildren().add(func3);
        grid.add(func3, 0, 14);
        func3.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHgrow(func3, Priority.ALWAYS);


        Button func4 = new Button("выйти из учётной записи");
        func4.setPrefSize(500, 60);
        func4.setId("functions");
        box.getChildren().add(func4);
        grid.add(func4, 0, 16);
        func3.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHgrow(func4, Priority.ALWAYS);
        func4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.close();
            }
        });

        Scene scene = new Scene(grid, 450, 700); //добавляем Grid в Scene

        primaryStage.setScene(scene); //добавляем scene в stage
        primaryStage.setTitle("Администратор");
        scene.getStylesheets().add(0, "file:SuperAdminMenu.css"); //подключение CSS
        primaryStage.show();

    }
}
