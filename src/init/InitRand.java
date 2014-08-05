package init;

import java.util.ArrayList;

/**
 * Created by XingKaiXin on 2014/8/5.
 */
public class InitRand {

    public int randint;


    public InitRand(int max) {
        int min = 0;

        randint = (int) (Math.random()*(max - min) + min);
    }

    public ArrayList<Integer> createBasic() {
        ArrayList<Integer> basicint = new ArrayList<Integer>();
        for(int i=0;i<9; i++) {
            basicint.add(i+1);
        }
        return basicint;
    }

    public static void main(String[] args) {

        for(int i=0;i<10;i++) {
            smash smash1 = new smash();
            System.out.println(smash1.getmash());
        }




    }
}
