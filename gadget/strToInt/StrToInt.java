package strToInt;

public class StrToInt {
	public static void main(String[] args) {
		System.out.println(strToInt("a12"));
	}
	
	public static int strToInt(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new RuntimeException("�������,�޷�ת�����ַ���");
        }
        char[] charArray = str.toCharArray();
        int start = 0;
        if (charArray[0] == '-') {
            // �п����Ǹ�����start+1
            start++;
        }
        int result = charArrayToInt(charArray, start, charArray.length - 1);
        return start == 1 ? -result : result;
    }
 
    // �ַ�����[start,end]ת����һ������
    private static int charArrayToInt(char[] charArray, int start, int end) {
        if (start < 0 || end < 0 || start > end) {
            return 0;
        }
        long result = 0;
        result = charToNum(charArray[end]) + (long)10 * charArrayToInt(charArray, start, end - 1);
        if (result > Integer.MAX_VALUE) {
            throw new RuntimeException("�������");
        }
        if (start > 0 && result > (long) Integer.MAX_VALUE+1 ) {// ����
            throw new RuntimeException("�������");
        }
        if(end != charArray.length -1 && result == 0){
            throw new RuntimeException("���ݷǷ�");
        }
        return (int) result;
    }
 
    // ��charת����0-9������
    private static int charToNum(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else {
            throw new RuntimeException("��������޷�ת�����ַ���");
        }
    }

}
