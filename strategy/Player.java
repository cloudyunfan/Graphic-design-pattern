public class Player {
	private String name;
	private Strategy strategy;
	private int wincount;
	private int losecount;
	private int gamecount;
	// 赋予姓名和策略
	public Player(String name, Strategy strategy) {
		this.name = name;
		this.strategy = strategy;
	}
	// 策略决定下一局要出的手势
	public Hand nextHand() {
		return strategy.nextHand();
	}
	// 胜
	public void win() {
		strategy.study(true);
		wincount++;
		gamecount++;
	}
	// 负
	public void lose() {
		strategy.study(false);
		losecount++;
		gamecount++;
	}
	// 平
	public void even() {
		gamecount++;
	}
	@Override
	public String toString() {
		return "[" + name + ":" + gamecount + " games, " + wincount + " win, " + losecount + " lose" + "]";
	}
}