public class NightState implements State {
	private static NightState singleton = new NightState();
	// 构造函数的可见性是private
	private NightState() {
	}
	// 获取唯一实例
	public static State getInstance() {
		return singleton;
	}
	// 设置时间
	public void doClock(Context context, int hour) {
		if ((9 <= hour && hour <= 12) || (13 <= hour && hour < 17)) {
			context.changeState(DayState.getInstance());
		} else if (12 <= hour && hour < 13) {
			context.changeState(LunchState.getInstance());
		}
	}
	// 使用金库
	@Override
	public void doUse(Context context) {
		context.callSecurityCenter("紧急：晚上使用金库！");
	}
	// 按下警铃
	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("按下警铃（晚上）");
	}
	// 正常通话
	@Override
	public void doPhone(Context context) {
		context.recordLog("晚上的通话录音");
	}
	// 显示表示类的文字
	public String toString() {
		return "[晚上]";
	}
}