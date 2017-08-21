package site.binghai;

import site.binghai.app.Apps;
import site.binghai.system.AppFactory;
import site.binghai.system.Param;
import site.binghai.utils.StringUtils;

import static site.binghai.system.Core.msgOut;
import static site.binghai.system.Core.shwoBanner;

//@SpringBootApplication
public class DragonSwordApplication {

    public static void main(String[] args) {
        if (args.length < 1) {
            shwoBanner();
            msgOut("没有输入任何命令");
            return;
        }
        Param param = new Param(args);
        if(StringUtils.valIn(args[0],"ls","all","list","listall","-h")){
            AppFactory.listAll();
            return;
        }
        Apps app = AppFactory.getAppByName(args[0]);
        if (app == null) {
            msgOut("这个应用不存在");
        } else {
            if (param.needHelp()) {
                app.help();
            } else {
                app.invokeFunction(param);
            }
        }
    }


}
