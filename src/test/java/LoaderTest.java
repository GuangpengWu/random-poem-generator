import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Loader Test
 * @ author Guangpeng & Jiawen
 */
public class LoaderTest {

  private Loader loader;

  private AllGrammars allGrammars;
  private AllGrammars allGrammars2;
  private ArrayList<GrammarContent> grammarContentArrayList;
  private GrammarContent grammarContent;
  private NonTerminalNode nonTerminalNode;
  private String definition;
  private ArrayList<String> productions;
  private ArrayList<String> start;

  /**
   * set up the Loader
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

    grammarContentArrayList=new ArrayList<>();
    grammarContentArrayList.add(grammarContent);

    allGrammars=new AllGrammars(grammarContentArrayList);
    allGrammars2=new AllGrammars();

    loader=new Loader();
  }

  /**
   * test load
   */
  @Test
  public void load() {

    try {
      loader.load("input");
    } catch ( Exception e) {
      e.printStackTrace();
    }

  }
}
