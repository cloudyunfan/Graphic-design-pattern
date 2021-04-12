import java.io.*;

public class FileDisplayImpl extends DisplayImpl {
	private String filename;
	private BufferedReader reader;
	// 循环显示的极限（缓存大小限制）
	private final int MAX_READHEAD_LIMIT = 4096;
	public FileDisplayImpl(String filename) {
		this.filename = filename;
	}
	@Override
	public void rawOpen() {
		try {
			reader = new BufferedReader(new FileReader(filename));
			reader.mark(MAX_READHEAD_LIMIT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 装饰框
		System.out.println("=-=-=-=-=-= " + filename + " =-=-=-=-=-=");
	}

    @Override	
	public void rawPrint() {
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println("> " + line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void rawClose() {
		// 装饰框
		System.out.println("=-=-=-=-=-= " + filename + " =-=-=-=-=-=");
		try {
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}