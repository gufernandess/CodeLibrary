/**
 * A classe livro é usada para instanciar um livro, que pode
 * ser comprado ou vendido.
 */

public class Book {
    private static int counterId = 0;
    private final int id;
    private String name;
    private double value;

    private int quantity;
    private Genre genre;

    public Book(String name, double value, int quantity, Genre genre) {
        this.counterId++;
        this.id = counterId;
        this.name = name;
        this.value = value;
        this.quantity = quantity;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return String.format("\n\nID: %d, Nome: %s, Preço: %.2f, Quantidade: %d, Gênero: %s\n\n",
                id, name, value, quantity, genre);
    }

}
