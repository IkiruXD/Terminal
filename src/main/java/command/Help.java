package command;

import java.io.File;
import java.util.List;
import java.util.Map;

//public class Help implements Command{
public class Help extends Command{

    public Help(Context context) {
        super(context);
    }

    /*@Override
    public String getName() {
        return "help";
    }
     */

    @Override
    public String execute(List<String> args) {
        Map<String, Command> commands = context.getCommandMap();

        StringBuilder result = new StringBuilder("Available commands \n");
        if(commands!=null) {
            for (String each: commands.keySet()) {
                result.append(each).append("\n");
            }
        }

        return result.toString();
    }
}
