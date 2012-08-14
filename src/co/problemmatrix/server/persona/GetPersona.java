package co.problemmatrix.server.persona;

import co.uniqueid.authentication.client.utilities.EncryptText;
import co.uniqueid.authentication.server.utilities.URLUtilities;

public class GetPersona {

	// http://jsonpfy.startupsdata.appspot.com/GetDataService
	// ?kind=Personas

	private static String getUrl = "https://jsonpfy.startupsdata.appspot.com/GetDataService";

	public static String get(String personaName) {

		String parameters = "kind=Personas&ID="
				+ URLUtilities.encode(personaName);

		final String jsonString = URLUtilities.fetchURLPost(getUrl, parameters
				+ EncryptText.getAuthParameter());

		return jsonString;
	}
}
