public class StringDisplay extends AbstractDisplay {
	// String也是AbstractDisplay的子类
	// 需要显示的字符串
	private String string;
    // 以字节为单位计算出的字符串长度
    private int width;
    // 构造函数中接收的字符串
    public StringDisplay(String string) {
		// 保存在字段中
		this.string = string;
		// 同时将字符串的字节长度也保存在字段中，以供后面使用
		this.width = string.getBytes().length;
	}
	@Override
	public void open() {
		// 重写open方法，调用该类的printLine方法画线
		printLine();
	}
	@Override
	public void print() {
		// print方法，给保存在字段中的字符串前后分别加上"|"并显示出来
		System.out.println("|" + string + "|");
	}
	@Override
	public void close() {
		// close方法与open方法一样，调用printLine方法画线
		printLine();
	}
	private void printLine() {
		// 被open和close方法调用，由于可见性是private，因此只能在本类中被调用
		// 显示表示方框的角的"+"
		System.out.print("+");
		for (int i = 0; i < width; i++) {
			// 显示width个"-"，组成方框的边框
			System.out.print("-");
		}
		// 显示表示方框的角的""
		System.out.println("+");
	}
}