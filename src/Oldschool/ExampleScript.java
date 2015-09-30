package Oldschool;

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
//the rt6 package is for RS3. For OSRS scripts, you would use the rt4 package.
import org.powerbot.script.rt6.ClientContext;

@Script.Manifest(
        name = "Rawr",
        description = "Basic Script Example",
        properties="client=6;"
)
public class ExampleScript extends PollingScript<ClientContext> {

    @Override

    public void start() {
        System.out.println("Script Started!");

    }
    final int goblinIds[] = {12357, 12352, 12353, 11236, 11234};
    @Override
    public void poll() {
//
        if(ctx.players.local().animation() == -1){
//            for(ctx.groundItems.poll().)
            ctx.npcs.select().name("Goblin").nearest().peek().interact("Attack");
            ctx.groundItems.id(123).action("Take");
        }
    }

    @Override
    public void stop() {
        System.out.println("Script Stopped!");
    }
}