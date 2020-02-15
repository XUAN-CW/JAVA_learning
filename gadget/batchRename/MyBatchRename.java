package batchRename;

import java.io.File;
import java.util.Scanner;


/**
 * ����ʹ�ã�����һ�����У��㲻�ɳ��أ�ע��·������д��
 * ���������⣺ת������ <=> ������������ַ�ǰ�� ��\\��
 */

public class MyBatchRename {
	interface rename {
		String renameRule(String oldName);
	}

	private String dir;// �˳����ݹ������Ŀ¼�������ļ�,�ǵ��޸�Ϊ������ϵ��ļ�����·��
	private rename r = (String oldName) -> null;
	private boolean canRename = false; // ΪԤ��Ч�������

	public MyBatchRename(String path) {
		setDir(path);
	}

	public void delete(String Deleted) {
		this.r = (String oldName) -> {
			return oldName.replaceAll(Deleted, "");// ������
		};
	}

	public void replace(String regex, String replacement) {
		this.r = (String oldName) -> {
			return oldName.replaceAll(regex, replacement);// ������
		};
	}

	public void addStringToFileAtHead(String head) {
		this.r = (String oldName) -> {
			return head + oldName;// ������
		};
	}

	public void bringTheStringForward(String str) {
		this.r = (String oldName) -> {
			StringBuffer newName = new StringBuffer("");
			String temp[] = oldName.split(str);
			if (oldName.contains(str)) {
				newName.append(str);
				for (int i = 0; i < temp.length; i++) {
					newName.append(temp[i]);
				}
				return newName.toString();// ������
			} else {
				return oldName;
			}
		};
	}
	
	/**
	 * ������Ϊ�����ļ�������������ּ��� x 
	 * ���� ��1.txt��,x Ϊ 2 ������������ ��3.txt��
	 */
	public void addX(int x) {
		this.r = (String oldName) -> {
			String s[]=oldName.split("\\.");
			try {
				oldName=String.valueOf(Integer.valueOf(s[0])+x)+"."+s[1];
			} catch (Exception e) {
				System.out.println("�ļ����������ֻ��ļ��޺�׺��"+oldName+" ����������");
//				e.printStackTrace();
			}
			return oldName;
		};
	}
	
	

	private String getNewName(File renamedFile) {
		return this.r.renameRule(renamedFile.getName());
	}

	/**
	 * �ݹ�����ļ��л�ȡ�ļ�
	 */
	private void recursiveTraversalFolder() {
		File folder = new File(dir);
		if (folder.exists()) {
			// ��ȡ�ļ����������ļ�
			File[] fileArr = folder.listFiles();
			if (null == fileArr || fileArr.length == 0) {
				System.out.println("�ļ����ǿյ�!");
				return;
			} else {
				for (int i=1;i<=fileArr.length;i++) {
					/**
					 * ΪʲôҪ��β��ͷ����Ϊ���ļ� 1.txt �� �ļ� 2.txt ͬʱ���ڣ����� addX() ��������һ�������
					 * 1.txt ������Ϊ 2.txt ʱ������ 2.txt �Ѵ��ڣ�����������ʧ��
					 */
					File file=fileArr[fileArr.length-i];
					if (file.isDirectory()) {// ���ļ��У������ݹ飬�����Ҫ�������ļ��У��������������
						System.out.println("�ļ���:" + file.getAbsolutePath() + "�������ݹ飡");
						recursiveTraversalFolder();
					} else {// ���ļ�����������
							// ���ļ� = �ļ������ļ���·�� + ���ļ���
						File newFile = new File(file.getParentFile() + "/" + getNewName(file));
						if (canRename) {
							file.renameTo(newFile);// ������
						}
						System.out.print(newFile.getName().equals(file.getName()) ? "" : "��������" + newFile.getName() + "\n");

					}

				}
			}
		} else {
			System.out.println("�ļ�������!");
		}
	}

	public void startOperate() {
		System.out.println("----------Ԥ��----------");
		recursiveTraversalFolder();
		System.out.println("ȷ�ϴ˲���������һ�����У��㲻�ɳ���!    y/n");
		Scanner input = new Scanner(System.in);
		if (input.nextLine().equals("y") || input.nextLine().equals("Y")) {
			this.canRename = true;
			System.out.println("----------ִ��----------");
			recursiveTraversalFolder();
		}
	}

	public String getDir() {
		return dir;
	}

	private void setDir(String dir) {
		this.dir = dir;
	}

}
