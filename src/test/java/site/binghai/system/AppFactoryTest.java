package site.binghai.system;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by binghai on 2017/8/17.
 *
 * @ MoGuJie
 */
public class AppFactoryTest {
    @Test
    public void getAppByName() throws Exception {
        AppFactory.getAppByName("a");
    }

}