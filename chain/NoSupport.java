public class NoSupport extends Support {
	public NoSupport(String name) {
		super(name);
	}
	// 解决问题的方法
	@Override
	protected boolean resolve(Trouble trouble) {
		// 自己什么也不处理
		return false;
	}
}