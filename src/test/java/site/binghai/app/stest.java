package site.binghai.app;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static jdk.nashorn.internal.ir.debug.ObjectSizeCalculator.getObjectSize;

/**
 * Created by binghai on 2017/8/20.
 *
 * @ MoGuJie
 */
public class stest {
    static int pick(int[] peaches) {
        output(peaches);
        int n = peaches.length;
        int[] len = new int[n];
        int i, j;
        int maxlen = 0;
        //计算以第i个数为结尾的最长上升子序列的长度
        for (i = 0; i < n; i++) {
            len[i] = 0;
            //从前i-1个数中找出满足a[j]<a[i]（1<=j<i）条件的最大的L[j]
            for (j = i - 1; j >= 0; j--) {
                if (peaches[j] < peaches[i] && len[j] > len[i]) {
                    len[i] = len[j];
                }
            }
            len[i]++;
            if (len[i] > maxlen) {
                maxlen = len[i];
            }
            output(len);
        }
        return maxlen;
    }

    private static void output(int[] len) {
        for (int i:len) System.out.print(i+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int i = 1276615;
        while (i < 1286615){
            System.out.println(i++);
        }
    }
}
