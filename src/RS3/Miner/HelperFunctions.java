package RS3.Miner;
import org.powerbot.script.*;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt6.ChatOption;
import org.powerbot.script.rt6.GeItem;
import org.powerbot.script.rt6.Npc;
import org.powerbot.script.rt6.TilePath;
import org.powerbot.script.rt6.ClientContext;
/**
 * Created by user on 9/30/2015.
 */
public class HelperFunctions extends PollingScript<ClientContext>{
    final int lumbBank[] = {3206, 3214, 2, 10};
    final int lumbMine[] = {3230, 3150, 0, 10};
    final int varrBank[] = {3253, 3421, 0, 8};
    final int varrMine[] = {3286, 3368, 0, 10};
    final int varrBankBooth[] = {782};
    final int lumbBankBooth[] = {36786};
    final int bankLoc[], mineLoc[], rockIDs[], boothIDs[];
    final Tile[] pathToBank;

    final int lumbRocks[] = {3027, 3229, 3038};
    final int varrIronRocks[] = {11955, 11956, 11954};

    final int location;
    public static final Tile[] pathToBankLumb = {
            new Tile(3231, 3150, 0),
            new Tile(3237, 3158, 0),
            new Tile(3237, 3166, 0),
            new Tile(3241, 3180, 0),
            new Tile(3243, 3193, 0),
            new Tile(3238, 3205, 0),
            new Tile(3232, 3216, 0),
            new Tile(3222, 3217, 0),
            new Tile(3210, 3210, 0)
    };

    public static final Tile[] pathToBankVarrock = {
            new Tile(3286, 3368, 0),
            new Tile(3289, 3373, 0),
            new Tile(3291, 3381, 0),
            new Tile(3292, 3387, 0),
            new Tile(3290, 3398, 0),
            new Tile(3289, 3408, 0),
            new Tile(3285, 3417, 0),
            new Tile(3280, 3426, 0),
            new Tile(3271, 3428, 0),
            new Tile(3261, 3428, 0),
            new Tile(3253, 3421, 0)
    };
    //default to lumbridge if no location provided
    public HelperFunctions(){
        bankLoc = lumbBank;
        mineLoc = lumbMine;
        pathToBank = pathToBankLumb;
        rockIDs = lumbRocks;
        location = 1;
        boothIDs = lumbBankBooth;
    }
    public HelperFunctions(int loc){
        if(loc == 1){
            bankLoc = lumbBank;
            mineLoc = lumbMine;
            pathToBank = pathToBankLumb;
            rockIDs = lumbRocks;
            boothIDs = lumbBankBooth;
            location = 1;

        }else if (loc == 2){
            bankLoc = varrBank;
            mineLoc = varrMine;
            pathToBank = pathToBankVarrock;
            rockIDs = varrIronRocks;
            boothIDs = varrBankBooth;
            location = 2;

        }
        else{
            bankLoc = lumbBank;
            mineLoc = lumbMine;
            pathToBank = pathToBankLumb;
            rockIDs = lumbRocks;
            location = 1;
            boothIDs = lumbBankBooth;
        }
    }
    //check if your player is i distance away fom a tile(x,y,z)
    public boolean checkDistance(int x, int y, int z, int i){
        Tile t = new Tile(x,y,z);
        return t.distanceTo(ctx.players.local()) < i && ctx.movement.reachable(t, ctx.players.local());
    }
    public void poll() {
    }

    public void walk(TilePath path){
        while(path.traverse()){
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {

            }
        }
        return;
    }
    public boolean atBank(){
        return checkDistance(bankLoc[0],bankLoc[1],bankLoc[2],bankLoc[3]);
    }
    public boolean atMine(){
        return checkDistance(mineLoc[0],mineLoc[1],mineLoc[2],mineLoc[3]);
    }
    public Tile[] getPathToBank(){
        return pathToBank;
    }
    public int[] getBankLoc(){
        return bankLoc;
    }
    public int[] getMineLoc(){
        return mineLoc;
    }
    public int[] getRocks(){
        return rockIDs;
    }
    public int getLocation(){
        return location;
    }
    public int[] getBoothIDs(){
        return boothIDs;
    }
}
