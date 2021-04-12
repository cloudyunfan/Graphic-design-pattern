public class PrinterProxy implements Printable {
	// 名字
	private String name;
	// “本人”
	private Printable real;
	private String className;
	public PrinterProxy() {
	}
	// 构造函数
	public PrinterProxy(String name, String className) {
		this.name = name;
		this.className = className;
	}
	// 设置名字
	@Override
	public synchronized void setPrinterName(String name) {
		if (real != null) {
			// 同时设置“本人”的名字
			real.setPrinterName(name);
		}
		this.name = name;
	}
	// 获取名字
	@Override
	public String getPrinterName() {
		return name;
	}
	// 显示
	@Override
	public void print(String string) {
		realize();
		real.print(string);
	}
	private synchronized void realize() {
		if (real == null) {
			try {
				real = (Printable)Class.forName(className).newInstance();
				real.setPrinterName(name);
			} catch (ClassNotFoundException e) {
				System.err.println("没有找到" + className + "类。");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}