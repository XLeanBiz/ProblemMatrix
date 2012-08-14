package co.problemmatrix.server.persona;

import co.uniqueid.authentication.client.utilities.EncryptText;
import co.uniqueid.authentication.server.utilities.JSONUtilities;
import co.uniqueid.authentication.server.utilities.URLUtilities;

import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class SavePersona {

	private static String saveUrl = "https://jsonpfy.startupsdata.appspot.com/SaveDataService";

	public static String save(JSONObject personaJson) {

		String parameters = "kind=Personas";

		parameters += "&ID=" + JSONUtilities.getString(personaJson, "ID");

		parameters += URLUtilities.addSaveParameterString(personaJson, "name");

		parameters += URLUtilities.addSaveParameterString(personaJson,
				"imageURL");

		parameters += URLUtilities.addSaveParameterText(personaJson,
				"behaviors");

		parameters += URLUtilities.addSaveParameterText(personaJson, "needs");

		parameters += URLUtilities.addSaveParameterText(personaJson, "goals");

		parameters += URLUtilities.addSaveParameterText(personaJson,
				"demographics");

		parameters += URLUtilities
				.addSaveParameterText(personaJson, "problems");

		parameters += URLUtilities.addSaveParameterText(personaJson,
				"whereToFind");

		URLUtilities.fetchURLPost(saveUrl,
				parameters + EncryptText.getAuthParameter());

		return personaJson.toString();
	}
}
