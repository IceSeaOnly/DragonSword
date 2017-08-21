package site.binghai.app;

import org.junit.Test;
import site.binghai.system.Param;

import static org.junit.Assert.*;

/**
 * Created by binghai on 2017/8/21.
 *
 * @ MoGuJie
 */
public class TimeStampGeneratorTest {
    @Test
    public void invokeFunction() throws Exception {
        String[] p = new String[]{"ts","-f","yyyy-MM-dd","-t","2017-1-1","-s"};
        Param param = new Param(p);
        new TimeStampGenerator().invokeFunction(param);
    }

}