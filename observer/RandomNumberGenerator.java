import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {
	// �����������
	private Random random = new Random();
	// ��ǰ��ֵ
	private int number;
	// ��ȡ��ǰ��ֵ
	@Override
	public int getNumber() {
		return number;
	}
	@Override
	public void execute() {
		for (int i = 0; i < 20; i++) {
			number = random.nextInt(50);
			notifyObservers();
		}
	}
}