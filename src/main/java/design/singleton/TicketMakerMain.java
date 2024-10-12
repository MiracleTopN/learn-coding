package design.singleton;

/**
 * @author hason
 * @since 2023/6/4 22:55
 */
public class TicketMakerMain {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            TicketMaker ticketMaker = TicketMaker.getInstance();
            System.out.println("current ticket is " + ticketMaker.getNextTicketNumber());
        }
    }
}
