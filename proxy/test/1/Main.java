public class Main {
	public static void main(String[] args) {
		Printable p = new PrinterProxy("Alice", "Printer");
		System.out.println("���ڵ�������" + p.getPrinterName() + "��");
		p.setPrinterName("Bob");
		System.out.println("���ڵ�������" + p.getPrinterName() + "��");
		p.print("Hello, world.");
	}
}