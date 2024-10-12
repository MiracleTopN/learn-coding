package design.singleton;

/**
 * @author hason
 * @since 2023/6/4 22:47
 */
public class TicketMaker {

    private static TicketMaker ticketMaker = new TicketMaker(1000);

    private int ticket;

    private TicketMaker(int ticket) {
        this.ticket = ticket;
    }

    public static TicketMaker getInstance() {
        return ticketMaker;
    }

    public synchronized int getNextTicketNumber() {
        return ticket++;
    }
}
