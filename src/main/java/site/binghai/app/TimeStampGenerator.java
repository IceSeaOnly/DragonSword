package site.binghai.app;

import site.binghai.system.Param;
import site.binghai.utils.StringUtils;
import site.binghai.utils.TimeUtil;

import java.util.Date;

import static site.binghai.system.Core.msgOut;

/**
 * Created by binghai on 2017/8/21.
 *
 * @ MoGuJie
 */
public class TimeStampGenerator implements Apps {
    @Override
    public void invokeFunction(Param param) {
        String curDate = (String) StringUtils.getVal(param.getVal("-t"), TimeUtil.format(System.currentTimeMillis()));
        String formater = (String) StringUtils.getVal(param.getVal("-f"), "yyyy-MM-dd hh:mm:ss");
        Long curTS = TimeUtil.formatByFormatter(curDate, formater);
        if(param.hasKey("-f") && !param.hasKey("-t")) {
            msgOut(TimeUtil.format2String(curTS,param.getVal("-f")));
        }else{
            msgOut(param.hasKey("-s") ? curTS / 1000 : curTS);
        }
    }

    @Override
    public String[] getName() {
        return new String[]{"timestamp", "ts", "tsg"};
    }

    @Override
    public void help() {
        msgOut("时间戳产生器");
        msgOut(" 无参数传入时，打印当前时间戳");
        msgOut(" -s，打印当前短时间戳，及时间戳/1000");
        msgOut(" -t，传入时间，默认格式2016-01-01 00:00:00,其他格式必须使用-f指明");
        msgOut(" -f，传入时间格式，例如yyyy-MM-dd hh:mm:ss");
        msgOut(" 有-f无-t时按-f格式输出时间");
    }
}
