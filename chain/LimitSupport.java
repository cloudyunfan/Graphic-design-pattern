public class LimitSupport extends Support {
	// ���Խ�����С��limit������
	private int limit;
	public LimitSupport(String name, int limit) {
		super(name);
		this.limit = limit;
	}
	// �������ķ���
	@Override
	protected boolean resolve(Trouble trouble) {
		if (trouble.getNumber() < limit) {
			return true;
		} else {
			return false;
		}
	}
}