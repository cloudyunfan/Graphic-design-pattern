public class LunchState implements State {
	private static LunchState singleton = new LunchState();
	// ���캯���Ŀɼ�����private
	private LunchState() {
	}
	// ��ȡΨһʵ��
	public static State getInstance() {
		return singleton;
	}
	// ����ʱ��
	public void doClock(Context context, int hour) {
		if (13 <= hour || hour < 12) {
			context.changeState(DayState.getInstance());
		}
	}
	// ʹ�ý��
	@Override
	public void doUse(Context context) {
		context.callSecurityCenter("���������ʱ��ʹ�ý�⣡");
	}
	// ���¾���
	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("���¾��壨���ʱ�䣩");
	}
	// ����ͨ��
	@Override
	public void doPhone(Context context) {
		context.recordLog("���ʱ���ͨ��¼��");
	}
	// ��ʾ��ʾ�������
	public String toString() {
		return "[���ʱ��]";
	}
}