package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class autorizeme {

    public static String CurrentLogin="", CurrentPassword="", CurrentType="";
    public static int matching = 0, space, check=0; //переменная, проверяющая наличие данных для входа
    public static String line="";


    public static void autorizeme() {

        try(FileReader reader = new FileReader(registerme.f)) {
            BufferedReader reader1 = new BufferedReader(reader);
            matching = 0;
            check=0;
            while (check==0) { //пока нужные данные не найдены
                line = reader1.readLine(); //считываем строку из файла
                if (line != null) {
                    space = line.indexOf(" ");
                    CurrentLogin = line.substring(0, space);
                    space = line.indexOf(" ");                                          //с божьей помощью считываем логин
                    CurrentPassword = line.substring(space+1, line.length());           //пароль и тип. серьёзно, тут такие
                    line=line.substring(space+1, line.length());                        //схемы мошшенические, даже не пытайтесь
                    space=line.indexOf(" ");                                            //разобраться. работает и слава богу
                    CurrentPassword=line.substring(0, space+1);
                    CurrentType = line.substring(space + 1, line.length());
                    CurrentPassword=CurrentPassword.trim();
                    //оставшуюся строку считаем типом пользователя
                    if (CurrentLogin.equals(Menu.userTextFieldAutoriz.getText().trim())) { //сравниваем логины
                        if (CurrentPassword.equals(Menu.pwBoxAutoriz.getText().trim())) { //сравниваем пароли
                            matching = 1;
                            check = 4;
                        } else {
                            matching = 2;
                            check = 4;
                        }
                    }

                } else { check=4; matching=3;}   } //если файл изначально пустой, говорим об этом

        }

        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        switch (matching) {
            case 1: Menu.Alert1(); break; //всё верно
            case 2: Menu.Alert8(); break;  //пароль неверный
            case 3: Menu.Alert2(); break;  //логина нет

        }

       // Menu.TestAlert();

    }
}
