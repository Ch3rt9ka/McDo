
public class Order {
	enum Status {
		NEW, INPROGRESS, CLOSED
	}
	
	private static int counter;
	private int id;
	private String phone;
	private Cashier cashier;
	private Status status = Status.NEW;

	public Order(String phone1) {
		id = ++Order.counter;
		phone = phone1;
	}
	
	
	public int getId() {
		return id;
	}

	public Cashier getCashier() {
		return cashier;
	}

	public Status status() {
		return status;
	}

	@Override
	public String toString() {
		if(cashier!=null) {
			return "Order #" + id + " " + status + " phone =" +phone+ " served by  " + cashier+"\n";
		}
		else {
			return "Order #" + id + " " + status + " phone =" +phone+"\n";
		}
		
	}

	public void Do(Cashier newCashier) {
		cashier = newCashier;
		status = Status.INPROGRESS;
	}

	public void close() {
		status = Status.CLOSED;
	}
}
