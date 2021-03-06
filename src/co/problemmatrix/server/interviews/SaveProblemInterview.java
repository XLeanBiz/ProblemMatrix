package co.problemmatrix.server.interviews;

import co.uniqueid.authentication.client.utilities.EncryptText;
import co.uniqueid.authentication.server.utilities.JSONUtilities;
import co.uniqueid.authentication.server.utilities.URLUtilities;

import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class SaveProblemInterview {

	private static String saveUrl = "https://jsonpfy.startupsdata.appspot.com/SaveDataService";

	public static String save(JSONObject interview) {

		String parameters = "kind=ProblemsInterviews";

		if (JSONUtilities.getString(interview, "ID") != null) {

			parameters += "&ID=" + JSONUtilities.getString(interview, "ID");
		}

		parameters += URLUtilities.addSaveParameterString(interview, "company");

		parameters += URLUtilities.addSaveParameterString(interview,
				"interviewer");

		parameters += URLUtilities.addSaveParameterString(interview, "persona");

		parameters += URLUtilities
				.addSaveParameterString(interview, "datetime");

		parameters += URLUtilities.addSaveParameterString(interview, "problem");

		parameters += URLUtilities.addSaveParameterString(interview,
				"customerName");

		parameters += URLUtilities.addSaveParameterString(interview,
				"customerUniqueID");

		parameters += URLUtilities
				.addSaveParameterString(interview, "videoURL");

		parameters += URLUtilities.addSaveParameterText(interview, "notes");

		parameters += URLUtilities.addSaveParameterText(interview,
				"problemUnderstand");

		parameters += URLUtilities.addSaveParameterText(interview,
				"haveProblem");

		parameters += URLUtilities.addSaveParameterText(interview,
				"whyHaveProblem");

		parameters += URLUtilities.addSaveParameterString(interview,
				"problemRate");

		parameters += URLUtilities.addSaveParameterText(interview,
				"make5Problem");

		parameters += URLUtilities.addSaveParameterText(interview,
				"howSolvingProblem");

		parameters += URLUtilities.addSaveParameterText(interview,
				"howLikeSolvingProblem");

		parameters += URLUtilities.addSaveParameterText(interview,
				"openComments");

		String interviewID = URLUtilities.fetchURLPost(saveUrl, parameters
				+ EncryptText.getAuthParameter());

		return interviewID;
	}
}
