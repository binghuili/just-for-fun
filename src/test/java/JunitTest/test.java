package JunitTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @author libinghui
 * @date 2018/4/10 18:46
 */
@RunWith(value = Parameterized.class)
public class test {

    private int a;
    private int b;
    private int c;

    public test(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Parameterized.Parameters
    public static Collection<Integer[]> getParameters() {
        return Arrays.asList(new Integer[][]{
                {6, 2, 3},
                {8, 2, 4},
                {10, 2, 5},
        });
    }

    @Test
    public void test11() {
        assertEquals(a, b * c);
    }

}
