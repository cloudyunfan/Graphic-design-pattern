public class SideBorder extends Border {
	// ��ʾװ�α߿���ַ�
	private char borderChar;
	// ͨ�����캯��ָ��Display��װ�α߿��ַ�
	public SideBorder(Display display, char ch) {
		super(display);
		this.borderChar = ch;
	}
	public int getColumns() {
		// �ַ���Ϊ�ֶδ��ַ�����������߿��ַ���
		return 1 + display.getColumns() + 1;
	}
	public int getRows() {
		// ��������װ���������
		return display.getRows();
	}
	public String getRowText(int row) {
		// ָ������һ�е��ַ���Ϊ��װ������ַ�����������ı߿���ַ�
		return borderChar + display.getRowText(row) + borderChar;
	}
}