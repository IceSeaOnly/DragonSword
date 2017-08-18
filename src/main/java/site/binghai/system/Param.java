package site.binghai.system;

import java.util.HashMap;

/**
 * Created by binghai on 2017/8/18.
 *
 * @ MoGuJie
 */
public class Param {
    private String appName;
    private HashMap<String, String> kv;
    private String[] args;

    public Param(String[] args) {
        this.args = args;
        this.appName = args[0];
        this.kv = new HashMap<>();
        for (int i = 1; i < args.length; ) {
            if (args[i].startsWith("-") && i + 1 < args.length && !args[i + 1].startsWith("-")) {
                kv.put(args[i], args[i + 1]);
                i += 2;
            } else {
                kv.put(args[i], "true");
                i++;
            }
        }
    }


    public boolean hasKey(String k) {
        return kv.containsKey(k);
    }

    public String getVal(String k){
        return kv.get(k);
    }

    public String getAppName() {
        return appName;
    }

    public String[] getArgs() {
        return args;
    }

    public boolean needHelp() {
        for (String arg : args) {
            if (arg.toLowerCase().equals("-h") || arg.toLowerCase().equals("-help")) {
                return true;
            }
        }
        return false;
    }

    public String getValByIndex(int index){
        return index < args.length ? args[index] : null;
    }

    public int getArgSize(){
        return args.length;
    }
}
