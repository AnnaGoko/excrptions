import java.util.Scanner;

public class BankTransaction {
    private static double balance = 10000; // начальный баланс

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер счета получателя: ");
        String recipient = scanner.nextLine();
        System.out.print("Введите сумму перевода: ");
        double amount = 0;
        try {
            amount = Double.parseDouble(scanner.nextLine());
            if (amount <= 0) {
                throw new InvalidAmountException("Некорректная сумма перевода");
            }
            if (amount > balance) {
                throw new InsufficientFundsException("Недостаточно средств на счете");
            }
            balance -= amount;
            System.out.println("Перевод на счет " + recipient + " выполнен успешно, остаток на счете: " + balance);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода: введите число");
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}