import java.util.Random;

public class RandomDisplay extends Display {
	public RandomDisplay(DisplayImpl impl) {
		super(impl);
	}
	public void randomDisplay(int times) {  // ѭ�������ʾ0~times��
		open();
		int count = new Random().nextInt(times + 1);
		for (int i = 0; i < count; i++) {
			print();
		}
		close();
	}
}