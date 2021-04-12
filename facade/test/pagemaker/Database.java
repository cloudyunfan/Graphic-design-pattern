package pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class Database {
	// 防止外部new出Database的实例，所以声明为private
	private Database() {
	}
	// 根据数据库名获取Properties
	public static Properties getProperties(String dbname) {
		String filename = dbname + ".txt";
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(filename));
		} catch (IOException e) {
			System.out.println("Warning: " + filename + " is not found.");
		}
		return prop;
	}
}