# Group_Jiawen_Guangpeng
# Deliverable Information For Assignment4
This is the detailed deliverable information for assignment4.

## Command Line Start
The whole project could execute through command line with jar build. Belows are the steps to execute project with jar.

### · Step 1
Open Terminal window.

### · Step 2
Enter: java -jar [JarFile Path].  
We've named built jar file as "RSG-1.0-SNAPSHOT.jar", and have already put it in the folder of Assignment4. You can put it at any folder for your convenience. Just replace [JarFile Path] with the path you put .jar file at. 

* Input Example: java -jar /Users/jiawenli/Documents/RSG-1.0-SNAPSHOT.jar

### · Step 3
After running jar file, the project will prompt to ask to enter the grammar folder path like: "Please enter the grammar folder path:"  
Then, you can drag grammar storage path to terminal (Attention to delete last blank space if exists). 

* Input Example: /Users/jiawenli/Desktop/input(No BLANK SPACE AT THE END OF FILE PATH)

### · Step 3
Then, just run the project as prompt instruction goes.

## High Level Description
### Structure
The high level structure of this project:  
* 1st, we have a "Generator.class" to start processing the project and resposible for user interface.  

* 2nd, after receiving grammar folder path, we have to check for the folder path and folder's files validation, this is what "MyMatcher.class" does.

* 3rd, if both matchers have passed, then we will load all grammar files in the folder only one time and parse it components. These are "AllGrammars.class" and "GrammarContent" do.

* 4th, we futher go to extract non-terminal information, split it into defition and productions, in order for later replacement. This is "NonTerminalNode.class" does.

* 5th, also, we will have "Parser.class" to extract <definition> content, which means we have to git rid of "<>" for easy searching and replacement.

* 6th, after receiving user choice, we have "Processor.class" to generate grammar sentences according the corresponding choice. Also, with the help of "RandomGenerator.class", we can generate random contents.

* 7th, finally, back to "Generator.class"'s main function, the generated contents display to users for further interaction.

### User Interface Highlight
Our project handles kinds of situations users may encounter:
#### * Grammar Folder Contains Non-json File.
A dummy.txt file is contained in our input file under Assignment4 folder. To deal with this issue, we prompt a information to user that the program has skipped this non-json file, and keep loading all other json file.
#### * Display Grammar Discription After Grammar Title.
Our design is going to display grammar decription after grammar title when asking user to choose grammar to generate. If no grammar description in corresponding json file, then it just going to display nothing.
#### * No Exit If Non-terminal In Start Doesn't Exist In It's Json File.
If a start in a grammar contains non-terminal that doesn't exist in it's json file below. Then our program is going to prompt to ask user to check for the resources .json file. Instead of exist the program, we will still ask user to choose other grammar in list.
#### * No Exit If User Choice Is Invalid.
If we only have 4 grammar, whereas user mistakenly typed 5 in command line. Our program will not exit under this situation. Instead, we will ask user to re-type between the valid range.

### Other Detail Highlight
#### Case-insensitive Non-terminal Definition
ADj/aDj/adj: the content case between "<>" won't have an impact when generating the reuslts.

## Example Implementation
#### Input: java -jar /Users/jiawenli/Desktop/Group_PDP/Assignment4/RSG-1.0-SNAPSHOT.jar
Output:  
Loading grammars...  
Please enter the grammar folder path:
#### Input: /Users/jiawenli/Desktop/input
Output:  
File dummy.txt is not a valid json file.  

Skipping dummy.txt, and keep loading rest json files.  
The following grammars are available:  
1. Poem Generator: A grammar that generates poems.   
2. A sample grammar: A grammar that generates sample grammars.  
3. Term Paper Generator: A grammar that generates term papers.   
4. Insult Generator: A grammar that generates insult.   

Which would you like to use? (q to quit).   

#### Input(Normal Situation): 1
Output:  
The slugs portend like slugs tonight.  
Would you like another? (y/n)  

#### Input(Normal Situation): y  
Output:  
The slugs die grumpily tonight.  
Would you like another? (y/n)  

#### Input(Normal Situation): n  
Output:  
The following grammars are available:  
1. Poem Generator: A grammar that generates poems.   
2. A sample grammar: A grammar that generates sample grammars.  
3. Term Paper Generator: A grammar that generates term papers.   
4. Insult Generator: A grammar that generates insult.   

Which would you like to use? (q to quit).  

#### Input(Abnormal Situation - Non-terminal Component body1 Missing): 3  
Output:  
Non terminal node body1 is not found.  

Please check the source file of Term Paper Generator  

The following grammars are available:  
1. Poem Generator: A grammar that generates poems.   
2. A sample grammar: A grammar that generates sample grammars.  
3. Term Paper Generator: A grammar that generates term papers.   
4. Insult Generator: A grammar that generates insult.   

Which would you like to use? (q to quit).  

#### Input(Abnormal Situation - Choice Wrong Number): 9
Output:  
Please Re-enter a valid integer from 1 to 4:  

#### Input(Normal Situation): q
Output: (Program will exit after q typed.)  

# End For Assignment4 Deliverables.
======
