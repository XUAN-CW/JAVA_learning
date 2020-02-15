package saveAndRead;

public class Main {
	public static void main(String[] args) {
		SaveAndRead saveAndRead=new SaveAndRead();
		StringBuffer s = new StringBuffer("");
		for (Integer i = 1; i <=10000; i++) {
			s.append(i.toString()+"\n");
		}
		saveAndRead.save("test.txt", s.toString());
		
		System.out.println(saveAndRead.read("test.txt"));
		System.out.println(s.length());
	}
}
