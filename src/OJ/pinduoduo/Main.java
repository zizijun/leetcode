package pinduoduo;

import java.util.Scanner;

/**
 * Created by jinchuyang on 2018/4/3.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int hour = Integer.parseInt(input.split(":")[0]);
        int minute = Integer.parseInt(input.split(":")[1]);
        hour = hour % 12;
        if(minute % 2 == 0){
            int degree1 = (int)((hour + minute / 60.0) * 30);
            int degree2 = minute * 6;
            int diff = Math.abs(degree1 - degree2) > 180 ? 360 - Math.abs(degree1 - degree2): Math.abs(degree1 - degree2);
            System.out.println(diff);
        }else {
            double degree1 = (hour + minute / 60.0) * 30;
            double degree2 = minute * 6;
            double diff = Math.abs(degree1 - degree2) > 180 ? 360 - Math.abs(degree1 - degree2): Math.abs(degree1 - degree2);
            System.out.println((int)(diff * 10) / 10.0);
        }


    }
}
