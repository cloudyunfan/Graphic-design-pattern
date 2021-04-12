import framework.*;
import idcard.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
	    Factory factory = new IDCardFactory();
	    Product card1 = factory.create("Ð¡ÔÆ");
	    Product card2 = factory.create("Ð¡Çï");
	    Product card3 = factory.create("Ð¡»Æ");
	    card1.use();
	    card2.use();
	    card3.use();
		Set<Integer> nums = ((IDCardFactory)factory).getNumbers();
		Iterator it = nums.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}