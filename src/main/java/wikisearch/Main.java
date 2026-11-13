package wikisearch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleInput consoleInput = new ConsoleInput(scanner);
        ConsoleOutput consoleOutput = new ConsoleOutput();
        WikipediaClient wikipediaClient = new WikipediaClient();
        WikipediaResponseParser parser = new WikipediaResponseParser();
        BrowserOpener browserOpener = new BrowserOpener();

        WikiSearchApp app = new WikiSearchApp(
                consoleInput,
                consoleOutput,
                wikipediaClient,
                parser,
                browserOpener
        );
        app.run();
    }
}
