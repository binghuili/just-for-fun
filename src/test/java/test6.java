import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author libinghui
 * @date 2018/6/26 8:17
 */
public class test6 {
    int[] a = new int[10];
    //private int[2]  a;
    private int i;

    @Test
    public void test99() {
        for (i = 0; i < 10; i++) {
            a[i] = 0;
            System.out.println(a[i]);
        }
    }

    @Test
    public void test881() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("2".equals(item)) {
                iterator.remove();
            }
        }
        for(String item : list){
            System.out.println(item);
        }
//        while (iterator.hasNext()) {
//            String item = iterator.next();
//            System.out.println(item);
//        }
        Iterator<String> iterator2 = list.iterator();
                while (iterator2.hasNext()) {
            String item = iterator2.next();
            System.out.println(item);
        }
    }

    @Test
    public void test882() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        for (String item : list) {
            if ("6".equals(item)) {
                list.remove(item);
            }
        }
        for(String item : list){
            System.out.println(item);
        }
    }

}
