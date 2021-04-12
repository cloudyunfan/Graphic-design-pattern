import java.util.Random;

public class RandomStrategy implements Strategy {
	private Random random;
	private boolean won = false;
	private Hand prevHand;
	public RandomStrategy(int seed) {
		random = new Random(seed);
	}
	@Override
	public Hand nextHand() {
		prevHand = Hand.getHand(random.nextInt(3));
		return prevHand;
	}
	@Override
	public void study(boolean win) {
		won = win;
	}
}