package entity;

public class Budget {

    public Budget( String yearMonth, Integer amount){
        this.yearMonth = yearMonth;
        this.amount = amount;
    }
    String yearMonth;
    Integer amount;

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
