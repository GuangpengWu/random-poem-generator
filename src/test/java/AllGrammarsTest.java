import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * AllGrammars Test
 * @ author Guangpeng & Jiawen
 */
public class AllGrammarsTest {

  private AllGrammars allGrammars;
  private AllGrammars allGrammars2;
  private ArrayList<GrammarContent> grammarContentArrayList;
  private GrammarContent grammarContent;
  private NonTerminalNode nonTerminalNode;
  private String definition;
  private ArrayList<String> productions;
  private ArrayList<String> start;

  /**
   * set up the AllGrammars
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

  }

  /**
   * test addGrammarContent
   */
  @Test
  public void addGrammarContent() {
    definition="definition";

    productions=new ArrayList<>();

    productions.add("production1");
    productions.add("production2");

    nonTerminalNode=new NonTerminalNode(definition,productions);
    HashMap<String, NonTerminalNode> hashmap=new HashMap<>();
    hashmap.put("mapKey",nonTerminalNode);
    allGrammars.addGrammarContent(new GrammarContent("title2","description2",start,hashmap));

    Assert.assertEquals("title2",allGrammars.getGrammar(1).getTitle());
  }

  /**
   * test getGrammars
   */
  @Test
  public void getGrammars() {
    definition="definition";

    productions=new ArrayList<>();

    productions.add("production1");
    productions.add("production2");

    nonTerminalNode=new NonTerminalNode(definition,productions);
    HashMap<String, NonTerminalNode> hashmap=new HashMap<>();
    hashmap.put("mapKey",nonTerminalNode);
    allGrammars.addGrammarContent(new GrammarContent("title2","description2",start,hashmap));

    Assert.assertEquals("title2",allGrammars.getGrammars().get(1).getTitle());
  }

  /**
   * test getGrammar
   */
  @Test
  public void getGrammar() {


    Assert.assertEquals("title",allGrammars.getGrammar(0).getTitle());
  }

  /**
   * test toString
   */
  @Test
  public void testToString() {

    Assert.assertEquals("[{ grammarTitle: title,\n" +
        "description: description,\n" +
        "start: [start],\n" +
        "{mapKey={definition: [production1, production2]}}}\n" +
        "]",allGrammars.toString());

  }
}
