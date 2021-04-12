   import java.util.Iterator;

public class ListVisitor extends Visitor {
	// ��С
	private int size = 0;
	// �ڷ����ļ�ʱ������
	@Override
	public void visit(File file) {
		size += file.getSize();
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
}