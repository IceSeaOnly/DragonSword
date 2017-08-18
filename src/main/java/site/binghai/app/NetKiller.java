package site.binghai.app;

import org.springframework.util.Assert;
import site.binghai.system.Param;
import site.binghai.utils.HttpUtil;
import site.binghai.utils.StringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static site.binghai.system.Core.msgOut;

/**
 * Created by binghai on 2017/8/18.
 *
 * @ MoGuJie
 */
public class NetKiller implements Apps {
    @Override
    public void invokeFunction(Param param) {
        if (param.hasKey("-o")) {
            Assert.notNull(param.getVal("-f"), "-o 同时需要 -f 需要指定file地址");
            byFileUrls(param.getVal("-f"), StringUtils.getInt(param.getVal("-r"), 1));
        } else {
            String baseUrl = param.getVal("-u");
            Assert.notNull(baseUrl, "需要 -u 指定url");
            if (param.hasKey("-f")) {
                joinUrl(baseUrl,param.getVal("-f"),StringUtils.getInt(param.getVal("-r"), 1));
            } else {
                byUrl(baseUrl,StringUtils.getInt(param.getVal("-r"), 1));
            }
        }
    }

    private void joinUrl(String baseUrl, String filePath, int repeat) {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileInputStream(filePath));
            int line = 0;
            while (sc.hasNextLine()){
                byJoinUrl(line++,baseUrl,sc.nextLine(),repeat);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            sc.close();
        }
    }

    private void byJoinUrl(int line,String baseUrl, String param, int repeat) {
        String[] params = param.split(" ");
        if(params.length > 0){
            for(String hold : params){
                baseUrl = baseUrl.replaceFirst("<?>",hold);
            }
        }else{
            msgOut(String.format("第%s行没有参数",line));
        }
        byUrl(baseUrl,repeat);
    }

    private void byUrl(String url, int repeat) {
        while (repeat-- > 0) {
            msgOut(HttpUtil.sendGet(url));
        }
    }

    public void byFileUrls(String file, int repeat) {
        Scanner sc = null;
        try {
            InputStream is = new FileInputStream(file);
            sc = new Scanner(is);
            while (sc.hasNextLine()) {
                byUrl(sc.nextLine(), repeat);
            }
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }

    @Override
    public String[] getName() {
        return new String[]{"netkiller", "nk", "NetKiller", "netkill"};
    }

    @Override
    public void help() {
        msgOut("网络自动发生器,目前仅支持GET，应用名：netkiller,nk,NetKiller,netkill,参数：");
        msgOut(" -f fileName 指定参数文件名,每行参数以空格分隔,与url中的待替换参数列对应");
        msgOut(" -u url 设置url，<?>作占位符被文件内的参数替换,例如http://binghai.site?username=<?>&age=<?>");
        msgOut(" -r 10 重复10次");
        msgOut(" -o fileName 直接访问文本文件内的每个url");
    }
}
