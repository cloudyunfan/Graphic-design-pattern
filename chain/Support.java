public abstract class Support {
	// 解决问题的实例的名字
	private String name;
	// 要推卸给的对象
	private Support next;
	// 生成解决问题的实例
	public Support(String name) {
		this.name = name;
	}
	// 设置要推卸给的对象
	public Support setNext(Support next) {
		this.next = next;
		return next;
	}
	// 解决问题的步骤
	public final void support(Trouble trouble) {
		if (resolve(trouble)) {
			done(trouble);
		} else if (next != null) {
			next.support(trouble);
		} else {
			fail(trouble);
		}
	}
	// 显示字符串
	public String toString() {
		return "[" + name + "]";
	}
	// 解决问题的方法
	protected abstract boolean resolve(Trouble trouble);
	// 解决
	protected void done (Trouble trouble) {
		System.out.println(trouble + " is solved by " + this + ".");
	}		
	// 未解决
	protected void fail (Trouble trouble) {
		System.out.println(trouble + " cannot be resolved.");
	}
}