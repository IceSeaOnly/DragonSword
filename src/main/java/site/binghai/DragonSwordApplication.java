package site.binghai;

import site.binghai.app.Apps;
import site.binghai.system.AppFactory;
import static site.binghai.system.Core.msgOut;
import static site.binghai.system.Core.shwoBanner;

//@SpringBootApplication
public class DragonSwordApplication {

    public static void main(String[] args) {
        if (args.length < 1) {
            shwoBanner();
            msgOut("没有输入任何命令");
        }
        Apps app = AppFactory.getAppByName(args[0]);
        if (app == null) {
            msgOut("这个应用不存在");
        } else {
            if (needHelp(args)) {
                app.help();
            } else {
                app.invokeFunction(args);
            }
        }
    }

    private static boolean needHelp(String[] args) {
        for (String arg : args) {
            if (arg.toLowerCase().equals("-h") || arg.toLowerCase().equals("-help")) {
                return true;
            }
        }
        return false;
    }
}
