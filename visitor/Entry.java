import java.util.Iterator;

public abstract class Entry implements Element {
	// ��ȡ����
	public abstract String getName();
	// ��ȡ��С
	public abstract int getSize();
	// ����Ŀ¼��Ŀ
	public Entry add(Entry entry) throws FileTreatmentException {
		throw new FileTreatmentException();
	}
	// ����Iterator
	public Iterator<Entry> iterator() throws FileTreatmentException {
		throw new FileTreatmentException();
	}
	// ��ʾ�����������
	public String toString() {
		return getName() + " (" + getSize() + ")";
	}
}