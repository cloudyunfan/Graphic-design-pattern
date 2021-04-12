package game;
import java.util.*;

public class Memento {
	// 所持金钱
	int money;
	// 获得的水果
	ArrayList<String> fruits;
	// 获取当前所持金钱（narrow interface）
	public int getMoney() {
		return money;
	}
	// 构造函数（wide interface）
	Memento(int money) {
		this.money = money;
		this.fruits = new ArrayList<>();
	}
	// 添加水果（wide interface）
	void addFruit(String fruit) {
		fruits.add(fruit);
	}
	// 获取当前所持所有水果（wide interface）
	List getFruits() {
		return (List)fruits.clone();
	}
}