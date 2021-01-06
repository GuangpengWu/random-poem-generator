import java.util.ArrayList;
import java.util.List;

/**
 * Non-terminal Node: definition: productions
 *
 * e.g. adj[definition]: beautiful, spiteful...[productions]
 */
public class NonTerminalNode {
  private final String definition;
  private final List<String> productions;

  /**
   * Contents in non-terminal nodes
   * @param def definition
   * @param productions list
   */
  public NonTerminalNode(String def, ArrayList<String> productions) {
    this.definition = def;
    this.productions = productions;
  }

  /**
   * @return definition in non-terminal node
   */
  public String getDefinition() {
    return definition;
  }

  /**
   * @return a list of non-terminal node's productions
   */
  public List<String> getProductions() {
    return productions;
  }

  /**
   * @return size of productions in one node
   */
  public int getProductionNumber(){
    return getProductions().size();
  }

  /**
   * @param index production's index
   * @return production at index position
   */
  public String getProduction(int index) {
    return productions.get(index);
  }

  @Override
  public String toString() {
    return "{" + definition + ": " + productions.toString() + "}";
  }
}
