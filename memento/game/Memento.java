package game;
import java.util.*;

public class Memento {
	// ���ֽ�Ǯ
	int money;
	// ��õ�ˮ��
	ArrayList<String> fruits;
	// ��ȡ��ǰ���ֽ�Ǯ��narrow interface��
	public int getMoney() {
		return money;
	}
	// ���캯����wide interface��
	Memento(int money) {
		this.money = money;
		this.fruits = new ArrayList<>();
	}
	// ���ˮ����wide interface��
	void addFruit(String fruit) {
		fruits.add(fruit);
	}
	// ��ȡ��ǰ��������ˮ����wide interface��
	List getFruits() {
		return (List)fruits.clone();
	}
}