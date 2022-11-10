import java.io.Serializable;

/**
 * A classe de venda registra uma única venda, que por sua vez
 * fica registrado na lista de vendas.
 */

public class Sale implements Serializable {

    private static int counterId = 0;
    private final int id;
    private String seller;
    private String buyer;
    private Book book;

    private int quantity;

    public Sale(String seller, String buyer, Book book, int quantity) {
        this.id = counterId;
        counterId++;
        this.seller = seller;
        this.buyer = buyer;
        this.book = book;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getSeller() {
        return seller;
    }

    public String getBuyer() {
        return buyer;
    }

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("\n\nID: %d, Vendedor: %s, Comprador: %s, Livro: %s, Quantidade: %d\n\n",
                id, seller, buyer, book, quantity);
    }
}
