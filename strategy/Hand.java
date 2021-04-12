public class Hand {
	// ��ʾʯͷ��ֵ
	public static final int HANDVALUE_GUU = 0;
	// ��ʾ������ֵ
	public static final int HANDVALUE_CHO = 1;
	// ��ʾ����ֵ
	public static final int HANDVALUE_PAA = 2;
	// ��ʾ��ȭ��3�����Ƶ�ʵ��
	public static final Hand[] hand = {
		new Hand(HANDVALUE_GUU),
		new Hand(HANDVALUE_CHO),
		new Hand(HANDVALUE_PAA),
	};
	// ��ʾ��ȭ�����ƶ�Ӧ���ַ���
	private static final String[] name = {
		"ʯͷ", "����", "��",
	};
	// ��ȭ�г������Ƶ�ֵ
	private int handvalue;
	private Hand(int handvalue) {
		this.handvalue = handvalue;
	}
	// �������Ƶ�ֵ��ȡ���Ӧ��ʵ��
	public static Hand getHand(int handvalue) {
		return hand[handvalue];
	}
	// ���thisʤ��h�򷵻�true
	public boolean isStrongerThan(Hand h) {
		return fight(h) == 1;
	}
	// ���this�����h�򷵻�true
	public boolean isWeakerThan(Hand h) {
		return fight(h) == -1;
	}
	// �Ʒ֣�ƽ0��ʤ1����-1
	private int fight(Hand h) {
		if (this == h) {
			return 0;
		} else if ((this.handvalue + 1) % 3 == h.handvalue) {
			return 1;
		} else {
			return -1;
		}
	}
	// ת��Ϊ����ֵ����Ӧ���ַ���
	public String toString() {
		return name[handvalue];
	}
}