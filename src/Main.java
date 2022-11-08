/**
 * O programa entra em tempo de execução na classe Controller.Main, instanciando
 * os objetos necessários e chamando o método de navegação (menu), por
 * onde é possível navegar por toda a aplicação.
 */

public class Main {
    static Cash cash = new Cash(0);
    static Sales sales = new Sales();
    static Stock stock = new Stock();

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