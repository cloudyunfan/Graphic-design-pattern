public interface State {
	// ����ʱ��
    abstract void doClock(Context context, int hour);
	// ʹ�ý��
	abstract void doUse(Context context);
	// ���¾���
	abstract void doAlarm(Context context);
	// ����ͨ��
	abstract void doPhone(Context context);
}