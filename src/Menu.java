import java.util.List;
import java.util.Scanner;

/**
 * Aqui ocorre todo o mecanismo de navegação do programa.
 */

public class Menu {

    /**
     * O método de navegação mostra o menu do programa,
     * através de onde é possível navegar pela aplicação.
     */
    public static void Navigation() {
        Scanner input = new Scanner(System.in);

        System.out.println("1 - Efetuar venda \n2 - Cadastrar compra \n3 - Consultar estoque" +
                " \n4 - Consultar vendas \n5 - Verificar caixa \n6 - Sair \n");

        int response = input.nextInt();

        System.out.print("\033[H\033[2J");
        System.out.flush();

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
            /*Serialization.writeBinaryFile((List<Object>) Main.cash, "cash.dat");
            Serialization.writeBinaryFile((List<Object>) Main.sales, "sales.dat");
            Serialization.writeBinaryFile((List<Object>) Main.stock, "stock.dat");*/

            System.exit(0);
        } else {
            try {
                System.out.println("Entrada inválida. Tente novamente.\n");
                Menu.Navigation();
            } catch (Exception e) {
                System.out.println(e + "\n");
                Menu.Navigation();
            }
        }

        input.close();
    }

    /**
     * O "makeSale" realiza uma venda de um determinado
     * livro, através do método "sellBook" encontrado
     * em "sales".
     */

    public static void makeASale() {
        Scanner input = new Scanner(System.in);

        System.out.println(Main.stock.toString());

        System.out.println("\n\nInsira o ID do livro que deseja vender:");
        int id = input.nextInt();

        System.out.println("\n\nQuantos livros deste você irá querer?");
        int quantity = input.nextInt();

        System.out.println("\n\nQual é o nome do comprador?");
        String buyer = input.next();

        Main.sales.sellBook(id - 1, quantity, buyer);

        input.close();
    }

    /**
     * O método "registerPurchase" serve para dois casos específicos:
     * Para um livro que nunca foi comprado antes (Não está na lista),
     * usando o método "registerBook", e para um livro que já está na
     * lista, através do método "buyBook".
     */

    public static void registerPurchase() {
        Scanner input = new Scanner(System.in);

        System.out.println(Main.stock.toString());

        System.out.println("\n\nEste livro já está registrado no estoque?");
        System.out.println("\n\n1 - Sim\n2 - Não\n");
        int response = input.nextInt();

        if(response == 1) {
            System.out.println("\n\nInsira o ID do livro: ");
            int id = input.nextInt();

            System.out.println("\n\nInsira a quantidade de livros comprados: ");
            int quantity = input.nextInt();

            Main.stock.buyBook(id - 1, quantity);
        }
        if(response == 2) {
            System.out.println("\n\nInsira o nome do livro: ");
            String name = input.next();

            System.out.println("\n\nInsira o valor unitário do livro: ");
            double value = input.nextDouble();

            System.out.println("\n\nInsira a quantidade de livros comprados: ");
            int quantity = input.nextInt();

            System.out.println("\n\nInsira o gênero do livro: ");
            System.out.println("\n\n1 - Aventura\n2 - Comédia\n3 - Drama\n");
            int genre = input.nextInt();

            if(genre == 1) {
                Main.stock.registerBook(name, value, quantity, Genre.Adventure);
            }
            if(genre == 2) {
                Main.stock.registerBook(name, value, quantity, Genre.Comedy);
            }
            if(genre == 3) {
                Main.stock.registerBook(name, value, quantity, Genre.Drama);
            } else {
                try {
                    System.out.println("Insira um gênero válido.\n");
                    Menu.Navigation();
                } catch (Exception e) {
                    System.out.println(e + "\n");
                    Menu.Navigation();
                }
            }

        } else {
            try {
                System.out.println("Entrada inválida. Tente novamente.\n");
                Menu.makeASale();
            } catch (Exception e) {
                System.out.println(e + "\n");
                Menu.makeASale();
            }
        }

        input.close();
    }

    /**
     * Os seguintes métodos servem apenas para mostrar
     * o estoque e vendas registrados na livraria. Foi
     * usado uma sobrescrita do método "toString" para
     * formatar a saída.
     */

    public static void checkStock() {
        System.out.println(Main.stock.toString());
        System.out.println("\n\n");

        Navigation();
    }

    public static void checkSales() {
        System.out.println(Main.sales.toString());
        System.out.println("\n\n");

        Navigation();
    }

    /**
     * O seguinte método retorna o dinheiro disponível no caixa
     */

    public static void verifyCash() {
        System.out.println("O saldo disponível em seu caixa é de R$" + String.format("%.2f", Main.cash.getMoney()) + "\n\n");
        Navigation();
    }
}
