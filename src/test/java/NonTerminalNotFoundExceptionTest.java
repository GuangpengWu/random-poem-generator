import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * NonTerminalNotFoundException Test
 * @ author Guangpeng & Jiawen
 */
public class NonTerminalNotFoundExceptionTest {

  private Exception nonTerminalNotFoundException;

  /**
   * set up the Exception
   * @throws Exception when invalid creation
   */
  @Before
  public void setUp() throws Exception {
    nonTerminalNotFoundException=new NonTerminalNotFoundException("NonTerminalNotFoundException");
  }

  /**
   * test getMessage
   */
  @Test
  public void getMessage(){
    Assert.assertEquals("NonTerminalNotFoundException",nonTerminalNotFoundException.getMessage());
  }
}
