import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author libinghui
 * @date 2018/3/27 21:44
 */
public class test2 {
    private static Logger logger = LoggerFactory.getLogger(test2.class);
    private ExecutorService pool = null;

    @Test
    public void test22() {
        for (int i = 0; i < 100; i++) {
            test21("1");
        }
    }

    private void test21(String i) {
        pool.submit(() -> {
            System.out.println(i);
        });
    }

    @PostConstruct
    public void init() throws Exception {
        pool = Executors.newFixedThreadPool(5);
    }

    @PreDestroy
    public void destroy() throws Exception {
        pool.shutdown();
    }
}
