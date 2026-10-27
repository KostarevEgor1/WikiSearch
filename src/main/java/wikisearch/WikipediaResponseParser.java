package wikisearch;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class WikipediaResponseParser {
    public List<SearchResult> parse(String json) {
        if (json == null || json.isBlank()) {
            System.out.println("Получен пустой ответ от сервера.");
            return null;
        }

        try {
            List<SearchResult> results = new ArrayList<>();

            JsonObject root = JsonParser.parseString(json).getAsJsonObject();
            JsonObject queryObject = root.getAsJsonObject("query");
            JsonArray articles = queryObject.getAsJsonArray("search");

            for (JsonElement element : articles) {
                JsonObject article = element.getAsJsonObject();

                long pageId = article.get("pageid").getAsLong();
                String title = article.get("title").getAsString();

                results.add(new SearchResult(pageId, title));
            }

            return results;
        } catch (RuntimeException e) {
            // Общая обработка ошибок внешнего JSON сильно упрощает читаемость парсера,
            // но может скрыть и нашу ошибку программирования — здесь это осознанный компромисс
            System.out.println("Не удалось обработать ответ Википедии.");
            return null;
        }
    }
}
