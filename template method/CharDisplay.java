// CharDisplay��AbstractDisplay������
public class CharDisplay extends AbstractDisplay {
	// ��Ҫ��ʾ���ַ�
	private char ch;
	// ���캯���н��յ��ַ�
	public CharDisplay(char ch) {
		// �������ֶ���
		this.ch = ch;
	}
	@Override
	public void open() {
		// open�ڸ����еĳ��󷽷�
		// �˴���д�÷���
		// ��ʾ��ʼ�ַ�"<<"
		System.out.print("<<");
	}
	@Override
	public void print() {
		// ͬ���أ��˴���дprint����
		// �÷�������display�б��ظ�����
		// ��ʾ�������ֶ�ch�е��ַ�
		System.out.print(ch);
	}
	@Override
   	public void close() {
		// ͬ���أ��˴���дclose����
		// ��ʾ�����ַ�">>"
		System.out.println(">>");
	}
}