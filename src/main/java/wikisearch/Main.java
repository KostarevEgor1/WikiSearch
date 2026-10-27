package wikisearch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleInput consoleInput = new ConsoleInput(scanner);

        String query = consoleInput.readSearchQuery();
        if (query == null) {
            return;
        }

        System.out.println(query);
    }
}
