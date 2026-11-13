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
}
