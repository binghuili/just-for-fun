package JunitTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.stereotype.Controller;

/**
 * @author libinghui
 * @date 2018/4/10 19:35
 */
@RunWith(value = org.junit.runners.Suite.class)
@Suite.SuiteClasses(value = test.class)
public class test1 {

    @Test
    public void test22(){
        System.out.println("1");
    }

}
