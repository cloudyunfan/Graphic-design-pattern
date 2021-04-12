import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class FileFindVisitor extends Visitor {
	// �ļ���׺��
	private String suffix;
	private List<File> files = new ArrayList<>();
	public FileFindVisitor(String suffix) {
		this.suffix = suffix;
	}
	// �ڷ����ļ�ʱ������
	@Override
	public void visit(File file) {
		if (file.getName().toLowerCase().endsWith(suffix)) {
			files.add(file);
		}
	}
	// �ڷ����ļ���ʱ������
	@Override
	public void visit(Directory directory) {
		Iterator<Entry> it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = it.next();
			entry.accept(this);
		}
	}
	// ��ȡ�ļ�
	public Iterator<File> getFoundFiles(){
		return files.iterator();
	}
}