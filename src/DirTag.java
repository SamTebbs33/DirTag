import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;


/**
 * CommandLineTools
 * @author samtebbs, 15:32:26 - 18 Apr 2015
 */
public class DirTag {
    
    static String aliasFilePath = "~/.dirtags";
    static String command = "";

    public static void main(String[] args) {
	Options options = new Options();
	options.addOption("p", true, "Specifiy an alias file path");
	options.addOption("c", true, "Specify a command to run after the dirtag has been made");
	
	CommandLineParser parser  = new GnuParser();
	CommandLine cmd = null;
	try {
	    cmd = parser.parse(options, args);
	} catch (ParseException e) {
	    System.err.println("Invalid argument: " + e.getMessage());
	    return;
	}
	String arg;
	if((arg = cmd.getOptionValue("p")) != null) aliasFilePath = arg;
	if((arg = cmd.getOptionValue("c")) != null) command = arg;
		
	if(cmd.getArgList().size() > 0){
	    String tag = cmd.getArgList().get(0).toString();
	    String dir = System.getProperty("user.dir");
	    System.out.println(String.format("Creating dirtag (%s) in %s for %s", tag, aliasFilePath, dir));
	    try {
		Environment.makeSystemAlias(aliasFilePath, "cd"+tag, "cd " + dir, command);
	    } catch (IOException e) {
		System.err.println(String.format("Could not create dirtag (%s) in %s: %s", tag, aliasFilePath, e.getMessage()));
	    }
	}else{
	    System.out.println(String.format("Listing aliases in %s", aliasFilePath));
	    try {
		String[] lines = (String[])(Files.lines(Paths.get(aliasFilePath, "")).toArray());
		for(String line : lines){
		    String[] split = line.split(" ");
		    if(split.length >= 2){
			if(split[0].equals("alias")) System.out.println(split[1]);
		    }
		}
	    } catch (IOException e) {
		System.err.println(String.format("Could not read alias file (%s)", aliasFilePath));
	    }
	}
    }

}
