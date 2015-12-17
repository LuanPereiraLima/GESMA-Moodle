// CArtAgO artifact code for project gesma_moodle

package hibernate;

import cartago.*;

public class ArtefatoConexaoCurso extends Artifact {
	void init(int initialValue) {
	}
	
	@OPERATION
	void exec() {
		ManageCurso a = new ManageCurso();
		a.main();
	}
}

