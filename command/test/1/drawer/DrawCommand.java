package drawer;

import command.Command;
import java.awt.Point;

public class DrawCommand implements Command {
	// ���ƶ���
	protected Drawable drawable;
	// ����λ��
	private Point position;
	// ���캯��
	public DrawCommand(Drawable drawable, Point position) {
		this.drawable = drawable;
		this.position = position;
	}
	// ִ��
	@Override
	public void execute() {
		drawable.draw(position.x, position.y);
	}
}