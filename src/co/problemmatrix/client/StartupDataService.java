package co.problemmatrix.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("startupData")
public interface StartupDataService extends RemoteService {
	
	String listProblemInterviews(String company);
	
	String saveProblemInterview(String interview);
	
	String getPersona(String name);
	
	String savePersona(String persona);
}
