package framework;

public interface Product extends Cloneable {
	public abstract void use(String s);
	default public Product createClone() {
		Product p = null;
		try {
			p = clone();
		} catch (CloneNotSupportedException e) {
			e.printStrackTrace();
		}
		return p;
	}
}