import java.util.List;

/**
 * A classe de venda registra uma única venda, que por sua vez
 * fica registrado na lista de vendas.
 */

public class Sale {

    private static int counterId = 0;
    private int id;
    private String seller;
    private String buyer;
    private List<Book> books;

    public Sale(String seller, String buyer, List<Book> books) {
        this.seller = seller;
        this.buyer = buyer;
        this.books = books;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", seller='" + seller + '\'' +
                ", buyer='" + buyer + '\'' +
                ", books=" + books +
                '}';
    }
}
