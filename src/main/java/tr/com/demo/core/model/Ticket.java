package tr.com.demo.core.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by muratbayram on 12/03/2017.
 */
public class Ticket {
    private String name;
    private BigDecimal amount;
    private LocalDate startDate;
    private LocalDate endDate;

    public Ticket(String name, BigDecimal amount, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
