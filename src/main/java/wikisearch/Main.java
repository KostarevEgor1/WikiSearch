package wikisearch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleInput consoleInput = new ConsoleInput(scanner);
        ConsoleOutput consoleOutput = new ConsoleOutput();
        WikipediaClient wikipediaClient = new WikipediaClient();
        WikipediaResponseParser parser = new WikipediaResponseParser();

        WikiSearchApp app = new WikiSearchApp(
                consoleInput,
                consoleOutput,
                wikipediaClient,
                parser
        );
        app.run();
    }
}
