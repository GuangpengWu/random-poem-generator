import java.util.Random;

/**
 * Generate random number with seed set
 */
public class RandomGenerator {
  private final Random random;

  public RandomGenerator(int seed){
    this.random = new Random(seed);
  }

  /**
   * Get random number not exceed productions index
   * @param scale productions numbers in a definition
   * @return absolute value as position index
   */
  public int getRandomNumber(int scale){
    return Math.abs(random.nextInt() % scale);
  }
}
