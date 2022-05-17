
public class Cashier {
	private static int counter;
	private int id;

	public Cashier() {
		id = ++counter;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Cashier #" + id+"\n";
	}

}
