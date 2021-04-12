import game.Memento;
import game.Gamer;
import java.io.*;

public class Main {
	private static final String SAVEFILENAME = "game.dat";
	public static void main(String[] args) {
		// ��������ֽ�Ǯ��Ϊ100
		Gamer gamer = new Gamer(100);
		// ���ļ��ж�ȡ��ʼ״̬
		Memento memento = loadMemento();
		if (memento != null) {
			System.out.println("��ȡ�ϴα���浵��ʼ��Ϸ��");
			gamer.restoreMemento(memento);
		} else {
			System.out.println("����Ϸ");
		    memento = gamer.createMemento();
		}
		
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
				saveMemento(memento);
			} else if (gamer.getMoney() < memento.getMoney() / 2) {
				System.out.println("   (���ֽ�Ǯ��������࣬��˽���Ϸ�ָ�����ǰ��״̬)");
				gamer.restoreMemento(memento);
			}
		}
	}
	
	public static void saveMemento(Memento memento) {
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream(SAVEFILENAME))) {
			out.writeObject(memento);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public static Memento loadMemento() {
		Memento memento = null;
		try (ObjectInput in = new ObjectInputStream(new FileInputStream(SAVEFILENAME))) {
			memento = (Memento)in.readObject();
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return memento;
	}
}