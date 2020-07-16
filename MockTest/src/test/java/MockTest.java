import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.log4j.Logger;
import org.hamcrest.Matcher;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.runners.MockitoJUnit44Runner;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(value = MockitoJUnitRunner.class)
public class MockTest {

    @Mock
    MockObj mockObj;

    MockObj nullObj;

    @Test
    public void mockTest(){

        assertNotNull(mockObj);
        assertThat(nullObj, nullValue());
        assertNull(nullObj);

    }
}
