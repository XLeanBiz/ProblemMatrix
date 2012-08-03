package co.problemmatrix.server;

import co.problemmatrix.client.interviews.StartupDataService;
import co.problemmatrix.server.interviews.ListProblemInterviews;
import co.problemmatrix.server.interviews.SaveProblemInterview;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class StartupDataServiceImpl extends RemoteServiceServlet implements
		StartupDataService {

	public String listProblemInterviews(final String company) {

		return ListProblemInterviews.list(company);
	}
	
	public String saveProblemInterview(final String interview) {

		JSONObject json;
		try {
			json = new JSONObject(interview);

			return SaveProblemInterview.save(json);

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return null;
	}
}
