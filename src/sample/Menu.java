package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static TextField userTextField = new TextField();
    private static PasswordField pwBox = new PasswordField();
    private static PasswordField pwBox2 = new PasswordField();
    private static Button arrow = new Button("→");
    private static Stage primaryStage = new Stage();
    private static String name = userTextField.getText(), pass = pwBox.getText();
    public static RadioButton selection = new RadioButton();


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
        alert.setContentText("Пароли не совпадают.");

        alert.showAndWait();
    }

    private static void Alert4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Пользователь с таким логином уже существует.");

        alert.showAndWait();
    }

    private static void Alert5() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Регистрация выполнена успешно.");

        alert.showAndWait();
    }

    private static void Alert6() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Пароль не может быть пустым.");

        alert.showAndWait();
    }

    private static void Alert7() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Выберите тип пользователя.");

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
        try (FileWriter fw = new FileWriter("reg.txt", true)) {


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
            RadioButton phis = new RadioButton("Физическое лицо");


            phis.setToggleGroup(group);
            phis.setId("phis");
            yur.setToggleGroup(group);
            yur.setId("yur");




            group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){

                public void changed(ObservableValue<? extends Toggle> changed, Toggle oldValue, Toggle newValue){

                    // получаем выбранный элемент RadioButton
                    selection = (RadioButton) newValue;

                }
            });




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
            arrow.setOnAction(event->registerme());

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

    public static String d = "C://FileFolder"; //путь к папке с текстовым файлом (ну пусть будет)
    public static String f = "C://FileFolder/ImHere.txt"; //пусть к текстовому файлу
    public static String NewLogin="", NewPassword="", NewGuyType="", NewUser="", line=""; //тут всё очевидно

    public static void registerme() { //метод регистрации в блокнот

        int j=0; // для проверки уникальности логина
        try (FileWriter writer = new FileWriter(f, true)) { //открываем файл для обновления (потому что аппенд -  тру, был бы фолз, стирал бы всё, что уже есть)
            NewLogin = userTextField.getText();
            try (FileReader reader = new FileReader(Menu.f)) {
                BufferedReader reader1 = new BufferedReader(reader);
                while (j==0) { //читаем по строке, пока файл не кончился или не найден такой же логин
                line = reader1.readLine();
                if (line == null) {j=2;} else { //файл кончился, выходим и смотрим пароль
                line = line.substring(0, line.indexOf(" "));
                if (line.equals(NewLogin)) {
                    j=1; //если логин такой уже есть, выход и вызов соотвествующего алерта

                }  } }


            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }
            if (j!=1) { //если проверка на уникальность пройдена
                NewUser=NewLogin+" "; //запоминаем логин
                NewPassword=pwBox.getText(); //читаем пароль
                if (NewPassword.equals("")) {Menu.Alert6();} else {
                    if (NewPassword.equals(pwBox2.getText())==false) {Menu.Alert3();} else {
                        NewUser = NewUser + NewPassword + " "; //сравниваем ввод пароля и повтор, если всё хорошо - записываем
                        NewGuyType=Menu.selection.getId(); //смотрим какая радио кнопка выбрана
                        if (NewGuyType == null) {Menu.Alert7();} else { //если никакая, то просим выбрать всё-таки
                        if (NewGuyType == "phis") NewUser=NewUser+2; //если физ. лицо, то записываем тип 2
                        if (NewGuyType == "yur") NewUser=NewUser+3; //если юр. лицо, то записываем тип 3
                        writer.write("\n"); // конец строки
                        writer.write(NewUser); // переносим строку в файл
                        Menu.Alert5(); //осчастливываем пользователя, что всё получилось

                    } } } } else Menu.Alert4(); // говорим, что такой логин уже есть

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }}
