package drawer;

import command.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawCanvas extends Canvas implements Drawable {
	// ��ɫ
	private Color color;
	// Ҫ���Ƶ�Բ��İ뾶
	private int radius = 6;
	// �������ʷ��¼
	private MacroCommand history = new MacroCommand();
	// ���캯��
	public DrawCanvas(int width, int height, MacroCommand history) {
		setSize(width, height);
		setBackground(Color.white);
		this.history = history;
		init();
	}
	// ����ȫ������
	@Override
	public void paint(Graphics g) {
		history.execute();
	}
	// ����
	@Override
	public void draw(int x, int y) {
		Graphics g = getGraphics();
		g.setColor(color);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}
	
	// ��ʼ��
	@Override
	public void init() {
		color = Color.red;
		radius = 6;
		history.append(new ColorCommand(this, color));
	}
	
	// ������ɫ
	@Override
	public void setColor(Color color) {
		this.color = color;
	}
}