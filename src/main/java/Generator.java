import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Generator {

  public static void main(String[] args){
    // convert String Array to List
//    List<String> list = Arrays.asList(args);
    // if input directory is not given
//    if (args.length < 1){
//      System.err.println(errorMessage());
//      System.err.println(usageMessage());
//     System.exit(1);
//     }

//    String input = "./input";
//    List<String> list = Arrays.asList(input);

    // Main part of Generator
    try {
      System.out.println("Loading grammars...\n");

      BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Please enter the grammar folder path: ");
      String line = stdin.readLine();
      List<String> list = Arrays.asList(line);

      // check for the input folder path
      String inputPath = MyMatcher.validSource(list.get(0));
 //     System.out.println(list);
      AllGrammars allGrammars = Loader.load(inputPath);

      // counter to set numbers for users to choose
      int counter = generateGrammarList(allGrammars);
      choiceMessage();
//     BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
     String choice = stdin.readLine();

      // User Interaction
      while (!(choice.equals("q") || choice.equals("quit"))){
        try {
          int selected = Integer.parseInt(choice);
          // Handling invalid number input
          if (selected > counter || selected < 1){
            System.out.println("Please Re-enter a valid integer from 1 to " + counter + ":");
            choice = stdin.readLine();
            continue;
          }

          // Get corresponding grammar content after user choosing a number
          GrammarContent currentGrammar = allGrammars.getGrammar(selected-1); // grammar corresponding index
          // Generate random number and do the replacement
          RandomGenerator rand = new RandomGenerator(400);
          System.out.println("\n"+ Processor.process(currentGrammar, rand));


          System.out.println("\nWould you like another? (y/n)");
          line = stdin.readLine();

          // Handling input out of choices given
          while (!(line.equals("y") || line.equals("n"))){
            retryMessage();
            line = stdin.readLine();
          }
          // While "y" with exceptions
          while (!line.equals("n")){
            // if input is neither y/n
            if (!line.equals("y")){
              retryMessage();
              line = stdin.readLine();
              continue;
            }
            // Generate another grammar
            System.out.println("\n"+ Processor.process(currentGrammar, rand));
            System.out.println("\nWould you like another? (y/n)");
            line = stdin.readLine();
          }
        } catch (NumberFormatException e){
          // handling invalid non number input
          System.out.println("Please Re-enter a valid integer from 1 to " + counter + " or enter q to quit:");
          choice = stdin.readLine();
          continue;
        } catch (NonTerminalNotFoundException e) {
          int selected = Integer.parseInt(choice);
          GrammarContent currentGrammar = allGrammars.getGrammar(selected-1);
          System.out.println(e.getMessage());
          System.out.println("Please check the source file of " + currentGrammar.getTitle() + "\n");
        }

        // While "n" with showing choices again
        counter = generateGrammarList(allGrammars);
        choiceMessage();
        choice = stdin.readLine();
      }

    } catch (InvalidDirectoryException | IOException | ParseException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }
  }

  private static String errorMessage(){
    return "Error: Missing Source Directory";
  }

  private static String usageMessage(){
    return "Usage:\n" + "\t" + "Source directory: <path> contains all source grammar files.";
  }

  private static int generateGrammarList(AllGrammars allGrammars){
    System.out.println("The following grammars are available:\n");
    int counter = 1;
    for (GrammarContent grammar: allGrammars.getGrammars()) {
      System.out.printf("%d. %s\n", counter, grammar.getTitleWithDesc());
      counter++;
    }
    return counter-1;
  }

  private static void choiceMessage(){
    System.out.println("\nWhich would you like to use? (q to quit)");
  }

  private static void retryMessage(){
    System.out.println("\nPlease enter either y or n.\nWould you like another? (y/n)");
  }
}
