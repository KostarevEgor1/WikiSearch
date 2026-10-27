package wikisearch;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

public class BrowserOpener {
    private static final String ARTICLE_URL =
            "https://ru.wikipedia.org/w/index.php?curid=";

    public String buildArticleUrl(long pageId) {
        return ARTICLE_URL + pageId;
    }

    public boolean open(long pageId) {
        if (pageId <= 0) {
            return false;
        }

        try {
            if (!Desktop.isDesktopSupported()) {
                return false;
            }

            Desktop desktop = Desktop.getDesktop();
            if (!desktop.isSupported(Desktop.Action.BROWSE)) {
                return false;
            }

            desktop.browse(URI.create(buildArticleUrl(pageId)));
            return true;
        } catch (IOException | UnsupportedOperationException | SecurityException e) {
            return false;
        }
    }
}
