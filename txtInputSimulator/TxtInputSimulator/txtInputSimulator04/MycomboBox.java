package txtInputSimulator04;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class MycomboBox<E> extends JComboBox<E>{
	int numberOfItem;
	//ItemContentAndTheCorrespondingString[0]为条目内容
	//ItemContentAndTheCorrespondingString[1]为条目对应文本
	String[][] itemContentAndTheCorrespondingString;
	int currentSelected=0;
	
	public MycomboBox(){
		super();
		setNumberOfItem(5);
		initItemContentAndTheCorrespondingString();
//		initItemList();
		setModel(new DefaultComboBoxModel(getItemList()));
		initCurrentSelected(getSelectedIndex());
		
	}

	public void initItemContentAndTheCorrespondingString() {
		itemContentAndTheCorrespondingString = new String[2][getNumberOfItem()];
		for (int i = 0; i < itemContentAndTheCorrespondingString[0].length; i++) {
			Integer temp=i+1;
			itemContentAndTheCorrespondingString[0][i]="文本"+temp.toString();
		}
		for (int i = 0; i < itemContentAndTheCorrespondingString.length; i++) {
			itemContentAndTheCorrespondingString[1][i]="";
		}
	}

	public void initCurrentSelected(int currentSelected) {
		this.currentSelected = currentSelected;
	}

	public String[] getItemList() {
		return itemContentAndTheCorrespondingString[0];
	}

//	public void initItemList() {
//		for (int i = 0; i < itemContentAndTheCorrespondingString[0].length; i++) {
//			Integer temp=i+1;
//			itemContentAndTheCorrespondingString[0][i]="文本"+temp.toString();
//		}
//	}

	public String[] getItemListCorrespondingStringList() {
		return itemContentAndTheCorrespondingString[1];
	}

	public void setItemCorrespondingString(String str,int index) {
		itemContentAndTheCorrespondingString[1][index]=str;
	}

	
	public int getNumberOfItem() {
		return numberOfItem;
	}

	public void setNumberOfItem(int numberOfItem) {
		this.numberOfItem = numberOfItem;
	}

	public String[][] getItemContentAndTheCorrespondingString() {
		return itemContentAndTheCorrespondingString;
	}

	public void setItemContentAndTheCorrespondingString(String[][] itemContentAndTheCorrespondingString) {
		this.itemContentAndTheCorrespondingString = itemContentAndTheCorrespondingString;
	}

	public int getCurrentSelected() {
		return currentSelected;
	}

	public void setCurrentSelected(int currentSelected) {
		this.currentSelected = currentSelected;
	}
	
	
	
	
	
	
	
	
}
