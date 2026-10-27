package wikisearch;

import java.util.Scanner;

public class ConsoleInput {
    public static final int EXIT = 0;
    public static final int BACK_TO_SEARCH = -1;

    private final Scanner scanner;

    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readSearchQuery() {
        while (true) {
            System.out.println("Введите поисковый запрос или /exit для выхода:");

            if (!scanner.hasNextLine()) {
                return null;
            }

            String userInput = scanner.nextLine().strip();

            if (userInput.equalsIgnoreCase("/exit")) {
                return null;
            }

            if (userInput.isEmpty()) {
                System.out.println("Запрос не должен быть пустым.");
                continue;
            }

            return userInput;
        }
    }

    public int readArticleNumber(int resultsCount) {
        while (true) {
            System.out.println("Введите номер статьи, /back для нового поиска или /exit для выхода:");

            if (!scanner.hasNextLine()) {
                return EXIT;
            }

            String userInput = scanner.nextLine().strip();

            if (userInput.equalsIgnoreCase("/exit")) {
                return EXIT;
            }

            if (userInput.equalsIgnoreCase("/back")) {
                return BACK_TO_SEARCH;
            }

            try {
                int chosenNumber = Integer.parseInt(userInput);

                if (1 <= chosenNumber && chosenNumber <= resultsCount) {
                    return chosenNumber;
                }

                System.out.println("Число должно находиться в диапазоне от 1 до " + resultsCount);
            } catch (NumberFormatException e) {
                System.out.println("Введите целый номер статьи.");
            }
        }
    }
}
