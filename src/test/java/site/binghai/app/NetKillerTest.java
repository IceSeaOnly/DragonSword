package site.binghai.app;

import org.junit.Test;
import site.binghai.system.Param;

import static org.junit.Assert.*;

/**
 * Created by binghai on 2017/8/18.
 *
 * @ MoGuJie
 */
public class NetKillerTest {
    @Test
    public void invokeFunction() throws Exception {
        String[] p = new String[]{"netkill","-u","http://www.binghai.site","-r","10"};
        Param param = new Param(p);
        new NetKiller().invokeFunction(param);
    }

}