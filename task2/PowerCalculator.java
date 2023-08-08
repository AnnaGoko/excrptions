import java.util.Scanner;

public class PowerCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите основание: ");
        double base = 0;
        try {
            base = Double.parseDouble(scanner.next());
            if (base == 0) {
                throw new InvalidInputException("Основание не может быть нулем");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода: введите число");
            return;
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.print("Введите показатель степени: ");
        int exponent = 0;
        try {
            exponent = Integer.parseInt(scanner.next());
            if (exponent < 0) {
                throw new InvalidInputException("Степень не может быть отрицательной");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода: введите целое число");
            return;
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            return;
        }
        try {
            double result = calculatePower(base, exponent);
            System.out.println(base + " в степени " + exponent + " равно " + result);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double calculatePower(double base, int exponent) throws InvalidInputException {
        if (base == 0 && exponent == 0) {
            throw new InvalidInputException("Некорректное выражение 0^0");
        } else if (base == 0 && exponent < 0) {
            throw new InvalidInputException("Некорректное выражение 0^(-n)");
        } else {
            double result = 1;
            for (int i = 0; i < Math.abs(exponent); i++) {
                result *= base;
            }
            if (exponent < 0) {
                result = 1 / result;
            }
            return result;
        }
    }
}

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}