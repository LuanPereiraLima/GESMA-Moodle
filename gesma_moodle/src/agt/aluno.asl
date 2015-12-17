// Agent sample_agent in project gesma_moodle

/* Initial beliefs and rules */

/* Initial goals */

//!start.
!conectar.

/* Plans */

+!start : true <- .print("hello world.").

+!conectar : true
	<- makeArtifact("conexao", "hibernate.ArtefatoConexaoCurso", [], Artid);
	focus(Artid);
	exec.

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have a agent that always complies with its organization  
//{ include("$jacamoJar/templates/org-obedient.asl") }
