package tr.com.iyzico.core.service;

import org.junit.Test;
import tr.com.iyzico.core.model.Ticket;
import tr.com.iyzico.core.service.TicketFinder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by muratbayram on 12/03/2017.
 */
public class TicketFinderTest {

    @Test
    public void should_have_tickets(){
        TicketFinder finder = new TicketFinder();

        assertTrue(finder.hasTicket());
    }

    @Test
    public void should_find_ticket_by_date(){
        List<Ticket> testList = new ArrayList<>();
        testList.add(new Ticket("Blind Bird", BigDecimal.valueOf(100), LocalDate.of(2016, 10, 12), LocalDate.of(2016, 12, 12)));
        testList.add(new Ticket("Early Bird", BigDecimal.valueOf(120), LocalDate.of(2016, 12, 13), LocalDate.of(2016, 12, 31)));
        TicketFinder finder = new TicketFinder(testList);

        Ticket ticket = finder.findTicketByDate(LocalDate.of(2016, 10, 12));
        assertNotNull(ticket);
        assertEquals("Blind Bird", ticket.getName());

        ticket = finder.findTicketByDate(LocalDate.of(2016, 12, 31));
        assertNotNull(ticket);
        assertEquals("Early Bird", ticket.getName());

        ticket = finder.findTicketByDate(LocalDate.of(2017, 12, 10));
        assertNull(ticket);

        ticket = finder.findTicketByDate(LocalDate.of(2016, 8, 10));
        assertNull(ticket);
    }
}
