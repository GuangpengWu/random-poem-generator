import com.sun.tools.javac.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Parser Test
 * @ author Guangpeng & Jiawen
 */
public class ParserTest {

  private Parser parser;
  private HashMap<String,ArrayList<String>> map;

  /**
   * set up the Parser
   * @throws Exception when invalid creation
   */
  @Before
  public void setUp() throws Exception {
    parser=new Parser();

    ArrayList<String> arrayList=new ArrayList<>(List.of("value1","value2"));

    map=new HashMap<>();
    map.put("<test>",arrayList);
  }

  /**
   * test getPlaceholder
   */
  @Test
  public void getPlaceholder() {
    ArrayList<String> arrayList1=new ArrayList<>();
    arrayList1.add("test");
    ArrayList<String> arrayList2=new ArrayList<>();
    arrayList2.add("<test>");
    Assert.assertEquals(arrayList2,parser.getPlaceholder("<test>").get("placeholder"));
    Assert.assertEquals(arrayList1,parser.getPlaceholder("<test>").get("placeholderName"));
  }
}
