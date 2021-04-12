import command.*;
import drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener 
 {
	// ���Ƶ���ʷ��¼
	private MacroCommand history = new MacroCommand();
	// ��������
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);
	// ɾ����ť
	private JButton clearButton = new JButton("clear");
	
	// ���캯��
	public Main(String title) {
		super(title);
		
		this.addWindowListener(new WindowAdapter() {
			// WindowAdapter�еķ���
	        @Override
	        public void windowClosing(WindowEvent e) {
		        System.exit(0);
	        }
		});
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			// MouseMotionAdapter�еķ���
	        @Override
	        public void mouseDragged(MouseEvent e) {
		        Command cmd = new DrawCommand(canvas, e.getPoint());
		        history.append(cmd);
		        cmd.execute();
	        }
		});
		clearButton.addActionListener(this);
		
		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(clearButton);
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
		}
	}
	
	public static void main(String[] args) {
		new Main("Command Pattern Sample");
	}
}