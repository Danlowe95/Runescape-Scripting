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

    final int rockIDs[];
    HelperFunctions hf;

    public Mine(ClientContext ctx, HelperFunctions h) {
        super(ctx);
        hf = h;
        rockIDs = hf.getRocks();
    }

    @Override
    public boolean activate() {
        return ctx.backpack.select().count() < 28 && !ctx.objects.select().id(rockIDs).isEmpty() && ctx.players.local().animation() == -1;

    }

    @Override
    public String name() {
        return "Mine";
    }

    @Override
    public void execute() {
        final GameObject rock = ctx.objects.select().id(rockIDs).nearest().poll();
        while (rock.valid()) {
            if (rock.inViewport() && ctx.players.local().animation() == -1) {
                rock.interact("Mine");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {

                }
            } else if (!rock.inViewport()) {
                ctx.movement.step(rock);
                ctx.camera.turnTo(rock);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
    }
}
