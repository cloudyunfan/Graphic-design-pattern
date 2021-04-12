import java.util.Iterator;
import java.util.ArrayList;

public class Directory extends Entry {
	// 文件夹的名字
	private String name;
	// 文件夹中目录条目的集合
	private ArrayList<Entry> directory = new ArrayList<>();
	// 构造函数
	public Directory(String name) {
		this.name = name;
	}
	// 获取名字
	@Override
	public String getName() {
		return name;
	}
	// 获取大小
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
	// 增加目录条目
	@Override
	public Entry add(Entry entry) {
		directory.add(entry);
		entry.parent = this;
		return this;
	}
	// 显示目录条目一览
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