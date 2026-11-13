package wikisearch;

import java.util.Scanner;

public class ConsoleInput {
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
            System.out.println("Введите номер статьи, которую хотите посмотреть или /exit для выхода:");

            if (!scanner.hasNextLine()) {
                return 0;
            }

            String userInput = scanner.nextLine().strip();

            if (userInput.equalsIgnoreCase("/exit")) {
                return 0;
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
