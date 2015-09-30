package RS3.Miner;

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
//the rt6 package is for RS3. For OSRS scripts, you would use the rt4 package.
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
/**
 * Created by user on 9/30/2015.
 */
public class Bank extends Task<ClientContext> {

    private HelperFunctions hf = new HelperFunctions();
    public Bank(ClientContext ctx){
        super(ctx);
    }
    @Override
    public boolean activate() {
        return ctx.backpack.select().count() == 28 && hf.atBank();

    }

    @Override
    public void execute() {
            final GameObject bank = ctx.objects.select(36786).nearest().poll();
            if (!ctx.bank.open()) {
                bank.interact("Bank");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
            }
            if (ctx.bank.open()) {
                ctx.bank.depositInventory();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {

                }
                ctx.bank.close();
            }

    }
}
