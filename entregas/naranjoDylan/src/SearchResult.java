
public record SearchResult(boolean found, int row, int col) {

    public static SearchResult notFound() {
        return new SearchResult(false, -1, -1);
    }

    public static SearchResult foundAt(int row, int col) {
        return new SearchResult(true, row, col);
    }

    @Override
    public String toString() {
        return found
                ? String.format("Encontrado en [%d][%d]", row, col)
                : "No encontrado en la matriz";
    }
}
