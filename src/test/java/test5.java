import org.junit.Test;

/**
 * @author libinghui
 * @date 2018/6/4 16:43
 */
public class test5 {

    int tally = 0;

    @Test
    public void test1(){
        System.out.println(test2(null));
    }
    public Object test2(String s){
        // todo
         //String p = s.split("-");
        return "string";
    }

    class Thread1 extends Thread {

        @Override
        public void run() { // 这个线程绝对是线程的入口方法
            ThreadProc();
        }
    }
    class Thread2 extends Thread {

        @Override
        public void run() { // 这个线程绝对是线程的入口方法
            ThreadProc();
        }
    }

    public void ThreadProc(){
        for(int i = 1; i <= 50; i++)
            tally += 1;
    }


}
