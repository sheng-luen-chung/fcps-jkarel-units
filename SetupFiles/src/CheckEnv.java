// 環境檢查工具:在任何機器上 Run 這個檔,立刻知道 Eclipse「實際」用哪個 JDK/JRE 在執行。
// 印出來的 java.version / java.home 是執行當下的真相,比任何設定畫面都可靠。
public class CheckEnv {
	public static void main(String[] args) {
		System.out.println("java.version  = " + System.getProperty("java.version"));
		System.out.println("java.vendor   = " + System.getProperty("java.vendor"));
		System.out.println("java.home     = " + System.getProperty("java.home"));
		System.out.println("file.encoding = " + System.getProperty("file.encoding"));
		System.out.println("user.dir      = " + System.getProperty("user.dir"));
		System.out.println("os.name       = " + System.getProperty("os.name"));
		System.out.println("中文測試:如果這行是亂碼,代表 console 編碼有問題");
	}
}
