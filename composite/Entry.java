public abstract class Entry {
	// 获取名字
	public abstract String getName();
	// 获取大小
	public abstract int getSize();
	// 加入目录条目
	public Entry add(Entry entry) throws FileTreatmentException {
		throw new FileTreatmentException();
	}
	// 显示目录条目一览
	public void printList() {
		printList("");
	}
	// 为一览加上前缀并显示目录条目一览
	protected abstract void printList(String prefix);
	// 显示代表类的文字
	public String toString() {
		return getName() + " (" + getSize() + ")";
	}
}