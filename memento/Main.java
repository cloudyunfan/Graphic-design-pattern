import game.Memento;
import game.Gamer;

public class Main {
	public static void main(String[] args) {
		// ��������ֽ�Ǯ��Ϊ100
		Gamer gamer = new Gamer(100);
		// ���������״̬
		Memento memento = gamer.createMemento();
		for (int i = 0; i < 100; i++) {
			// ��ʾ�����ӵĴ���
			System.out.println("==== " + i);
			// ��ʾ���˹����ڵ�״̬
			System.out.println("��ǰ״̬��" + gamer);
			// ������Ϸ
			gamer.bet();
			System.out.println("���ֽ�ǮΪ" + gamer.getMoney() + "Ԫ��");
			// ������δ���Memento
			if (gamer.getMoney() > memento.getMoney()) {
				System.out.println("   (���ֽ�Ǯ��������࣬��˱�����Ϸ��ǰ��״̬)");
				memento = gamer.createMemento();
			} else if (gamer.getMoney() < memento.getMoney() / 2) {
				System.out.println("   (���ֽ�Ǯ��������࣬��˽���Ϸ�ָ�����ǰ��״̬)");
				gamer.restoreMemento(memento);
			}
		}
	}
}