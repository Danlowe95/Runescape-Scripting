import java.util.Map;
import org.rsbot.script.Script;
import org.rsbot.script.ScriptManifest;
import java.awt.*;
import org.rsbot.script.methods.Combat;
import org.rsbot.script.methods.Prayer;
import org.rsbot.script.methods.Prayer.Normal;
import org.rsbot.event.events.MessageEvent;
import org.rsbot.event.listeners.MessageListener;
import org.rsbot.event.listeners.PaintListener;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import org.rsbot.script.wrappers.*;
import org.rsbot.script.methods.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.rsbot.script.wrappers.RSComponent;
@ScriptManifest(authors = "sniperkid1", name = "SnipersMoleKiller", version = 2.5, description = "Make sure you have a lantern and spade in inventory at start!")
    public class SnipersMoleKiller extends Script implements PaintListener, MouseListener{

        GUIMole g = new GUIMole();
    public boolean onStart() {
        log("Welcome!");
        startTime = System.currentTimeMillis();
        moleLiving = true;
        status = "Starting Up";
        g.setVisible(true);
        doTeleport = false;
        mouse.setSpeed(7);
        while(guiWait) sleep(500);
        return true;
    }
    boolean usePrayerPots;
    boolean drinkAtt = true;
    boolean useSupers;
    boolean useBoosts;
    boolean drinkStr = true;
    boolean drinkDef = true;
    private boolean guiWait = true;
    public boolean showPaint = true;
    boolean lootCharms;
    boolean doTeleport;
    int amountShark;
    int amountPPots;
    int amountCmbPots;
    int prayerPotID[] = {2434,139,141,143};//2434 is (4)
    int pPot1 = 143;
    int pPot2 = 141;
    int pPot3 = 139;
    int fullPrayerPot = 2434;
    int profit =0;
    int kills =0;
    int teleport = 8009;
    public int mole = 3340;
    int moleClaw = 7416;
    int moleSkin = 7418;
    int shark = 385;
    int foodIDs[] = {385};
    int spade = 952;
    int lantern = 4531;
    int bones = 532;
    int exAtt4 = 15308;
    int exAtt3 =15309;
    int exAtt2 =15310;
    int exAtt1 =15311;
    int exStr4 =15312;
    int exStr3 =15313;
    int exStr2 =15314;
    int exStr1 =15315;
    int exDef4 =15316;
    int exDef3 =15317;
    int exDef2 =15318;
    int exDef1 =15319;
    int supAtt4 =2436;
    int supAtt3 =143;
    int supAtt2 =147;
    int supAtt1 =149;
    int supDef4 =2442;
    int supDef3 =163;
    int supDef2 =165;
    int supDef1 =167;
    int supStr4 =2440;
    int supStr3 =157;
    int supStr2 =159;
    int supStr1 =161;
    //int allDrops[] = {7416, 7418, 385, 565, 1516, 532};
    private String status = "";
public long startTime = 0;
int loops = 0;
         public long millis = 0;
         public long hours = 0;
         public long minutes = 0;
         public long seconds = 0;
         public long last = 0;
         // moleskin, blood, law, death, iron arrows, loop/toothhalf
     int items1[] = { 7418,565,560,563,884,985,987};
     //nature rune, rune battleaxe, rune 2H, , rune spear, shield left half
     int items2[] = {561,1373,1374, 1319,1247, 2366};
     //dragon spear, dragon dagger, rune med helm rune kiteshield, rune sq shield, dragon med helm
     int items3[] = {1249,1215,1216,1147,1201,1185,1149,};
     //iron ore - 9500 --rune bar,uncut diamond ,silver ore ,dragon stone,yew logs,bones, rune arrow
     int items4[] = {440,441,2363,2364,1617,1618,442,443,1615,1616, 1515,1516, 532,892};
     //shark, effigy, cluescrolls(need IDS)
     int items5[] = {385,18778};
     //RARE DROP TABLE
     int itemClaw = 7416;
     int itemsRare[] = {9143,9342,1631,20667,1392,574,570,2999,3001,258,270, 6686,454,450,452,2362,7937,1443,372,383,5315,5316,5289,5304,5300};
     int allItems[] = {18778,7416, 7418,565,560,563,884,985,987,561,1373,1374, 1319,892,1247, 2366,
     1249,1215,1216,1147,1201,1185,1149,9143,9342,1631,20667,1392,574,570,2999,3001,258,
     270, 6686,454,450,452,2362,7937,1443,372,383,5315,5316,5289,5304,5300};
     boolean moleLiving;
     int charmIDs[] = {12158, 12159,12160,12163};
                 private void WhackAMole(){
                     status = "Attacking Mole!!";
                     RSNPC moley = npcs.getNearest(mole);
                 if (!moley.isOnScreen()){
                walking.walkTo(moley.getLocation());
                camera.turnTo(moley);
                camera.setPitch(0);
                }
                else if (moley.isOnScreen() && !getMyPlayer().getInteracting().equals(moley)){
                moley.interact("Attack");
                sleep(random(900,1200));
                camera.setPitch(100);

 }
    }
                 private boolean atMainTunnel() {
                                        RSArea area = new RSArea(new RSTile(1751, 5177), new RSTile(1768, 5196));
                                        return area.contains(getMyPlayer().getLocation());
                                    }
                 private boolean atSubtunnel1() {
                                        RSArea area = new RSArea(new RSTile(1739, 5192), new RSTile(1755, 5209));
                                        return area.contains(getMyPlayer().getLocation());
                                    }
                 private boolean atSubtunnel2() {
                                        RSArea area = new RSArea(new RSTile(1760, 5196), new RSTile(1785, 5204));
                                        return area.contains(getMyPlayer().getLocation());
                                    }
                 private boolean atSubtunnel3() {
                                        RSArea area = new RSArea(new RSTile(1769, 5172), new RSTile(1785, 5195));
                                        return area.contains(getMyPlayer().getLocation());
                                    }
                 private boolean atSubtunnel4() {
                                        RSArea area = new RSArea(new RSTile(1756, 5159), new RSTile(1778, 5170));
                                        return area.contains(getMyPlayer().getLocation());
                                    }
                 private boolean atSubtunnel5() {
                                        RSArea area = new RSArea(new RSTile(1742, 5218), new RSTile(1764, 5224));
                                        return area.contains(getMyPlayer().getLocation());
                                    }
                 private boolean atSubtunnel5A() {
                                        RSArea area = new RSArea(new RSTile(1755, 5204), new RSTile(1762, 5214));
                                        return area.contains(getMyPlayer().getLocation());
                                    }
                 private void searchCaves(){
                     status = "Searching....";
                     RSNPC moley = npcs.getNearest(mole);
                     RSTile loc1 = new RSTile(1752, 5201, 4);
                     RSTile loc2 = new RSTile(1769, 5198, 4);
                     RSTile loc3 = new RSTile(1768, 5175, 4);
                     RSTile locMain = new RSTile(1761, 5186, 7);
                     RSTile loc4 = new RSTile(1771, 5165, 4);
                     RSTile loc5 = new RSTile(1758, 5219, 4);
                                            RSItem Bones = inventory.getItem(bones);

                     if(inventory.contains(bones)){
                                                Bones.interact("Bury");
                                                sleep(random(400,800));
                                            }
                     if(atMainTunnel() && moley == null && getMyPlayer().isIdle()){
                         if(random(1,6) < 3){
                         walking.walkTo(loc1);
                         sleep(random(700,1200));
                         }
                         else if(random(1, 6) >= 3)
                         {
                             walking.walkTo(loc3);
                         }
                     }
                     if (atSubtunnel1() && moley == null && getMyPlayer().isIdle()){
                            walking.walkTo(loc5);
                            sleep(random(1500,3000));
                        }
                    // else if(atSubtunnel1() && moley.getAnimation() == 3314){
                         //walking.walkTo(locMain);
                     //}
                          if (atSubtunnel2() && moley == null && getMyPlayer().isIdle()){
                             walking.walkTo(loc3);
                                    }
 //else if (atSubtunnel2() && moley.getAnimation() == 3314);
                         if (atSubtunnel3() && moley == null && getMyPlayer().isIdle()){
                            walking.walkTo(loc4);
                     }
                     if ((atSubtunnel5() || atSubtunnel5A()) && moley == null){
                            walking.walkTo(loc2);
                        }
                     if (atSubtunnel4() && moley == null && getMyPlayer().isIdle()){
                            walking.walkTo(locMain);
                        }
                     if(atTunnels() && !atSubtunnel1() && !atSubtunnel2() && !atSubtunnel3() && !atMainTunnel() && moley == null && getMyPlayer().isIdle()){
                        walking.walkTo(locMain);
                     }
                 //if(moley.getAnimation() == 3314){
                  //       walking.walkTo(locMain);
                   //  }
    }
                                        private boolean atTunnels() {
                                        RSArea area = new RSArea(new RSTile(1732, 5133), new RSTile(1786, 5242));
                                        return area.contains(getMyPlayer().getLocation());
                                    }
                                        private boolean atHills() {
                                        RSArea area = new RSArea(new RSTile(2982, 3382), new RSTile(2990, 3390));
                                        return area.contains(getMyPlayer().getLocation());
                                    }

                                         private boolean atFalador() {
                                        RSArea area = new RSArea(new RSTile(2937, 3342), new RSTile(3019, 3388));
                                        return area.contains(getMyPlayer().getLocation());
                                    }
                                         private boolean atFaladorSquare() {
                                        RSArea area = new RSArea(new RSTile(2959, 3372), new RSTile(2970, 3388));
                                        return area.contains(getMyPlayer().getLocation());
                                    }
                                         private boolean atBank() {
                                        RSArea area = new RSArea(new RSTile(2943, 3368), new RSTile(2953, 3378));
                                        return area.contains(getMyPlayer().getLocation());
                                    }
                                        
                                         
                                         private void lootMethod(){
                                            RSGroundItem drops = groundItems.getNearest(allItems);
                                            RSItem Bones = inventory.getItem(bones);
                                            RSGroundItem a = groundItems.getNearest(items1);
                                            RSGroundItem b = groundItems.getNearest(items2);
                                            RSGroundItem c = groundItems.getNearest(items3);
                                            RSGroundItem d = groundItems.getNearest(items4);
                                            RSGroundItem e = groundItems.getNearest(items5);
                                            RSGroundItem rare = groundItems.getNearest(itemsRare);
                                            RSGroundItem claw = groundItems.getNearest(itemClaw);
                                            RSItem[] aaa = inventory.getItems(items1);
                                            RSGroundItem all = groundItems.getNearest(allItems);
                                            RSGroundItem charm = groundItems.getNearest(charmIDs);
                                            status = "looting..";
                                            
                                            if (a !=null && getMyPlayer().getInteracting() == null && a.isOnScreen()){
                                                int aa = a.getItem().getID();
                                                a.interact("Take " + a.getItem().getName());;


                                                profit += (grandExchange.lookup(aa).getGuidePrice());
                                                
                                                if(aa == 7418 && all ==null){

                                                }
                                                sleep(random(400,600));
                                            }

                                             if (a !=null && !a.isOnScreen()){
                                                walking.walkTo(a.getLocation());
                                            }else{
                                                sleep(50);
                                            }
                                            if (b !=null && getMyPlayer().getInteracting() == null && b.isOnScreen()){
                                                int bb = b.getItem().getID();
                                                b.interact("Take " + b.getItem().getName());;


                                                profit += (grandExchange.lookup(bb).getGuidePrice());

                                                sleep(random(400,600));
                                            } if (b !=null && !b.isOnScreen()){
                                                walking.walkTo(b.getLocation());
                                            }else{
                                                sleep(50);
                                            }
                                            if (c !=null && getMyPlayer().getInteracting() == null && c.isOnScreen()){
                                                int cc = c.getItem().getID();
                                                
                                                c.interact("Take " + c.getItem().getName());


                                                profit += (grandExchange.lookup(cc).getGuidePrice());
                                                

                                                sleep(random(400,600));
                                            } if (c !=null && !c.isOnScreen()){
                                                walking.walkTo(c.getLocation());
                                            }else{
                                                sleep(50);
                                            }
                                            if (d !=null && getMyPlayer().getInteracting() == null && d.isOnScreen()){
                                                int dd = d.getItem().getID();
                                                int stacksize = d.getItem().getStackSize();
                                                d.interact("Take " + d.getItem().getName());


                                                //profit += ((stacksize)*(grandExchange.lookup(dd).getGuidePrice()));

                                                sleep(random(400,600));
                                            } if (d !=null && !d.isOnScreen()){
                                                walking.walkTo(d.getLocation());
                                            }else{
                                                sleep(50);
                                            }
                                            
                                            if (e !=null && getMyPlayer().getInteracting() == null && e.isOnScreen()){
                                                int ee = e.getItem().getID();
                                                e.interact("Take " + e.getItem().getName());

                                                sleep(random(400,600));
                                            }if (e !=null && !e.isOnScreen()){
                                                walking.walkTo(e.getLocation());
                                            }else{
                                                sleep(50);
                                            }
                                            if (rare !=null && getMyPlayer().getInteracting() == null && rare.isOnScreen()){
                                                int raree = rare.getItem().getID();
                                                rare.interact("Take " + rare.getItem().getName());


                                                profit += (grandExchange.lookup(raree).getGuidePrice());

                                                sleep(random(400,600));
                                            } if (rare !=null && !rare.isOnScreen()){
                                                walking.walkTo(rare.getLocation());
                                            }else{
                                                sleep(50);
                                            }
                                            if (claw !=null && getMyPlayer().getInteracting() == null && claw.isOnScreen()){
                                                int claww = claw.getItem().getID();
                                                claw.interact("Take " + claw.getItem().getName());
                                                moleLiving = false;


                                                profit += (grandExchange.lookup(claww).getGuidePrice());
                                                if(claww == 7416){
                                                    kills++;
                                                }
                                                sleep(random(400,600));
                                            } if (claw !=null && !claw.isOnScreen()){
                                                walking.walkTo(claw.getLocation());
                                            }else{
                                                sleep(50);
                                            }
                                            if (charm !=null && getMyPlayer().getInteracting() == null && charm.isOnScreen() && lootCharms == true){
                                                charm.interact("Take " + charm.getItem().getName());
                                                sleep(random(400,600));
                                            } if (charm !=null && !charm.isOnScreen() && lootCharms == true){
                                                walking.walkTo(charm.getLocation());
                                            }else{
                                                sleep(50);
                                            }


                                        }
                             private void healMethod(){
                                 status = "Healing";
                                 RSItem teletab = inventory.getItem(teleport);
                                 RSItem foodd = inventory.getItem(shark);
                                 if (combat.getLifePoints() < skills.getRealLevel(Skills.CONSTITUTION) * 5 && foodd !=null) {
                                                foodd.interact("Eat");
                                                sleep(random(300,600));
                                            }
                                            else if (combat.getLifePoints() < skills.getRealLevel(Skills.CONSTITUTION) * 5 && foodd == null) {
                                                teletab.interact("Break");
                                                doTeleport = false;
                                                sleep(random(3000,5000));
                                            }
                             }
                                    private void walkToBank(){
                                        status = "Walking to bank";
                                        RSTile bank = new RSTile(2946, 3370, 2);
                                        RSTile booth = new RSTile(2946, 3367);
                                        RSObject bankBooth = objects.getTopAt(booth);
                                    if (!inventory.containsOneOf(foodIDs) && !atBank()){
                                        walking.walkTo(bank);
                                    }
                                        if(atBank() && !inventory.containsOneOf(foodIDs) && !bankBooth.isOnScreen()){
                                            camera.turnTo(bankBooth);
                                            camera.setPitch(10);
                                        }
                                    if(!inventory.containsOneOf(foodIDs) && atBank() && bankBooth.isOnScreen()){
                                        bankBooth.interact("Use-quickly");
                                        sleep(random(800,1200));
                                    }

                                    }
               private void bankingMethod(){
                   RSItem teletab = inventory.getItem(teleport);
                   RSItem sharky = inventory.getItem(shark);
                   if(inventory.containsOneOf(allItems)){
                       status = "Depositing Loot..";
                       bank.depositAllExcept(lantern, spade, teleport, shark);
                       sleep(300,350);
                   //}
                   //if(!inventory.containsOneOf(allItems));
                   //bank.withdraw(shark, 15);
                   //sleep(300,350);
                   }
                   if(bank.getCount(teleport) <2){
                       log("Out of Teletabs - stopping script.");
                       stopScript();
                   }
                   if(bank.getCount(shark) <4){
                       log("Out of sharks - stopping script.");
                       stopScript();
                   }
                   if(bank.getCount(fullPrayerPot) <3){
                       log("Out of Prayer Pots - stopping script.");
                       stopScript();
                   }
                   if(useBoosts && useSupers && bank.getCount(supAtt4) <1){
                       log("Out of Super Attack (4) - stopping script.");
                       stopScript();

                   }
                   if(useBoosts && useSupers && bank.getCount(supStr4) <1){
                       log("Out of Super Strength (4) - stopping script.");
                       stopScript();
                   }
                       if(useBoosts && useSupers && bank.getCount(supDef4) <1){
                       log("Out of Super Defense (4) - stopping script.");
                       stopScript();
                       }
                   if(useBoosts && useSupers == false && bank.getCount(exAtt4) <2){
                       log("Out of Extreme Attack (4) - stopping script.");
                       stopScript();
                   }
                   if(useBoosts && useSupers == false && bank.getCount(exStr4) <2){
                       log("Out of Extreme Strength (4) - stopping script.");
                       stopScript();
                   }
                   if(useBoosts && useSupers == false && bank.getCount(exDef4) <2){
                       log("Out of Extreme Defense (4) - stopping script.");
                       stopScript();
                   }
                      if(teletab.getStackSize() <5 || teletab == null){
                          status = "Taking teleports";
                           bank.withdraw(teleport, 5);
                           sleep(300,500);
                       }
                   if (combat.getLifePoints() < skills.getRealLevel(Skills.CONSTITUTION) * 7) {
                       status = "Healing..";
                   if(!inventory.contains(shark)){
                       bank.withdraw(shark, 3);
                       sleep(random(500,700));
                       }
                       else if((inventory.contains(shark)))
                       {
                       sharky.interact("Eat");
                       sleep(500,600);
                   }//else{
                    //       sleep(50);
                   //}
                   }
if(useBoosts && useSupers && !inventory.contains(supAtt4)){
                       bank.withdraw(supAtt4, amountCmbPots);
                       drinkAtt = true;
                      sleep(random(400,600));
                   }
                   if(useBoosts && useSupers && !inventory.contains(supStr4)){
                       bank.withdraw(supStr4, amountCmbPots);
                       drinkStr = true;
                      sleep(random(400,600));
                   }
                       if(useBoosts && useSupers && !inventory.contains(supDef4)){
                       bank.withdraw(supDef4, amountCmbPots);
                       drinkDef = true;
                      sleep(random(400,600));
                       }
                   if(useBoosts && useSupers == false && !inventory.contains(exAtt4)){
                       bank.withdraw(exAtt4, amountCmbPots);
                       drinkAtt = true;
                      sleep(random(400,600));
                   }
                   if(useBoosts && useSupers == false && !inventory.contains(exStr4)){
                       bank.withdraw(exStr4, amountCmbPots);
                       drinkStr = true;
                      sleep(random(400,600));
                   }
                   if(useBoosts && useSupers == false && !inventory.contains(exDef4)){
                       bank.withdraw(supDef4, amountCmbPots);
                       drinkDef = true;
                      sleep(random(400,600));
                   }
                   if(!inventory.containsOneOf(allItems) && teletab.getStackSize() >=5 && combat.getLifePoints() > skills.getRealLevel(Skills.CONSTITUTION) * 7 && usePrayerPots == false){
                       status = "Filling inventory";
                       bank.withdraw(shark, amountShark);
                       sleep(350,450);
                       
                       bank.close();

                   }else if (usePrayerPots == true){
                       bank.withdraw(shark, amountShark);
                       sleep(350,450);
                       bank.withdraw(fullPrayerPot, amountPPots);
                       sleep(350,450);
                       bank.close();
                   }
               }

               private void walkToMoleHill(){
                   status = "Walking back to moles!";
                   RSTile moleyhills = new RSTile(2985, 3386);
                   RSTile molezhillz = new RSTile(2984, 3387);
                   RSItem shovel = inventory.getItem(spade);
                   RSObject moleHill1 = objects.getTopAt(molezhillz);
                   //int distanceFromHill = calc.distanceTo
                   //walking.walkTo(moleyhills);

                   if(!atHills()){
                        walking.walkTo(moleyhills);
                    }

                   if(atHills() && getMyPlayer().getLocation() == molezhillz){
                   shovel.interact("Dig");
                   sleep(random(3000,5000));
               }
                   if(atHills() && (calc.distanceTo(moleHill1) >0)) {
                       moleHill1.doClick();
                       sleep(1000,1500);
                        }
                      
    }
               private void goDownTunnel(){
                   status = "Digging";
                   RSItem shovel = inventory.getItem(spade);
                   shovel.interact("Dig");
                   sleep(random(3000,5000));
               }

               private void waitForSpawn(){
                   status = "Waiting for mole to spawn...";
                   RSItem sharky = inventory.getItem(shark);
                   RSNPC moley = npcs.getNearest(mole);
                   RSTile locMain = new RSTile(1761, 5186, 7);
                   if(!atMainTunnel() && moley == null){
                       walking.walkTo(locMain);
                   }
                   if(atMainTunnel() && getMyPlayer().getHPPercent() <=85 && moley == null){
                       sharky.interact("eat");
                       sleep(random(600,800));
                   }
                    if(atMainTunnel() && getMyPlayer().getHPPercent() >=85 && moley == null && walking.getEnergy() <=80){
                       walking.rest();
                   }else if(atMainTunnel() && getMyPlayer().getHPPercent() >=85 && moley == null && (walking.getEnergy() >=80 || getMyPlayer().getAnimation() !=-1)){
                       sleep(100);
                   }
                   if(atMainTunnel() && moley !=null){
                       moleLiving = true;
                   }

               }

               public void turnPrayerOn(){
                   if (interfaces.getComponent(749, 1).containsAction("Turn quick prayers on")) {
					interfaces.getComponent(749,1).doClick();
				}
               }
               public void turnPrayerOff(){
               if (interfaces.getComponent(749, 1).containsAction("Turn prayers off")) {
					interfaces.getComponent(749,1).doClick();
				}
               }
                        public void restorePrayer(){
                            RSItem[] prayerpots = inventory.getItems(prayerPotID);
                            RSItem pPotion1 = inventory.getItem(pPot1);
                            RSItem pPotion2 = inventory.getItem(pPot2);
                            RSItem pPotion3 = inventory.getItem(pPot3);
                            RSItem pPotion4 = inventory.getItem(fullPrayerPot);
                            status = "Restoring Prayer";
                                if(pPotion1 !=null){
                                pPotion1.interact("drink");
                                sleep(random(300,500));
                            }else if (pPotion1 == null && pPotion2 !=null){
                                pPotion2.interact("drink");
                                sleep(random(300,500));
                            }else if (pPotion1 == null && pPotion2 == null && pPotion3 !=null){
                                pPotion3.interact("drink");
                                sleep(random(300,500));
                            }else if (pPotion1 == null && pPotion2 == null && pPotion3 == null && pPotion4 !=null){
                                pPotion4.interact("drink");
                                sleep(random(300,500));
                            }else if (pPotion1 == null && pPotion2 == null && pPotion3 == null && pPotion4 ==null){
                                doTeleport = true;
                                }
                        }
               public void doAntiban(){
                   int action = random(0, 2);

            switch (action) {
            case 0:
                status = "Turning camera...";
                camera.setAngle(random(20,150));
                sleep(200, 400);
                break;
            case 1:
                status = "Moving mouse...";
                mouse.moveRandomly(100, 900);
                sleep(200, 400);
                break;
                case 2:
                    mouse.moveOffScreen();
                    sleep(300,600);
                    break;
                   }
               }


               public void drinkPotAtt(){
                            RSItem superA1 = inventory.getItem(supAtt1);
                            RSItem superA2 = inventory.getItem(supAtt2);
                            RSItem superA3 = inventory.getItem(supAtt3);
                            RSItem superA4 = inventory.getItem(supAtt4);
                            RSItem exA1 = inventory.getItem(exAtt1);
                            RSItem exA2 = inventory.getItem(exAtt2);
                            RSItem exA3 = inventory.getItem(exAtt3);
                            RSItem exA4 = inventory.getItem(exAtt4);
                            status = "Drinking";
                            if(useSupers){
                                if(superA1 !=null){
                                superA1.interact("drink");
                                sleep(random(300,500));
                            }else if (superA1 == null && superA2 !=null){
                                superA2.interact("drink");
                                sleep(random(300,500));
                            }else if (superA1 == null && superA2 == null && superA3 !=null){
                                superA3.interact("drink");
                                sleep(random(300,500));
                            }else if (superA1 == null && superA2 == null && superA3 == null && superA4 !=null){
                                superA4.interact("drink");
                                sleep(random(300,500));
                            }else if (superA1 == null && superA2 == null && superA3 == null && superA4 ==null){
                                drinkAtt = false;
                                }
    }
                            if(useSupers == false){
                            if(exA1 !=null){
                                exA1.interact("drink");
                                sleep(random(300,500));
                            }else if (exA1 == null && exA2 !=null){
                                exA2.interact("drink");
                                sleep(random(300,500));
                            }else if (exA1 == null && exA2 == null && exA3 !=null){
                                exA3.interact("drink");
                                sleep(random(300,500));
                            }else if (exA1 == null && exA2 == null && exA3 == null && exA4 !=null){
                               exA4.interact("drink");
                                sleep(random(300,500));
                            }else if (exA1 == null && exA2 == null && exA3 == null && exA4 ==null){
                                drinkStr = false;
                                }
                   }
               }
               public void drinkPotStr(){
                            RSItem superA1 = inventory.getItem(supStr1);
                            RSItem superA2 = inventory.getItem(supStr2);
                            RSItem superA3 = inventory.getItem(supStr3);
                            RSItem superA4 = inventory.getItem(supStr4);
                            RSItem exA1 = inventory.getItem(exStr1);
                            RSItem exA2 = inventory.getItem(exStr2);
                            RSItem exA3 = inventory.getItem(exStr3);
                            RSItem exA4 = inventory.getItem(exStr4);
                            status = "Drinking";
                            if(useSupers == true){
                            if(superA1 !=null){
                                superA1.interact("drink");
                                sleep(random(300,500));
                            }else if (superA1 == null && superA2 !=null){
                                superA2.interact("drink");
                                sleep(random(300,500));
                            }else if (superA1 == null && superA2 == null && superA3 !=null){
                                superA3.interact("drink");
                                sleep(random(300,500));
                            }else if (superA1 == null && superA2 == null && superA3 == null && superA4 !=null){
                                superA4.interact("drink");
                                sleep(random(300,500));
                            }else if (superA1 == null && superA2 == null && superA3 == null && superA4 ==null){
                                drinkDef = false;
                                }
                   }if(useSupers == false){
                            if(exA1 !=null){
                                exA1.interact("drink");
                                sleep(random(300,500));
                            }else if (exA1 == null && exA2 !=null){
                                exA2.interact("drink");
                                sleep(random(300,500));
                            }else if (exA1 == null && exA2 == null && exA3 !=null){
                                exA3.interact("drink");
                                sleep(random(300,500));
                            }else if (exA1 == null && exA2 == null && exA3 == null && exA4 !=null){
                               exA4.interact("drink");
                                sleep(random(300,500));
                            }else if (exA1 == null && exA2 == null && exA3 == null && exA4 ==null){
                                drinkStr = false;
                                }
                   }
               }
               public void drinkPotDef(){
                            RSItem superA1 = inventory.getItem(supDef1);
                            RSItem superA2 = inventory.getItem(supDef2);
                            RSItem superA3 = inventory.getItem(supDef3);
                            RSItem superA4 = inventory.getItem(supDef4);
                            RSItem exA1 = inventory.getItem(exDef1);
                            RSItem exA2 = inventory.getItem(exDef2);
                            RSItem exA3 = inventory.getItem(exDef3);
                            RSItem exA4 = inventory.getItem(exDef4);
                            status = "Drinking";
                            if(useSupers == true){
                            if(superA1 !=null){
                                superA1.interact("drink");
                                sleep(random(300,500));
                            }else if (superA1 == null && superA2 !=null){
                                superA2.interact("drink");
                                sleep(random(300,500));
                            }else if (superA1 == null && superA2 == null && superA3 !=null){
                                superA3.interact("drink");
                                sleep(random(300,500));
                            }else if (superA1 == null && superA2 == null && superA3 == null && superA4 !=null){
                                superA4.interact("drink");
                                sleep(random(300,500));
                            }else if (superA1 == null && superA2 == null && superA3 == null && superA4 ==null){
                                drinkDef = false;
                                }
                   }if(useSupers == false){
                            if(exA1 !=null){
                                exA1.interact("drink");
                                sleep(random(300,500));
                            }else if (exA1 == null && exA2 !=null){
                                exA2.interact("drink");
                                sleep(random(300,500));
                            }else if (exA1 == null && exA2 == null && exA3 !=null){
                                exA3.interact("drink");
                                sleep(random(300,500));
                            }else if (exA1 == null && exA2 == null && exA3 == null && exA4 !=null){
                               exA4.interact("drink");
                                sleep(random(300,500));
                            }else if (exA1 == null && exA2 == null && exA3 == null && exA4 ==null){
                                drinkDef = false;
                                }
                   }
               }
    public void onFinish(){
        log("Please report any bugs to my thread.  If you liked it, be sure to tell me there!");
        status = "Closing";
    }

    public void mouseClicked(MouseEvent e) {
                RSComponent inter = interfaces.get(137).getComponent(0);
                if (inter.getArea().contains(e.getPoint())) {
                    showPaint = !showPaint;
                }
            }
    @Override
    public int loop(){
        loops++;
        RSNPC moley = npcs.getNearest(mole);
        RSGroundItem drops = groundItems.getNearest(allItems);
        RSTile molezhillz = new RSTile(2984, 3387);
        RSGroundItem all = groundItems.getNearest(allItems);
        RSItem[] allinv = inventory.getItems(allItems);
        RSItem sharky = inventory.getItem(shark);
        RSItem teletab = inventory.getItem(teleport);
        RSItem Bones = inventory.getItem(bones);
        RSGroundItem sharke = groundItems.getNearest(shark);
        RSItem prayerFull = inventory.getItem(fullPrayerPot);
        RSItem evial = inventory.getItem(229);
                     if(inventory.contains(bones)){
                                                Bones.interact("Bury");
                                                sleep(random(400,800));
                                            }
        if (atTunnels() && (!getMyPlayer().isInCombat()) && !getMyPlayer().getInteracting().equals(moley) && !(moley == null) && moleLiving == true){
            WhackAMole();
        }
        if (evial != null){
            evial.interact("Drop");
        }
        if (atTunnels() && (drops != null) && !inventory.isFull()){
            lootMethod();
        }
        if (atTunnels() && (drops !=null) && inventory.isFull() && sharky !=null){
            sharky.interact("Eat");
        }
        if(atTunnels() && drops !=null && inventory.isFull() && sharky == null){
            doTeleport = true;
        }
        if(doTeleport == true && sharky == null){
            teletab.interact("Break");
            sleep(random(1500,2000));
            doTeleport = false;
        }
        if (atTunnels() &&(moley == null) && drops == null&& moleLiving == true){
            searchCaves();
        }
        if ((atTunnels() && getMyPlayer().getHPPercent() <=50)|| doTeleport == true){
            healMethod();
        }
        if (moley !=null && usePrayerPots == true && prayer.isQuickPrayerOn() == false){
            turnPrayerOn();
        }
        if (moley == null && prayer.isQuickPrayerOn() == true && usePrayerPots == true){
            turnPrayerOff();
        }
        if (atFalador() && (!inventory.containsOneOf(foodIDs) || prayerFull ==null)){
            walkToBank();
        }
        if (atTunnels() && usePrayerPots == true && prayer.getPrayerLeft() <=25 ){
            restorePrayer();
        }//figure out prayer level line
        if (atBank() && bank.isOpen()){
            bankingMethod();
        }
        if (atFalador() && inventory.contains(shark) && !bank.isOpen() && !(getMyPlayer().getLocation() == molezhillz)){
            walkToMoleHill();
        }
        if (atFalador() && inventory.contains(shark) && !bank.isOpen() && (calc.distanceTo(molezhillz) == 0)){
            goDownTunnel();
        }
        if (all ==null && sharke == null && moleLiving == false && atTunnels() && drops ==null){
            waitForSpawn();
        }
        if(atTunnels() && useBoosts && drinkStr && skills.getRealLevel(Skills.STRENGTH)+(1) >= skills.getCurrentLevel(Skills.STRENGTH)){
        drinkPotStr();
        }
        if(atTunnels() && useBoosts && drinkDef && skills.getRealLevel(Skills.DEFENSE)+(1) >= skills.getCurrentLevel(Skills.DEFENSE)){
        drinkPotDef();
        }
        if(atTunnels() && useBoosts &&drinkAtt && skills.getRealLevel(Skills.ATTACK)+(1) >= skills.getCurrentLevel(Skills.ATTACK)){
        drinkPotAtt();
        }
        if(moley !=null && moleLiving != true){
            moleLiving = true;
        }
        if (!walking.isRunEnabled() && walking.getEnergy() > 50) {
			walking.setRun(true);
                        sleep(random(300,500));
            }
        if (loops % 10 == 0) {
                doAntiban();
            }
        

        return 200;
    }
        //START: Code generated using Enfilade's Easel
    private Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch(IOException e) {
            return null;
        }
    }

    private final Color color1 = new Color(0, 0, 0);
    private final Color color2 = new Color(199, 2, 2);
    private final Color color3 = new Color(157, 10, 10);
    private final Color color4 = new Color(156, 11, 11);

    private final BasicStroke stroke1 = new BasicStroke(2);
    private final BasicStroke stroke2 = new BasicStroke(4);

    private final Font font1 = new Font("Arial", 0, 20);
    private final Font font2 = new Font("Arial", 0, 15);
    private final Font font3 = new Font("Arial", 0, 12);

    private final Image img1 = getImage("http://img96.imageshack.us/img96/3415/moley.png");
    private final Image img2 = getImage("http://img830.imageshack.us/img830/4753/babymole.th.png");

    public void onRepaint(Graphics g1) {
        if(showPaint){
        Graphics2D g = (Graphics2D)g1;
        millis = System.currentTimeMillis() - startTime;
            hours = millis / (1000 * 60 * 60);
            millis -= hours * (1000 * 60 * 60);
            minutes = millis / (1000 * 60);
            millis -= minutes * (1000 * 60);
            seconds = millis / 1000;

        g.setColor(color1);
        g.fillRect(1, 336, 517, 142);
        g.setColor(color2);
        g.setStroke(stroke1);
        g.drawRect(1, 336, 517, 142);
        g.drawImage(img1, 347, 387, null);
        g.setColor(color1);
        g.fillRect(337, 334, 181, 51);
        g.setColor(color2);
        g.drawRect(337, 334, 181, 51);
        g.setStroke(stroke2);
        g.drawRect(0, 335, 519, 144);
        g.setFont(font1);
        g.setColor(color3);
        g.drawString("Sniper's Mole Killer", 341, 361);
        g.setFont(font2);
        g.drawString("Made By Sniperkid1", 380, 377);
        g.setFont(font3);
        g.setColor(color4);
        g.drawString("Time Ran : " + hours +" : "+ minutes + " : " + seconds, 11, 353);
        g.drawString("GP Gained : " + profit, 11, 374);
        g.drawString("GP/Hour : "+(int) (profit * 3600000D / (System.currentTimeMillis() - startTime)), 11, 395);
        g.drawImage(img2, 305, 418, null);
        g.drawImage(img2, 453, 391, null);
        g.drawImage(img2, 466, 432, null);
        g.drawString("Kills : " + kills, 11, 416);
        g.drawString("Kills/Hour : "+(int) (kills * 3600000D / (System.currentTimeMillis() - startTime)), 11, 437);
        g.drawString("Status = " + status, 11, 458);
    }}
