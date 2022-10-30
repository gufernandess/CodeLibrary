import java.util.Scanner;

/**
 * Aqui ocorre todo o mecanismo de navegação do programa.
 */

public class Menu {
    public static void Navigation() {
        Scanner input = new Scanner(System.in);

        System.out.println("1 - Efetuar venda \n 2 - Cadastrar compra \n 3 - Consultar estoque" +
                " \n 4 - Consultar vendas \n 5 - Verificar caixa \n 6 - Sair \n\n");

        int response = input.nextInt();

        if(response == 1) {
            makeASale();
        }
        if(response == 2) {
            registerPurchase();
        }
        if(response == 3) {
            checkStock();
        }
        if(response == 4) {
            checkSales();
        }
        if(response == 5) {
            verifyCash();
        }
        if(response == 6) {
            System.exit(0);
        }
        else {
            System.out.println("\n\nDesculpe, não entendemos o que você quer fazer. Tente novamente.\n\n");
            input.close();
            Navigation();
        }
    }

    public static void makeASale() {}

    public static void registerPurchase() {}

    public static void checkStock() {}

    public static void checkSales() {}

    public static void verifyCash() {
        System.out.println("O saldo disponível em seu caixa é de R$" + Main.cash.getMoney() + "\n\n");
        Navigation();
    }
}
