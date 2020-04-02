package pictureDownload;

public class DownloaderDemo extends Thread {
	private String url;		//远程路径
	private String name;	//存储名字
	
	public DownloaderDemo(String url, String name) {
		this.url = url; 
		this.name = name;
	}

	@Override
	public void run() {
		WebDownloader wd =new WebDownloader();
		wd.download(url, name);		
		System.out.println(name);	//由此观之，没有先后顺序，多运行几次可见
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		DownloaderDemo td1 =new DownloaderDemo("http://p1.pstatp.com/large/403c00037462ae2eee13","spl.jpg");
		DownloaderDemo td2 =new DownloaderDemo("http://5b0988e595225.cdn.sohucs.com/images/20170830/d8b57e0dce0d4fa29bd5ef014be663d5.jpeg","success.jpg");
		
		//启动两个线程，没有先后顺序，多运行几次可见
		td1.start();
		td2.start();
	}
}
