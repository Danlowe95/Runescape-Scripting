package RS3.Miner;

import org.powerbot.script.ClientAccessor;
import org.powerbot.script.ClientContext;
/**
 * Created by user on 9/30/2015.
 */
public abstract class Task<C extends ClientContext> extends ClientAccessor<C>  {
    public Task(C ctx) {
        super(ctx);
    }
    public abstract boolean activate();
    public abstract void execute();
    public abstract String name();
}
