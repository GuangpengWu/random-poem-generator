import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * RandomGenerator Test
 * @ author Guangpeng & Jiawen
 */
public class RandomGeneratorTest {

  private RandomGenerator randomGenerator;

  /**
   * set up the RandomGenerator
   * @throws Exception when invalid creation
   */
  @Before
  public void setUp() throws Exception {
    randomGenerator=new RandomGenerator(0);
  }

  /**
   * test getRandomNumber
   */
  @Test
  public void getRandomNumber() {
    Assert.assertEquals(6,randomGenerator.getRandomNumber(10));
  }
}
