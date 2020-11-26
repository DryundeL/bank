package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static TextField userTextField = new TextField();
    private static PasswordField pwBox = new PasswordField();
    private static PasswordField pwBox2 = new PasswordField();
    private static Button arrow = new Button("→");
    private static Stage primaryStage = new Stage();
    private static String name = userTextField.getText(), pass = pwBox.getText();

    private static void Alert1() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Авторизация выполнена успешно");

        alert.showAndWait();
    }

    private void Alert2() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Потвторите попытку регистрации");

        alert.showAndWait();
    }

    private static void Alert3() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Пароли не совпадают");

        alert.showAndWait();
    }


    //Первая ФОРМА
    public static void strtWin() {
        //Первая форма
        GridPane first = new GridPane();  // создание Grid для размтки эл-ов
        // grid.setGridLinesVisible(true); // видна/не видна Grid
        first.setHgap(10); //отступы столбцов и строк друг от друга
        first.setVgap(10);
        first.setPadding(new Insets(60, 60, 100, 65)); // отступы от краёв формы
        //ТЕКСТ "ПРИВЕТСТВИЕ"
        Text hello = new Text("Приветствуем Вас\nв банке \"BANG\"!");
        first.add(hello, 0, 9, 1, 1); // 1 число - номер столбца, 2 число - номер строки
        hello.setId("hello"); // для CSS
        // СОЗДАНИЕ КНОПУЛЕЧКИ "→"
        Button btn1 = new Button("→");
        GridPane.setMargin(btn1, new Insets(120)); //если включишь видимость Grid, увидишь отступы кнопки
        btn1.setId("butt1"); //для CSS

        first.add(btn1, 0, 16); //добавляем кнопку в Grid в 0 столбец в 16 строку

        Scene screen = new Scene(first, 450, 700); //добавляем Grid в Scene
        primaryStage.setScene(screen); //добавляем Scene в stage
        primaryStage.setTitle("BANG");
        primaryStage.getIcons().add(new Image("file:bangf.png"));
        screen.getStylesheets().add(0, "file:ForMainBank.css"); //подклчаем CSS
        primaryStage.show();
        primaryStage.getOnHidden();


        btn1.setOnAction(event -> Atuoriz());


    }


    //ВТОРАЯ ФОРМА
    public static void Atuoriz() {
        //2 форма
        GridPane grid = new GridPane();   //создание сетки для разметки формы
        // grid.setGridLinesVisible(true);  //видна/не видна
        // grid.setAlignment(Pos.CENTER); //выравнивание по центру
        grid.setHgap(0);                   //отступы например между Edit и Label по горизонтали
        grid.setVgap(10);                   //отступы например между Edit и Label по вертикали
        grid.setPadding(new Insets(45, 23, 100, 45)); //утсановка отступов от краёв формы

        //КНОПУЛЕЧКА "РЕГИСТРАЦИЯ"
        Button reg = new Button("Регистрация");
        HBox hbbtn = new HBox(100); //поместить в контейнер HBox, но это больше для удобства
        reg.setId("reg");
        hbbtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbbtn.getChildren().add(reg);
        grid.add(reg, 1, 0);

        //ЗАГОЛОВОК "АВТОРИЗАЦИЯ"
        Text scenetitle = new Text("Авторизация");
        scenetitle.setId("welcome-text");   //для CSS
        grid.add(scenetitle, 0, 11, 1, 1); //добавляем текст в Grid
        //i - столбец, i2 - строка, остальное хз))))
        //LABEL "ИМЯ ПОЛЬЗОВАТЕЛЯ"
        Label userName = new Label("Имя пользователя:");
        userName.setId("user-name"); //для CSS
        grid.add(userName, 0, 24);//добавляем текст в Grid

        //EDIT "ВВОД ИМЯ ПОЛЬЗОВАТЕЛЯ"
        TextField userTextField = new TextField();
        userTextField.setId("field");
        grid.add(userTextField, 0, 25);

        //LABEL "ПАРОЛЬ"
        Label pw = new Label("Пароль:");
        pw.setId("user-name");
        grid.add(pw, 0, 31);

        //EDIT "ВВОД ПАРОЛЬ"
        PasswordField pwBox = new PasswordField();
        pwBox.setId("field");
        grid.add(pwBox, 0, 32);

        //КНОПУЛЕЧКА "→"
        Button btn = new Button("→");
        HBox hbBtn = new HBox(100); //поместить в контейнер HBox, но это больше для удобства
        btn.setId("butt");
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(btn, 1, 36);


        Scene scene = new Scene(grid, 450, 700); //добавляем Grid в Scene

        primaryStage.setScene(scene); //добавляем scene в stage
        primaryStage.setTitle("BANG"); //название форме (как наказывала Ишкушка)
        scene.getStylesheets().add(0, "file:ForButtons.css"); //подключение CSS
        primaryStage.show();

        reg.setOnAction(event -> r3g());
    }


    //ТРЕТЬЯ ФОРМА МЕНЮ
    public static void r3g() {
        try (FileWriter fw = new FileWriter("C://reg/reg.txt", true)) {


            GridPane grid = new GridPane();   //создание сетки для разметки формы
            // grid.setGridLinesVisible(true);  //видна/не видна
            // grid.setAlignment(Pos.CENTER); //выравнивание по центру
            grid.setHgap(0);                   //отступы например между Edit и Label по горизонтали
            grid.setVgap(10);                   //отступы например между Edit и Label по вертикали
            grid.setPadding(new Insets(45, 23, 100, 58)); //утсановка отступов от краёв формы

            //КНОПУЛЕЧКА "Авторизация"
            Button avtor = new Button("Авторизация");
            HBox hbbtn = new HBox(100); //поместить в контейнер HBox, но это больше для удобства
            avtor.setId("avtor");
            hbbtn.setAlignment(Pos.BOTTOM_RIGHT);
            hbbtn.getChildren().add(avtor);
            grid.add(avtor, 1, 0);

            //ЗАГОЛОВОК "РЕГИСТРАЦИЯ"
            Text scenetitle = new Text("Регистрация");
            scenetitle.setId("welcome-text");   //для CSS
            grid.add(scenetitle, 0, 7, 1, 1); //добавляем текст в Grid
            //i - столбец, i2 - строка, остальное хз))))

            //LABEL "ИМЯ ПОЛЬЗОВАТЕЛЯ"
            Label userName = new Label("Имя пользователя:");
            userName.setId("Label"); //для CSS
            grid.add(userName, 0, 14);//добавляем текст в Grid

            //EDIT "ВВОД ИМЯ ПОЛЬЗОВАТЕЛЯ"

            userTextField.setId("field");
            grid.add(userTextField, 0, 15);
            name = userTextField.getText();


            //LABEL "ПАРОЛЬ"
            Label pw = new Label("Пароль:");
            pw.setId("Label");
            grid.add(pw, 0, 19);

            //EDIT "ВВОД ПАРОЛЬ"

            pwBox.setId("field");
            grid.add(pwBox, 0, 20);
            pass = pwBox.getText();

            //LABEL "ПОВТОРИТЕ ПАРОЛЬ"
            Label pwret = new Label("Повторите пароль:");
            pwret.setId("Label");
            grid.add(pwret, 0, 24);

            //EDIT "ПОВТОР ПАРОЛЬ"

            pwBox2.setId("field");
            grid.add(pwBox2, 0, 25);


            ToggleGroup group = new ToggleGroup();
            RadioButton yur = new RadioButton("Юридическое лицо");
            yur.setToggleGroup(group);
            yur.setId("faces");
            RadioButton phis = new RadioButton("Физическое лицо");
            phis.setToggleGroup(group);
            phis.setId("faces");


            HBox faces = new HBox();
            faces.setSpacing(25);
            faces.getChildren().addAll(yur, phis);
            grid.add(faces, 0, 27);


            //КНОПУЛЕЧКА "→"

            HBox hbBtn = new HBox(100); //поместить в контейнер HBox, но это больше для удобства
            arrow.setId("arrow");
            hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
            hbBtn.getChildren().add(arrow);
            grid.add(arrow, 1, 30);


            Scene scene = new Scene(grid, 450, 700); //добавляем Grid в Scene

            primaryStage.setScene(scene); //добавляем scene в stage
            primaryStage.setTitle("Регистрация"); //название форме (как наказывала Ишкушка)
            scene.getStylesheets().add(0, "file:Registration.css"); //подключение CSS
            primaryStage.show();


            avtor.setOnAction(event -> Atuoriz());
            arrow.setOnAction(event->backend());

        } catch (Exception ex) {
            ex.getMessage();
        }
    }


    public static void backend() {
        //взять из работы романа проверку логина и пароля
        // Сама работа на рабочем столе под названием Лабоант - Ассистент
       /* if (pwBox.getText() != pwBox2.getText()) {
            arrow.setOnAction(event -> Alert3());
        }
        else{*/
                primaryStage.toBack();
                Worker.AMenu();

        //}
    }
}
