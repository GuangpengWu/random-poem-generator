import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Record of every grammar content
 */
public class GrammarContent {
  private final String title;
  private final String description;
  private final List<String> start;
  private final Map<String, NonTerminalNode> nodes;

  /**
   * @param title grammarTitle
   * @param desc grammarDesc
   * @param start grammar start
   * @param nodes A hash map with definition as key, and (definition + productions) as value
   */
  public GrammarContent(String title, String desc, ArrayList<String> start, HashMap<String, NonTerminalNode> nodes){
    this.title = title;
    this.description = desc;
    this.start = start;
    this.nodes = nodes;
  }

  /**
   * @return true if no description in this non-terminal node
   */
  public boolean noDescription() {
    return description.equals("");
  }

  public String getTitle(){
    return title;
  }

  public String getDescription(){
    return description;
  }

  public List<String> getStart(){
    return start;
  }

  public Map<String, NonTerminalNode> getNodes(){
    return nodes;
  }

  public String getTitleWithDesc(){
    if (noDescription()){
      return getTitle();
    }
    return getTitle() + ": " + getDescription();
  }

  /**
   * Case-insensitive management
   * @param nodeName non-terminal definition grammar start contains
   * @return true if grammar contains the definition regardless of case format
   */
  public boolean containNode(String nodeName) {
    ArrayList<String> currentNames = new ArrayList<>();
    nodes.keySet().forEach((key) -> currentNames.add(key.toLowerCase()));
    return currentNames.contains(nodeName.toLowerCase());
  }

  /**
   * Get non-terminal node map to the definition key
   * @param nodeName non-terminal definition grammar start contains
   * @return non-terminal node content map to the definition
   */
  public NonTerminalNode getNode(String nodeName) {
    NonTerminalNode result = (NonTerminalNode) nodes.values().toArray()[0];
    for (String key: nodes.keySet()) {
      if (key.toLowerCase().equals(nodeName.toLowerCase())){
        result = nodes.get(key);
      }
    }
    return result;
  }

  @Override
  public String toString(){
    if (noDescription()) {
      return "{ grammarTitle: " + title + ",\n" +
          "start: " + start.toString() + ",\n" + nodes.toString() + "}\n";
    }
    return "{ grammarTitle: " + title + ",\n" + "description: " + description + ",\n" +
        "start: " + start.toString() + ",\n" + nodes.toString() + "}\n";
  }
}
