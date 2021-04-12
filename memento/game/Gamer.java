package game;
import java.util.*;

public class Gamer {
	// ���ֽ�Ǯ
	private int money;
	// ��õ�ˮ��
	private List<String> fruits = new ArrayList<>();
	// �����������
	private Random random = new Random();
	// ��ʾˮ�����������
	private static String[] fruitsname = {
		"ƻ��", "����", "�㽶", "����"
	};
	// ���캯��
	public Gamer(int money) {
		this.money = money;
	}
	// ��ȡ��ǰ���ֽ�Ǯ
	public int getMoney() {
		return money;
	}
	// Ͷ�����ӽ�����Ϸ
	public void bet() {
		// ������
		int dice = random.nextInt(6) + 1;
		// ���ӽ����1ʱ���������ֽ�Ǯ
		if (dice == 1) {
			money += 100;
			System.out.println("���ֽ�Ǯ�����ˡ�");
		} else if (dice == 2) { // ���ӽ��Ϊ2ʱ�����ֽ�Ǯ����
			money /= 2;
			System.out.println("���ֽ�Ǯ�����ˡ�");
		} else if (dice == 6) { // ���ӽ��Ϊ6ʱ�����ˮ��
			String f = getFruit();
			System.out.println("�����ˮ��(" + f + ")��");
			fruits.add(f);
		} else { // ���ӽ��Ϊ3��4��5��ʲô�����ᷢ��
			System.out.println("ʲô��û�з�����");
		}
	}
	// �������
	public Memento createMemento() {
		Memento m = new Memento(money);
		Iterator<String> it = fruits.iterator();
		while (it.hasNext()) {
			String f = it.next();
			if (f.startsWith("�óԵ�")) {
				// ֻ����óԵ�ˮ��
				m.addFruit(f);
			}
		}
		return m;
	}
	// ����
	public void restoreMemento(Memento memento) {
		this.money = memento.money;
		this.fruits = memento.getFruits();
	}
	// ���ַ�����ʾ���˹�״̬
	public String toString() {
		return "[money = " + money + ", fruits = " + fruits + "]";
	}
	// ���һ��ˮ��
	private String getFruit() {
		String prefix = "";
		if (random.nextBoolean()) {
			prefix = "�óԵ�";
		}
		return prefix + fruitsname[random.nextInt(fruitsname.length)];
	}
}