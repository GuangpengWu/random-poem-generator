import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * InvalidFileException Test
 * @ author Guangpeng & Jiawen
 */
public class InvalidFileExceptionTest {

  private Exception invalidFileExceptionTest;

  /**
   * set up the Exception
   * @throws Exception when invalid creation
   */
  @Before
  public void setUp() throws Exception {
    invalidFileExceptionTest=new InvalidFileException("InvalidFileExceptionTest");

  }

  /**
   * test getMessage
   */
  @Test
  public void getMessage(){
    Assert.assertEquals("InvalidFileExceptionTest",invalidFileExceptionTest.getMessage());
  }
}
