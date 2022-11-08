import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A classe vendas serve como registro de todas as
 * vendas efetuadas.
 */

public class Sales implements Serializable {

    private List<Sale> salesList;

    public Sales() {
        salesList = new ArrayList<Sale>();
    }

    public List<Sale> getSalesList() {
        return salesList;
    }

    /**
     * O método "sellBook" vende os livros disponíveis no estoque, adicionando
     * a venda na lista de vendas, alterando o dinheiro do caixa e mudando a
     * quantidade de livros disponíveis.
     *
     * @param id
     * @param quantity
     * @param buyer
     */

    public void sellBook(int id, int quantity, String buyer) {
            try {
                if(quantity <= Main.stock.getBooksList().get(id).getQuantity() && quantity > 0) {
                    Sale sale = new Sale("Sr. Code", buyer, Main.stock.getBooksList().get(id), quantity);
                    Main.sales.getSalesList().add(sale);
                    Main.cash.setMoney(Main.cash.getMoney() + (Main.stock.getBooksList().get(id).getValue() * quantity));
                    Main.stock.getBooksList().get(id).setQuantity(Main.stock.getBooksList().get(id).getQuantity() - quantity);

                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("A venda foi realizada com sucesso!\n\n");

                    Menu.Navigation();

                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("Quantidade de livros inválida. Tente novamente.\n");
                    Menu.makeASale();
                }
            } catch(Exception e) {
                System.out.print("\033[H\033[2J");
                System.out.flush();

                System.out.println("\nNão foi possível realizar a venda: " + e + "\n");
                Menu.Navigation();
            }
        }

    @Override
    public String toString() {
        StringBuilder sales = new StringBuilder();

        System.out.println("----------VENDAS----------");
        System.out.println("\nID | Vendedor | Comprador | Livro | Quantidade");

        for (int i = 0; i < salesList.size(); i++) {
            sales.append(salesList.get(i).getId() + " | " + salesList.get(i).getSeller() + " | " +
                    salesList.get(i).getBuyer() + " | " + salesList.get(i).getBook().getName() + "|" +
                    salesList.get(i).getQuantity() + " \n");
        }

        return sales.toString();
    }
}
