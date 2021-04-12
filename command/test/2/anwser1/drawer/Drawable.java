package drawer;

public interface Drawable {
	public abstract void draw(int x, int y);
	public abstract void undo(int x, int y);
}