public interface Context {
	// 设置时间
    abstract void setClock(int hour);
	// 改变状态
	abstract void changeState(State state);
	// 联系警报中心
	abstract void callSecurityCenter(String msg);
	// 在警报中心留下记录
	abstract void recordLog(String msg);
}