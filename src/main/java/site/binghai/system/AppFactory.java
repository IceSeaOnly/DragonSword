package site.binghai.system;

import site.binghai.app.Apps;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by binghai on 2017/8/17.
 *
 * @ MoGuJie
 */
public class AppFactory {
    private static HashMap<String,Apps> appPool = new HashMap<>();
    static {
        List<String> classNames = listClasses();
        classNames.stream().forEach(v->instanceClass(v.substring(0,v.length()-6)));
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
        String rootPath = Core.getResourcePath("/site/binghai/app/");
        List<String> rs = Arrays.asList(new File(rootPath).list());
        return rs;
    }

    public static Apps getAppByName(String appName){
        return appPool.get(appName);
    }
}
