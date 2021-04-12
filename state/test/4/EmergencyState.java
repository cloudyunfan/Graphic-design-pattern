public class EmergencyState implements State {
	private static EmergencyState singleton = new EmergencyState();
	// 构造函数的可见性是private
	private EmergencyState() {
	}
	// 获取唯一实例
	public static State getInstance() {
		return singleton;
	}
	// 设置时间
	public void doClock(Context context, int hour) {
		/**if (9 <= hour && hour < 17) {
			context.changeState(DayState.getInstance());
		} else {
			context.changeState(NightState.getInstance());
		}**/
		// 在设置时间处理中什么都不做
	}
	// 使用金库
	@Override
	public void doUse(Context context) {
		context.callSecurityCenter("紧急：使用金库（紧急情况）");
	}
	// 按下警铃
	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("按下警铃（紧急情况）");
	}
	// 正常通话
	@Override
	public void doPhone(Context context) {
		context.recordLog("通话录音（紧急情况）");
	}
	// 显示表示类的文字
	public String toString() {
		return "[紧急情况]";
	}
}