public class GUIMole extends javax.swing.JFrame {

    /** Creates new form GUIMole */
    public GUIMole() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sharkField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PrayerField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        boostsComboBox = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        amountOfPotsBox = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 255));

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No" }));

        jLabel1.setText("Pickup Charms?");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sharks ONLY", "Prayer Pots(4) and sharks" }));

        jLabel2.setText("Method To Use");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel4.setText("Sniperkid's Mole Killer");

        sharkField.setText("2");

        jLabel5.setText("# of Sharks");

        jLabel6.setText("# of Prayer Pots");

        PrayerField.setText("3");

        jLabel7.setText("(If using prayer method)");

        jLabel8.setText("(2 recommended for prayer)");

        jLabel9.setText("(14+ recommended without)");

        jLabel10.setText("Use any Boosts?");

        boostsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Super Pots (Att, Str, Def)", "Extremes (Att, Str, Def)" }));

        jLabel11.setText("How many of each to Bring?");

        amountOfPotsBox.setText("1");

        jLabel12.setText("By choosing \"1\" The bot will bring 1 attack, strength,");

        jLabel13.setText("and defence potion.  This should be all you need.");

        jLabel14.setText("Note: If you would like to use quickprayer, you MUST");

        jLabel15.setText("select \"prayer pots(4) and sharks\"  If you select \"Sharks ONLY,\"");

        jLabel16.setText("Quickprayer will not activate");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PrayerField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel14))
                                .addGap(92, 92, 92)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(42, 42, 42)
                                        .addComponent(amountOfPotsBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(30, 30, 30)
                                        .addComponent(boostsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(sharkField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)))
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(startButton)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(boostsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(amountOfPotsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(sharkField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(PrayerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(startButton)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {
       String pickCharms = jComboBox1.getSelectedItem().toString();
       String potions = jComboBox2.getSelectedItem().toString();
       amountShark = Integer.parseInt(sharkField.getText().split(" ")[0]);
       amountPPots = Integer.parseInt(PrayerField.getText().split(" ")[0]);
       String cmbPots = boostsComboBox.getSelectedItem().toString();
       amountCmbPots = Integer.parseInt(amountOfPotsBox.getText().split(" ")[0]);
        if(pickCharms.equals("Yes")){
            lootCharms = true;
        }else{
            lootCharms = false;
        }//who should let it make it to a INT wait lemme try something
       if(potions.equals("Sharks ONLY")){
           usePrayerPots = false;
       }else{// if(potions.equals("Prayer Pots(4)")){
           usePrayerPots = true;
       }
       if(cmbPots.equals("None")){
           useBoosts = false;
           drinkStr = false;
           drinkAtt = false;
           drinkDef = false;
           useSupers = false;
       }
        else if(cmbPots.equals("Super Pots (Att, Str, Def)"))
        {
           useBoosts = true;
           drinkStr = true;
           drinkAtt = true;
           drinkDef = true;
           useSupers = true;
       }else{
           useBoosts = true;
           drinkStr = true;
           drinkAtt = true;
           drinkDef = true;
           useSupers = false;
       }
        guiWait = false;
        g.dispose();
    }


    /**
    * @param args the command line arguments
    */

    }

        // Variables declaration - do not modify
    private javax.swing.JTextField PrayerField;
    private javax.swing.JTextField amountOfPotsBox;
    private javax.swing.JComboBox boostsComboBox;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField sharkField;
    private javax.swing.JButton startButton;
    // End of variables declaration


    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}