import entity.Budget;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class BudgetService {
    BudgetRepository budgetRepository;
    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public Double query(LocalDate startDate, LocalDate endDate) {
        List<Budget> data = budgetRepository.getAll();
        YearMonth startYearMonth = YearMonth.from(startDate);
        YearMonth endYearMonth = YearMonth.from(endDate);
        Double totalBudgetAmount = 0D;
        for(Budget budget : data){
            YearMonth budgetYearMonth = YearMonth.parse(budget.getYearMonth(), DateTimeFormatter.ofPattern("yyyyMM"));

            if ((startYearMonth.isBefore(budgetYearMonth) && endYearMonth.isAfter(budgetYearMonth)) )
            {
                totalBudgetAmount += budget.getAmount();
            }


        }

        return totalBudgetAmount;
    }
}
