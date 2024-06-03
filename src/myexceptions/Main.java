package myexceptions;

import java.util.Scanner;

public class Main {
    private static final String REGEX = "^[a-zA-Z0-9_]*$";
    private static final String ALLOWED_CHARS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM_";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите логин");
        String login = SCANNER.nextLine();
        System.out.println("Введите пароль");
        String password = SCANNER.nextLine();
        System.out.println("Введите пароль еще раз");
        String confirmPassword = SCANNER.nextLine();
      try {
          checkCredentials(login,password,confirmPassword);
          System.out.println("Данные успешно проверены");
      } catch (WrongLoginException|WrongPasswordException e){
          System.out.println("Данные не прошли проверку");
          e.printStackTrace();
      }

    }

    public static void checkCredentials(String login, String password, String confirmPassword) {
        if (login.length() > 20) {
            throw new WrongLoginException("Длина логина больше 20 символов");
        }
        if (!login.matches(REGEX)) {
            throw new WrongLoginException("В логине недопустимые символы");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("Длина пароля больше 20 символов");
        }
        if (!password.matches(REGEX)) {
            throw new WrongPasswordException("В пароле недопустимые символы");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}