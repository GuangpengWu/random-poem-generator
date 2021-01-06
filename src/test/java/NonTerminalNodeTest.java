import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * NonTerminalNode Test
 * @ author Guangpeng & Jiawen
 */
public class NonTerminalNodeTest {

  private NonTerminalNode nonTerminalNode;
  private String definition;
  private ArrayList<String> productions;

  /**
   * set up the NonTerminalNode
   * @throws Exception when invalid creation
   */
  @Before
  public void setUp() throws Exception {

    definition="definition";

    productions=new ArrayList<>();

    productions.add("production1");
    productions.add("production2");

    nonTerminalNode=new NonTerminalNode(definition,productions);

  }

  /**
   * test getDefinition
   */
  @Test
  public void getDefinition() {
    Assert.assertEquals("definition",nonTerminalNode.getDefinition());
  }

  /**
   * test getProductions
   */
  @Test
  public void getProductions() {

    Assert.assertEquals("production1",nonTerminalNode.getProductions().get(0));
    Assert.assertEquals("production2",nonTerminalNode.getProductions().get(1));
  }

  /**
   * test getProductionNumber
   */
  @Test
  public void getProductionNumber() {
    Assert.assertEquals(2,nonTerminalNode.getProductionNumber());
  }

  /**
   * test getProduction
   */
  @Test
  public void getProduction() {
    Assert.assertEquals("production1",nonTerminalNode.getProduction(0));
    Assert.assertEquals("production2",nonTerminalNode.getProduction(1));
  }

  /**
   * test toString
   */
  @Test
  public void testToString() {
    Assert.assertEquals("{definition: [production1, production2]}",nonTerminalNode.toString());
  }
}
