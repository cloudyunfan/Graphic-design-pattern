package pagemaker;

import java.io.Writer;
import java.io.IOException;

class HtmlWriter {
	private Writer writer;
	// 构造函数
	public HtmlWriter(Writer writer) {
		this.writer = writer;
	}
	// 输出标题
	public void title(String title) throws IOException {
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<title>" + title + "</title>");
		writer.write("</head>");
		writer.write("<body>\n");
		writer.write("<h1>" + title + "</h1>\n");
	}
	// 输出段落
	public void paragraph(String msg) throws IOException {
		writer.write("<p>" + msg + "</p>\n");
	}
	// 输出超链接
	public void link(String href, String caption) throws IOException {
		paragraph("<a href=\"" + href + "\">" + caption + "</a>");
	}
	// 输出邮件地址
	public void mailto(String mailaddr, String username) throws IOException {
		link("mailto:" + mailaddr, username);
	}
	// 结束输出HTML
	public void close() throws IOException {
		writer.write("</body>");
		writer.write("</html>\n");
		writer.close();
	}
}