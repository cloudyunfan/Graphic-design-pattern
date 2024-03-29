import game.Memento;
import game.Gamer;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		// 最初的所持金钱数为100
		Gamer gamer = new Gamer(100);
		try {
			gamer.restoreMemento();
		} catch (RuntimeException e) {
			// 如果不存在game.dat文件，以所持金钱数目为100开始游戏，保存最初的状态
			gamer = new Gamer(100);
		}
		Memento memento = gamer.createMemento();
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
			} else if (gamer.getMoney() < memento.getMoney() / 2) {
				System.out.println("   (所持金钱减少了许多，因此将游戏恢复至以前的状态)");
				gamer.restoreMemento();
			}
		}
	}
}