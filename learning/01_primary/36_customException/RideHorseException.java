package customException;

public class RideHorseException extends Exception{
	public RideHorseException(int health){
		super("��ǰ����ֵΪ" + health + "������ʧ�ܣ�");
	}
}
