package site.binghai.system;

import site.binghai.app.Apps;
import site.binghai.utils.ClassUtils;

import java.io.File;
import java.util.*;

import static site.binghai.system.Core.msgOut;

/**
 * Created by binghai on 2017/8/17.
 *
 * @ MoGuJie
 */
public class AppFactory {
    private static HashMap<String,Apps> appPool = new HashMap<>();
    static {
        List<String> classNames = listClasses();
        classNames.stream().forEach(v->instanceClass(v));
    }

    private static void instanceClass(String v) {
        if (v.equals("Apps")){
            return;
        }
        String pkg = "site.binghai.app.";
        try {
            Class<Apps> appClazz = (Class<Apps>) Class.forName(pkg+v);
            Apps app = appClazz.newInstance();
            Arrays.stream(app.getName()).forEach(e -> appPool.put(e,app));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static List<String> listClasses() {
        return ClassUtils.classUnderPackage("site.binghai.app");
    }

    public static Apps getAppByName(String appName){
        return appPool.get(appName);
    }

    public static void listAll() {
        msgOut("应用列表：");
        int i = 1;
        for(String name : listClasses()){
            msgOut(" "+(i++)+". "+name);
        }
    }
}
