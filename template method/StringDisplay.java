public class StringDisplay extends AbstractDisplay {
	// StringҲ��AbstractDisplay������
	// ��Ҫ��ʾ���ַ���
	private String string;
    // ���ֽ�Ϊ��λ��������ַ�������
    private int width;
    // ���캯���н��յ��ַ���
    public StringDisplay(String string) {
		// �������ֶ���
		this.string = string;
		// ͬʱ���ַ������ֽڳ���Ҳ�������ֶ��У��Թ�����ʹ��
		this.width = string.getBytes().length;
	}
	@Override
	public void open() {
		// ��дopen���������ø����printLine��������
		printLine();
	}
	@Override
	public void print() {
		// print���������������ֶ��е��ַ���ǰ��ֱ����"|"����ʾ����
		System.out.println("|" + string + "|");
	}
	@Override
	public void close() {
		// close������open����һ��������printLine��������
		printLine();
	}
	private void printLine() {
		// ��open��close�������ã����ڿɼ�����private�����ֻ���ڱ����б�����
		// ��ʾ��ʾ����Ľǵ�"+"
		System.out.print("+");
		for (int i = 0; i < width; i++) {
			// ��ʾwidth��"-"����ɷ���ı߿�
			System.out.print("-");
		}
		// ��ʾ��ʾ����Ľǵ�""
		System.out.println("+");
	}
}