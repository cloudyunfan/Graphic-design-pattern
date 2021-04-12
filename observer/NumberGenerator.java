import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
	// ����Observer��
	private ArrayList observers = new ArrayList();
	// ע��Observer
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	// ɾ��Observer
	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}
	// ��Observer����֪ͨ
	public void notifyObservers() {
		Iterator it = observers.iterator();
		while (it.hasNext()) {
			Observer o = (Observer)it.next();
			o.update(this);
		}
	}
	// ��ȡ��ֵ
	public abstract int getNumber();
	// ������ֵ
	public abstract void execute();
}