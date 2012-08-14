package co.problemmatrix.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface StartupDataServiceAsync {
	
	void listProblemInterviews(String company, AsyncCallback<String> callback);
	
	void saveProblemInterview(String interview, AsyncCallback<String> callback);
	
	void getPersona(String name, AsyncCallback<String> callback);

	void savePersona(String persona, AsyncCallback<String> callback);
}
