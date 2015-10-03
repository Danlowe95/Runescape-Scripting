package RS3.Miner;

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
//the rt6 package is for RS3. For OSRS scripts, you would use the rt4 package.
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.TilePath;
import org.powerbot.script.rt6.GameObject;
import RS3.Miner.HelperFunctions;
import java.time.chrono.HijrahEra;


public class WalkToMine extends Task<ClientContext> {
    private HelperFunctions hf;
    public static Tile[] PATHTOBANK;
    private int location;
    public WalkToMine(ClientContext ctx, HelperFunctions h) {
        super(ctx);
        hf = h;
        PATHTOBANK = hf.getPathToBank();
        location = hf.getLocation();
    }


    @Override
    public String name(){
        return "Walk To Mine";
    }

    @Override
    public boolean activate() {
        return ctx.backpack.select().count() < 28 && !hf.atMine();

    }

    @Override
    public void execute() {
        if (location == 1)
            walkLumbridge();
        else if (location == 2)
            walkVarrock();
        else
            ctx.controller.stop();

    }

    private TilePath pathToLadder;
    public void walkLumbridge(){
        if (hf.atBank()) {
            final GameObject stairs = ctx.objects.select().id(36775).poll();
            if(!stairs.inViewport()){
                ctx.movement.step(stairs);
                ctx.camera.turnTo(stairs);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
            }
            if(stairs.inViewport()) {
                stairs.interact("Climb-down");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        }
        final GameObject midStairs = ctx.objects.select().id(36774).nearest().poll();
        final GameObject lowerStairs = ctx.objects.select().id(36773).nearest().poll();
        if (lowerStairs.inViewport() || (!hf.atBank() && !midStairs.inViewport())) {

            pathToLadder = new TilePath(ctx, PATHTOBANK).reverse();
            hf.walk(pathToLadder);
        }

        if (midStairs.inViewport()) {
            midStairs.interact("Climb-down");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
    }
    private void walkVarrock(){

    }
}
