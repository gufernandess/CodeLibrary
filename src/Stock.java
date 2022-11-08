import java.util.ArrayList;
import java.util.List;

/**
 * A classe de estoque serve como um estoque dos livros
 * disponíveis na livraria. Assim como comporta os
 * métodos de compra de livros.
 */

public class Stock {

    private List<Book> booksList;

    public Stock() {
        booksList = new ArrayList<Book>();
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    /**
     * Este primeiro método serve especificamente para livros
     * que nunca foram comprados antes, portanto precisam ser
     * registrados na livraria.
     *
     * @param name
     * @param value
     * @param quantity
     * @param genre
     */

    public void registerBook(String name, double value, int quantity, Genre genre) {
        try {
            if(Main.cash.getMoney() >= value * quantity) {
                if(quantity > 0) {
                    Book book = new Book(name, value, quantity, genre);
                    Main.stock.getBooksList().add(book);
                    Main.cash.setMoney(Main.cash.getMoney() - value * quantity);

                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("\n\nCompra realizada com sucesso!\n");

                    Menu.Navigation();
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("Para registrar um livro no estoque, realize a compra de pelo menos uma unidade.\n");
                    Menu.Navigation();
                }
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();

                System.out.println("Não há dinheiro o suficiente no caixa para realizar a transação.\n");
                Menu.Navigation();
            }
        } catch(Exception e) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("\nNão foi possível registrar o livro: " + e + " \n");
            Menu.Navigation();
        }
    }

    /**
     * Já este serve para livros já registrados, necessitando somente
     * do ID do livro e da quantidade que está sendo comprado.
     *
     * @param id
     * @param quantity
     */

    public void buyBook(int id, int quantity) {
        try {
                if(Main.cash.getMoney() >= Main.stock.getBooksList().get(id).getValue() * quantity) {
                    Main.stock.getBooksList().get(id).setQuantity(Main.stock.getBooksList().get(id).getQuantity() + quantity);
                    Main.cash.setMoney(Main.cash.getMoney() - Main.stock.getBooksList().get(id).getValue() * quantity);

                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("A compra foi realizada com sucesso!\n");

                    Menu.Navigation();
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("Você não tem dinheiro o suficiente no caixa. Tente novamente.\n");
                    Menu.Navigation();
                }

        } catch(Exception e) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("\nNão foi possível realizar a compra: " + e + "\n");
            Menu.Navigation();
        }
    }

    @Override
    public String toString() {
        StringBuilder books = new StringBuilder();

        System.out.println("----------LIVROS----------");
        System.out.println("\nID | Nome | Preço | Quantidade | Gênero");

        for (int i = 0; i < booksList.size(); i++) {
            books.append(booksList.get(i).getId() + " | " + booksList.get(i).getName() + " | " +
                    String.format("%.2f", booksList.get(i).getValue()) + " | " + booksList.get(i).getQuantity() +
                    " | " + booksList.get(i).getGenre() + "\n");
        }

        return books.toString();
    }
}
