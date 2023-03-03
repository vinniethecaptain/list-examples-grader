import static org.junit.Assert.*;
import org.junit.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMoon() {
    List<String> correctVariedList = Arrays.asList("moon", "moon", "moon");
    List<String> fullVariedList = Arrays.asList("start", "early", "moon", "often", "moon", "moon");
    assertEquals(correctVariedList, ListExamples.filter(fullVariedList, new IsMoon()));

    List<String> correctMoonList = Arrays.asList("moon", "moon", "moon");
    List<String> fullMoonList = Arrays.asList("moon", "moon", "moon");
    assertEquals(correctMoonList, ListExamples.filter(fullMoonList, new IsMoon()));

    List<String> correctNoMoonList = Arrays.asList();
    List<String> fullNoMoonList = Arrays.asList("sun", "star", "blackhole");
    assertEquals(correctNoMoonList, ListExamples.filter(fullNoMoonList, new IsMoon()));
  }
}
