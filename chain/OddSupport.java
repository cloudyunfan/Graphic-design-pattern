public class OddSupport extends Support {
	public OddSupport(String name) {
		super(name);
	}
	// 解决问题的方法
	@Override
	protected boolean resolve(Trouble trouble) {
		if (trouble.getNumber() % 2 == 1) {
			return true;
		} else {
			return false;
		}
	}
}