package drawer;

import command.Command;
import java.awt.Color;

public class ColorCommand implements Command {
	// 绘制对象
	protected Drawable drawable;
	// 颜色
	protected Color color;
	// 构造函数
	public ColorCommand(Drawable drawable, Color color) {
		this.drawable = drawable;
		this.color = color;
	}
	// 执行
	@Override
	public void execute() {
		drawable.setColor(color);
	}
}