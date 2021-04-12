public class Main {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: java Main digits");
			System.out.println("Example: java Main 1212123");
			System.exit(0);
		}
		// �ǹ���ʹ���ڴ�
		BigString bs = new BigString(args[0], false);
		bs.print();
		Runtime.getRuntime().gc();
		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("�ǹ���ʹ���ڴ� = " + used + "B");
		
		// ����ʹ���ڴ�
		bs = new BigString(args[0], true);
		bs.print();
		Runtime.getRuntime().gc();
	    used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("����ʹ���ڴ� = " + used + "B");
	}
}