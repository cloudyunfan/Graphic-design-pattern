import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display {
	// Ҫ��ʾ���ַ����б�
	private List<String> strings;
	// ��ȡ��������
	public MultiStringDisplay() {
		strings = new ArrayList<>();
	}
	public void add(String string) {
		// �����ַ������ַ�����
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
		// �ַ���
		return max;
	}
	@Override
	public int getRows() {
		// �������б���
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