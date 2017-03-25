package tr.com.iyzico.core.service;

import org.apache.tomcat.jni.Local;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import tr.com.iyzico.core.model.Ticket;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by muratbayram on 12/03/2017.
 */
@Service
@Scope("singleton")
public class TicketFinder {

    private List<Ticket> tickets;

    public TicketFinder() {
        tickets = new ArrayList<>();
        tickets.add(new Ticket(
                "Blind Bird",
                BigDecimal.valueOf(250),
                LocalDate.of(2017, 12, 1),
                LocalDate.of(2018, 1, 15)));

        tickets.add(new Ticket(
                "Early Bird",
                BigDecimal.valueOf(500),
                LocalDate.of(2018, 1, 16),
                LocalDate.of(2018, 2, 28)));

        tickets.add(new Ticket(
                "Regular",
                BigDecimal.valueOf(750),
                LocalDate.of(2018, 3, 1),
                LocalDate.of(2018, 4, 30)));

        tickets.add(new Ticket(
                "Laggard",
                BigDecimal.valueOf(1000),
                LocalDate.of(2018, 5, 1),
                LocalDate.of(2018, 5, 27)));
    }

    public TicketFinder(List<Ticket> tickets) {
        this.tickets = tickets;
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
