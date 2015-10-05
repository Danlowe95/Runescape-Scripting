package RS3.Miner;

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
//the rt6 package is for RS3. For OSRS scripts, you would use the rt4 package.
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.Tile;
/**
 * Created by user on 9/30/2015.
 */
public class Bank extends Task<ClientContext> {

    private HelperFunctions hf;
    private int boothIDs[];
    private final int location;
    public Bank(ClientContext ctx, HelperFunctions h){
        super(ctx);
        hf = h;
        boothIDs = hf.getBoothIDs();
        location = hf.getLocation();
    }
    @Override
    public boolean activate() {
        return ctx.backpack.select().count() == 28 && hf.atBank();

    }

    @Override
    public String name(){
        return "Bank";
    }

    @Override
    public void execute() {
        if (location == 1)
            bankLumb();
        else{
            bankGeneric();
        }

    }
    private void bankLumb(){
        Tile banktile = new Tile(3208, 3220, 2);
        if(banktile.distanceTo((ctx.players.local())) > 10){
            ctx.movement.step(banktile);
            ctx.camera.turnTo(banktile);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
        final GameObject bank = ctx.objects.select().id(boothIDs).nearest().poll();
        if(!bank.inViewport()){
            ctx.camera.turnTo(bank);
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {

            }
        }
        if (!ctx.bank.open() && bank.inViewport()) {
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
    private void bankGeneric(){
        final GameObject bank = ctx.objects.select().id(boothIDs).nearest().poll();
        if (!ctx.bank.open() && bank.inViewport()) {
            bank.interact("Bank");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }if (!bank.inViewport()){
            ctx.movement.step(bank);
            ctx.camera.turnTo(bank);
            try {
                Thread.sleep(700);
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
