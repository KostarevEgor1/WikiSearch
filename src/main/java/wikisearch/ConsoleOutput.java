package wikisearch;

import java.util.List;

public class ConsoleOutput {
    public void printBrowserError(String url) {
        System.out.println("Не удалось открыть браузер. Откройте ссылку вручную:");
        System.out.println(url);
    }

    public void printNoResults() {
        System.out.println("Статьи не найдены.");
    }

    public void printSelectedArticle(SearchResult article) {
        System.out.println("Выбрана статья: " + article.getTitle());
    }

    public void printSearchResults(List<SearchResult> results) {
        System.out.println("Результаты поиска:");
        for (int i = 0; i < results.size(); i++) {
            SearchResult result = results.get(i);
            System.out.println((i + 1) + ". " + result.getTitle());
        }
    }
}
