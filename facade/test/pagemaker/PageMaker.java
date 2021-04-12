package pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Enumeration;

public class PageMaker {
	// 防止外部new出PageMaker的实例，所以声明为private方法
	private PageMaker() {
	}
	public static void makeWelcomePage(String mailaddr, String filename) {
		try {
			Properties mailprop = Database.getProperties("maildata");
			System.out.println(mailprop.toString());
			String username = mailprop.getProperty(mailaddr);
			HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
			writer.title("Welcome to " + username + "'s page!");
			writer.paragraph(username + "欢迎来到" + username + "的主页。");
			writer.paragraph("等着你的邮件哦！");
			writer.mailto(mailaddr, username);
			writer.close();
			System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void makeLinkPage(String filename) {
		try {
			Properties mailprop = Database.getProperties("maildata");
			HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
			writer.title("Link page");
			for (Enumeration<?> e = mailprop.keys(); e.hasMoreElements(); ) {
				String mailaddr = (String)e.nextElement();
				String username = (String)mailprop.get(mailaddr);
				writer.mailto(mailaddr, username);
			}
			writer.close();
			System.out.println(filename + " is created.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}