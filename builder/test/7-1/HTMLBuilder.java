import java.io.*;

public class HTMLBuilder implements Builder {
	// �ļ���
	private String filename;
	// ���ڱ�д�ļ���PrintWriter
	private PrintWriter writer;
	// HTML�ļ�����
	@Override
	public void makeTitle(String title) {
		filename = title + ".html";
		try {
			// ����PrintWriter
			writer = new PrintWriter(new FileWriter(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		writer.println("<html><head><title>" + title + "</title></head><body>");
		// �������
		writer.println("<h1>" + title + "</h1>");
	}
	// HTML�ļ��е��ַ���
	@Override
	public void makeString(String str) {
		// ��<p>��ǩ���
		writer.println("<p>" + str + "</p>");
	}
	// HTML�ļ��е���Ŀ
	@Override
	public void makeItems(String[] items) {
		// ��<ul>��<li>���
		writer.println("<ul>");
		for (int i = 0; i < items.length; i++) {
			writer.println("<li>" + items[i] + "</li>");
		}
		writer.println("</ul>");
	}
	// ����ĵ�
	@Override
	public void close() {
		// �رձ�ǩ
		writer.println("</body></html>");
		// �ر��ļ�
		writer.close();
	}
	// ��д��ɵ��ĵ�
	public String getResult() {
		// �����ļ���
		return filename;
	}
}