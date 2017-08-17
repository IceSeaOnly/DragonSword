package site.binghai;
import site.binghai.app.JsonComparator;

import static site.binghai.system.Core.msgOut;
import static site.binghai.system.Core.shwoBanner;

//@SpringBootApplication
public class DragonSwordApplication {

	public static void main(String[] args) {
		if(args.length < 1){
			shwoBanner();
			msgOut("没有输入任何命令");
		}
		new JsonComparator().invokeFunction(args);
	}
}
