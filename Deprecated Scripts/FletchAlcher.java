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
import org.rsbot.script.methods.Game.Tab;
import org.rsbot.script.wrappers.*;
import org.rsbot.script.methods.*;

@ScriptManifest(authors = "sniperkid1", name = "SnipersFletchAlcher", version = 1.20, description = "Settings in GUI.")
    public class SnipersFletchAlcher extends Script implements PaintListener{

    boolean GUIWait = true;
    GUIFletchAlch g = new GUIFletchAlch();
    public boolean onStart() {
        log("Welcome");
        startTime = System.currentTimeMillis();
        startExp = skills.getCurrentExp(skills.MAGIC);
        startExp2 = skills.getCurrentExp(skills.FLETCHING);
        g.setVisible(true);
        while(GUIWait) sleep(500);
        return true;
    }
    boolean useStringing;
    public int bowToUse;
    public boolean longBow15;
    public boolean shortBow14;
    public boolean nshortBow15;
    public boolean nlongBow16;
public long startTime = 0;
         public long millis = 0;
         public long hours = 0;
         public long minutes = 0;
         public long seconds = 0;
         public long last = 0;
         public int expGained = 0;
         public int startExp;
         public int expGained2 = 0;
         public int startExp2;
    int loops = 0;
    int normShort =841;
    int normLong = 839;
    int oakShort =843;
    int oakLong =845;
    int willowShort =849;
    int willowLong =847;
    int mapleShort =853;
    int mapleLong =851;
    int yewShort =857;
    int yewLong =855;
    int magicShort =861;
    int magicLong =859;
    public int logsToUse;
    int normLogs = 1511;
    int oakLogs= 1521;
    int willowLogs = 1519;
    int mapleLogs = 1517;
    int yewLogs =1515;
    int magicLogs = 1513;
    //getIDS
    int unormShort =50;
    int unormLong = 48;
    int uoakShort =54;
    int uoakLong =56;
    int uwillowShort =60;
    int uwillowLong =58;
    int umapleShort =64;
    int umapleLong =62;
    int uyewShort =68;
    int uyewLong =66;
    int umagicShort =72;
    int umagicLong =70;
    public int unstrungBow;
    int bowString = 1777;
    int natureRunes = 561;
    int knifeID = 946;
    int coins = 995;
    int bowsCompleted = 0;
    //endIDS

    public void cutLogs(){
        RSItem logs = inventory.getItem(logsToUse);
        RSItem knife = inventory.getItem(knifeID);
        if(getMyPlayer().isIdle() && (!interfaces.getComponent(905,14).isValid()||!interfaces.getComponent(905,15).isValid()||!interfaces.getComponent(905,16).isValid())){
            logs.doClick(true);
            sleep(300,500);
            knife.doClick(true);
            sleep(random(1000,1400));}
        if(interfaces.getComponent(905,14).isValid() && (shortBow14)){
            interfaces.getComponent(905,14).doClick(true);
            sleep(random(1500,2000));
        }else if(interfaces.getComponent(905,15).isValid() && (longBow15 || nshortBow15)){
            interfaces.getComponent(905, 15).doClick(true);
            sleep(random(1500,2000));
        }else if(interfaces.getComponent(905, 16).isValid() && (nlongBow16)){
            interfaces.getComponent(905,16).doClick(true);
            sleep(random(1500,2000));
        }
    }
                public void stringBows(){
                   RSItem ubow = inventory.getItem(unstrungBow);
                   RSItem bstring = inventory.getItem(bowString);
                   RSItem strungbow = inventory.getItem(bowToUse);
                if(getMyPlayer().isIdle() && !interfaces.getComponent(905, 14).isValid() && strungbow == null){
                    ubow.doClick(true);
                    sleep(300,500);
                    bstring.doClick(true);
                    sleep(1000,1500);
                }
                   if(interfaces.getComponent(905,14).isValid()){
                       interfaces.getComponent(905,14).doClick(true);
                       sleep(1500,2000);
                   }
                }

                public void openBank(){
                            bank.open();
                            sleep(random(700,1000));
                        }

                        public void bank(){
                            if(bank.getCount(knifeID) <1){
                                log("You do not have a knife to fletch with. Get a knife.");
                                stopScript();
                            }
                            if(bank.getCount(natureRunes) <13 || inventory.getItem(natureRunes).getStackSize() <13){
                                log("You do not enough nature runes. Stopping Script");
                                stopScript();
                            }
                            if(bank.getCount(logsToUse) <13){
                                log("You do not have enough logs.  Stopping Script");
                                stopScript();
                            }
                            if(bank.getCount(bowString) <13){
                                log("You do not have enough bow strings.  Stopping Script");
                                stopScript();
                            }
                        if(bank.isOpen() && (inventory.contains(coins) || inventory.getCount(logsToUse) >13 || inventory.getCount(bowString) > 13)){
                            bank.depositAllExcept(knifeID, natureRunes);
                            sleep(random(500,700));
                        }
                        if(!inventory.contains(knifeID)){
                            bank.withdraw(knifeID, 1);
                            sleep(random(300,500));
                        }
                        if(!inventory.contains(natureRunes)){
                            bank.withdraw(natureRunes, 1000);
                        }
                        if(bank.isOpen() && !inventory.containsOneOf(logsToUse, coins)){
                            bank.withdraw(logsToUse, 13);
                            sleep(random(300,500));
                            }
                        if(bank.isOpen() && !inventory.containsOneOf(bowString, coins)){
                            bank.withdraw(bowString, 13);
                            sleep(random(500,700));
                        }
                        if(bank.isOpen() && inventory.contains(logsToUse) && inventory.contains(knifeID) && inventory.contains(bowString)){
                            bank.close();
                        }
                        }

                                public void alchBows(){
                                    
                                    if(magic.isSpellSelected() == false){
                                        magic.castSpell(Magic.Spell.HIGH_LEVEL_ALCHEMY);
                                        sleep(random(500,600));
                                    }
                                    if(magic.isSpellSelected() && game.getTab() == Tab.INVENTORY){
                                        try{
                                            RSItem bowToAlch = inventory.getItem(bowToUse);
                                        bowToAlch.doClick(true);
                                        bowsCompleted++;
                                        }catch (NullPointerException e){
                                    }
                                }
                                  }
                        public void alchUBows(){
                            if(magic.isSpellSelected() == false){
                                        magic.castSpell(Magic.Spell.HIGH_LEVEL_ALCHEMY);
                                        sleep(random(500,600));
                                    }
                                    if(magic.isSpellSelected() && game.getTab() == Tab.INVENTORY){
                                        try{
                                            RSItem bowToAlch = inventory.getItem(unstrungBow);
                                        bowToAlch.doClick(true);
                                        bowsCompleted++;
                                        }catch (NullPointerException e){
                                    }
                                }
                                  }
                        
                 public void doAntiban(){
                   int action = random(0, 2);

            switch (action) {
            case 0:
               // status = "Turning camera...";
                camera.setAngle(random(20,150));
                sleep(200, 400);
                break;
            case 1:
                //status = "Moving mouse...";
                mouse.moveRandomly(100, 900);
                sleep(200, 400);
                break;
                case 2:
                    mouse.moveOffScreen();
                    sleep(300,600);
                    break;
                   }
               }
    public void onFinish() {
        log("Thanks");
    }
    
    @Override
    public int loop(){
        loops++;
        RSItem logs = inventory.getItem(logsToUse);
        RSItem uBows = inventory.getItem(unstrungBow);
        RSItem bStrings = inventory.getItem(bowString);
        RSItem strungBows = inventory.getItem(bowToUse);
        RSItem nats = inventory.getItem(natureRunes);
        if(logs !=null && !bank.isOpen() && inventory.contains(knifeID)){
            cutLogs();
        }
        if(logs == null && uBows != null && bStrings !=null && useStringing == true){
            stringBows();
        }
        if(logs == null && uBows == null && strungBows !=null && nats !=null){
            alchBows();
        }
        if(logs == null && uBows !=null && useStringing == false && nats !=null){
            alchUBows();
        }
        if(logs == null && uBows == null && strungBows == null && !bank.isOpen() && GUIWait == false){
            openBank();
        }
        if(bank.isOpen()){
            bank();
        }
        if(!inventory.contains(knifeID)){
            bank.open();
        }
        if(inventory.getCount(logsToUse) > 13 && !bank.isOpen()){
            bank.open();
        }
        if(inventory.getCount(bowString) > 13 && !bank.isOpen()){
            bank.open();
        }
        if(nats == null){
            bank.open();
        }
        if(loops % 10 == 0){
            doAntiban();
        }

        return 200;
    }

        private Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch(IOException e) {
            return null;
        }
    }

    private final Color color1 = new Color(0, 0, 102, 151);
    private final Color color2 = new Color(0, 0, 0);
    private final Color color3 = new Color(0, 255, 255);

    private final BasicStroke stroke1 = new BasicStroke(4);

    private final Font font1 = new Font("Copperplate Gothic Light", 3, 15);
    private final Font font2 = new Font("Copperplate Gothic Light", 3, 10);

    private final Image img1 = getImage("http://www.tip.it/runescape/img2/knife_transp.gif");

    public void onRepaint(Graphics g1) {
        Graphics2D g = (Graphics2D)g1;

        expGained = skills.getCurrentExp(skills.MAGIC) - startExp;
        expGained2 = skills.getCurrentExp(skills.FLETCHING) - startExp2;
        millis = System.currentTimeMillis() - startTime;
            hours = millis / (1000 * 60 * 60);
            millis -= hours * (1000 * 60 * 60);
            minutes = millis / (1000 * 60);
            millis -= minutes * (1000 * 60);
            seconds = millis / 1000;
        g.setColor(color1);
        g.fillRoundRect(289, 2, 227, 110, 16, 16);
        g.setColor(color2);
        g.setStroke(stroke1);
        g.drawRoundRect(289, 2, 227, 110, 16, 16);
        g.setFont(font1);
        g.setColor(color3);
        g.drawString("Sniper's Fletch Alcher", 300, 22);
        g.setFont(font2);
        g.drawString("Fletching XP: " + (int) expGained2 + " (" +(int) (expGained2 * 3600000D / (System.currentTimeMillis() - startTime))+"/hr)", 302, 58);
        g.drawString("Time Ran: " + hours +" : "+ minutes + " : " + seconds, 303, 41);
        g.drawString("Magic XP: " + (int) expGained + " ("+(int) (expGained * 3600000D / (System.currentTimeMillis() - startTime))+"/hr)", 303, 75);
        g.drawString("Bows Completed:" + bowsCompleted, 302, 92);
        g.drawImage(img1, 483, 73, null);
    }

