package co.problemmatrix.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("startupData")
public interface StartupDataService extends RemoteService {
	
	String listMatrixInterviews(String company);

	String getPersona(String name);

	String savePersona(String persona);

	String listPersonaInterviews(String persona);

	String savePersonaInterview(String interview);

	String listProblemInterviews(String company);

	String saveProblemInterview(String interview);

	String listSolutionInterviews(String solutionName);

	String saveSolutionInterview(String interview);
}
