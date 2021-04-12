public abstract class Entry {
	protected Entry parent;
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
	// 获取完整路径
	public String getFullName() {
		StringBuffer fullname = new StringBuffer();
		Entry entry = this;
		do {
			fullname.insert(0, "/" + entry.getName());
			entry = entry.parent;
		} while (entry != null);
		return fullname.toString();
	}
}