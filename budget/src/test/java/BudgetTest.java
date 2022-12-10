import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class BudgetTest {

    @Test
    void singleDay() {
        BudgetRepository budgetRepository = new BudgetRepository();
        BudgetService budgetService = new BudgetService(budgetRepository);
        Date startDate = new Date();
        Date endDate = new Date();
        budgetService.query(startDate, endDate);

    }
    @Test
    void multyMonth(){

    }
}