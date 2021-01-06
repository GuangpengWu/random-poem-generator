import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * GrammarContent Test
 * @ author Guangpeng & Jiawen
 */
public class GrammarContentTest {

  private GrammarContent grammarContent;
  private NonTerminalNode nonTerminalNode;
  private String definition;
  private ArrayList<String> productions;
  private ArrayList<String> start;

  private GrammarContent grammarContent2;

  /**
   * set up the GrammarContent
   * @throws Exception when invalid creation
   */
  @Before
  public void setUp() throws Exception {
    definition="definition";

    productions=new ArrayList<>();

    productions.add("production1");
    productions.add("production2");

    nonTerminalNode=new NonTerminalNode(definition,productions);
    HashMap<String, NonTerminalNode> hashmap=new HashMap<>();
    hashmap.put("mapKey",nonTerminalNode);

    start=new ArrayList<>();
    start.add("start");

    grammarContent=new GrammarContent("title","description",start,hashmap);

    grammarContent2=new GrammarContent("title2","",start,hashmap);
  }

  /**
   * test noDescription
   */
  @Test
  public void noDescription() {
    Assert.assertFalse(grammarContent.noDescription());
  }

  /**
   * test getTitle
   */
  @Test
  public void getTitle() {
    Assert.assertEquals("title",grammarContent.getTitle());
  }

  /**
   * test getDescription
   */
  @Test
  public void getDescription() {
    Assert.assertEquals("description",grammarContent.getDescription());
  }

  /**
   * test getStart
   */
  @Test
  public void getStart() {
    Assert.assertEquals("start",grammarContent.getStart().get(0));
  }

  /**
   * test getNodes
   */
  @Test
  public void getNodes() {
    Assert.assertTrue(grammarContent.getNodes().containsKey("mapKey"));
  }

  /**
   * test getTitleWithDesc
   */
  @Test
  public void getTitleWithDesc() {
    Assert.assertEquals("title: description",grammarContent.getTitleWithDesc());
    Assert.assertEquals("title2",grammarContent2.getTitleWithDesc());
  }

  /**
   * test containNode
   */
  @Test
  public void containNode() {

    Assert.assertTrue(grammarContent.containNode("mapKey"));
  }

  /**
   * test getNode
   */
  @Test
  public void getNode() {

    Assert.assertEquals("definition",grammarContent.getNode("mapKey").getDefinition());
    Assert.assertEquals("production1",grammarContent.getNode("mapKey").getProduction(0));
    Assert.assertEquals("production2",grammarContent.getNode("mapKey").getProduction(1));
  }

  /**
   * test toString
   */
  @Test
  public void testToString() {
    Assert.assertEquals("{ grammarTitle: title,\n" +
        "description: description,\n" +
        "start: [start],\n" +
        "{mapKey={definition: [production1, production2]}}}\n",grammarContent.toString());

    Assert.assertEquals("{ grammarTitle: title2,\n" +
        "start: [start],\n" +
        "{mapKey={definition: [production1, production2]}}}\n",grammarContent2.toString());
  }
}
