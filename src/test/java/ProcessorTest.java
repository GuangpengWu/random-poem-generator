import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Processor Test
 * @ author Guangpeng & Jiawen
 */
public class ProcessorTest {

  private Processor processor;

  private GrammarContent grammarContent;
  private GrammarContent grammarContent2;

  private NonTerminalNode nonTerminalNode;
  private String definition;
  private ArrayList<String> productions;
  private ArrayList<String> start;

  private RandomGenerator randomGenerator;

  private Parser parser;
  private HashMap<String,ArrayList<String>> map;

  /**
   * set up the Processor
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

    randomGenerator=new RandomGenerator(0);

    start=new ArrayList<>();
    start.add("<mapKey>");

    grammarContent2=new GrammarContent("title","description",start,hashmap);
  }

  /**
   * test process
   */
  @Test
  public void process() {
    try {
      processor.process(grammarContent,randomGenerator);
    } catch (NonTerminalNotFoundException e) {
      e.printStackTrace();
    }

  }

  /**
   * test process2
   */
  @Test
  public void process2() {
    try {
      processor.process(grammarContent2,randomGenerator);
    } catch (NonTerminalNotFoundException e) {
      e.printStackTrace();
    }

  }

}
