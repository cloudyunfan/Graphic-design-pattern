public class Main {
	public static void main(String[] args) {
		Triple triple0 = Triple.getInstance(0);
		Triple triple1 = Triple.getInstance(1);
		Triple triple2 = Triple.getInstance(2);
		if (triple0 == triple1) {
			System.out.println("triple0与triple1是相同的实例。");
		} else {
			System.out.println("triple0与triple1是不同的实例。");
		}
		if (triple1 == triple2) {
			System.out.println("triple1与triple2是相同的实例。");
		} else {
			System.out.println("triple1与triple2是不同的实例。");
		}
		if (triple2 == triple0) {
			System.out.println("triple2与triple0是相同的实例。");
		} else {
			System.out.println("triple2与triple0是不同的实例。");
		}
	}
}