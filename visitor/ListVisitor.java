import java.util.Iterator;

public class ListVisitor extends Visitor {
	// ��ǰ���ʵ��ļ��е�����
	private String currentdir = "";
	// �ڷ����ļ�ʱ������
	@Override
	public void visit(File file) {
		System.out.println(currentdir + "/" + file);
	}
	// �ڷ����ļ���ʱ������
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