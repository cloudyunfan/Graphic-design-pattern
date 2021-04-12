import game.Memento;
import game.Gamer;
import java.io.*;

public class Main {
	private static final String SAVEFILENAME = "game.dat";
	public static void main(String[] args) {
		// 最初的所持金钱数为100
		Gamer gamer = new Gamer(100);
		// 从文件中读取起始状态
		Memento memento = loadMemento();
		if (memento != null) {
			System.out.println("读取上次保存存档开始游戏。");
			gamer.restoreMemento(memento);
		} else {
			System.out.println("新游戏");
		    memento = gamer.createMemento();
		}
		
		for (int i = 0; i < 100; i++) {
			// 显示掷骰子的次数
			System.out.println("==== " + i);
			// 显示主人公现在的状态
			System.out.println("当前状态：" + gamer);
			// 进行游戏
			gamer.bet();
			System.out.println("所持金钱为" + gamer.getMoney() + "元。");
			// 决定如何处理Memento
			if (gamer.getMoney() > memento.getMoney()) {
				System.out.println("   (所持金钱增加了许多，因此保存游戏当前的状态)");
				memento = gamer.createMemento();
				saveMemento(memento);
			} else if (gamer.getMoney() < memento.getMoney() / 2) {
				System.out.println("   (所持金钱减少了许多，因此将游戏恢复至以前的状态)");
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