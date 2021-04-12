public class BigString {
	// "�����ַ�"������
	private BigChar[] bigchars;
	// ���캯��
	public BigString(String string) {
		bigchars = new BigChar[string.length()];
		BigCharFactory factory = BigCharFactory.getInstance();
		for (int i = 0; i < bigchars.length; i++) {
			bigchars[i] = factory.getBigChar(string.charAt(i));
		}
	}
	public BigString(String string, boolean shared) {
		bigchars = new BigChar[string.length()];
		BigCharFactory factory = BigCharFactory.getInstance();
		for (int i = 0; i < bigchars.length; i++) {
			if (shared) {
				// �����ڴ�
				bigchars[i] = factory.getBigChar(string.charAt(i));
			} else {
				// �ǹ����ڴ�
				bigchars[i] = new BigChar(string.charAt(i));
			}
		}
	}
	// ��ʾ
	public void print() {
		for (int i = 0; i < bigchars.length; i++) {
			bigchars[i].print();
		}
	}
}