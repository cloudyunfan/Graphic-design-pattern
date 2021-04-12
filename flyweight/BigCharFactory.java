import java.util.HashMap;

public class BigCharFactory {
	// �����Ѿ����ɵ�BigChar��ʵ��
	private HashMap<String, BigChar> pool = new HashMap<>();
	// Singletonģʽ
	private static BigCharFactory singleton = new BigCharFactory();
	// ���캯��
	private BigCharFactory() {
	}
	// ��ȡΨһ��ʵ��
	public static BigCharFactory getInstance() {
		return singleton;
	}
	// ���ɣ�����BigChar���ʵ��
	public synchronized BigChar getBigChar(char charname) {
		BigChar bc = pool.get("" + charname);
		if (bc == null) {
			// ����BigChar��ʵ��
			bc = new BigChar(charname);
			pool.put("" + charname, bc);
		}
		return bc;
	}
}