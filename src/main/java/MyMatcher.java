import java.io.File;

/**
 * Directory / Grammar File validation check
 */
public class MyMatcher {

  /**
   * Check for the validation of grammar directory path
   * @param sourcePath directory path
   * @return directory path if valid
   * @throws InvalidDirectoryException if the directory path is invalid
   */
  public static String validSource(String sourcePath) throws InvalidDirectoryException {
    File path = new File(sourcePath);

    if (!path.exists()) {
      throw new InvalidDirectoryException(
          String.format("No such directory named %s exist.\n", sourcePath));
    }
    if (!path.isDirectory()) {
      throw new InvalidDirectoryException(
          String.format("Source path %s is not a directory.\n", sourcePath));
    }
    return sourcePath;
  }

  /**
   * Check for the validation of grammar files under directory
   * @param file contain grammar
   * @return true if file is valid
   * @throws InvalidFileException if the file doesn't exist or not end with .json
   */
  public static boolean validJson(File file) throws InvalidFileException {
    String filename = file.getName();

    if (!file.exists()) {
      throw new InvalidFileException(String.format("No such file named %s exist.\n", filename));
    }
    if (!filename.endsWith(".json")){
      throw new InvalidFileException(String.format("File %s is not a valid json file.\n", filename));
    }
    return true;
  }
}
