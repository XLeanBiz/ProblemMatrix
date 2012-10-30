package co.problemmatrix.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface StartupDataServiceAsync {

	void listProblemMatrixInterviews(String company,
			AsyncCallback<String> callback);

	void listSolutionMatrixInterviews(String company,
			AsyncCallback<String> callback);

	void getPersona(String name, AsyncCallback<String> callback);

	void savePersona(String persona, AsyncCallback<String> callback);

	void listPersonaInterviews(String persona, AsyncCallback<String> callback);

	void savePersonaInterview(String interview, AsyncCallback<String> callback);

	void listProblemInterviews(String company, AsyncCallback<String> callback);

	void saveProblemInterview(String interview, AsyncCallback<String> callback);

	void listSolutionInterviews(String solutionName,
			AsyncCallback<String> callback);

	void saveSolutionInterview(String interview, AsyncCallback<String> callback);

	void listEarlyAdoptersInterviews(String solutionName,
			AsyncCallback<String> callback);

	void saveEarlyAdoptersInterview(String interview,
			AsyncCallback<String> callback);

	void listSatisfactionInterviews(String solutionName,
			AsyncCallback<String> callback);

	void saveSatisfactionInterview(String interview,
			AsyncCallback<String> callback);
}
