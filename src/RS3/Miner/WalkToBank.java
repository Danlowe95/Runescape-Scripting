package RS3.Miner;

import jdk.nashorn.internal.runtime.Context;
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
    private HelperFunctions hf;
    public static Tile[] PATHTOBANK;
    private int location;
    public WalkToBank(ClientContext ctx, HelperFunctions h) {
        super(ctx);
        hf = h;
        PATHTOBANK = hf.getPathToBank();
        location = hf.getLocation();
    }


    private TilePath pathToLadder;

    @Override
    public boolean activate() {
        return ctx.backpack.select().count() == 28 && !hf.atBank();

    }

    @Override
    public String name(){
        return "Walk To Bank";
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

    public void walkLumbridge(){
        if (hf.atMine()) {
            System.out.println("At Mine");
            pathToLadder = new TilePath(ctx, PATHTOBANK);
            hf.walk(pathToLadder);
        }
        final GameObject lowerStairs = ctx.objects.select().id(36773).nearest().poll();
        if (lowerStairs.inViewport()){
            System.out.println("See Stairs");
            lowerStairs.interact("Climb-up");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
        final GameObject midStairs = ctx.objects.select().id(36774).nearest().poll();
        if (midStairs.inViewport()) {
            midStairs.interact("Climb-up");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
    }
    public void walkVarrock(){

    }


}
