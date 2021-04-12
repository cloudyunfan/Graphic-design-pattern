public class EmergencyState implements State {
	private static EmergencyState singleton = new EmergencyState();
	// ���캯���Ŀɼ�����private
	private EmergencyState() {
	}
	// ��ȡΨһʵ��
	public static State getInstance() {
		return singleton;
	}
	// ����ʱ��
	public void doClock(Context context, int hour) {
		/**if (9 <= hour && hour < 17) {
			context.changeState(DayState.getInstance());
		} else {
			context.changeState(NightState.getInstance());
		}**/
		// ������ʱ�䴦����ʲô������
	}
	// ʹ�ý��
	@Override
	public void doUse(Context context) {
		context.callSecurityCenter("������ʹ�ý�⣨���������");
	}
	// ���¾���
	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("���¾��壨���������");
	}
	// ����ͨ��
	@Override
	public void doPhone(Context context) {
		context.recordLog("ͨ��¼�������������");
	}
	// ��ʾ��ʾ�������
	public String toString() {
		return "[�������]";
	}
}