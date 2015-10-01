import java.util.Map;
import org.rsbot.script.Script;
import org.rsbot.script.ScriptManifest;
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

@ScriptManifest(authors = "sniperkid1", name = "KebabBuyer", version = 1.0, description = "Buys kebabs from man in Al-Kharid")
    public class KebabBuyer extends Script implements PaintListener, MessageListener{

    public boolean onStart(){
        itemPrice = grandExchange.loadItemInfo(1971).getMarketPrice();
        startTime = System.currentTimeMillis();
        profit = (kebabs * itemPrice);
        log("welcome to my kebab buyer.  have gold in inventory and start at the man");
        return true;
    }

         int sellerID = 543;
         int kebabID = 1971;
         RSTile[] manToBank = {new RSTile(3271, 3169)};
         RSTile[] backToMan = {new RSTile(3274, 3180)};
         int bankBoothID = 35647;
         int coinsID = 995;
         private int profit;
         private int kebabs =0;
         public long startTime = 0;
         public long millis = 0;
         public long hours = 0;
         public long minutes = 0;
         public long seconds = 0;
         public long last = 0;
         private Timer runTime;
         private int itemPrice;

                        private void buyKebab(){
                                RSNPC man = npcs.getNearest(sellerID);
                                    if (!interfaces.getComponent(241, 5).isValid()) {
                                    man.doAction("Talk-to");
                                    sleep(1600,2000);
                                    }
                                    if (interfaces.getComponent(241, 5).isValid()) {
                                    interfaces.getComponent(241, 5).doClick();
                                    sleep(1000,1100);
                                    }
                                 if (interfaces.getComponent(228, 3).isValid()){
                                interfaces.getComponent(228, 3).doClick();
                                sleep(1400,1600);
                            }
                           if (interfaces.getComponent(64, 5).isValid()){
                               interfaces.getComponent(64, 5).doClick();
                               sleep(200,400);
                            }
                            }
                             
                                    private boolean walkBank() {
                                            RSTile[] randomizedPath = walking.randomizePath(manToBank, 0, 2);
                                            return walking.walkPathMM(randomizedPath, 0, 2);
                                          }
                                            private boolean atMan() {
                                                RSArea area = new RSArea(new RSTile(3268, 3177), new RSTile(3276, 3184));
                                                return area.contains(getMyPlayer().getLocation());
                                            }
                                                    private boolean atBank() {
                                                        RSArea area = new RSArea(new RSTile(3269, 3164), new RSTile(3271, 3172));
                                                        return area.contains(getMyPlayer().getLocation());
                                                    }
                                                        private void banking() {
                                                             RSObject bankBooth = objects.getNearest(bankBoothID);
                                                             if (bankBooth != null && !bank.isOpen()) {
                                                             bankBooth.doAction("uickly");
                                                             sleep(500,700);
                                                             if(bank.isOpen()){
                                                                    bank.depositAllExcept(coinsID);
                                                                    sleep(1000, 1800);
                                                                    }
                                                                    if(!bank.isOpen()){
                                                                        banking();}

                                                             }
                                                                       
                                                                        }
                                                            
                                                                    
                                                                    private void closeBank() {
                                                                        if(bank.isOpen()){
                                                                        mouse.move(490, 36, 3, 3);
                                                                        mouse.click(true);
                                                                        sleep(150,200);
                                                                        }
                                                                        }
                                                                            private void bank() {
                                                                                banking();
                                                                                closeBank();
                                                                            }
                                                         private boolean walkMan() {
                                            RSTile[] randomizedPath = walking.randomizePath(backToMan, 0, 1);
                                            return walking.walkPathMM(backToMan, 0, 2);
                                                                  }

                                    public void onFinish(){
                                    log("thanks for coming!");
                                        
                                        }
                                                                          //START: Code generated using Enfilade's Easel
    private final Color color1 = new Color(51, 102, 0, 155);
    private final Color color2 = new Color(0, 102, 51, 152);
    private final Color color3 = new Color(255, 255, 255);

    private final BasicStroke stroke1 = new BasicStroke(1);

    private final Font font1 = new Font("Impact", 0, 14);
    private final Font font2 = new Font("Impact", 0, 22);
    private final Font font3 = new Font("Arial Black", 0, 13);

    public void onRepaint(Graphics g1) {
        Graphics2D g = (Graphics2D)g1;
            millis = System.currentTimeMillis() - startTime;
            hours = millis / (1000 * 60 * 60);
            millis -= hours * (1000 * 60 * 60);
            minutes = millis / (1000 * 60);
            millis -= minutes * (1000 * 60);
            seconds = millis / 1000;
        g.setColor(color1);
        g.fillRect(3, 341, 516, 138);
        g.setColor(color2);
        g.setStroke(stroke1);
        g.drawRect(3, 341, 516, 138);
        g.setFont(font1);
        g.setColor(color3);
        g.drawString("Made By Sniperkid1", 323, 399);
        g.setFont(font2);
        g.drawString("Kebab Buyer", 249, 375);
        g.setFont(font3);
        g.drawString("Time ran - " + hours +":"+ minutes + ":" + seconds, 18, 373);
        g.drawString("Profit (gp) - " + (itemPrice * kebabs), 16, 451);
        g.drawString("Kebabs Bought - " + kebabs, 17, 412);

    }
    //END: Code generated using Enfilade's Easel
                            @Override
                            public int loop(){
                                if (atMan() && inventory.isFull()){
                                    walkBank();
                                }
                                if (atMan() && !inventory.isFull()){
                                    buyKebab();
                                }
                                 if(atBank() && inventory.isFull()){
                                     bank();
                                }
                                 if(atBank() && !inventory.isFull()){
                                     walkMan();
                                 }

                                       return 2000;
                                }
                                      public void messageReceived(MessageEvent e) {
                                        String x = e.getMessage().toLowerCase();
                                        if (x.contains("buy a kebab.")){
                                         kebabs++;
    }
  }
}


 // public void serverMessageRecieved(ServerMessageEvent e) {
 //                                       if (e.getMessage().contains("You buy")) {
   //                                      kebabs++;
 //                                       }
  //  }