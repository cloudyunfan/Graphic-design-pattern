package drawer;

import command.Command;
import java.awt.Color;

public class ColorCommand implements Command {
	// ���ƶ���
	protected Drawable drawable;
	// ��ɫ
	protected Color color;
	// ���캯��
	public ColorCommand(Drawable drawable, Color color) {
		this.drawable = drawable;
		this.color = color;
	}
	// ִ��
	@Override
	public void execute() {
		drawable.setColor(color);
	}
}