/**
 * 
 */
package Test;
 
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
 
/**
 * @author duchao
 * 
 */
class MyComboBoxEditor extends DefaultCellEditor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	public MyComboBoxEditor(String[] items) {
		super(new JComboBox(items));
		
		
	}
	
	
}