class GUIFletchAlch extends javax.swing.JFrame {

    /** Creates new form GUIFletchAlch */
    public GUIFletchAlch() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bowComboBox = new javax.swing.JComboBox();
        StringCheckBox = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        StartButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Sniper's Fletch Alcher");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Bow to Make");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Before Starting:");

        bowComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Magic Longbow", "Normal Shortbow", "Normal Longbow", "Oak Shortbow", "Oak Longbow", "Willow Shortbow", "Willow Longbow", "Maple Shortbow", "Maple Longbow", "Yew Shortbow", "Yew Longbow", "Magic Shortbow", " " }));


        StringCheckBox.setBackground(new java.awt.Color(102, 102, 102));
        StringCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        StringCheckBox.setForeground(new java.awt.Color(204, 204, 204));
        StringCheckBox.setSelected(true);
        StringCheckBox.setText("String before alching?");


        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("-Have a knife and however many nature runes you need in your inventory.");

        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("-Be holding some form of fire staff (bot doesn't check for it, it is required to work though)");

        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("-Have all logs and bowstrings visible in bank to speed up the experience an hour");

        StartButton.setBackground(new java.awt.Color(102, 102, 102));
        StartButton.setText("Start");
        StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(89, 89, 89))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bowComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(StringCheckBox)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(170, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StartButton, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StringCheckBox)
                    .addComponent(bowComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(6, 6, 6)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StartButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>



    private void StartButtonActionPerformed(java.awt.event.ActionEvent evt) {
     String bowToFletch = bowComboBox.getSelectedItem().toString();

        if(StringCheckBox.isSelected()){
            useStringing = true;
        }else{
         useStringing = false;
        }
     if(bowToFletch.equals("Normal Shortbow")){
         bowToUse = normShort;
         logsToUse = normLogs;
         unstrungBow = unormShort;
         nlongBow16 = false;
         nshortBow15 = true;
         shortBow14 = false;
         longBow15 = false;
     }
     if(bowToFletch.equals("Normal Longbow")){
         bowToUse = normLong;
         logsToUse = normLogs;
         unstrungBow = unormLong;
         nlongBow16 = true;
         nshortBow15 = false;
         shortBow14 = false;
         longBow15 = false;
     }
     if(bowToFletch.equals("Oak Shortbow")){
         bowToUse = oakShort;
         logsToUse = oakLogs;
         unstrungBow = uoakShort;
         nlongBow16 = false;
         nshortBow15 = false;
         shortBow14 = true;
         longBow15 = false;
     }
     if(bowToFletch.equals("Oak Longbow")){
         bowToUse = oakLong;
         logsToUse = oakLogs;
         unstrungBow = uoakLong;
         nlongBow16 = false;
         nshortBow15 = false;
         shortBow14 = false;
         longBow15 = true;
     }
     if(bowToFletch.equals("Willow Shortbow")){
         bowToUse = willowShort;
         logsToUse = willowLogs;
         unstrungBow = uwillowShort;
         nlongBow16 = false;
         nshortBow15 = false;
         shortBow14 = true;
         longBow15 = false;
     }
     if(bowToFletch.equals("Willow Longbow")){
         bowToUse = willowLong;
         logsToUse = willowLogs;
         unstrungBow = uwillowLong;
         nlongBow16 = false;
         nshortBow15 = false;
         shortBow14 = false;
         longBow15 = true;
     }
     if(bowToFletch.equals("Maple Shortbow")){
         bowToUse = mapleShort;
         logsToUse = mapleLogs;
         unstrungBow = umapleShort;
         nlongBow16 = false;
         nshortBow15 = false;
         shortBow14 = true;
         longBow15 = false;
     }
     if(bowToFletch.equals("Maple Longbow")){
         bowToUse = mapleLong;
         logsToUse = mapleLogs;
         unstrungBow = umapleLong;
         nlongBow16 = false;
         nshortBow15 = false;
         shortBow14 = false;
         longBow15 = true;
     }
     if(bowToFletch.equals("Yew Shortbow")){
         bowToUse = yewShort;
         logsToUse = yewLogs;
         unstrungBow = uyewShort;
         nlongBow16 = false;
         nshortBow15 = false;
         shortBow14 = true;
         longBow15 = false;
     }
     if(bowToFletch.equals("Yew Longbow")){
         bowToUse = yewLong;
         logsToUse = yewLogs;
         unstrungBow = uyewLong;
         nlongBow16 = false;
         nshortBow15 = false;
         shortBow14 = false;
         longBow15 = true;
     }
     if(bowToFletch.equals("Magic Shortbow")){
         bowToUse = magicShort;
         logsToUse = magicLogs;
         unstrungBow = umagicShort;
         nlongBow16 = false;
         nshortBow15 = false;
         shortBow14 = true;
         longBow15 = false;
     }
     if(bowToFletch.equals("Magic Longbow")){
         bowToUse = magicLong;
         logsToUse = magicLogs;
         unstrungBow = umagicLong;
         nlongBow16 = false;
         nshortBow15 = false;
         shortBow14 = false;
         longBow15 = true;
     }
     GUIWait = false;
     g.dispose();
    }


    // Variables declaration - do not modify
    private javax.swing.JButton StartButton;
    private javax.swing.JCheckBox StringCheckBox;
    private javax.swing.JComboBox bowComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration

}

}