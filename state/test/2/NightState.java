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
		if (8 <= hour && hour < 21) {
			context.changeState(DayState.getInstance());
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