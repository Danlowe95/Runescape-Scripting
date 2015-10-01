import java.util.Map;
import org.rsbot.script.Script;
import org.rsbot.script.ScriptManifest;
import org.rsbot.script.wrappers.RSObject;
import org.rsbot.script.wrappers.RSTile;
import org.rsbot.script.wrappers.RSArea;
import org.rsbot.script.wrappers.RSNPC;
import org.rsbot.script.wrappers.RSTilePath;
import java.awt.*;
import org.rsbot.event.events.MessageEvent;
import org.rsbot.event.listeners.MessageListener;
import org.rsbot.event.listeners.PaintListener;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import org.rsbot.script.wrappers.*;
import java.util.regex.Pattern;
import org.rsbot.script.methods.GrandExchange.GEItem;
import org.rsbot.script.methods.*;

@ScriptManifest(authors = "sniperkid1", name = "SniperFlaxer", version = 1.00, description = "Picks Flax at Seer's Village.")
    public class SniperFlaxer extends Script implements PaintListener, MessageListener{

    public boolean onStart() {
        log("Starting Flaxer-Prepare for Epicness");
                startTime = System.currentTimeMillis();
                guidePrice = grandExchange.lookup(1779).getGuidePrice();
        return true;
    }
    int guidePrice;
    int flaxID =2646;
    int bankBoothID=25808;
    int flaxInv=1779;
    int loops = 0;
    int flaxPicked = 0;
        private int profit;
         public long startTime = 0;
         public long millis = 0;
         public long hours = 0;
         public long minutes = 0;
         public long seconds = 0;
         public long last = 0;
         private int itemPrice;
    RSTile[] flaxToBank = { new RSTile(2730, 3453), new RSTile(2726,3459),
    new RSTile(2725,3464), new RSTile(2723,3473), new RSTile(2725,3481),
    new RSTile(2725,3489),  new RSTile(2726,3493)};

                            private void bank(){
                                RSObject bankBooth = objects.getNearest(bankBoothID);
                               if(!bank.isOpen() && inventory.isFull()){
                                bankBooth.doAction("Use-quickly");
                                sleep(random(2000,2600));
                            }
                               if(bank.isOpen() && inventory.isFull()){
                                   bank.depositAll();
                                   sleep(random(400,600));
                               }
                               //if(bank.isOpen() && !inventory.isFull()){
                                  // bank.close();
                                  // sleep(random(300,600));
                               }//}
                               private void walkBank(){
                                   walking.walkTo(new RSTile(2726,3493));
                               }
                            private boolean atField() {
                                        RSArea area = new RSArea(new RSTile(2735, 3436), new RSTile(2751, 3451));
                                        return area.contains(getMyPlayer().getLocation());
                                                }
                            private void walkField(){
                                   walking.walkTo(new RSTile(2739,3439, 2));
                               }
                            private boolean atBank() {
                                        RSArea area = new RSArea(new RSTile(2719, 3487), new RSTile(2731, 3494));
                                        return area.contains(getMyPlayer().getLocation());
                                                    }
                            private void pickFlax(){
                                RSObject flax = objects.getNearest(flaxID);
                                flax.doClick();
                                sleep(200,350);
                            }

        public void onFinish(){
        log("Thanks for using my script! any bugs please report at glowbotting.com");
    }


    @Override
       
        public int loop() {
        loops++;
        if(atField() && inventory.isFull()){
            walkBank();
        }
        if(!atBank() && inventory.isFull()){
            walkBank();
        }
        //if(atField() && !inventory.isFull()){
        //    pickFlax();
        //}
        if(atBank() && inventory.isFull()){
            bank();
        }
        if(atBank() && !inventory.isFull()){
            walkField();
        }
        if(!atBank() && !atField() && !inventory.isFull()){
            walkField();
        }
        if(atField() && !inventory.isFull()){
            pickFlax();
        }
        if(bank.isOpen() && !inventory.isFull()){
            walkField();
        }
            if (loops % 10 == 0) {
                camera.setAngle(random(20,150));
            }
                    if (!walking.isRunEnabled() && walking.getEnergy() > 40) {
			walking.setRun(true);
        }
        return 200;
    }
          public void messageReceived(MessageEvent e) {
                                        String x = e.getMessage().toLowerCase();
                                        if (x.contains("ou pick some")){
                                         flaxPicked++;
              }}
        //START: Code generated using Enfilade's Easel
    private Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch(IOException e) {
            return null;
        }
    }

    private final Color color1 = new Color(0, 153, 0, 130);
    private final Color color2 = new Color(0, 204, 204);
    private final Color color3 = new Color(0, 0, 0);

    private final BasicStroke stroke1 = new BasicStroke(5);

    private final Font font1 = new Font("Courier New", 1, 28);
    private final Font font2 = new Font("Courier New", 1, 19);

    private final Image img1 = getImage("http://www.global-rs.com/img/flax.gif");

    public void onRepaint(Graphics g1) {
        Graphics2D g = (Graphics2D)g1;
                millis = System.currentTimeMillis() - startTime;
            hours = millis / (1000 * 60 * 60);
            millis -= hours * (1000 * 60 * 60);
            minutes = millis / (1000 * 60);
            millis -= minutes * (1000 * 60);
            seconds = millis / 1000;
        g.setColor(color1);
        g.fillRoundRect(2, 337, 515, 138, 16, 16);
        g.setColor(color2);
        g.setStroke(stroke1);
        g.drawRoundRect(2, 337, 515, 138, 16, 16);
        g.setFont(font1);
        g.setColor(color3);
        g.drawString("Sniper's Flaxer", 132, 414);
        g.setFont(font2);
        g.drawString("Created by Sniperkid1", 142, 434);
        g.drawString("Time Ran: " + hours +" : "+ minutes + " : " + seconds, 14, 366);
        g.drawString("Flax Picked: " + flaxPicked, 290, 366);
        g.drawString("Profit: " + (guidePrice*flaxPicked), 168, 458);
        g.drawImage(img1, 13, 363, null);
        g.drawImage(img1, 103, 410, null);
        g.drawImage(img1, 3, 423, null);
        g.drawImage(img1, 524, 120, null);
        g.drawImage(img1, 704, 49, null);
        g.drawImage(img1, 687, 11, null);
        g.drawImage(img1, 373, 409, null);
        g.drawImage(img1, 479, 422, null);
        g.drawImage(img1, 113, 362, null);
        g.drawImage(img1, 223, 361, null);
        g.drawImage(img1, 325, 362, null);
        g.drawImage(img1, 434, 362, null);
        g.drawImage(img1, 703, 90, null);
        g.drawImage(img1, 522, 3, null);
    }
    //END: Code generated using Enfilade's Easel
}