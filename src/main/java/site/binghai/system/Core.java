package site.binghai.system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by binghai on 2017/8/17.
 *
 * @ MoGuJie
 */
public class Core {
    public static void shwoBanner() {
        String fpath = getResourcePath("/banner.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(new FileInputStream(fpath));
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

    public static void msgOut(String msg){
        System.out.println(msg);
    }

    public static String getResourcePath(String sname){
        return Core.class.getResource(sname.startsWith("/") ? sname : "/"+sname).getPath();
    }
}
