 package drawer;

import command.Command;
import java.awt.Point;

public class DrawCommand implements Command {
	// 绘制对象
	protected Drawable drawable;
	// 绘制位置
	private Point position;
	// 构造函数
	public DrawCommand(Drawable drawable, Point position) {
		this.drawable = drawable;
		this.position = position;
	}
	// 执行
	@Override
	public void execute() {
		drawable.draw(position.x, position.y);
	}
	// UNDO
	@Override
	public void undo() {
		drawable.undo(position.x, position.y);
	}
}