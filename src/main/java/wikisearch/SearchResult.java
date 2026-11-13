package wikisearch;

public class SearchResult {
    private final long pageId;
    private final String title;

    public SearchResult(long pageId, String title) {
        this.pageId = pageId;
        this.title = title;
    }

    public long getPageId() {
        return pageId;
    }

    public String getTitle() {
        return title;
    }
}
