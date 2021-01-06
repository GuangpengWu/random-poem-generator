import java.util.ArrayList;
import java.util.Map;

public class Processor {

  /**
   * Non-terminal words replace process
   * @param grammarContent grammar content with title, desc, start and non-terminals
   * @param rand generate random number
   * @return content generate from current grammar
   * @throws NonTerminalNotFoundException if non-terminal is not in current grammar content
   */
  public static String process(GrammarContent grammarContent, RandomGenerator rand) throws NonTerminalNotFoundException {

    StringBuilder content = new StringBuilder();

    for (String s: grammarContent.getStart()) {
      content.append(replace(s, grammarContent, rand));
    }
    return content.toString();
  }

  /**
   * Get placeholder replaced
   * @param s every string in grammar start
   * @param grammarContent current grammar content
   * @param rand random number
   * @return final replaced grammar start
   * @throws NonTerminalNotFoundException if non-terminal start expected to replace doesn't exist
   */
  private static String replace(String s, GrammarContent grammarContent, RandomGenerator rand) throws NonTerminalNotFoundException {
    // get placeholders(definitions) from current grammar start
    Map<String, ArrayList<String>> map = Parser.getPlaceholder(s);
    ArrayList<String> placeholder = map.get("placeholder");
    ArrayList<String> placeholderName = map.get("placeholderName");

    // if no placeholder there, that means no need to replace, just return
    if (placeholder.size() == 0){
      return s;
    }

    // replace non-terminal word with back track
    String replaced = "";
    for (int i=0; i<placeholder.size(); i++){
      String nonTerminalName = placeholderName.get(i);
      // throw exception if there is no required non-terminal node
      if (!grammarContent.containNode(nonTerminalName)) {
        throw new NonTerminalNotFoundException(String.format("Non terminal node %s is not found.\n", nonTerminalName));
      }
      // otherwise, replace placeholder to production
      NonTerminalNode node = grammarContent.getNode(nonTerminalName);
      int randNum = rand.getRandomNumber(node.getProductionNumber());
      replaced = s.replace(placeholder.get(i), node.getProduction(randNum));
    }
    return replace(replaced, grammarContent, rand);
  }
}
