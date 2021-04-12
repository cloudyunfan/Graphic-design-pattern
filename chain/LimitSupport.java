public class LimitSupport extends Support {
	// 可以解决编号小于limit的问题
	private int limit;
	public LimitSupport(String name, int limit) {
		super(name);
		this.limit = limit;
	}
	// 解决问题的方法
	@Override
	protected boolean resolve(Trouble trouble) {
		if (trouble.getNumber() < limit) {
			return true;
		} else {
			return false;
		}
	}
}