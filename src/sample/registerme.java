package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class registerme {

    public static String d = "C://FileFolder"; //путь к папке с текстовым файлом (ну пусть будет)
    public static String f = "C://FileFolder/ImHere.txt"; //пусть к текстовому файлу
    public static String NewLogin="", NewPassword="", NewGuyType="", NewUser="", line=""; //тут всё очевидно

    public static void registerme() { //метод регистрации в блокнот

        int j=0; // для проверки уникальности логина
        try (FileWriter writer = new FileWriter(f, true)) { //открываем файл для обновления (потому что аппенд -  тру, был бы фолз, стирал бы всё, что уже есть)
            NewLogin = Menu.userTextField.getText();
            try (FileReader reader = new FileReader(f)) {
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
                if (NewLogin.trim().isEmpty()) {Menu.Alert9();} else {
                  if (NewLogin.indexOf(" ")!=-1) {Menu.Alert10();} else {
                NewUser=NewLogin.trim()+" "; //запоминаем логин
                NewPassword=Menu.pwBox.getText(); //читаем пароль
                if (NewPassword.trim().equals("")) {Menu.Alert6();} else {
                    if (NewPassword.indexOf(" ")!=-1) {Menu.Alert11();} else {
                    if (NewPassword.equals(Menu.pwBox2.getText())==false) {Menu.Alert3();} else {
                        NewUser = NewUser + NewPassword.trim() + " "; //сравниваем ввод пароля и повтор, если всё хорошо - записываем
                        NewGuyType=Menu.selection.getId(); //смотрим какая радио кнопка выбрана
                        if (NewGuyType == null) {Menu.Alert7();} else { //если никакая, то просим выбрать всё-таки
                            if (NewGuyType == "phis") NewUser=NewUser+2; //если физ. лицо, то записываем тип 2
                            if (NewGuyType == "yur") NewUser=NewUser+3; //если юр. лицо, то записываем тип 3
                            writer.write("\n"); // конец строки
                            writer.write(NewUser); // переносим строку в файл
                            Menu.Alert5(); //осчастливываем пользователя, что всё получилось
                            Menu.Autoriz();

                        } } } } } } } else Menu.Alert4(); // говорим, что такой логин уже есть

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }}

