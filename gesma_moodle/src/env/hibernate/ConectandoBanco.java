// CArtAgO artifact code for project gesma_moodle

package hibernate;

import cartago.*;

public class ConectandoBanco extends Artifact {
	void init(int initialValue) {
	}
	
	@OPERATION
	void exec() {
		ManageObjeto a = new ManageObjeto();
		a.main();
	}
}

