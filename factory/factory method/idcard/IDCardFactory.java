package idcard;
import framework.*;
import java.util.*;

public class IDCardFactory extends Factory {
	private static Integer number = 1;
	private Map<Integer, String> owners = new HashMap<>();
	@Override
	protected Product createProduct(String owner) {
		return new IDCard(owner);
	}
    @Override
    protected void registerProduct(Product product) {
		owners.put(number++, ((IDCard)product).getOwner());
	}
	public Collection<String> getOwners() {
		return owners.values();
	}
	public Set<Integer> getNumbers() {
		return owners.keySet();
	}
}