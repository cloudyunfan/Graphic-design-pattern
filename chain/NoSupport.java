public class NoSupport extends Support {
	public NoSupport(String name) {
		super(name);
	}
	// �������ķ���
	@Override
	protected boolean resolve(Trouble trouble) {
		// �Լ�ʲôҲ������
		return false;
	}
}