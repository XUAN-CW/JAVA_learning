package test;

import javax.swing.JOptionPane;

public class Dialog 
{
	public static void main(String[] args)
	{
		//参数1：对话框的父窗体对象
		//参数2：对话框中的提示信息
		//参数3：对话框的标题信息
		//参数4：对话框的消息类型
		//参数5：对话框中显示的图片对象
		
		/*** 让用户确认信息，比如装备已获得、商品已加入购物车 **/
//		JOptionPane.showMessageDialog(null, "商品已加入购物车");
		
		/*** 让用户确认信息，比如充值成功、网络已关闭 **/
//		JOptionPane.showMessageDialog(null, "充值成功", "窗体的标题", JOptionPane.INFORMATION_MESSAGE);
//		JOptionPane.showMessageDialog(null, "网络已关闭", "窗体的标题", JOptionPane.ERROR_MESSAGE);
		
		/*** 输入字符串并将其转成数字 **/
//		int num =Integer.parseInt(JOptionPane.showInputDialog("输入字符串并返回输入的字符串"));
//		System.out.println(num);
		
		/** 
		 * 选择 - 适用于在少量选项中选择 
		 * @return 选项数组中的下标，关闭则返回【-1】
		 */
//		    Object[] options ={ "打印 0 ", "打印 1 " };  
//	    int response = JOptionPane.showOptionDialog(null, "提示信息", "标题",JOptionPane.YES_NO_OPTION,
//	    		JOptionPane.QUESTION_MESSAGE, null, options, options[0]);  
//		System.out.println(response);
		
		/** 
		 * 选择 - 适用于在大量选项中选择 
		 * @return 选项数组中对应的内容，关闭则返回【null】
		 */
//	    Object[] possibleValues = { "第一", "第二", "第三","第四","第五","第六","第七" }; // 用户的选择项目
//	    Object selectedValue = JOptionPane.showInputDialog(null, "Choose one",
//		"窗体的标题", JOptionPane.INFORMATION_MESSAGE, null, possibleValues,possibleValues[0]);
//		System.out.println("您按下了"+(String)selectedValue+"项目");
		
//		JOptionPane.showMessageDialog(null, "显示的信息", "窗体的标题", JOptionPane.WARNING_MESSAGE, 
//		new ImageIcon("images/timg.jpg"));	
		
//		Object inputValue = JOptionPane.showInputDialog(null, "显示的信息", "窗体的标题", 0,
//				new ImageIcon("images/timg.jpg"), null, "可输入信息");
//		System.out.println((String)inputValue);
		
//		String inputValue = JOptionPane.showInputDialog("可输入并返回字符串");
//		System.out.println(inputValue);
		
//		Object option = JOptionPane.showInputDialog(null, "显示的信息", "窗体的标题", 0, new ImageIcon("images/timg.jpg"), 
//				new String[]{"选项一", "选项二", "选项三"}, "默认值");
//		System.out.println((String)option);
		
//		int confirm = JOptionPane.showConfirmDialog(null, "显示确认对话");
//		System.out.println(confirm);
		
		
	}

}
