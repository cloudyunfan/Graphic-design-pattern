// CharDisplay是AbstractDisplay的子类
public class CharDisplay extends AbstractDisplay {
	// 需要显示的字符
	private char ch;
	// 构造函数中接收的字符
	public CharDisplay(char ch) {
		// 保存在字段中
		this.ch = ch;
	}
	@Override
	public void open() {
		// open在父类中的抽象方法
		// 此处重写该方法
		// 显示开始字符"<<"
		System.out.print("<<");
	}
	@Override
	public void print() {
		// 同样地，此处重写print方法
		// 该方法灰在display中被重复调用
		// 显示保存在字段ch中的字符
		System.out.print(ch);
	}
	@Override
   	public void close() {
		// 同样地，此处重写close方法
		// 显示结束字符">>"
		System.out.println(">>");
	}
}