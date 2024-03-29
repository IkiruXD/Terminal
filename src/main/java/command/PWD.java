package command;

import java.io.File;
import java.util.List;

public class PWD extends Command{
    public PWD(Context context) {
        super(context);
    }

    /*@Override
    public String getName() {
        return "pwd";
    }
     */

    @Override
    public String execute(List<String> args) {
        return context.getCurrentDirectory().getAbsolutePath();
    }
}
