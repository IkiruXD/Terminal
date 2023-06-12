import command.Command;
import command.Context;
import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //path, where program starts
        Context context = new Context(null, new File(System.getenv().get("PWD")));

        Map<String,Command> commands  = getCommands(context);

        context.setCommandMap(commands);

        System.out.println("Hello. Press q or exit to quit.");

        performCommand(context, commands);
    }

    private static void performCommand(Context context, Map<String, Command> commands) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String line = scanner.nextLine();
            List<String> allArguments = Arrays.asList(line.split(" "));

            String commandName = allArguments.get(0);
            //if(StringUtils)

            if(commandName.equals("exit")||commandName.equals("q")){
                System.out.println("bye");
                break;
            }

            Command command = commands.getOrDefault(commandName, new Command(context) {
                /*
                for method getName() in Command interface
                @Override
                public String getName() {
                    return "not found";
                }
                 */

                @Override
                public String execute(List<String> args) {
                    return "Command " + line + " is unknown";
                }
            });
            System.out.println(command.execute(allArguments.subList(1,allArguments.size())));
            //System.out.println("Command " + line );
        }
    }

    @SneakyThrows
    private static Map<String, Command> getCommands(Context context) {
        Reflections reflection = new Reflections("command", Scanners.SubTypes);
        Set<Class<? extends Command>> allClasses = reflection.getSubTypesOf(Command.class);
        Map<String,Command> commandNameToFunction = new LinkedHashMap<>();
        for (Class<? extends Command> each : allClasses) {
            Command instance = each.getDeclaredConstructor(Context.class).newInstance(context);
            //for method getName() in Command interface
            //commandNameToFunction.put(instance.getName(), instance);
            commandNameToFunction.put(each.getSimpleName().toLowerCase(), instance);
        }
        return commandNameToFunction;
    }

}
