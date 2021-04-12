public class SpecialSupport extends Support {
	// ֻ�ܽ��ָ����ŵ�����
	private int number;
	public SpecialSupport(String name, int number) {
		super(name);
		this.number = number;
	}
	// �������ķ���
	@Override
	protected boolean resolve(Trouble trouble) {
		if (trouble.getNumber() == number) {
			return true;
		} else {
			return false;
		}
	}
}