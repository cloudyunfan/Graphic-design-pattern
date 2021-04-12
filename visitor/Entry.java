import java.util.Iterator;

public abstract class Entry implements Element {
	// 获取名字
	public abstract String getName();
	// 获取大小
	public abstract int getSize();
	// 加入目录条目
	public Entry add(Entry entry) throws FileTreatmentException {
		throw new FileTreatmentException();
	}
	// 生成Iterator
	public Iterator<Entry> iterator() throws FileTreatmentException {
		throw new FileTreatmentException();
	}
	// 显示代表类的文字
	public String toString() {
		return getName() + " (" + getSize() + ")";
	}
}