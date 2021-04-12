import command.*;
import drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener, MouseMotionListener, 
WindowListener {
	// ���Ƶ���ʷ��¼
	private MacroCommand history = new MacroCommand();
	// ��������
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);
	// ɾ����ť
	private JButton clearButton = new JButton("clear");
	// �޸���ɫΪ��ɫ
	private JButton redButton = new JButton("red");
	// �޸���ɫΪ��ɫ
	private JButton blueButton = new JButton("blue");
	// �޸���ɫΪ��ɫ
	private JButton yellowButton = new JButton("yellow");
	
	// ���캯��
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
	
	// ActionListener�ӿ��еķ���
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
	// MouseMotionListener�ӿ��еķ���
	@Override
	public void mouseMoved(MouseEvent e) {
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		Command cmd = new DrawCommand(canvas, e.getPoint());
		history.append(cmd);
		cmd.execute();
	}
	// WindowListener�ӿ��еķ���
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