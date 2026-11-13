package wikisearch;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class WikipediaClient {
    private static final String SEARCH_URL =
            "https://ru.wikipedia.org/w/api.php?action=query&list=search&format=json&srsearch=";

    private final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10)).build();

    public String buildSearchUrl(String query) {
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
        return SEARCH_URL + encodedQuery;
    }

    public String search(String query) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(buildSearchUrl(query)))
                    .timeout(Duration.ofSeconds(20))
                    .header("User-Agent", "WikiSearch")
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(
                    request,
                    HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)
            );

            if (response.statusCode() != 200) {
                System.out.println("Сервер вернул HTTP-код " + response.statusCode());
                return null;
            }

            return response.body();
        } catch (IOException e) {
            System.out.println("Не удалось получить ответ от Википедии.");
            return null;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Запрос был прерван.");
            return null;
        }
    }
}
