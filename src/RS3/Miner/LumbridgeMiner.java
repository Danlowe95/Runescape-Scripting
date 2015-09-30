package RS3.Miner;

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
//the rt6 package is for RS3. For OSRS scripts, you would use the rt4 package.
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Script.Manifest(
        name = "Lumbridge miner",
        description = "Basic Script Example",
        properties="client=6;"
)
public class LumbridgeMiner extends PollingScript<ClientContext> {
    private List<Task> taskList = new ArrayList<Task>();
    @Override

    public void start() {
        taskList.addAll(Arrays.asList(new Mine(ctx), new Bank(ctx), new WalkToBank(ctx)));

    }

    @Override
    public void poll() {

        for (Task task : taskList){
            if (task.activate()){
                task.execute();
            }
        }
    }

    @Override
    public void stop() {
        System.out.println("Script Stopped!");
    }
}