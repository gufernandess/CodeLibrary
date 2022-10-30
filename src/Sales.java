import java.util.ArrayList;
import java.util.List;

/**
 * A classe vendas serve como registro de todas as
 * vendas efetuadas.
 */

public class Sales {

    private List<Sale> salesList;

    public Sales() {
        salesList = new ArrayList<Sale>();
    }

    public List<Sale> getSalesList() {
        return salesList;
    }

    public void addSale(Sale sale) {}

    public void removeSale(int id) {}

    @Override
    public String toString() {
        return "Sales{" +
                "salesList=" + salesList +
                '}';
    }
}
