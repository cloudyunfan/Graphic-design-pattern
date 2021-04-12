import java.awt.TextField;
import java.awt.Color;
import java.awt.event.TextListener;
import java.awt.event.TextEvent;

public class ColleagueTextField extends TextField implements TextListener, Colleague {
	private Mediator mediator;
	// 构造函数
	public ColleagueTextField(String text, int columns) {
		super(text, columns);
	}
	// 保存Mediator
	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	// Mediator下达启用/禁用的指示
	@Override
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
		setBackground(enabled ? Color.white : Color.lightGray);
	}
	// 当文字发生变化时通知Mediator
	public void textValueChanged(TextEvent e) {
		mediator.colleagueChanged();
	}
}