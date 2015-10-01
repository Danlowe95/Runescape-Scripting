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


    public void poll() {
    }

    public void walk(TilePath path){
        while(path.traverse());
        return;
    }
    public void goUpLadder(){

    }
    public void goDownLadder(){

    }
    public boolean atBank(){
        return true;
    }
    public boolean atMine(){
        return ;
    }
    public boolean atLowerStair(){
        return true;
    }
    public boolean atMiddleStair(){
        return true;
    }
    public boolean atUpperStair(){
        return true;
    }
}
