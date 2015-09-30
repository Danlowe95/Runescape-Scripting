package RS3.Miner;

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
//the rt6 package is for RS3. For OSRS scripts, you would use the rt4 package.
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
/**
 * Created by user on 9/30/2015.
 */
public class Mine extends Task<ClientContext> {

    final int rockIDs[] = {3027, 3229, 3038};

    public Mine(ClientContext ctx){
        super(ctx);
    }
    @Override
    public boolean activate() {
        return ctx.backpack.select().count() < 28 && !ctx.objects.select().id(rockIDs).isEmpty() && ctx.players.local().animation() == -1 && false;

    }

    @Override
    public void execute() {
        final GameObject rock = ctx.objects.select().id(rockIDs).nearest().poll();
        if (rock.inViewport()) {
            rock.interact("Mine");
//                wait(200);
        } else {
            ctx.movement.step(rock);
            ctx.camera.turnTo(rock);
        }
    }
}
