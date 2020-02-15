package txtInputSimulator06;

public interface DataTransmission {
	
	String divider="&";
	String txtDivider="-";
	String filler=" ";
	
	String connectionFail="connectionFail";
	
	String loggingFlag = "logging";
	String loginSuccessfully="loginSuccessfully";
	String accountDoesNotExist="accountDoesNotExist";
	String wrongPassword="wrongPassword";
	
	String uploadFlag="upload";
	String downloadFlag="download";
	
	String createAccount="createAccount";
	boolean isAccountExistsFlag=false;
	String createSuccessfully="createSuccessfully";
	String createFailed="createFailed";
	
	boolean isAccountExists(String account);
	String createAccount(String account,String password);
	String logging(String account,String password);
	String upload(String account);
	String download(String account);
}
