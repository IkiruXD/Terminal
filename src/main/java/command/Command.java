package command;

//public interface Command {

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class Command {

    protected final Context context;

    /*protected Command(Context context) {
        this.context = context;
    }
     */

    //public abstract String getName();

    public abstract String execute(List<String> args);

}
