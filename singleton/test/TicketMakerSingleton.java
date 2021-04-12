public class TicketMakerSingleton {
	private static int ticket = 1000;
	private TicketMakerSingleton ticket = new TicketMakerSingleton();
	private TicketMakerSingleton() {
	}
	public int getNextTicketNumber() {
		return ticket++;
	}
	public static TicketMakerSingleton getInstance() {
		return ticket;
	}
}