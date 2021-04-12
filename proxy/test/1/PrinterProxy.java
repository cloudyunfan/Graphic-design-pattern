public class PrinterProxy implements Printable {
	// ����
	private String name;
	// �����ˡ�
	private Printable real;
	private String className;
	public PrinterProxy() {
	}
	// ���캯��
	public PrinterProxy(String name, String className) {
		this.name = name;
		this.className = className;
	}
	// ��������
	@Override
	public synchronized void setPrinterName(String name) {
		if (real != null) {
			// ͬʱ���á����ˡ�������
			real.setPrinterName(name);
		}
		this.name = name;
	}
	// ��ȡ����
	@Override
	public String getPrinterName() {
		return name;
	}
	// ��ʾ
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
				System.err.println("û���ҵ�" + className + "�ࡣ");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}