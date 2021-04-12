public class SpecialSupport extends Support {
	// 只能解决指定编号的问题
	private int number;
	public SpecialSupport(String name, int number) {
		super(name);
		this.number = number;
	}
	// 解决问题的方法
	@Override
	protected boolean resolve(Trouble trouble) {
		if (trouble.getNumber() == number) {
			return true;
		} else {
			return false;
		}
	}
}