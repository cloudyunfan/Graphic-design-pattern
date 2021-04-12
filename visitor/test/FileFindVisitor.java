import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class FileFindVisitor extends Visitor {
	// 文件后缀名
	private String suffix;
	private List<File> files = new ArrayList<>();
	public FileFindVisitor(String suffix) {
		this.suffix = suffix;
	}
	// 在访问文件时被调用
	@Override
	public void visit(File file) {
		if (file.getName().toLowerCase().endsWith(suffix)) {
			files.add(file);
		}
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
	// 获取文件
	public Iterator<File> getFoundFiles(){
		return files.iterator();
	}
}