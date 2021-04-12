import java.util.Iterator;
import java.util.ArrayList;

public class Directory extends Entry {
	// �ļ��е�����
	private String name;
	// �ļ�����Ŀ¼��Ŀ�ļ���
	private ArrayList<Entry> directory = new ArrayList<>();
	// ���캯��
	public Directory(String name) {
		this.name = name;
	}
	// ��ȡ����
	@Override
	public String getName() {
		return name;
	}
	// ��ȡ��С
	@Override
	public int getSize() {
		int size = 0;
		Iterator<Entry> it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = it.next();
			size += entry.getSize();
		}
		return size;
	}
	// ����Ŀ¼��Ŀ
	@Override
	public Entry add(Entry entry) {
		directory.add(entry);
		entry.parent = this;
		return this;
	}
	// ��ʾĿ¼��Ŀһ��
	@Override
	protected void printList(String prefix) {
		System.out.println(prefix + "/" + this);
		Iterator<Entry> it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = it.next();
			entry.printList(prefix + "/" + name);
		}
	}
}