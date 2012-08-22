package co.problemmatrix.server.interviews;

import co.uniqueid.authentication.client.utilities.EncryptText;
import co.uniqueid.authentication.server.utilities.URLUtilities;

public class ListPersonaInterviews {

	// http://jsonpfy.startupsdata.appspot.com/ListDataService
	// ?kind=Interviews
	// &filterField=company&filterValue=
	// &sortField=datetime&sortDirection=desc

	private static String listUrl = "https://jsonpfy.startupsdata.appspot.com/ListDataService";

	public static String list(final String persona) {

		String parameters = "kind=PersonasInterviews";
		
		parameters += "&filterField=persona&filterValue="
				+ persona;
		
	//	parameters += "&sortField=datetime&sortDirection=desc";

		final String jsonString = URLUtilities.fetchURLPost(listUrl,
				parameters + EncryptText.getAuthParameter());

		return jsonString;
	}
}
