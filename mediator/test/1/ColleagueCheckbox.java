import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague {
	private Mediator mediator;
	// ���캯��
	public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state) {
		super(caption, group, state);
	}
	@Override
	public void setMediator(Mediator mediator) {
		// ����Mediator
		this.mediator = mediator;
	}
	@Override
	public void setColleagueEnabled(boolean enabled) {
		// Mediator�´�����/���õ�ָʾ
		setEnabled(enabled);
	}
	public void itemStateChanged(ItemEvent e) {
		// ��״̬�����仯ʱ֪ͨMediator
		mediator.colleagueChanged();
	}
}