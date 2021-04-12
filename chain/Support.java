public abstract class Support {
	// ��������ʵ��������
	private String name;
	// Ҫ��ж���Ķ���
	private Support next;
	// ���ɽ�������ʵ��
	public Support(String name) {
		this.name = name;
	}
	// ����Ҫ��ж���Ķ���
	public Support setNext(Support next) {
		this.next = next;
		return next;
	}
	// �������Ĳ���
	public final void support(Trouble trouble) {
		if (resolve(trouble)) {
			done(trouble);
		} else if (next != null) {
			next.support(trouble);
		} else {
			fail(trouble);
		}
	}
	// ��ʾ�ַ���
	public String toString() {
		return "[" + name + "]";
	}
	// �������ķ���
	protected abstract boolean resolve(Trouble trouble);
	// ���
	protected void done (Trouble trouble) {
		System.out.println(trouble + " is solved by " + this + ".");
	}		
	// δ���
	protected void fail (Trouble trouble) {
		System.out.println(trouble + " cannot be resolved.");
	}
}