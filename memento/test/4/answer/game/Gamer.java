package game;
import java.util.*;

public class Gamer {
	// 所持金钱
	private int money;
	// 获得的水果
	private List<String> fruits = new ArrayList<>();
	// 随机数生成器
	private Random random = new Random();
	// 表示水果种类的数组
	private static String[] fruitsname = {
		"苹果", "葡萄", "香蕉", "橘子"
	};
	// 构造函数
	public Gamer(int money) {
		this.money = money;
	}
	// 获取当前所持金钱
	public int getMoney() {
		return money;
	}
	// 投掷骰子进行游戏
	public void bet() {
		// 掷骰子
		int dice = random.nextInt(6) + 1;
		// 骰子结果过1时，增加所持金钱
		if (dice == 1) {
			money += 100;
			System.out.println("所持金钱增加了。");
		} else if (dice == 2) { // 骰子结果为2时，所持金钱减半
			money /= 2;
			System.out.println("所持金钱减半了。");
		} else if (dice == 6) { // 骰子结果为6时，获得水果
			String f = getFruit();
			System.out.println("获得了水果(" + f + ")。");
			fruits.add(f);
		} else { // 骰子结果为3、4、5则什么都不会发生
			System.out.println("什么都没有发生。");
		}
	}
	// 拍摄快照
	public Memento createMemento() {
		Memento m = new Memento(money);
		Iterator<String> it = fruits.iterator();
		while (it.hasNext()) {
			String f = it.next();
			if (f.startsWith("好吃的")) {
				// 只保存好吃的水果
				m.addFruit(f);
			}
		}
		return m;
	}
	// 撤销
	public void restoreMemento(Memento memento) {
		this.money = memento.money;
		this.fruits = memento.getFruits();
	}
	// 用字符串表示主人公状态
	public String toString() {
		return "[money = " + money + ", fruits = " + fruits + "]";
	}
	// 获得一个水果
	private String getFruit() {
		String prefix = "";
		if (random.nextBoolean()) {
			prefix = "好吃的";
		}
		return prefix + fruitsname[random.nextInt(fruitsname.length)];
	}
}