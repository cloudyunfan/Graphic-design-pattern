package game;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class Gamer {
	private static final String SAVEFILENAME = "game.dat";
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
	
	// 撤销
	public void restoreMemento() {
		try (FileInputStream file = new FileInputStream(SAVEFILENAME); 
		ObjectInputStream in = new ObjectInputStream(file);) {
			// 从文件中重新初始化Memento
			Memento m = (Memento)in.readObject();
			// 从文件中重新初始化Game
		    this.money = m.money;
			this.fruits = m.getFruits();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("打开文件失败，撤销失败");
			throw new RuntimeException("打开文件失败");
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
		try (FileOutputStream file = new FileOutputStream(SAVEFILENAME);
		ObjectOutputStream out = new ObjectOutputStream(file);) {
			out.writeObject(m);
		} catch (IOException e) {
			System.out.println("保存文件失败，Memento实例未保存成功");
			throw new RuntimeException("保存文件失败");
		}
		return m;
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