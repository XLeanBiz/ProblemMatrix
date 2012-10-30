package co.problemmatrix.server.interviews;

import co.uniqueid.authentication.client.utilities.EncryptText;
import co.uniqueid.authentication.server.utilities.JSONUtilities;
import co.uniqueid.authentication.server.utilities.URLUtilities;

import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class SaveSatisfactionInterview {

	private static String saveUrl = "https://jsonpfy.startupsdata.appspot.com/SaveDataService";

	public static String save(JSONObject interview) {

		String parameters = "kind=SatisfactionInterviews";

		if (JSONUtilities.getString(interview, "ID") != null) {

			parameters += "&ID=" + JSONUtilities.getString(interview, "ID");
		}

		parameters += URLUtilities.addSaveParameterString(interview, "company");

		parameters += URLUtilities.addSaveParameterString(interview, "persona");

		parameters += URLUtilities.addSaveParameterString(interview,
				"interviewer");

		parameters += URLUtilities
				.addSaveParameterString(interview, "datetime");

		parameters += URLUtilities.addSaveParameterString(interview, "feature");

		parameters += URLUtilities.addSaveParameterString(interview,
				"customerName");

		parameters += URLUtilities.addSaveParameterString(interview,
				"customerUniqueID");

		parameters += URLUtilities
				.addSaveParameterString(interview, "videoURL");

		parameters += URLUtilities.addSaveParameterText(interview, "notes");

		parameters += URLUtilities
				.addSaveParameterText(interview, "whyFeature");

		parameters += URLUtilities.addSaveParameterString(interview,
				"satisfactionRate");

		parameters += URLUtilities.addSaveParameterText(interview,
				"improveFeature");

		parameters += URLUtilities.addSaveParameterText(interview,
				"disappointedNoFeature");

		parameters += URLUtilities.addSaveParameterText(interview,
				"openComments");

		String interviewID = URLUtilities.fetchURLPost(saveUrl, parameters
				+ EncryptText.getAuthParameter());

		return interviewID;
	}
}
