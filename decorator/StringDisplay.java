public class StringDisplay extends Display {
	// Ҫ��ʾ���ַ���
	private String string;
	// ��ȡ��������
	public StringDisplay(String string) {
		this.string = string;
	}
	@Override
	public int getColumns() {
		// �ַ���
		return string.getBytes().length;
	}
	@Override
	public int getRows() {
		// ������1
		return 1;
	}
	@Override
	public String getRowText(int row) {
		// ����rowΪ0ʱ����ֵ
		if (row == 0) {
			return string;
		} else {
			return null;
		}
	}
}