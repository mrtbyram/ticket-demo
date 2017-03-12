package tr.com.iyzico.core.service;

import org.apache.tomcat.jni.Local;
import tr.com.iyzico.core.model.Ticket;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by muratbayram on 12/03/2017.
 */
public class TicketFinder {

    private List<Ticket> tickets = new ArrayList<>();

    public TicketFinder(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public TicketFinder() {
        tickets.add(new Ticket(
                "Blind Bird",
                BigDecimal.valueOf(100),
                LocalDate.of(2016, 10, 12),
                LocalDate.of(2016, 12, 12)));
    }

    public boolean hasTicket() {
        return !tickets.isEmpty();
    }

    public Ticket findTicketByDate(LocalDate date) {
        return tickets.stream().filter(
                t -> date.compareTo(t.getStartDate())>=0
                        && date.compareTo(t.getEndDate()) <= 0).findAny()
                .orElse(null);
    }
}
