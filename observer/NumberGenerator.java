import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
	// 保存Observer们
	private ArrayList observers = new ArrayList();
	// 注册Observer
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	// 删除Observer
	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}
	// 向Observer发生通知
	public void notifyObservers() {
		Iterator it = observers.iterator();
		while (it.hasNext()) {
			Observer o = (Observer)it.next();
			o.update(this);
		}
	}
	// 获取数值
	public abstract int getNumber();
	// 生成数值
	public abstract void execute();
}