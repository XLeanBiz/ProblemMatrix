package co.problemmatrix.server;

import co.problemmatrix.client.StartupDataService;
import co.problemmatrix.server.interviews.ListEarlyAdoptersInterviews;
import co.problemmatrix.server.interviews.ListPersonaInterviews;
import co.problemmatrix.server.interviews.ListProblemInterviews;
import co.problemmatrix.server.interviews.ListProblemMatrixInterviews;
import co.problemmatrix.server.interviews.ListSatisfactionInterviews;
import co.problemmatrix.server.interviews.ListSolutionInterviews;
import co.problemmatrix.server.interviews.ListSolutionMatrixInterviews;
import co.problemmatrix.server.interviews.SaveEarlyAdoptersInterview;
import co.problemmatrix.server.interviews.SavePersonaInterview;
import co.problemmatrix.server.interviews.SaveProblemInterview;
import co.problemmatrix.server.interviews.SaveSatisfactionInterview;
import co.problemmatrix.server.interviews.SaveSolutionInterview;
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

	public String listProblemMatrixInterviews(final String company) {

		return ListProblemMatrixInterviews.list(company);
	}

	public String listSolutionMatrixInterviews(final String company) {

		return ListSolutionMatrixInterviews.list(company);
	}

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

	public String listPersonaInterviews(final String persona) {

		return ListPersonaInterviews.list(persona);
	}

	public String savePersonaInterview(final String interview) {

		JSONObject json;
		try {
			json = new JSONObject(interview);

			return SavePersonaInterview.save(json);

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return null;
	}

	public String listSolutionInterviews(final String solutionName) {

		return ListSolutionInterviews.list(solutionName);
	}

	public String saveSolutionInterview(final String interview) {

		JSONObject json;
		try {
			json = new JSONObject(interview);

			return SaveSolutionInterview.save(json);

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return null;
	}

	public String listEarlyAdoptersInterviews(final String solutionName) {

		return ListEarlyAdoptersInterviews.list(solutionName);
	}

	public String saveEarlyAdoptersInterview(final String interview) {

		JSONObject json;
		try {
			json = new JSONObject(interview);

			return SaveEarlyAdoptersInterview.save(json);

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return null;
	}
	
	public String listSatisfactionInterviews(final String solutionName) {

		return ListSatisfactionInterviews.list(solutionName);
	}

	public String saveSatisfactionInterview(final String interview) {

		JSONObject json;
		try {
			json = new JSONObject(interview);

			return SaveSatisfactionInterview.save(json);

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return null;
	}
}
