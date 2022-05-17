

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
	private List<Order> orders = new ArrayList<Order>();

	private List<Cashier> cashiers = new ArrayList<Cashier>();
	private static OrderService obj;

	private OrderService() {
		super();
	}

	public static OrderService getObj() {
		if (obj == null) {
			obj = new OrderService();
		}
		return obj;
	}

	public Cashier addCashier() {
		Cashier cashier = new Cashier();
		cashiers.add(cashier);
		return cashier;
	}

	public Cashier checkCashier(int id) {
		return cashiers.stream().filter(x -> x.getId() == id).findAny().orElse(null);
	}

	public List<Cashier> cashiers() {
		return cashiers;
	}
	public List<Order> orders() {
		return orders;
	}
	

	public Order addOrder(String phone) {
		Order order = new Order(phone);
		orders.add(order);
		return order;
	}

	public Cashier Do(Cashier cashier) {
		Cashier result = null;
		if (cashier != null) {
			for (Order order : orders) {
				if (order.status() == Order.Status.NEW) {
					order.Do(cashier);
					result = cashier;
					break;
				}
			}
		}

		return result;
	}

	public void close(Cashier cashier) {
		for (Order order : orders) {
			if (order.getCashier() == cashier && order.status() == Order.Status.INPROGRESS) {
				order.close();
				break;
			}
		}

	}

	public List<Order> orders(Order.Status status) {
		return orders.stream().filter(x -> x.status() == status).collect(Collectors.toList());
	}

	public List<Order> orders(Cashier cashier) {
		return orders.stream().filter(x -> x.getCashier() == cashier && x.status() == Order.Status.INPROGRESS)
				.collect(Collectors.toList());
	}

	public Order checkOrder(int id) {
		return orders.stream().filter(x -> x.getId() == id).findAny().orElse(null);
	}

}
