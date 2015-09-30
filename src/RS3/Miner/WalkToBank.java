package RS3.Miner;

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
//the rt6 package is for RS3. For OSRS scripts, you would use the rt4 package.
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.TilePath;
import org.powerbot.script.rt6.GameObject;
import RS3.Miner.HelperFunctions;
/**
 * Created by user on 9/30/2015.
 */
public class WalkToBank extends Task<ClientContext> {
    private HelperFunctions hf = new HelperFunctions();
    public static final Tile[] PATHTOLADDER = {
            new Tile(3231, 3150, 0),
            new Tile(3237, 3166, 0),
            new Tile(3241, 3180, 0),
            new Tile(3243, 3193, 0),
            new Tile(3238, 3205, 0),
            new Tile(3232, 3216, 0),
            new Tile(3222, 3217, 0),
            new Tile(3210, 3210, 0)
    };

    public WalkToBank(ClientContext ctx) {
        super(ctx);
    }

    private TilePath pathToLadder;

    @Override
    public boolean activate() {
        return ctx.backpack.select().count() == 28 && !hf.atBank();

    }

    @Override
    public void execute() {
        if (hf.atMine()) {
            pathToLadder = new TilePath(ctx, PATHTOLADDER);
            hf.walk(pathToLadder);
        }
        if (hf.atLowerStair()) {
            ctx.objects.select().id(36773).nearest().poll().interact("Climb-up");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
        if (hf.atMiddleStair()) {
            ctx.objects.select().id(36774).nearest().poll().interact("Climb-up");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }

    }
}
