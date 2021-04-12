import command.*;
import drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener, MouseMotionListener, 
WindowListener {
	// 绘制的历史记录
	private MacroCommand history = new MacroCommand();
	// 绘制区域
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);
	// 删除按钮
	private JButton clearButton = new JButton("clear");
	// 修改颜色为红色
	private JButton redButton = new JButton("red");
	// 修改颜色为蓝色
	private JButton blueButton = new JButton("blue");
	// 修改颜色为黄色
	private JButton yellowButton = new JButton("yellow");
	
	// 构造函数
	public Main(String title) {
		super(title);
		
		this.addWindowListener(this);
		canvas.addMouseMotionListener(this);
		clearButton.addActionListener(this);
		redButton.addActionListener(this);
		blueButton.addActionListener(this);
		yellowButton.addActionListener(this);
		
		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(clearButton);
		buttonBox.add(redButton);
		buttonBox.add(blueButton);
		buttonBox.add(yellowButton);
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(canvas);
		getContentPane().add(mainBox);
		
		pack();
		show();
	}
	
	// ActionListener接口中的方法
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clearButton) {
			history.clear();
			canvas.repaint();
			canvas.init();
		} else if (e.getSource() == redButton) {
			Command cmd = new ColorCommand(canvas, Color.red);
		    history.append(cmd);
		    cmd.execute();
		} else if (e.getSource() == blueButton) {
			Command cmd = new ColorCommand(canvas, Color.blue);
		    history.append(cmd);
		    cmd.execute();
		} else if (e.getSource() == yellowButton) {
			Command cmd = new ColorCommand(canvas, Color.yellow);
		    history.append(cmd);
		    cmd.execute();
		}
	}
	// MouseMotionListener接口中的方法
	@Override
	public void mouseMoved(MouseEvent e) {
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		Command cmd = new DrawCommand(canvas, e.getPoint());
		history.append(cmd);
		cmd.execute();
	}
	// WindowListener接口中的方法
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowOpened(WindowEvent e) {}
	
	public static void main(String[] args) {
		new Main("Command Pattern Sample");
	}
}