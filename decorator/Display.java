public abstract class Display {
	// ��ȡ�����ַ���
	public abstract int getColumns();
	// ��ȡ��������
	public abstract int getRows();
	// ��ȡ��row�е��ַ���
	public abstract String getRowText(int row);
	// ȫ����ʾ
	public final void show() {
		for (int i = 0; i < getRows(); i++) {
			System.out.println(getRowText(i));
		}
	}
}