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

    // return days
    private int countBudgetDays(LocalDate startDate, LocalDate endDate, YearMonth budgetYearMonth){

        // -1 表示不用
        int startDayofMonth =1;
        if(startDate.isBefore(budgetYearMonth.atDay(1)))
        {

        }
        else{
            if(startDate.getMonthValue()==budgetYearMonth.getMonthValue())
                startDayofMonth = startDate.getDayOfMonth();
            else
                return 0;
        }


        int endDayofMonth = budgetYearMonth.lengthOfMonth();
        if(endDate.isAfter(budgetYearMonth.atEndOfMonth()))
        {

        }
        else{
            if(endDate.getMonthValue()==budgetYearMonth.getMonthValue())
                endDayofMonth = endDate.getDayOfMonth();
            else
                return 0;
        }

        return endDayofMonth- startDayofMonth +1;
    }

    public Double query(LocalDate startDate, LocalDate endDate) {
        List<Budget> data = budgetRepository.getAll();
        YearMonth startYearMonth = YearMonth.from(startDate);
        YearMonth endYearMonth = YearMonth.from(endDate);
        Double totalBudgetAmount = 0D;
        int startIndex =0;

        // start peroid

        //int endOfStartDate =startYearMonth.lengthOfMonth();

        int startPeriodDays =0;
        //int startDays = endOfStartDate - startDate.getDayOfMonth()+1;

        for(Budget budget : data) {


            YearMonth budgetYearMonth = YearMonth.parse(budget.getYearMonth(), DateTimeFormatter.ofPattern("yyyyMM"));

            int budgetDays = countBudgetDays(startDate, endDate, budgetYearMonth);

            totalBudgetAmount += budget.getAmount() / budgetYearMonth.lengthOfMonth() *budgetDays;

        }




        // midle period

        // end period


        return totalBudgetAmount;
    }
}
