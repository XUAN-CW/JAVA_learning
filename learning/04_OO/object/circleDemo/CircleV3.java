package circleDemo;

public class CircleV3 
{
	/** Բ�İ뾶 */
	private double radius;
	/** Բ���ܳ� */
	private double perimeter;
	/** Բ����� */
	private double area;
	
//	public  //���е�
//	private //˽�е�
//	(default)	//Ĭ��  ͬһ����
//	protected	//�ܱ����� ͬһ�����и��ӹ�ϵ
	
	
	public double getRadius()
	{
		return radius;
	}
	
	public void show()
	{
		System.out.println("�ܳ�Ϊ��" + this.getPerimeter());
		System.out.println("���Ϊ��" + this.getArea());
	}
	
	public CircleV3() {}
	public CircleV3(double radius) 
	{
		//this.radius = radius;
		this.setRadius(radius);
	}
	
	// ���� double radius �����˶���� radius ���� this �ɷ��ʶ���� radius 
	// ���� double radius ��Ϊ double radius1 ����ʱ��radius Ϊ����� radius
	public void setRadius(double radius)	
	{
		if(radius <= 0)	//��װ�ĺô������ԶԴ�������Խ��м򵥵���֤
		{
			radius = 1;
		}else
		{
			//this->��ָ��   ��/����
			this.radius = radius;
			//radius = radius;
		}		
	}

	public double getPerimeter() 
	{
		perimeter = 2 * Math.PI * radius;
		return perimeter;
	}

	public double getArea()
	{
		//�洢 area �Ŀ�ռ������ֵ�Ѹı�
		area = Math.PI * Math.pow(radius, 2);
		return area;
	}
	
	public double getArea2() 
	{
		return area;
	}
	
	
	
}
