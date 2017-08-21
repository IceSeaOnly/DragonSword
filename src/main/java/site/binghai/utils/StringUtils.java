package site.binghai.utils;

/**
 * Created by binghai on 2017/8/18.
 *
 * @ MoGuJie
 */
public class StringUtils {
    public static int getInt(String val,int Default){
        try{
            return Integer.valueOf(val);
        }catch (Exception e){

        }
        return Default;
    }

    public static Object getVal(Object val,Object Default){
        return val == null ? Default : val;
    }

    public static boolean valIn(String cur,String...param){
        for(String s : param){
            if(s.equals(cur)){
                return true;
            }
        }
        return false;
    }
}
