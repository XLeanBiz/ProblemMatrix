package co.problemmatrix.server.interviews;

import co.uniqueid.authentication.client.utilities.EncryptText;
import co.uniqueid.authentication.server.utilities.URLUtilities;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class ListSolutionMatrixInterviews {

	// http://jsonpfy.startupsdata.appspot.com/ListDataService
	// ?kind=Interviews
	// &filterField=company&filterValue=
	// &sortField=datetime&sortDirection=desc

	private static String listUrl = "https://jsonpfy.startupsdata.appspot.com/ListDataService";

	public static String list(final String company) {

		String solutionsInterviewsJsonString = listSolutionsInterviews(company);

		String matrixInterviews = solutionsInterviewsJsonString;

		JSONArray solutionsInterviewsJson;
		try {
			solutionsInterviewsJson = new JSONArray(
					solutionsInterviewsJsonString);

			String earlyAdoptersInterviewsJsonString = listEarlyAdoptersInterviews(company);

			JSONArray earlyAdoptersInterviewsJson = new JSONArray(
					earlyAdoptersInterviewsJsonString);

			for (int i = 0; i < earlyAdoptersInterviewsJson.length(); i++) {

				JSONObject earlyAdopterInterviewJson = earlyAdoptersInterviewsJson
						.getJSONObject(i);

				solutionsInterviewsJson.put(earlyAdopterInterviewJson);

			}

			matrixInterviews = solutionsInterviewsJson.toString();

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return matrixInterviews;
	}

	private static String listSolutionsInterviews(final String company) {

		String parameters = "kind=SolutionsInterviews";

		parameters += "&filterField=company&filterValue=" + company;

		final String jsonString = URLUtilities.fetchURLPost(listUrl, parameters
				+ EncryptText.getAuthParameter());

		return jsonString;
	}

	private static String listEarlyAdoptersInterviews(final String company) {

		String parameters = "kind=EarlyAdoptersInterviews";

		parameters += "&filterField=company&filterValue=" + company;

		final String jsonString = URLUtilities.fetchURLPost(listUrl, parameters
				+ EncryptText.getAuthParameter());

		return jsonString;
	}
}
