public abstract class Builder {
	public final void makeText(String title, String str, String[] items) {
		makeTitle(title);
		makeString(str);
		makeItems(items);
	}
	public abstract void makeTitle(String title);
	public abstract void makeString(String str);
	public abstract void makeItems(String[] items);
	public abstract void close();
}