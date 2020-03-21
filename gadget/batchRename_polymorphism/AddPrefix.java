package batchRename_polymorphism;

/**
 * 加前缀
 */
public class AddPrefix implements RenameRule {
	String prefix;

	public AddPrefix(String prefix) {
		setPrefix(prefix);
	}

	@Override
	public String getNewName(String oldName) {
		return prefix + oldName;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
