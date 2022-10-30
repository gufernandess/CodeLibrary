import java.util.ArrayList;
import java.util.List;

/**
 * A classe de estoque serve como um estoque dos livros
 * disponíveis na livraria.
 */

public class Stock {

    private List<Book> booksList;

    public Stock() {
        booksList = new ArrayList<Book>();
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public void addBook() {}

    public void removeBook(int id) {}

    @Override
    public String toString() {
        return "Stock{" +
                "booksList=" + booksList +
                '}';
    }
}
