package site.binghai.system;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by binghai on 2017/8/17.
 *
 * @ MoGuJie
 */
public class Core {
    public static void shwoBanner() {
        InputStream fpath= getResourcePath("/banner.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(fpath);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } finally {
            sc.close();
        }
    }

    public static void msgOut(String msg){
        System.out.println(msg);
    }

    public static InputStream getResourcePath(String sname){
        return Core.class.getResourceAsStream(sname.startsWith("/") ? sname : "/"+sname);
    }
}
