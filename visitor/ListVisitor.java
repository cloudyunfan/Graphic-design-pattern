import java.util.Iterator;

public class ListVisitor extends Visitor {
	// 当前访问的文件夹的名字
	private String currentdir = "";
	// 在访问文件时被调用
	@Override
	public void visit(File file) {
		System.out.println(currentdir + "/" + file);
	}
	// 在访问文件夹时被调用
	@Override
	public void visit(Directory directory) {
		System.out.println(currentdir + "/" + directory);
		String savedir = currentdir;
		currentdir = currentdir + "/" + directory.getName();
		Iterator<Entry> it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = it.next();
			entry.accept(this);
		}
		currentdir = savedir;
	}
}