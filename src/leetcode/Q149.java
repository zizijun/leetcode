package leetcode;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by jinchuyang on 2018/4/23.
 */
public class Q149 {
    public static void main(String[] args) {
        //[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
        Point p1 = new Point(3, 1);
        Point p2 = new Point(3,1);
        Point p3 = new Point(12,3);
        Point p4 = new Point(-6,-1);
        Point p5 = new Point(2,3);
        Point p6 = new Point(1,4);
        Point[] points = {p1,p2,p3,p4};
        System.out.println(maxPoints(points));
    }
    public static int maxPoints(Point[] points) {
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < points.length; i++){
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            int howManyCur = 1, maxLocal = 0;
            for(int j = i + 1; j < points.length; j++){
                if(points[i].y == points[j].y && points[i].x == points[j].x){
                    howManyCur++;
                }else {          //不同顶点
                    String key = getSlopeInString(points[i], points[j]);
                    //map里存(过cur点,斜率key)代表的直线有多少除了cur的点
                    map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
                    maxLocal = Math.max(maxLocal, map.get(key));
                }

            }
            maxLocal = howManyCur + maxLocal;
            ans = Math.max(maxLocal, ans);
        }

        return ans;
    }

    public static String getSlopeInString(Point cur, Point iter) {
        int numerator = iter.y - cur.y;
        int denominator = iter.x - cur.x;
        String sign = getSign(numerator, denominator);
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));//0和任意一个非零数'a'的gcd为'a',0和0的gcd为0,所以斜率为无穷的情况分母为0
        return sign + Math.abs(numerator)/gcd + "/" + Math.abs(denominator)/gcd;
    }
    //a和b为非负整数 且 a和b不同时为0
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    private static String getSign(int numerator, int denominator) {
        return (numerator >= 0 && denominator >= 0) || (numerator <= 0 && denominator <= 0) ? "+" : "-";
    }

    static class Base{
        Double k;
        Double b;
        Base(){k = 0d; b = 0d;}
        Base(Double K, Double B){k = K; b = B;}


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Base base = (Base) o;

            if (k != null ? !k.equals(base.k) : base.k != null) return false;
            return b != null ? b.equals(base.b) : base.b == null;
        }

        @Override
        public int hashCode() {
            int result = k != null ? k.hashCode() : 0;
            result = 31 * result + (b != null ? b.hashCode() : 0);
            return result;
        }
    }
}
