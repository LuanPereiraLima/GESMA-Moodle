// Agent acompanhante_de_tutor in project gesma_moodle

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true <- 
	makeArtifact("contador", "gesma_moodle.Tempo", [], ArtId);
	focus(ArtId).
	
+time(Tempo) <- makeArtifact("repositorio", "gesma_moodle.RepositorioCurso", [], IDArtifact);
				focus(IDArtifact);
				cursoApos(Tempo).

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have a agent that always complies with its organization  
//{ include("$jacamoJar/templates/org-obedient.asl") }
