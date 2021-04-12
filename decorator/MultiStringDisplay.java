import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display {
	// 要显示的字符串列表
	private List<String> strings;
	// 获取纵向行数
	public MultiStringDisplay() {
		strings = new ArrayList<>();
	}
	public void add(String string) {
		// 新增字符串到字符数组
		strings.add(string);
	}
	@Override
	public int getColumns() {
		int max = 0;
		for (int i = 0; i < getRows(); i++) {
			if (strings.get(i).getBytes().length > max) {
				max = strings.get(i).getBytes().length;
			}
		}
		// 字符数
		return max;
	}
	@Override
	public int getRows() {
		// 行数是列表长度
		return strings.size();
	}
	@Override
	public String getRowText(int row) {
		StringBuilder sb = new StringBuilder();
		sb.append(strings.get(row));
		int columns = getColumns();
		int strColumns = strings.get(row).getBytes().length;
		if (strColumns < columns) {
			for (int i = 0; i < columns - strColumns; i++) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}
}