package alphabet;

public class Alphabet {
	public static void main(String[] args)
	{
		alphabetDemo();
		System.out.println("\n"+"禤成伟:1800301037");
	}
	
	public static void alphabetDemo() {
		char ch;
		for(ch='a';ch<='z';ch++){
			System.out.print(ch);
		}
		System.out.println();
		for(ch='A';ch<='Z';ch++){
			System.out.print(ch);
		}
	}
}
