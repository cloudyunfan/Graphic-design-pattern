   import java.util.Iterator;

public class ListVisitor extends Visitor {
	// 大小
	private int size = 0;
	// 在访问文件时被调用
	@Override
	public void visit(File file) {
		size += file.getSize();
	}
	// 在访问文件夹时被调用
	@Override
	public void visit(Directory directory) {
		Iterator<Entry> it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = it.next();
			entry.accept(this);
		}
	}
}