public class Main {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: java Main digits");
			System.out.println("Example: java Main 1212123");
			System.exit(0);
		}
		// 非共享使用内存
		BigString bs = new BigString(args[0], false);
		bs.print();
		Runtime.getRuntime().gc();
		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("非共享使用内存 = " + used + "B");
		
		// 共享使用内存
		bs = new BigString(args[0], true);
		bs.print();
		Runtime.getRuntime().gc();
	    used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("共享使用内存 = " + used + "B");
	}
}