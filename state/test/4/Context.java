public interface Context {
	// ����ʱ��
    abstract void setClock(int hour);
	// �ı�״̬
	abstract void changeState(State state);
	// ��ϵ��������
	abstract void callSecurityCenter(String msg);
	// �ھ����������¼�¼
	abstract void recordLog(String msg);
}