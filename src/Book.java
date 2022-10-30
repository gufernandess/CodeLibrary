/**
 * A classe livro é usada para instanciar um livro, que pode
 * ser comprado ou vendido.
 */

public class Book {
    private static int counterId = 0;
    private int id;
    private String name;
    private double value;
    private Genre genre;
    public Book(String name, double value, Genre genre) {
        this.counterId++;
        this.id = counterId;
        this.name = name;
        this.value = value;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", genre=" + genre +
                '}';
    }
}
