public class TextBuilder implements Builder {
	// �ĵ����ݱ����ڸ��ֶ���
	private StringBuffer buffer = new StringBuffer();
	// ���ı��ı���
	@Override
	public void makeTitle(String title) {
		// װ����
		buffer.append("======================\n");
		// Ϊ����ӡ���
		buffer.append("��" + title + "��\n");
		// ����
		buffer.append("\n");
	}
	// ���ı����ַ���
	@Override
	public void makeString(String str) {
		// Ϊ�ַ������-
		buffer.append('-' + str + "\n");
		// ����
		buffer.append("\n");
	}
	// ���ı�����Ŀ
	@Override
	public void makeItems(String[] items) {
		for (int i = 0; i < items.length; i++) {
			// Ϊ��Ŀ���.
			buffer.append("   ." + items[i] + "\n");
		}
		// ����
		buffer.append("\n");
	}
	// ����ĵ�
	@Override
	public void close() {
		// װ����
		buffer.append("======================\n");
	}
	// ��ɵ��ĵ�
	public String getResult() {
		// ��StringBuffer�任ΪString
		return buffer.toString();
	}
}