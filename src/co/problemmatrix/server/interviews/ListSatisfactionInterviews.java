package co.problemmatrix.server.interviews;

import co.uniqueid.authentication.client.utilities.EncryptText;
import co.uniqueid.authentication.server.utilities.URLUtilities;

public class ListSatisfactionInterviews {

	private static String listUrl = "https://jsonpfy.startupsdata.appspot.com/ListDataService";

	public static String list(final String company) {

		String parameters = "kind=SatisfactionInterviews";

		parameters += "&filterField=company&filterValue=" + company;

		final String jsonString = URLUtilities.fetchURLPost(listUrl, parameters
				+ EncryptText.getAuthParameter());

		return jsonString;
	}
}
