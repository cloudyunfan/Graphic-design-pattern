public class Main {
	public static void main(String[] args) {
		// ����һ������'H'��CharDisplay���ʵ��
		AbstractDisplay d1 = new CharDisplay('H');
		// ����һ������"Hello, world."��StringDisplay���ʵ��
		AbstractDisplay d2 = new StringDisplay("Hello, world.");
		// ����һ������"��ã����硣"��StringDisplay���ʵ��
		AbstractDisplay d3 = new StringDisplay("��ã�����");
		// ����d1��d2��d3����AbstractDisplay������࣬���Ե��ü̳е�display����
		// ʵ�ʵĳ�����Ϊȡ����CharDisplay���StringDisplay��ľ���ʵ��
		d1.display();
		d2.display();
		d3.display();
	}
}