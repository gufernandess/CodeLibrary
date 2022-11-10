import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A classe vendas serve como registro de todas as
 * vendas efetuadas.
 */

public class Sales {

    private List<Sale> salesList;

    public Sales() {
        salesList = new ArrayList<>();
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

                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("Quantidade de livros inválida. Tente novamente.\n");
                }
                Menu.Navigation();
            } catch(Exception e) {
                System.out.print("\033[H\033[2J");
                System.out.flush();

                System.out.println("\nNão foi possível realizar a venda: " + e + "\n");
                Menu.Navigation();
            }
        }

    public void readSalesData() {
        Sale sale;
        boolean endOfFile = false;

        try (
                FileInputStream saleFile = new FileInputStream("data/sales.dat");
                ObjectInputStream saleStream = new ObjectInputStream(saleFile);) {

            while (endOfFile == false) {
                try {
                    sale = (Sale) saleStream.readObject();
                    salesList.add(sale);
                } catch (EOFException e) {
                    endOfFile = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("\nNenhum arquivo anterior foi lido.");
        } catch (ClassNotFoundException e) {
            System.out.println("\nTentando ler um objeto de uma classe desconhecida.");
        } catch (StreamCorruptedException e) {
            System.out.println("\nFormato de arquivo ilegível.");
        } catch (IOException e) {
            System.out.println("\nerro: Ocorreu um problema ao ler o arquivo.");
        }
    }

    public void writeSalesData() {
        try (
                FileOutputStream saleFile = new FileOutputStream("data/sales.dat");
                ObjectOutputStream saleStream = new ObjectOutputStream(saleFile);) {
            for (Sale sale : salesList) {
                saleStream.writeObject(sale);
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um problema ao gravar o arquivo.");
            System.out.println(e.getMessage());
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
