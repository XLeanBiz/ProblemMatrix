package co.problemmatrix.server.interviews;

import co.uniqueid.authentication.client.utilities.EncryptText;
import co.uniqueid.authentication.server.utilities.JSONUtilities;
import co.uniqueid.authentication.server.utilities.URLUtilities;

import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class SaveEarlyAdoptersInterview {

	private static String saveUrl = "https://jsonpfy.startupsdata.appspot.com/SaveDataService";

	public static String save(JSONObject interview) {

		String parameters = "kind=EarlyAdoptersInterviews";

		if (JSONUtilities.getString(interview, "ID") != null) {

			parameters += "&ID=" + JSONUtilities.getString(interview, "ID");
		}

		parameters += URLUtilities.addSaveParameterString(interview, "company");
		
		parameters += URLUtilities.addSaveParameterString(interview, "persona");

		parameters += URLUtilities.addSaveParameterString(interview,
				"interviewer");

		parameters += URLUtilities
				.addSaveParameterString(interview, "datetime");

		parameters += URLUtilities
				.addSaveParameterString(interview, "solution");

		parameters += URLUtilities.addSaveParameterString(interview,
				"customerName");

		parameters += URLUtilities.addSaveParameterString(interview,
				"customerUniqueID");

		parameters += URLUtilities
				.addSaveParameterString(interview, "videoURL");

		parameters += URLUtilities.addSaveParameterText(interview, "notes");

		parameters += URLUtilities.addSaveParameterText(interview,
				"whyEarlyAdopter");

		parameters += URLUtilities.addSaveParameterString(interview,
				"earlyAdopterRate");

		parameters += URLUtilities.addSaveParameterText(interview,
				"threeMeetings");

		parameters += URLUtilities.addSaveParameterText(interview,
				"emailEarlyAdopter");

		parameters += URLUtilities.addSaveParameterText(interview,
				"openComments");

		String interviewID = URLUtilities.fetchURLPost(saveUrl, parameters
				+ EncryptText.getAuthParameter());

		return interviewID;
	}
}
