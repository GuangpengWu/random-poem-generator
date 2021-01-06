import java.util.ArrayList;
import java.util.List;

/**
 * All grammars in the grammar directory
 */
public class AllGrammars {

  private final List<GrammarContent> grammars;

  /**
   * All grammars store in an array list
   */
  public AllGrammars(){
    this.grammars = new ArrayList<>();
  }

  public AllGrammars(ArrayList<GrammarContent> grammarContents) {
    this.grammars = grammarContents;
  }

  /**
   * Add grammar content per grammar json file
   * @param content in one grammar json file
   */
  public void addGrammarContent(GrammarContent content) {
    grammars.add(content);
  }

  /**
   * Get all grammars
   * @return all grammars
   */
  public List<GrammarContent> getGrammars() {
    return grammars;
  }

  /**
   * Get grammar by index
   * @param index of file user choose to generate
   * @return grammar content in this index
   */
  public GrammarContent getGrammar(int index){
    return grammars.get(index);
  }

  @Override
  public String toString() {
    return grammars.toString();
  }
}
