import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * InvalidDirectoryException Test
 * @ author Guangpeng & Jiawen
 */
public class InvalidDirectoryExceptionTest {

  private Exception invalidDirectoryException;

  /**
   * set up the Exception
   * @throws Exception when invalid creation
   */
  @Before
  public void setUp() throws Exception {
    invalidDirectoryException=new InvalidDirectoryException("InvalidDirectoryException");
  }

  /**
   * test getMessage
   */
  @Test
  public void getMessage(){
    Assert.assertEquals("InvalidDirectoryException",invalidDirectoryException.getMessage());
  }
}
