package nccs.omts.model;

public class Tickets {
	private int booking_id;
	private int no_of_tickets;
	private int price;
	public Tickets(int booking_id, int no_of_tickets, int price) {
		super();
		this.booking_id = booking_id;
		this.no_of_tickets = no_of_tickets;
		this.price = price;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public int getNo_of_tickets() {
		return no_of_tickets;
	}
	public void setNo_of_tickets(int no_of_tickets) {
		this.no_of_tickets = no_of_tickets;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
