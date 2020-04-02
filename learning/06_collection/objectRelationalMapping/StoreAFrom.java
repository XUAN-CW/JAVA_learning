package objectRelationalMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ���Ա�����ݵĴ洢
 * ORM˼��ļ�ʵ�飺map��ʾһ�����ݣ����������Ƕ��map�������map�ŵ�list��
 */
public class StoreAFrom {
	public static void main(String[] args) {
		
		Map<String,Object>  row1 = new HashMap<>();
		row1.put("id", 1001);
		row1.put("����", "����");
		row1.put("нˮ", 20000);
		row1.put("��ְ����", "2018.5.5");
		
		Map<String,Object>  row2 = new HashMap<>();
		row2.put("id", 1002);
		row2.put("����", "����");
		row2.put("нˮ", 30000);
		row2.put("��ְ����", "2005.4.4");
		
		Map<String,Object>  row3 = new HashMap<>();
		row3.put("id", 1003);
		row3.put("����", "����");
		row3.put("нˮ", 3000);
		row3.put("��ְ����", "2020.5.4");
		
		List<Map<String,Object>> table1 = new ArrayList<>();
		table1.add(row1);
		table1.add(row2);
		table1.add(row3);
		
		for(Map<String,Object> row:table1){
			/**
			 * set��һ���洢���ظ�Ԫ�أ�������ļ�����
			 * keyset�������صľ���һ��set����
			 * map����ļ�ֵ����������:<1,one>,<2,two><3,three><4,four><5,five><6,six>,
			   ��ôkeyset�����������ǰ�1,2,3,4,5,6�ŵ�һ��set�������棬Ȼ�󷵻ظ����ô��� 
			 */
			Set<String> keyset = row.keySet();	
			for (String key : keyset) {
				System.out.print(key+":"+row.get(key)+"\t");
			}
			System.out.println();
		}
 
		
		
		
	}
}
