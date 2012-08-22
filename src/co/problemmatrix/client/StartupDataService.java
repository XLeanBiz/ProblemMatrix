package co.problemmatrix.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("startupData")
public interface StartupDataService extends RemoteService {
	
	String getPersona(String name);
	
	String savePersona(String persona);
	
	String listPersonaInterviews(String company);
	
	String savePersonaInterview(String interview);
	
	String listProblemInterviews(String persona);
	
	String saveProblemInterview(String interview);
}
