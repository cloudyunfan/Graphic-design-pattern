public class Director {
	private Builder builder;
	public Director(Builder builder) {
		// ��Ϊ���յĲ�����Builder������࣬���Կ��Խ��䱣����builder�ֶ���
		this.builder = builder;
	}
	public void construct() {
		// ��д�ĵ�������
		builder.makeTitle("Greeting");
		// �ַ���
		builder.makeString(" ������������");
		// ��Ŀ
		builder.makeItems(new String[] {
			"���Ϻá�",
			"����á�",
		});
		// �����ַ���
		builder.makeString(" ����");
		// ������Ŀ
		builder.makeItems(new String[] {
			"���Ϻá�",
			"����",
			"�ټ���",
		});
		// ����ĵ�
		builder.close();
	}
}