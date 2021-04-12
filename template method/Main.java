public class Main {
	public static void main(String[] args) {
		// 生成一个持有'H'的CharDisplay类的实例
		AbstractDisplay d1 = new CharDisplay('H');
		// 生成一个持有"Hello, world."的StringDisplay类的实例
		AbstractDisplay d2 = new StringDisplay("Hello, world.");
		// 生成一个持有"你好，世界。"的StringDisplay类的实例
		AbstractDisplay d3 = new StringDisplay("你好，世界");
		// 由于d1、d2、d3都是AbstractDisplay类的子类，可以调用继承的display方法
		// 实际的程序行为取决于CharDisplay类和StringDisplay类的具体实现
		d1.display();
		d2.display();
		d3.display();
	}
}