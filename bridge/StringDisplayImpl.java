public class StringDisplayImpl extends DisplayImpl {
	// 要显示的字符串
	private String string;
	// 以字节单位计算出的字符串的宽度
	private int width;
	// 构造函数接收要显示的字符串string
	public StringDisplayImpl(String string) {
		// 将它保存在字段中
		this.string = string;
		// 把字符串的宽度也保存在字段中，以供使用
		this.width = string.getBytes().length;
	}
	@Override
	public void rawOpen() {
		printLine();
	}
	@Override
	public void rawPrint() {
		// 前后加上"|"并显示
		System.out.println("|" + string + "|");
	}
	@Override
	public void rawClose() {
		printLine();
	}
	private void printLine() {
		// 显示用来表示方框的角的"+"
		System.out.print("+");
		// 显示width个"-"
		for (int i = 0; i < width; i++) {
			// 将其用作方框的边框
			System.out.print("-");
		}
		// 显示用来表示方框的角的"+"
		System.out.println("+");
	}
}