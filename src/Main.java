/**
 * O programa entra em tempo de execução na classe Main, instanciando
 * os objetos necessários e introduzindo a finalidade da aplicação.
 */

public class Main {
    static Cash cash = new Cash(0);
    static Sales sales = new Sales();
    static Stock stock = new Stock();

    public static void main(String[] args) {

        System.out.println("#############################################");
        System.out.println("------------Livraria do Sr. Code-------------");
        System.out.println("#############################################");

        System.out.println("\n\n");

        System.out.println("Seja bem-vindo, Sr. Code! O que deseja fazer? \n\n");

        Menu.Navigation();
    }
}