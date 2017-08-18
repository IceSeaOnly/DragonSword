package site.binghai.app;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.Assert;
import site.binghai.system.Param;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static site.binghai.system.Core.msgOut;

/**
 * Created by binghai on 2017/8/16.
 * JSON比较器
 *
 * @ MoGuJie
 */
public class JsonComparator implements Apps {

    private StringBuilder rs = new StringBuilder();

    @Override
    public void invokeFunction(Param args) {
        if (args.getArgSize() < 2) {
            msgOut("必须传入两个json文件的路径！");
        }
        File base = new File(args.getValByIndex(1));
        File cmps = new File(args.getValByIndex(2));

        JSONObject b = JSONObject.parseObject(getObjectString(base));
        JSONObject c = JSONObject.parseObject(getObjectString(cmps));

        Assert.notNull(b, args.getValByIndex(1) + "文件不存在");
        Assert.notNull(c, args.getValByIndex(2) + "文件不存在");

        b.keySet().stream().forEach(v -> cmp(v, b, c));
        msgOut(rs.toString());
    }

    @Override
    public String[] getName() {
        return new String[]{"jsonc"};
    }

    @Override
    public void help() {
        msgOut("this is help of JsonComparator");
    }

    private void cmp(String k, JSONObject b, JSONObject cmp) {
        rs.append(cmp.containsKey(k) ? (cmp.get(k).equals(b.get(k)) ? "" : k + " 对比失败 " + b.get(k) + " -> " + cmp.get(k) + "\n") : k + " 不存在\n");
    }

    private String getObjectString(File f) {
        Scanner sc = null;
        try {
            StringBuilder sb = new StringBuilder();
            sc = new Scanner(new FileInputStream(f));
            while (sc.hasNextLine()) {
                String line = DealLine(sc.nextLine().trim());
                sb.append(line);
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
        msgOut("解析" + f.getAbsolutePath() + " 时出现异常");
        return null;
    }

    private String DealLine(String ori) {
        return ori.trim();
    }
}
