package sample;

import java.sql.*;

public class DATABASEregistration {

    public static String NewLogin="", NewPassword="", NewGuyType="", NewUser="", line=""; //тут всё очевидно

    public static void registrationtodatabase() { NewLogin = Menu.userTextField.getText();
        try (Connection conn = DriverManager.getConnection(DATABASEautorize.url, DATABASEautorize.root, DATABASEautorize.password)) { //подключаемся к бд
            Statement statement = conn.createStatement(); //штука, которая обрабатывает запросы sql
            ResultSet resultSet = statement.executeQuery("SELECT * from users"); //коробка с данными из базы
            int matching=0;
            while (resultSet.next()) {//пока в коробке есть данные
                String CurrentLogin = resultSet.getString(1); //берём данные из первой строки первого столбца
                if (CurrentLogin.equals(NewLogin.trim())) {matching=1;}  //сравниваем с тем, что введено
            }

            if (matching==0) {
                if (NewLogin.trim().isEmpty()) {Menu.Alert9();} else { //еси написан пустой логин, выгоняем
                    if (NewLogin.indexOf(" ")!=-1) {Menu.Alert10();} else { //если написан логин с пробелами, выгоняем
                        NewPassword=Menu.pwBox.getText(); //читаем пароль
                        if (NewPassword.trim().equals("")) {Menu.Alert6();} else { //если пустой пароль, выгоняем
                            if (NewPassword.indexOf(" ")!=-1) {Menu.Alert11();} else {//если пароль с пробелами, выгоняем
                                if (NewPassword.equals(Menu.pwBox2.getText())==false) {Menu.Alert3();} else {
                                    NewGuyType = Menu.selection.getId(); //смотрим какая радио кнопка выбрана
                                    if (NewGuyType == null) {
                                        Menu.Alert7(); //если никакая, то просим выбрать всё-таки
                                    } else {
                                        if (NewGuyType == "phis")
                                            statement.executeUpdate("insert into users (login, password, usertype) VALUES ('" + NewLogin + "', '" + NewPassword + "', " + 2 + ")"); //если физ. лицо, то записываем тип 2
                                        if (NewGuyType == "yur")
                                            statement.executeUpdate("insert into users (login, password, usertype) VALUES ('" + NewLogin + "', '" + NewPassword + "', " + 3 + ")"); //если юр. лицо, то записываем тип 3
                                        Menu.Alert5();
                                    }
                                } } } } } } else Menu.Alert4();
        } catch (
                SQLException throwables) {
            Menu.DatabaseFail(); //если не получилось подключиться, держим в курсе
            throwables.printStackTrace();
        }
    }

    public static void registerworker() {
             NewLogin = Admin.userTextField.getText();
            try (Connection conn = DriverManager.getConnection(DATABASEautorize.url, DATABASEautorize.root, DATABASEautorize.password)) { //подключаемся к бд
                Statement statement = conn.createStatement(); //штука, которая обрабатывает запросы sql
                ResultSet resultSet = statement.executeQuery("SELECT * from users"); //коробка с данными из базы
                int matching=0;
                while (resultSet.next()) {//пока в коробке есть данные
                    String CurrentLogin = resultSet.getString(1); //берём данные из первой строки первого столбца
                    if (CurrentLogin.equals(NewLogin.trim())) {matching=1;}  //сравниваем с тем, что введено
                }

                if (matching==0) {
                    if (NewLogin.trim().isEmpty()) {Menu.Alert9();} else { //еси написан пустой логин, выгоняем
                        if (NewLogin.indexOf(" ")!=-1) {Menu.Alert10();} else { //если написан логин с пробелами, выгоняем
                            NewPassword=Admin.pwBoxAd.getText(); //читаем пароль
                            if (NewPassword.trim().equals("")) {Menu.Alert6();} else { //если пустой пароль, выгоняем
                                if (NewPassword.indexOf(" ")!=-1) {Menu.Alert11();} else {//если пароль с пробелами, выгоняем
                                    if (NewPassword.equals(Admin.pwBoxAd2.getText())==false) {Menu.Alert3();} else {
                                        statement.executeUpdate("INSERT INTO users (login, password, usertype) VALUES ('" + NewLogin + "', '" + NewPassword + "', " + 1 + ")");
                                        Menu.Alert5();
                                    }}}}}} else Menu.Alert4();

            } catch (SQLException throwables) {
                Menu.DatabaseFail(); //если не получилось подключиться, держим в курсе
                throwables.printStackTrace();
            }

    }
}
