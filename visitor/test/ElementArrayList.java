import java.util.ArrayList;
import java.util.Iterator;

public class ElementArrayList extends ArrayList<Entry> {
	public void accept(Visitor v) {
		Iterator<Entry> it = this.iterator();
		while (it.hasNext()) {
			it.next().accept(v);
		}
	}
}