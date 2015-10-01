import org.rsbot.script.Script;
import org.rsbot.script.ScriptManifest;
import java.util.Map;
import org.rsbot.event.listeners.ServerMessageListener;
import org.rsbot.event.events.ServerMessageEvent;
import org.rsbot.script.wrappers.RSComponent;
import org.rsbot.script.wrappers.RSNPC;
import org.rsbot.script.wrappers.RSObject;
import org.rsbot.script.wrappers.RSTile;
import org.rsbot.script.wrappers.RSArea;
import java.awt.*;
import org.rsbot.event.events.MessageEvent;
import org.rsbot.event.listeners.MessageListener;
import org.rsbot.event.listeners.PaintListener;
import org.rsbot.script.util.Timer;

 
 
@ScriptManifest(authors = "sniperkid1", name = "SymbolBlesser", version = 1.0, description = "Have symbols in bank and start at edgeville bank.")
public class SymbolBlesser extends Script {
 
public boolean onStart(){
        log("start at edgeville bank");
    return true;}
    
            RSTile[] bankToGuild = {new RSTile(3087, 3500), new RSTile(3075,3505), new RSTile(3063,3512),
            new RSTile(3052,3507), new RSTile(3051,3493), new RSTile(3044,3484) };
            RSTile[] monkToBank = {new RSTile(3044,3484), new RSTile(3051, 3493), new RSTile(3052,3507), 
            new RSTile(3063,3512), new RSTile(3075,3505), new RSTile(3087, 3500), new RSTile(3094,3494)};
            int unblessedID = 1716;
            int blessedID = 1718;
            int ladderID = 2641;
            int downLadderID = 30863;
            int bankBoothID = 26972;
            int monkID = 802;
            
                        private boolean walkToGuild() {
                             RSTile[] randomizedPath = walking.randomizePath(bankToGuild, 2, 2);
                                            return walking.walkPathMM(randomizedPath, 0, 2);
                                            }

                                                private boolean atClimbLadder() {
                                                    RSArea area = new RSArea(new RSTile(3044, 3485), new RSTile(3048, 3483));
                                                    return area.contains(getMyPlayer().getLocation());
                                                }
                                    private void climbLadder() {
                                        RSObject ladder = objects.getNearest(ladderID);
                                        ladder.doAction("Climb-up");
                                        }
                             
                            
                            private void talkToMonk() {
                                RSNPC monk = npcs.getNearest(monkID);
                            if (!interfaces.getComponent(228, 2).isValid()) {
                                    monk.doAction("Talk-to");
                                    sleep(1600,2000);
                                    }
                            if (interfaces.getComponent(228,2).isValid()) {
                                interfaces.getComponent(228, 2).doClick();
                                    sleep(1000,1100);
                                    }
                            if (interfaces.getComponent(64, 5).isValid()){
                                interfaces.getComponent(64, 5).doClick();
                                sleep(1400,1600);
                            }
                            if (interfaces.getComponent(242, 6).isValid()){
                                interfaces.getComponent(242, 6).doClick();
                                sleep(1400,1600);
                            }
                            if (interfaces.getComponent(230, 2).isValid()){
                                interfaces.getComponent(230, 2).doClick();
                                sleep(1400,1600);
                            }
                            if (interfaces.getComponent(64, 5).isValid()){
                                interfaces.getComponent(64, 5).doClick();
                                sleep(1400,1600);
                            }
                            }
                                        private boolean atMonk() {
                                                RSArea area = new RSArea(new RSTile(3044, 3482), new RSTile(3047, 3485));
                                                return area.contains(getMyPlayer().getLocation());
                                                }
                                                
                                                private boolean walkToBank() {
                                                    RSObject dladder = objects.getNearest(downLadderID);{
                                                    dladder.doAction("Climb-down");
                                                    }
                                                    RSTile[] randomizedPath = walking.randomizePath(monkToBank, 3, 3);
                                                    return walking.walkPathMM(randomizedPath, 0, 2);
                                                }
                                                            private boolean atBank() {
                                                                RSArea area = new RSArea(new RSTile(3091, 3489), new RSTile(3097, 3499));
                                                            return area.contains(getMyPlayer().getLocation());
                                                            }
                                               private void bank() {
                                                   RSObject bankBooth = objects.getNearest(bankBoothID);
                                                             if (bankBooth != null && !bank.isOpen()) {
                                                             bankBooth.doAction("uickly");
                                                             sleep(500,700);
                                                             if(bank.isOpen()){
                                                                    bank.depositAllExcept();
                                                                    sleep(700, 900);
                                                                    bank.withdraw(unblessedID, 0);
                                                                    }
                                                                    if(!bank.isOpen()){
                                                                        bank();}
                                                   }
                                               }

    @Override
    public int loop() {
    if (atMonk() && inventory.contains(unblessedID)){
        talkToMonk();
        }
    if (atMonk() && !inventory.contains(unblessedID)){
        walkToBank();
        }
    if (atBank() && inventory.contains(blessedID)){
        bank();
        }
    if (atBank() && inventory.contains(unblessedID)){
        walkToGuild();
        }
    if (atClimbLadder() && inventory.contains(unblessedID)){
        climbLadder();
        }
        return 1000;
    }
 
public void onFinish(){
    log("thanks for using my script!");

 
}
 
 
    }