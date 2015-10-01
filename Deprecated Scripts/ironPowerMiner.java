import java.util.Map;
import org.rsbot.script.Script;
import org.rsbot.script.ScriptManifest;
import org.rsbot.script.wrappers.RSObject;

@ScriptManifest(authors = "sniperkid1", name = "ironPMiner", version = 1.0, description = "iron powerminer in falador")
public class ironPMiner extends Script {
	
	int[] ironoreID = { 5775 , 5774 };

                public boolean onStart (){
    		log("yo");
    		return true;
                }
        
		private void mineOre(){
            		RSObject rock = objects.getNearest(ironoreID);
                        if (players.getMyPlayer().getAnimation() == -1){
            		rock.doAction("Mine");
                    }
                    }
                private void dropOre(){
                    int[] pickID = {1265, 1267, 1269, 1271, 1273, 1275};
                    inventory.dropAllExcept(pickID);
                }
                
                
	public void onFinish (){
    	log("bye");
	}

	@Override
	public int loop() {
                if(inventory.isFull()){
                    dropOre();
            } else if(!inventory.isFull()){
                mineOre();}
		return 2000;
	}
}