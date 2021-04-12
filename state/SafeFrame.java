import java.awt.Frame;
import java.awt.Label;
import java.awt.Color;
import java.awt.Button;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SafeFrame extends Frame implements ActionListener, Context {
	// ��ʾ��ǰʱ��
	private TextField textClock = new TextField(60);
	// ��ʾ�������ĵļ�¼
	private TextArea textScreen = new TextArea(10, 60);
	// ʹ�ý�ⰴť
	private Button buttonUse = new Button("ʹ�ý��");
	// ���¾��尴ť
	private Button buttonAlarm = new Button("���¾���");
	// ����ͨ����ť
	private Button buttonPhone = new Button("����ͨ��");
	// ������ť
	private Button buttonExit = new Button("����");
	
	// ��ǰ��״̬
	private State state = DayState.getInstance();
	
	// ���캯��
	public SafeFrame(String title) {
		super(title);
		setBackground(Color.lightGray);
		setLayout(new BorderLayout());
		// ����textClock
		add(textClock, BorderLayout.NORTH);
		textClock.setEditable(false);
		// ����textScreen
		add(textScreen, BorderLayout.CENTER);
		textScreen.setEditable(false);
		// Ϊ������Ӱ�ť
		Panel panel = new Panel();
		panel.add(buttonUse);
		panel.add(buttonAlarm);
		panel.add(buttonPhone);
		panel.add(buttonExit);
		// ���ý���
		add(panel, BorderLayout.SOUTH);
		// ��ʾ
		pack();
		show();
		// ���ü�����
		buttonUse.addActionListener(this);
		buttonAlarm.addActionListener(this);
		buttonPhone.addActionListener(this);
		buttonExit.addActionListener(this);
	}
	// ��ť�����º�÷����ᱻ����
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		if (e.getSource() == buttonUse) { // ���ʹ�ð�ť
			state.doUse(this);
		} else if (e.getSource() == buttonAlarm) { // ���¾��尴ť
			state.doAlarm(this);
		} else if (e.getSource() == buttonPhone) { // ����ͨ����ť
			state.doPhone(this);
		} else if (e.getSource() == buttonExit) { // ������ť
			System.exit(0);
		} else {
			System.out.println("?");
		}
	}
	// ����ʱ��
	@Override
	public void setClock(int hour) {
		String clockstring = "����ʱ����";
		if (hour < 10) {
			clockstring += "0" + hour + ":00";
		} else {
			clockstring += hour + ":00";
		}
		System.out.println(clockstring);
		textClock.setText(clockstring);
		state.doClock(this, hour);
	}
	// �ı�״̬
	@Override
	public void changeState(State state) {
		System.out.println("��" + this.state + "״̬��Ϊ��" + state + "״̬��");
		this.state = state;
	}
	// ��ϵ��������
	@Override
	public void callSecurityCenter(String msg) {
		textScreen.append("call! " + msg + "\n");
	}
	// �ھ����������¼�¼
	@Override
	public void recordLog(String msg) {
		textScreen.append("record ... " + msg + "\n");
	}
}