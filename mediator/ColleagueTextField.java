import java.awt.TextField;
import java.awt.Color;
import java.awt.event.TextListener;
import java.awt.event.TextEvent;

public class ColleagueTextField extends TextField implements TextListener, Colleague {
	private Mediator mediator;
	// ���캯��
	public ColleagueTextField(String text, int columns) {
		super(text, columns);
	}
	// ����Mediator
	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	// Mediator�´�����/���õ�ָʾ
	@Override
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
		setBackground(enabled ? Color.white : Color.lightGray);
	}
	// �����ַ����仯ʱ֪ͨMediator
	public void textValueChanged(TextEvent e) {
		mediator.colleagueChanged();
	}
}