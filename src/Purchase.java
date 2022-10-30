import java.util.List;

/**
 * A classe de compra registra as compras feitas pelo
 * comprador.
 */

public class Purchase {

    private static int counterId = 0;
    private int id;
    private List<Book> books;

    public Purchase(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", books=" + books +
                '}';
    }
}
