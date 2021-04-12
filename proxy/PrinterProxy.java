public class PrinterProxy implements Printable {
	// ����
	private String name;
	// �����ˡ�
	private Printer real;
	public PrinterProxy() {
	}
	// ���캯��
	public PrinterProxy(String name) {
		this.name = name;
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
			real = new Printer(name);
		}
	}
}