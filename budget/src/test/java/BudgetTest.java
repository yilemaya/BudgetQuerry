import entity.Budget;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

public class BudgetTest {

    private class FakeBudgetRepo extends BudgetRepository
    {
        private List<Budget> budgets;

        @Override
        public List<Budget> getAll() {
            return budgets;
        }

        public void setBudgets(List<Budget> budgets) {
            this.budgets = budgets;
        }
    }
    @Test
    void fullmonth() {
        FakeBudgetRepo budgetRepository = new FakeBudgetRepo();
        budgetRepository.setBudgets(asList(new Budget("202201",31), new Budget("202202",280), new Budget("202203",30*100)));
        BudgetService budgetService = new BudgetService(budgetRepository);
        LocalDate startDate =  LocalDate.of(2022, 01, 01);
        LocalDate endDate = LocalDate.of(2022, 01, 31);
        Assertions.assertEquals(31.0, budgetService.query(startDate, endDate));

    }
    @Test
    void multyMonth(){

    }
}