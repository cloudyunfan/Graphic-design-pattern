public class LunchState implements State {
	private static LunchState singleton = new LunchState();
	// 构造函数的可见性是private
	private LunchState() {
	}
	// 获取唯一实例
	public static State getInstance() {
		return singleton;
	}
	// 设置时间
	public void doClock(Context context, int hour) {
		if (13 <= hour || hour < 12) {
			context.changeState(DayState.getInstance());
		}
	}
	// 使用金库
	@Override
	public void doUse(Context context) {
		context.callSecurityCenter("紧急：午餐时间使用金库！");
	}
	// 按下警铃
	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("按下警铃（午餐时间）");
	}
	// 正常通话
	@Override
	public void doPhone(Context context) {
		context.recordLog("午餐时间的通话录音");
	}
	// 显示表示类的文字
	public String toString() {
		return "[午餐时间]";
	}
}