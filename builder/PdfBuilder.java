import java.io.*;

public class PdfBuilder extends Builder {
	// 文件名
	private String filename;
	// 用于编写文件的PrintWriter
	private PrintWriter writer;
	// Pdf文件标题
	@Override
	public void makeTitle(String title) {
		filename = title + ".pdf";
		try {
			// 生成PrintWriter
			writer = new PrintWriter(new FileWriter(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		writer.println("<html><head><title>" + title + "</title></head><body>");
		// 输出标题
		writer.println("<h1>" + title + "</h1>");
	}
	// Pdf文件中的字符串
	@Override
	public void makeString(String str) {
		// 用<p>标签输出
		writer.println("<p>" + str + "</p>");
	}
	// Pdf文件中的条目
	@Override
	public void makeItems(String[] items) {
		// 用<ul>和<li>输出
		writer.println("<ul>");
		for (int i = 0; i < items.length; i++) {
			writer.println("<li>" + items[i] + "</li>");
		}
		writer.println("</ul>");
	}
	// 完成文档
	@Override
	public void close() {
		// 关闭标签
		writer.println("</body></html>");
		// 关闭文件
		writer.close();
	}
	// 编写完成的文档
	public String getResult() {
		// 返回文件名
		return filename;
	}
}