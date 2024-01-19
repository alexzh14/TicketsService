package ru.netology.tickets;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int flyingTime1 = t1.getTimeTo() - t1.getTimeFrom();
        int flyingTime2 = t2.getTimeTo() - t2.getTimeFrom();

        if (flyingTime1 < flyingTime2) {
            return -1;
        } else if (flyingTime1 > flyingTime2) {
            return 1;
        } else {
            return 0;
        }
    }
}