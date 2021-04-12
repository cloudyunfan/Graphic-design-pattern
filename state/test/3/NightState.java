public class NightState implements State {
	private static NightState singleton = new NightState();
	// ���캯���Ŀɼ�����private
	private NightState() {
	}
	// ��ȡΨһʵ��
	public static State getInstance() {
		return singleton;
	}
	// ����ʱ��
	public void doClock(Context context, int hour) {
		if ((9 <= hour && hour <= 12) || (13 <= hour && hour < 17)) {
			context.changeState(DayState.getInstance());
		} else if (12 <= hour && hour < 13) {
			context.changeState(LunchState.getInstance());
		}
	}
	// ʹ�ý��
	@Override
	public void doUse(Context context) {
		context.callSecurityCenter("����������ʹ�ý�⣡");
	}
	// ���¾���
	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("���¾��壨���ϣ�");
	}
	// ����ͨ��
	@Override
	public void doPhone(Context context) {
		context.recordLog("���ϵ�ͨ��¼��");
	}
	// ��ʾ��ʾ�������
	public String toString() {
		return "[����]";
	}
}