package co.problemmatrix.server;

import co.problemmatrix.client.StartupDataService;
import co.problemmatrix.server.interviews.ListProblemInterviews;
import co.problemmatrix.server.interviews.SaveProblemInterview;
import co.problemmatrix.server.persona.GetPersona;
import co.problemmatrix.server.persona.SavePersona;

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
	
	public String getPersona(final String personaName) {

		return GetPersona.get(personaName);
	}

	public String savePersona(final String personaString) {

		JSONObject personaJson;
		try {
			personaJson = new JSONObject(personaString);

			return SavePersona.save(personaJson);
		} catch (JSONException e) {

			e.printStackTrace();
		}

		return null;
	}

}
