public class Main {
	public static void main(String[] args) {
		Triple triple0 = Triple.getInstance(0);
		Triple triple1 = Triple.getInstance(1);
		Triple triple2 = Triple.getInstance(2);
		if (triple0 == triple1) {
			System.out.println("triple0��triple1����ͬ��ʵ����");
		} else {
			System.out.println("triple0��triple1�ǲ�ͬ��ʵ����");
		}
		if (triple1 == triple2) {
			System.out.println("triple1��triple2����ͬ��ʵ����");
		} else {
			System.out.println("triple1��triple2�ǲ�ͬ��ʵ����");
		}
		if (triple2 == triple0) {
			System.out.println("triple2��triple0����ͬ��ʵ����");
		} else {
			System.out.println("triple2��triple0�ǲ�ͬ��ʵ����");
		}
	}
}