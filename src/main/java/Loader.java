import java.io.*;
import java.util.*;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Load json file from source path, and do json parse.
 */
public class Loader {

  /**
   * Load in all json file from source path, and skip the file not end with .json
   * @param sourcePath store all json file
   * @return all grammars in the directory
   * @throws IOException when failed or interrupted I/O operations
   * @throws ParseException when you fail to parse json file
   */
  public static AllGrammars load(String sourcePath) throws IOException, ParseException {
    File folder = new File(sourcePath);
    File[] files = Objects.requireNonNull(folder.listFiles());
    AllGrammars allGrammars = new AllGrammars();

    for (File file: files) {
      try {
        if (MyMatcher.validJson(file)){
          allGrammars.addGrammarContent(parseJson(file));
        }
      } catch (InvalidFileException e){
        System.out.println(e.getMessage());
        System.out.printf("Skipping %s, and keep loading rest json files.%n", file.getName());
      }
    }
    return allGrammars;
  }

  /**
   * Parse Json file content to get grammarTitle, grammarDesc, start and non-terminal node
   * @param file json file need to be parsed
   * @return grammar content in this json file
   * @throws IOException when failed or interrupted I/O operations
   * @throws ParseException when you fail to parse json file
   */
  private static GrammarContent parseJson(File file) throws IOException, ParseException {
    JSONParser jsonParser = new JSONParser();
    JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
    // There must be grammarTitle and start
    String title = (String) jsonObject.get("grammarTitle");
    String desc = "";
    if (jsonObject.containsKey("grammarDesc")) {
      desc = (String) jsonObject.get("grammarDesc");
    }
    // create array for start
    ArrayList<String> start = new ArrayList<>();
    JSONArray arr = (JSONArray) jsonObject.get("start");
    for (Object o: arr) {
      start.add((String) o);
    }
    HashMap<String, NonTerminalNode> nodes = parseProductions(jsonObject);
    return new GrammarContent(title, desc, start, nodes);
  }

  /**
   * Parse productions under non-terminal definition
   * @param jsonObject all json objects contained in the json file
   * @return A hash map with definition as key, and (definition + productions) as value
   */
  private static  HashMap<String, NonTerminalNode> parseProductions(JSONObject jsonObject) {
    HashMap<String, NonTerminalNode> nodes = new HashMap<>();
    // generate NonTerminalNode
    for (Object o: jsonObject.keySet()){
      String key = (String) o;
      if (!key.equals("grammarTitle") && !key.equals("start") && !key.equals("grammarDesc")){
        ArrayList<String> node = new ArrayList<>();
        JSONArray arr = (JSONArray) jsonObject.get(key);
        for (Object production : arr) {
          node.add((String) production);
        }
        NonTerminalNode nonTerminalNode = new NonTerminalNode(key, node);
        nodes.put(key, nonTerminalNode);
      }
    }
    return nodes;
  }
}
