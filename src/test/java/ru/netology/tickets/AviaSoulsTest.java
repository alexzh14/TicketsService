package ru.netology.tickets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void ticket1BiggerThanTicket2() {
        Ticket ticket1 = new Ticket("Moscow", "Budapest", 54_000, 20_00, 23_00);
        Ticket ticket2 = new Ticket("Berlin", "Budapest", 20_000, 21_00, 22_00);

        int expected = 1;

        Assertions.assertEquals(expected, ticket1.compareTo(ticket2));
    }

    @Test
    public void ticket2BiggerThanTicket1() {
        Ticket ticket1 = new Ticket("Moscow", "Budapest", 20_000, 20_00, 23_00);
        Ticket ticket2 = new Ticket("Berlin", "Budapest", 54_000, 21_00, 22_00);

        int expected = -1;

        Assertions.assertEquals(expected, ticket1.compareTo(ticket2));
    }

    @Test
    public void ticket1EqualToTicket2() {
        Ticket ticket1 = new Ticket("Moscow", "Budapest", 20_000, 20_00, 23_00);
        Ticket ticket2 = new Ticket("Berlin", "Budapest", 20_000, 21_00, 22_00);

        int expected = 0;

        Assertions.assertEquals(expected, ticket1.compareTo(ticket2));
    }

    @Test
    public void shouldFindAndSortNoTickets() {
        AviaSouls ticketManager = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "Budapest", 20_000, 20_00, 23_00);
        Ticket ticket2 = new Ticket("Berlin", "LA", 20_000, 21_00, 22_00);
        Ticket ticket3 = new Ticket("Moscow", "Budapest", 70_000, 20_00, 23_00);
        Ticket ticket4 = new Ticket("LA", "Oslo", 20_000, 21_00, 22_00);
        Ticket ticket5 = new Ticket("Moscow", "Budapest", 50_000, 20_00, 23_00);
        Ticket ticket6 = new Ticket("Tallinn", "Budapest", 20_000, 21_00, 22_00);
        Ticket ticket7 = new Ticket("Moscow", "Budapest", 15_000, 20_00, 23_00);
        Ticket ticket8 = new Ticket("Berlin", "Paris", 20_000, 21_00, 22_00);

        ticketManager.add(ticket1);
        ticketManager.add(ticket2);
        ticketManager.add(ticket3);
        ticketManager.add(ticket4);
        ticketManager.add(ticket5);
        ticketManager.add(ticket6);
        ticketManager.add(ticket7);
        ticketManager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = ticketManager.search("Paris", "Berlin");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAndSortJustOneTicket() {
        AviaSouls ticketManager = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "Budapest", 20_000, 20_00, 23_00);
        Ticket ticket2 = new Ticket("Berlin", "LA", 20_000, 21_00, 22_00);
        Ticket ticket3 = new Ticket("Moscow", "Budapest", 70_000, 20_00, 23_00);
        Ticket ticket4 = new Ticket("LA", "Oslo", 20_000, 21_00, 22_00);
        Ticket ticket5 = new Ticket("Moscow", "Budapest", 50_000, 20_00, 23_00);
        Ticket ticket6 = new Ticket("Tallinn", "Budapest", 20_000, 21_00, 22_00);
        Ticket ticket7 = new Ticket("Moscow", "Budapest", 15_000, 20_00, 23_00);
        Ticket ticket8 = new Ticket("Berlin", "Paris", 20_000, 21_00, 22_00);

        ticketManager.add(ticket1);
        ticketManager.add(ticket2);
        ticketManager.add(ticket3);
        ticketManager.add(ticket4);
        ticketManager.add(ticket5);
        ticketManager.add(ticket6);
        ticketManager.add(ticket7);
        ticketManager.add(ticket8);

        Ticket[] expected = {ticket4};
        Ticket[] actual = ticketManager.search("LA", "Oslo");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAndSortSomeTickets() {
        AviaSouls ticketManager = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "Budapest", 20_000, 20_00, 23_00);
        Ticket ticket2 = new Ticket("Berlin", "LA", 20_000, 21_00, 22_00);
        Ticket ticket3 = new Ticket("Moscow", "Budapest", 70_000, 20_00, 23_00);
        Ticket ticket4 = new Ticket("LA", "Oslo", 20_000, 21_00, 22_00);
        Ticket ticket5 = new Ticket("Moscow", "Budapest", 50_000, 20_00, 23_00);
        Ticket ticket6 = new Ticket("Tallinn", "Budapest", 20_000, 21_00, 22_00);
        Ticket ticket7 = new Ticket("Moscow", "Budapest", 15_000, 20_00, 23_00);
        Ticket ticket8 = new Ticket("Berlin", "Paris", 20_000, 21_00, 22_00);

        ticketManager.add(ticket1);
        ticketManager.add(ticket2);
        ticketManager.add(ticket3);
        ticketManager.add(ticket4);
        ticketManager.add(ticket5);
        ticketManager.add(ticket6);
        ticketManager.add(ticket7);
        ticketManager.add(ticket8);

        Ticket[] expected = {ticket7, ticket1, ticket5, ticket3};
        Ticket[] actual = ticketManager.search("Moscow", "Budapest");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticket1BiggerThanTicket2Comparator() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("Moscow", "Budapest", 54_000, 20_00, 23_00);
        Ticket ticket2 = new Ticket("Berlin", "Budapest", 20_000, 21_00, 22_00);

        int expected = 1;
        int actual = timeComparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ticket2BiggerThanTicket1Comparator() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("Moscow", "Budapest", 54_000, 20_00, 23_00);
        Ticket ticket2 = new Ticket("Berlin", "Budapest", 20_000, 14_00, 22_00);

        int expected = -1;
        int actual = timeComparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ticket1EqualToTicket2Comparator() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("Moscow", "Budapest", 54_000, 20_00, 23_00);
        Ticket ticket2 = new Ticket("Berlin", "Budapest", 20_000, 19_00, 22_00);

        int expected = 0;
        int actual = timeComparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAndSortSomeTicketsComparator() {
        AviaSouls ticketManager = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "Budapest", 20_000, 20_00, 22_00);
        Ticket ticket2 = new Ticket("Berlin", "LA", 20_000, 21_00, 22_00);
        Ticket ticket3 = new Ticket("Moscow", "Budapest", 70_000, 20_00, 24_00);
        Ticket ticket4 = new Ticket("LA", "Oslo", 20_000, 21_00, 22_00);
        Ticket ticket5 = new Ticket("Moscow", "Budapest", 50_000, 20_00, 23_00);
        Ticket ticket6 = new Ticket("Tallinn", "Budapest", 20_000, 21_00, 22_00);
        Ticket ticket7 = new Ticket("Moscow", "Budapest", 15_000, 20_00, 21_00);
        Ticket ticket8 = new Ticket("Berlin", "Paris", 20_000, 21_00, 22_00);

        ticketManager.add(ticket1);
        ticketManager.add(ticket2);
        ticketManager.add(ticket3);
        ticketManager.add(ticket4);
        ticketManager.add(ticket5);
        ticketManager.add(ticket6);
        ticketManager.add(ticket7);
        ticketManager.add(ticket8);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket7, ticket1, ticket5, ticket3};
        Ticket[] actual = ticketManager.search("Moscow", "Budapest");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAndSortNoTicketsComparator() {
        AviaSouls ticketManager = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "Budapest", 20_000, 20_00, 22_00);
        Ticket ticket2 = new Ticket("Berlin", "LA", 20_000, 21_00, 22_00);
        Ticket ticket3 = new Ticket("Moscow", "Budapest", 70_000, 20_00, 24_00);
        Ticket ticket4 = new Ticket("LA", "Oslo", 20_000, 21_00, 22_00);
        Ticket ticket5 = new Ticket("Moscow", "Budapest", 50_000, 20_00, 23_00);
        Ticket ticket6 = new Ticket("Tallinn", "Budapest", 20_000, 21_00, 22_00);
        Ticket ticket7 = new Ticket("Moscow", "Budapest", 15_000, 20_00, 21_00);
        Ticket ticket8 = new Ticket("Berlin", "Paris", 20_000, 21_00, 22_00);

        ticketManager.add(ticket1);
        ticketManager.add(ticket2);
        ticketManager.add(ticket3);
        ticketManager.add(ticket4);
        ticketManager.add(ticket5);
        ticketManager.add(ticket6);
        ticketManager.add(ticket7);
        ticketManager.add(ticket8);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = ticketManager.search("Moscow", "LA");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAndSortJustOneTicketComparator() {
        AviaSouls ticketManager = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "Budapest", 20_000, 20_00, 22_00);
        Ticket ticket2 = new Ticket("Berlin", "LA", 20_000, 21_00, 22_00);
        Ticket ticket3 = new Ticket("Moscow", "Budapest", 70_000, 20_00, 24_00);
        Ticket ticket4 = new Ticket("LA", "Oslo", 20_000, 21_00, 22_00);
        Ticket ticket5 = new Ticket("Moscow", "Budapest", 50_000, 20_00, 23_00);
        Ticket ticket6 = new Ticket("Tallinn", "Budapest", 20_000, 21_00, 22_00);
        Ticket ticket7 = new Ticket("Moscow", "Budapest", 15_000, 20_00, 21_00);
        Ticket ticket8 = new Ticket("Berlin", "Paris", 20_000, 21_00, 22_00);

        ticketManager.add(ticket1);
        ticketManager.add(ticket2);
        ticketManager.add(ticket3);
        ticketManager.add(ticket4);
        ticketManager.add(ticket5);
        ticketManager.add(ticket6);
        ticketManager.add(ticket7);
        ticketManager.add(ticket8);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4};
        Ticket[] actual = ticketManager.search("LA", "Oslo");

        Assertions.assertArrayEquals(expected, actual);
    }
}
