public class UpDownBorder extends Border {
	// ��ʾװ�α߿���ַ�
	private char borderChar;
	// ͨ�����캯��ָ��Display��װ�α߿��ַ�
	public UpDownBorder(Display display, char ch) {
		super(display);
		this.borderChar = ch;
	}
	public int getColumns() {
		// ��������װ���������
		return display.getColumns();
	}
	public int getRows() {
		// ����Ϊ��װ�������������±߿��ַ���
		return 1 + display.getRows() + 1;
	}
	public String getRowText(int row) {
		// ָ������һ�е��ַ���
		if (row == 0) {
			// �±߿�
			return makeLine(borderChar, display.getColumns());
		} else if (row == display.getRows() + 1) {
			// �ϱ߿�
			return makeLine(borderChar, display.getColumns());
		} else {
			// �ޱ߿�
			return display.getRowText(row - 1);
		}
	}
	private String makeLine(char ch, int count) {
		// ����һ���ظ�count���ַ�ch���ַ���
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < count; i++) {
			buf.append(ch);
		}
		return buf.toString();
	}
}