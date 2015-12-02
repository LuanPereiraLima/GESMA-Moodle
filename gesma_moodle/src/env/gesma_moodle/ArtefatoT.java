// CArtAgO artifact code for project gesma_moodle

package gesma_moodle;

import cartago.*;

public class ArtefatoT extends Artifact {
	void init(int initialValue) {
		defineObsProperty("count", initialValue);
	}
	
	@OPERATION
	void inc() {
		ObsProperty prop = getObsProperty("count");
		prop.updateValue(prop.intValue()+1);
		signal("tick");
	}
}

