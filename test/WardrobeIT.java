import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;
public class WardrobeIT {
    @Test
    public void with_unspecified_arguments() {
        Comparable c = mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);
        Assert.assertEquals(-1, c.compareTo(5));
    }
}
