package RS3.Miner;

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
//the rt6 package is for RS3. For OSRS scripts, you would use the rt4 package.
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.SwingUtilities;
@Script.Manifest(
        name = "Miner",
        description = "Mines Lumbridge and Varrock",
        properties="client=6;"
)
public class LumbridgeMiner extends PollingScript<ClientContext> {
    private List<Task> taskList = new ArrayList<Task>();

    public HelperFunctions hf;
    @Override
    public void start() {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                final Gui gui = new Gui();
//                gui.setVisible(true);
//            }
//        });
        hf = new HelperFunctions(2);
        taskList.addAll(Arrays.asList(new Mine(ctx, hf), new Bank(ctx, hf), new WalkToBank(ctx, hf), new WalkToMine(ctx, hf)));
    }

    @Override
    public void poll() {

        for (Task task : taskList){
            if (    task.activate()){
                System.out.println("Status: " + task.name());
                task.execute();

            }
        }
    }

    @Override
    public void stop() {
        System.out.println("Script Stopped!");
    }
}