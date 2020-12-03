package sample;

import java.sql.*;

public class DATABASEautorize {

    public static String root="root",
            password="root",
            url="jdbc:mysql://localhost:3306/test";
    //данные о бд, имя пользователя, пароль, расположение и коррекция бед с часовым поясом
    public static int check=0, matching=0, CurrentType;

    public static void autorizefromdatabase() {

        try (Connection conn = DriverManager.getConnection(url, root, password)){ //подключаемся к бд
            Statement statement=conn.createStatement(); //штука, которая обрабатывает запросы sql
            ResultSet resultSet = statement.executeQuery("SELECT * from users"); //коробка для записи взятых данных из таблицы
            //executeQuery метод для извлечения данных
            matching=0;
            while(resultSet.next()){ //пока в коробке с данными есть данные
                check=0;
                while (check==0) { // пока нужные данные не найдены
                    String CurrentLogin = resultSet.getString(1);
                    String CurrentPassword = resultSet.getString(2);


                    if (CurrentLogin.equals(Menu.userTextFieldAutoriz.getText().trim())&&matching==0) {
                        //сравниваем логины, если ещё не найден проходящий
                        if (DATABASEregistration.hash.equals(Menu.passw.trim())) { //сравниваем пароли
                            matching = 1; //логин и пароль совпали с записанными
                            check = 4;
                            CurrentType = resultSet.getInt(3);
                        } else {
                            matching = 2; //пароль не совпал
                            check = 4;
                        }
                    } else {check=4;}//такого логина нет
                }

            }




        }
        catch (SQLException throwables) {
            Menu.DatabaseFail(); //если не получилось подключиться, держим в курсе
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (matching) {
            case 1: Menu.Alert1(); break; //всё верно
            case 2: Menu.Alert8(); break;  //пароль неверный
            case 0: Menu.Alert2(); break;  //логина нет

        }

    }
}
