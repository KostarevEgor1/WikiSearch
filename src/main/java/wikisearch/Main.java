package wikisearch;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleInput consoleInput = new ConsoleInput(scanner);

        String query = consoleInput.readSearchQuery();
        if (query == null) {
            return;
        }

        WikipediaClient wikipediaClient = new WikipediaClient();
        String response = wikipediaClient.search(query);

        if (response == null) {
            return;
        }

        WikipediaResponseParser parser = new WikipediaResponseParser();
        List<SearchResult> results = parser.parse(response);

        if (results == null) {
            return;
        }

        if (results.isEmpty()) {
            System.out.println("Статьи не найдены.");
            return;
        }

        for (SearchResult result : results) {
            System.out.println(result.getPageId() + ": " + result.getTitle());
        }
    }
}
