package init;


/**
 * Created by Kevin on 2014/8/6.
 */
public class Test {
    public static void main(String[] args) {
     /*   int i = 0;
        int[] result = new int[2];
        int strsmash = 0;
        long start = System.currentTimeMillis();
        while (result[1] <3) {
            smash a = new smash();
            strsmash = a.getmash();
            i++;
            result = a.findnumber(1234);
            //System.out.println("result: "+result[0] + "  " + result[1]);
        }
        long end = System.currentTimeMillis();
        System.out.println("SMASH: " + strsmash);
        System.out.println("循此次数: " + i+"  耗时"+(end-start)/1000f+"秒");
*/
        for(int tt=0;tt<10;tt++) {
            smash targetsmash = new smash();
            int target = targetsmash.getmash();

            System.out.println("要猜的数字是：" + target);
            int i = 0;
            int[] firstresult = new int[2];
            int  firststrsmash = 0;
            long start = System.currentTimeMillis();
            while(firstresult[1]<3) {
                smash a = new smash();
                firststrsmash = a.getmash();
                firstresult = targetsmash.findnumber(firststrsmash);

                i++;
            }
            long end = System.currentTimeMillis();
            System.out.println("循环了"+ i +"次，耗时"+(end-start)/1000f+"秒。目前猜到的数字是："+firststrsmash);

            String second = String.valueOf(firststrsmash);
            int intsecond = Integer.parseInt(second);

            int result = intsecond;
            String secondtemp;
            int intssecondtemp;

            int[] secondresult = new int[2];

            int c=0;
            int n=1;


            for(c=0;c<4;c++) {

                for(n=1;n<10;n++) {
                    secondtemp = second.substring(0,c) + n + second.substring(c+1);
                    intssecondtemp = Integer.parseInt(secondtemp);
                    secondresult = targetsmash.findnumber(intssecondtemp);
                    if(secondresult[1]==4) {
                        result = intssecondtemp;
                    }

                }
            }

            start = System.currentTimeMillis();
            System.out.println("循环了"+ n*c +"次，耗时"+(start-end)/1000f+"秒。目前猜到的数字是："+result);
            // System.out.println(result);

        }

    }
}
