import java.io.*;

/**
 * A classe de caixa serve para guardar todo o dinheiro
 * das compras e vendas de livros. A ideia é instanciar
 * um objeto estático para que haja somente um único
 * caixa.
 */

public class Cash implements Serializable {

    private double money;

    public Cash() {
        this.money = readCashData("cash.dat");
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double readCashData(String fileName) {
        double money = 0;

        try {
            File file = new File("/home/gustavo_fernandes/Projects/CodeLibrary/src/data/" + fileName);

            if (file.exists()) {
                    ObjectInputStream inputFile = new ObjectInputStream(new FileInputStream(file));
                    money = (double) inputFile.readObject();
                    inputFile.close();
            }

        } catch(IOException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch(ClassNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return money;
    }

    public void writeCashData(double money, String fileName) {
        File file = new File("/home/gustavo_fernandes/Projects/CodeLibrary/src/data/" + fileName);

        try {
            file.delete();
            file.createNewFile();

            ObjectOutputStream outputFile = new ObjectOutputStream(new FileOutputStream(file));
            outputFile.writeObject(money);
            outputFile.close();

        } catch(IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
