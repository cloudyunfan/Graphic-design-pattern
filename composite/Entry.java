public abstract class Entry {
	// ��ȡ����
	public abstract String getName();
	// ��ȡ��С
	public abstract int getSize();
	// ����Ŀ¼��Ŀ
	public Entry add(Entry entry) throws FileTreatmentException {
		throw new FileTreatmentException();
	}
	// ��ʾĿ¼��Ŀһ��
	public void printList() {
		printList("");
	}
	// Ϊһ������ǰ׺����ʾĿ¼��Ŀһ��
	protected abstract void printList(String prefix);
	// ��ʾ�����������
	public String toString() {
		return getName() + " (" + getSize() + ")";
	}
}