// ������AbstractDisplay
public abstract class AbstractDisplay {
	// ��������ȥʵ�ֵĳ��󷽷�(1) open
	public abstract void open();
	// ��������ȥʵ�ֵĳ��󷽷�(2) print
	public abstract void print();
	// ��������ȥʵ�ֵĳ��󷽷�(3) close
	public abstract void close();
    // ����������ʵ�ֵ�display����
    public final void display() {
		// ���ȴ�
		open();
		for (int i = 0; i < 5; i++) {
			// ѭ������5��print
			print();
		}
		// ���رա������display������ʵ�ֵĹ���
		close();
	}		
}