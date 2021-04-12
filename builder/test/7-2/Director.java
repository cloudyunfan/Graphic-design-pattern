public class Director {
	private Builder builder;
	public Director(Builder builder) {
		// ��Ϊ���յĲ�����Builder������࣬���Կ��Խ��䱣����builder�ֶ���
		this.builder = builder;
	}
	public void construct() {
		builder.makeText("Greeting", " ������������", new String[] {
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