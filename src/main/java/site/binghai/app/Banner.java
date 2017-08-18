package site.binghai.app;

import site.binghai.system.Core;
import site.binghai.system.Param;

import static site.binghai.system.Core.msgOut;


/**
 * Created by binghai on 2017/8/18.
 *
 * @ MoGuJie
 */
public class Banner implements Apps {
    @Override
    public void invokeFunction(Param args) {
        Core.shwoBanner();
    }

    @Override
    public String[] getName() {
        return new String[]{"banner","Banner"};
    }

    @Override
    public void help() {
        msgOut("输出banner，无需参数输入");
    }
}
