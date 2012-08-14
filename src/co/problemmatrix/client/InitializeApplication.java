package co.problemmatrix.client;

import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.ListInterviews;
import co.problemmatrix.client.matrix.ProblemMatrixTable;
import co.uniqueid.authentication.client.login.facebook.FacebookLoginVerifyer;
import co.uniqueid.authentication.client.login.facebook.InitializeFacebookLogin;

public class InitializeApplication {

	private static final String REDIRECT_URL = "http://problemmatrix.com/";
	private static final String facebookAppID = "394142487301005";

	public static void initHome(final String uniqueID, final String companyID) {

		new InitializeFacebookLogin(uniqueID, facebookAppID, REDIRECT_URL,
				companyID, true);

		ProblemMatrixPanel.vpMain.clear();

		if (companyID != null) {

			ListInterviews.list();

		} else {

			ProblemMatrixPanel.vpMain.add(new ProblemMatrixTable());
		}
	}

	public static void VerifyFacebookLogin(final String authenticationCode) {

		FacebookLoginVerifyer.authenticate(facebookAppID, authenticationCode,
				REDIRECT_URL, null, true);
	}
}
