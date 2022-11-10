import java.awt.print.Book;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * O programa entra em tempo de execução na classe Main, instanciando
 * os objetos necessários e chamando o método de navegação (menu), por
 * onde é possível navegar por toda a aplicação.
 */

public class Main {

    static Cash cash = new Cash();

    static Sales sales = new Sales();

    static Stock stock = new Stock();

    public static void main(String[] args) {
        Main.sales.readSalesData();
        Main.stock.readStockData();

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("#############################################");
        System.out.println("------------Livraria do Sr. Code-------------");
        System.out.println("#############################################");

        System.out.println("\n");

        System.out.println("Seja bem-vindo, Sr. Code! O que deseja fazer? \n\n");

        Menu.Navigation();
    }
}