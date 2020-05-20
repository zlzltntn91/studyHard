package tobySpring;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

public class JUnitTest {
    public static JUnitTest testObject;

    @Test
    public void test1(){
        assertThat(this, is(sameInstance(testObject)));
    }

}
