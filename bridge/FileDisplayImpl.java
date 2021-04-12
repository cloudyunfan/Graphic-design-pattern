import java.io.*;

public class FileDisplayImpl extends DisplayImpl {
	private String filename;
	private BufferedReader reader;
	// ѭ����ʾ�ļ��ޣ������С���ƣ�
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
		// װ�ο�
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
		// װ�ο�
		System.out.println("=-=-=-=-=-= " + filename + " =-=-=-=-=-=");
		try {
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}