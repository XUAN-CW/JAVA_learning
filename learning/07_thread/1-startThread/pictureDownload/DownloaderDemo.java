package pictureDownload;

public class DownloaderDemo extends Thread {
	private String url;		//Զ��·��
	private String name;	//�洢����
	
	public DownloaderDemo(String url, String name) {
		this.url = url; 
		this.name = name;
	}

	@Override
	public void run() {
		WebDownloader wd =new WebDownloader();
		wd.download(url, name);		
		System.out.println(name);	//�ɴ˹�֮��û���Ⱥ�˳�򣬶����м��οɼ�
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		DownloaderDemo td1 =new DownloaderDemo("http://p1.pstatp.com/large/403c00037462ae2eee13","spl.jpg");
		DownloaderDemo td2 =new DownloaderDemo("http://5b0988e595225.cdn.sohucs.com/images/20170830/d8b57e0dce0d4fa29bd5ef014be663d5.jpeg","success.jpg");
		
		//���������̣߳�û���Ⱥ�˳�򣬶����м��οɼ�
		td1.start();
		td2.start();
	}
}
