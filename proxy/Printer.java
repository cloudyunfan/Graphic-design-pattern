public class Printer implements Printable {
	private String name;
	public Printer() {
		heavyJob("正在生成Printer的实例");
	}
	// 构造函数
	public Printer(String name) {
		this.name = name;
		heavyJob("正在生成Printer的实例(" + name + ")");
	}
	// 设置名字
	@Override
	public void setPrinterName(String name) {
		this.name = name;
	}
	// 获取名字
	@Override
	public String getPrinterName() {
		return name;
	}
	// 显示带打印机名字的文字
	@Override
	public void print(String string) {
		System.out.println("=== " + name + " ===");
		System.out.println(string);
	}
	// 重活
	private void heavyJob(String msg) {
		System.out.print(msg);
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.print(".");
		}
		System.out.println("结束。");
	}
}