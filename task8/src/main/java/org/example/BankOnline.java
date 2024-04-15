package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class BankOnline {
    private static final long LIMIT = 50000;
    private static final String BLOCKED_CARDS_FILE = "blocked_cards.txt";

    public static class BankOnlineException extends Exception {
        public BankOnlineException(String message) {
            super(message);
        }
    }

    public static class InvalidCardNumberException extends BankOnlineException {
        public InvalidCardNumberException(String message) {
            super(message);
        }
    }

    public static class BlockedCardException extends BankOnlineException {
        public BlockedCardException(String message) {
            super(message);
        }
    }

    public static class NegativeAmountException extends BankOnlineException {
        public NegativeAmountException(String message) {
            super(message);
        }
    }

    public static class ZeroAmountException extends BankOnlineException {
        public ZeroAmountException(String message) {
            super(message);
        }
    }

    public static class ExceedLimitException extends BankOnlineException {
        public ExceedLimitException(String message) {
            super(message);
        }
    }

    public static class NullArgumentException extends RuntimeException {
        public NullArgumentException(String message) {
            super(message);
        }
    }

    public static boolean CheckValid(String cardNumber){
        int lastDigit = Character.getNumericValue(cardNumber.charAt(cardNumber.length() - 1));
        int sum = 0;
        boolean doubleDigit = true;
        for (int i = cardNumber.length() - 2; i >= 0; i--) {
            int digit = Character.getNumericValue(cardNumber.charAt(i));
            if (doubleDigit) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
            doubleDigit = !doubleDigit;
        }
        int controlDigit = sum % 10;
        return controlDigit == lastDigit;
    }

    public static void send(String cardNumber, Double money) throws BankOnlineException {
        if (cardNumber == null || money == null) {
            throw new NullArgumentException("Один из агрументов равен null.");
        }
        cardNumber = cardNumber.replaceAll("\\s+","");
        if (!cardNumber.matches("\\d{16}") || !CheckValid(cardNumber)) {
            throw new InvalidCardNumberException("Неверный формат номера карты.");
        }

        try {
            Scanner scanner = new Scanner(new File(BLOCKED_CARDS_FILE));
            while (scanner.hasNextLine()) {
                String blockedCard = scanner.nextLine();
                blockedCard = blockedCard.replaceAll("\\s+","");
                if (blockedCard.equals(cardNumber)) {
                    throw new BlockedCardException("Карта заблокирована.");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (money < 0) {
            throw new NegativeAmountException("Отрицательная сумма перевода.");
        }

        if (money == 0) {
            throw new ZeroAmountException("Нулевая сумма перевода.");
        }

        if (money > LIMIT) {
            throw new ExceedLimitException("Превышен лимит перевода.");
        }
        System.out.println("Перевод выполнен!");
    }

    public static void main(String[] args) {
        //String cardNumber = "1111 1111 1111 1111";
        String cardNumber = "4556 7375 8689 9855";
        double money = 12000;
        try {
            send(cardNumber, money);
        } catch (BankOnlineException e) {
            System.out.println("Перевод не выполнен: " + e.getMessage());
        }
    }

}
