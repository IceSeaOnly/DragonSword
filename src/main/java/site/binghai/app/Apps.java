package site.binghai.app;

import site.binghai.system.Param;

/**
 * Created by binghai on 2017/8/16.
 *
 * @ MoGuJie
 */

public interface Apps {
    void invokeFunction(Param args);
    String[] getName();
    void help();
}
