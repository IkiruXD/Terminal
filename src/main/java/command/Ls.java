package command;

import java.io.File;
import java.util.List;

//public class Show implements Command{
public class Ls extends Command{
    public Ls(Context context) {
        super(context);
    }

    /*@Override
    public String getName() {
        return "show";
    }
     */

    @Override
    public String execute(List<String> args) {
        //File file = new File(input); //TODO
        File file = context.getCurrentDirectory();
        File[] allFiles = file.listFiles();
        StringBuilder result = new StringBuilder();
        if(allFiles!=null) {
            for (File each : allFiles) {
                result.append(each.getName()).append(" : ").append(each.getUsableSpace()).append("\n");
            }
        }

        return result.toString();
    }
}
