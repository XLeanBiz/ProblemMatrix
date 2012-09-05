package co.problemmatrix.server.interviews;

import co.uniqueid.authentication.client.utilities.EncryptText;
import co.uniqueid.authentication.server.utilities.URLUtilities;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class ListMatrixInterviews {

	// http://jsonpfy.startupsdata.appspot.com/ListDataService
	// ?kind=Interviews
	// &filterField=company&filterValue=
	// &sortField=datetime&sortDirection=desc

	private static String listUrl = "https://jsonpfy.startupsdata.appspot.com/ListDataService";

	public static String list(final String company) {

		String problemsInterviewsJsonString = listProblemsInterviews(company);

		String matrixInterviews = problemsInterviewsJsonString;

		JSONArray problemsInterviewsJson;
		try {
			problemsInterviewsJson = new JSONArray(problemsInterviewsJsonString);

			String personaInterviewsJsonString = listPersonasInterviews(company);

			JSONArray personaInterviewsJson = new JSONArray(
					personaInterviewsJsonString);

			for (int i = 0; i < personaInterviewsJson.length(); i++) {

				JSONObject personaInterviewJson = personaInterviewsJson
						.getJSONObject(i);

				String problems = personaInterviewJson.getString("problems");

				String[] personaMainProblems = problems.split(",");

				for (String personaMainProblem : personaMainProblems) {

					JSONObject personaProblemJson = new JSONObject(
							personaInterviewJson.toString());

					personaProblemJson
							.put("problem", personaMainProblem.trim());

					problemsInterviewsJson.put(personaProblemJson);
				}
			}

			matrixInterviews = problemsInterviewsJson.toString();

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return matrixInterviews;
	}

	private static String listProblemsInterviews(final String company) {

		String parameters = "kind=ProblemsInterviews";

		parameters += "&filterField=company&filterValue=" + company;

		final String jsonString = URLUtilities.fetchURLPost(listUrl, parameters
				+ EncryptText.getAuthParameter());

		return jsonString;
	}

	private static String listPersonasInterviews(final String company) {

		String parameters = "kind=PersonasInterviews";

		parameters += "&filterField=company&filterValue=" + company;

		final String jsonString = URLUtilities.fetchURLPost(listUrl, parameters
				+ EncryptText.getAuthParameter());

		return jsonString;
	}
}
