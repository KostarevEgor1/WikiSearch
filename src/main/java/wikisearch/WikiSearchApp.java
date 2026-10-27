package wikisearch;

import java.util.List;

public class WikiSearchApp {
    private final ConsoleInput consoleInput;
    private final ConsoleOutput consoleOutput;
    private final WikipediaClient wikipediaClient;
    private final WikipediaResponseParser parser;

    public WikiSearchApp(
            ConsoleInput consoleInput,
            ConsoleOutput consoleOutput,
            WikipediaClient wikipediaClient,
            WikipediaResponseParser parser
    ) {
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
        this.wikipediaClient = wikipediaClient;
        this.parser = parser;
    }

    public void run() {
        String query = consoleInput.readSearchQuery();
        if (query == null) {
            return;
        }

        String response = wikipediaClient.search(query);
        if (response == null) {
            return;
        }

        List<SearchResult> results = parser.parse(response);
        if (results == null) {
            return;
        }

        if (results.isEmpty()) {
            consoleOutput.printNoResults();
            return;
        }

        consoleOutput.printSearchResults(results);
        int number = consoleInput.readArticleNumber(results.size());
        if (number == 0) {
            return;
        }

        SearchResult selectedArticle = results.get(number - 1);
        consoleOutput.printSelectedArticle(selectedArticle);
    }
}
