public interface Printable {
	// ��������
	public abstract void setPrinterName(String name);
	// ��ȡ����
	public abstract String getPrinterName();
	// ��ʾ���֣���ӡ�����
	public abstract void print(String string);
}