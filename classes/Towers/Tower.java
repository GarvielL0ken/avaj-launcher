package towers;

import flyable.Flyable;

public class Tower {
	private List<Object>	observers;

	observers = new LinkedList<Object>();

	public register(Flyable flyable) {
		System.out.println("REGISTER");
	}

	public unregister(Flyable flyable) {
		System.out.println("UNREGISTER");
	}

	protected conditionsChanged() {
		System.out.println("CONDITONS CHANGED");
	}
}