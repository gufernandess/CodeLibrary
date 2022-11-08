import java.io.Serializable;

/**
 * A classe de caixa serve para guardar todo o dinheiro
 * das compras e vendas de livros. A ideia é instanciar
 * um objeto estático para que haja somente um único
 * caixa.
 */

public class Cash implements Serializable {

    private double Money;

    public Cash(double money) {
        Money = money;
    }

    public double getMoney() {
        return Money;
    }

    public void setMoney(double money) {
        Money = money;
    }
}
