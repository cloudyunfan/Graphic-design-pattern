public abstract class Entry {
	protected Entry parent;
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
	// ��ȡ����·��
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