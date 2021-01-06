import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * MyMatcher Test
 * @ author Guangpeng & Jiawen
 */
public class MyMatcherTest {

  private MyMatcher myMatcher;

  /**
   * set up the MyMatcher
   * @throws Exception when invalid creation
   */
  @Before
  public void setUp() throws Exception {
    myMatcher=new MyMatcher();

  }

  /**
   * test validSource
   */
  @Test
  public void validSource() throws InvalidDirectoryException {
    Assert.assertEquals("input",myMatcher.validSource("input"));

  }

  /**
   * test validSourceException1
   */
  @Test
  public void validSourceException1() throws InvalidDirectoryException {
    try {
      myMatcher.validSource("input2");
    } catch (InvalidDirectoryException e) {
      e.printStackTrace();
    }

  }

  /**
   * test validSourceException2
   */
  @Test
  public void validSourceException2() throws InvalidDirectoryException {
    try {
      myMatcher.validSource("input/sample_2.json");
    } catch (InvalidDirectoryException e) {
      e.printStackTrace();
    }

  }

  /**
   * test validJson
   */
  @Test
  public void validJson() throws InvalidFileException {
    File file=new File("input/sample_2.json");

    Assert.assertTrue(myMatcher.validJson(file));
  }

  /**
   * test validJsonException1
   */
  @Test
  public void validJsonException1() throws InvalidFileException {
    File file=new File("input");


    try {
      myMatcher.validJson(file);
    } catch (InvalidFileException e) {
      e.printStackTrace();
    }
  }

  /**
   * test validJsonException2
   */
  @Test
  public void validJsonException2() throws InvalidFileException {
    File file=new File("input/sample_3.json");


    try {
      myMatcher.validJson(file);
    } catch (InvalidFileException e) {
      e.printStackTrace();
    }
  }
}
