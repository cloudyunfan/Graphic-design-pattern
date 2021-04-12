public class StringDisplayImpl extends DisplayImpl {
	// Ҫ��ʾ���ַ���
	private String string;
	// ���ֽڵ�λ��������ַ����Ŀ��
	private int width;
	// ���캯������Ҫ��ʾ���ַ���string
	public StringDisplayImpl(String string) {
		// �����������ֶ���
		this.string = string;
		// ���ַ����Ŀ��Ҳ�������ֶ��У��Թ�ʹ��
		this.width = string.getBytes().length;
	}
	@Override
	public void rawOpen() {
		printLine();
	}
	@Override
	public void rawPrint() {
		// ǰ�����"|"����ʾ
		System.out.println("|" + string + "|");
	}
	@Override
	public void rawClose() {
		printLine();
	}
	private void printLine() {
		// ��ʾ������ʾ����Ľǵ�"+"
		System.out.print("+");
		// ��ʾwidth��"-"
		for (int i = 0; i < width; i++) {
			// ������������ı߿�
			System.out.print("-");
		}
		// ��ʾ������ʾ����Ľǵ�"+"
		System.out.println("+");
	}
}