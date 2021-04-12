public interface State {
	// 设置时间
    abstract void doClock(Context context, int hour);
	// 使用金库
	abstract void doUse(Context context);
	// 按下警铃
	abstract void doAlarm(Context context);
	// 正常通话
	abstract void doPhone(Context context);
}