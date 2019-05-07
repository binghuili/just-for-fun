import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author libinghui
 * @date 2018/4/10 18:22
 */
public class test3 {

    @Test
    public void test() {
        char x = 'x';
        int i = 10;
        System.out.println(false ? i : x);
        System.out.println(false ? 100 : x);
        System.out.println(true ? 100 : x);
    }

    @Test
    public void test1() {
        String e = "org.apache.catalina.connector.ClientAbortException: java.io.IOException: Connection reset by peer";
        System.out.println(e.substring(e.substring(0, e.indexOf(":")).lastIndexOf(".") + 1, e.indexOf(":")));
    }

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.remove("2");
        System.out.println(list.get(1)); //3

        List<String> list1 = new LinkedList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.remove("2");
        System.out.println(list1.get(1));
    }

    @Test
    public void test3() {
        try {
            int n = 0;
            int m = 3;
            int i = m / n;
        }catch (Exception e){
            if(e.toString().contains("ArithmeticException")){
                System.out.println("hello");
            }else{
                System.out.println("hello-world");
            }
        }
    }

    @Test
    public void test4() {
        StringBuilder ele = new StringBuilder();
        for(int i=0;i<10;i++){
            ele.append("hello").append(i);
        }
        System.out.println(ele.toString());
    }


}
