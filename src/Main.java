/**
 * O programa entra em tempo de execução na classe Controller.Main, instanciando
 * os objetos necessários e chamando o método de navegação (menu), por
 * onde é possível navegar por toda a aplicação.
 */

public class Main {
    static Cash cash = new Cash(0);

    //static Cash cash = (Cash) Serialization.readBinaryFile("cash.dat");
    static Sales sales = new Sales();

    //static Sales sales = (Sales) Serialization.readBinaryFile("sales.dat");
    static Stock stock = new Stock();

    //static Stock stock = (Stock) Serialization.readBinaryFile("stock.dat");

    public static void main(String[] args) {

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