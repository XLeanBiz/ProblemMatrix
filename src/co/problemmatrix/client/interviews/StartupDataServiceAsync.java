package co.problemmatrix.client.interviews;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface StartupDataServiceAsync {
	
	void listProblemInterviews(String company, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
