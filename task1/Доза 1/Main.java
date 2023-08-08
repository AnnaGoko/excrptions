import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        try {
            if (number <= 0) {
                throw new InvalidNumberException("Некорректное число");
            } else {
                System.out.println("Число корректно");
            }
        } catch (InvalidNumberException e) {
            System.out.println(e.getMessage());
        }
    }
}

class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }
}