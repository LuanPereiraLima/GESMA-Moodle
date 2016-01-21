// CArtAgO artifact code for project gesma_moodle

package gesma_moodle;

import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import cartago.*;

/**
 * 
 * @author loopback
 * 
 */

public class Tempo extends Artifact{
	
	private final long INTERVALO_TEMPO = 24*60*60*1000;//1000;//;
	
	void init() {
		Date data = new Date();
		defineObsProperty("time", Long.parseLong("1347999999"));
		//Timer tempo = new Timer();
		execInternalOp("countRelogio");
		//tempo.schedule(tick, 0, INTERVALO_TEMPO);
	}
	
	/*TimerTask tick = new TimerTask() {
		@Override
		public void run() {
			Date data = new Date();
			ObsProperty prop = getObsProperty("time");
			prop.updateValue(data.getTime());
			signal("tick");
		}
	};*/
	
	@INTERNAL_OPERATION
	void countRelogio() {
		//while(true){
			/*Date data = new Date();
			ObsProperty prop = getObsProperty("time");
			
			try {
				Thread.sleep(INTERVALO_TEMPO);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			prop.updateValue(data.getTime());*/
			signal("tick");
		//}
	}
	
	}