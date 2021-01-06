import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Get definitions contain in start, and parse them with regular expression
 */
public class Parser {
  public static Map<String, ArrayList<String>> getPlaceholder(String s){
    HashMap<String, ArrayList<String>> map = new HashMap<>();

    // create another array list without <> for easy replace
    ArrayList<String> placeholders = new ArrayList<>();
    ArrayList<String> placeholderNames = new ArrayList<>();

    Pattern pattern = Pattern.compile("<(\\w+)>");
    Matcher matcher = pattern.matcher(s);
    while (matcher.find()) {
      placeholders.add(matcher.group(0));
      placeholderNames.add(matcher.group(1));
    }
    map.put("placeholder", placeholders); //[<name>, <lastName>]
    map.put("placeholderName", placeholderNames); //[name, lastName]
    return map;
  }

}
