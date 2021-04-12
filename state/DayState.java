public class DayState implements State {
	private static DayState singleton = new DayState();
	// ���캯���Ŀɼ�����private
	private DayState() {
	}
	// ��ȡΨһʵ��
	public static State getInstance() {
		return singleton;
	}
	// ����ʱ��
	@Override
	public void doClock(Context context, int hour) {
		if (hour < 9 || 17 <= hour) {
			context.changeState(NightState.getInstance());
		}
	}
	
	// ʹ�ý��
	@Override
	public void doUse(Context context) {
		context.recordLog("ʹ�ý�⣨���죩");
	}
	// ���¾���
	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("���¾��壨���죩");
	}
	// ����ͨ��
	@Override
	public void doPhone(Context context) {
		context.callSecurityCenter("����ͨ�������죩");
	}
	// ��ʾ��ʾ�������
	public String toString() {
		return "[����]";
	}
}