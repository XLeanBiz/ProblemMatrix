package co.problemmatrix.server.interviews;

import co.uniqueid.authentication.client.utilities.EncryptText;
import co.uniqueid.authentication.server.utilities.URLUtilities;

public class ListSolutionInterviews {

	// http://jsonpfy.startupsdata.appspot.com/ListDataService
	// ?kind=Interviews
	// &filterField=company&filterValue=
	// &sortField=datetime&sortDirection=desc

	private static String listUrl = "https://jsonpfy.startupsdata.appspot.com/ListDataService";

	public static String list(final String solutionName) {

		String parameters = "kind=SolutionsInterviews";

		parameters += "&filterField=solution&filterValue=" + solutionName;

		// parameters += "&sortField=datetime&sortDirection=desc";

		final String jsonString = URLUtilities.fetchURLPost(listUrl, parameters
				+ EncryptText.getAuthParameter());

		return jsonString;
	}
}
