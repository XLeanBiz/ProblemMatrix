package co.problemmatrix.client;

import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.persona.customers.CustomerPersonaInterviewPage;
import co.problemmatrix.client.interviews.problems.ListProblemsInterviews;
import co.problemmatrix.client.interviews.problems.customers.CustomerProblemInterviewPage;
import co.problemmatrix.client.interviews.problems.edit.AddProblemInterviewButton;
import co.problemmatrix.client.matrix.ProblemMatrixTable;
import co.problemmatrix.client.persona.GetPersona;
import co.uniqueid.authentication.client.login.facebook.FacebookLoginVerifyer;
import co.uniqueid.authentication.client.login.facebook.InitializeFacebookLogin;

import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.RootPanel;

public class InitializeApplication {

	private static final String REDIRECT_URL = "http://problemmatrix.com/";
	private static final String facebookAppID = "394142487301005";

	public static void verifyParameters(final String uniqueID,
			final String companyID) {

		final String problemInterview = Location
				.getParameter("problemInterview");
		
		final String personaInterview = Location
				.getParameter("personaInterview");

		final String persona = Location.getParameter("persona");

		if (!(problemInterview == null || "null".equals(problemInterview))) {

			RootPanel.get("main").add(
					new CustomerProblemInterviewPage(problemInterview));

		} else if(!(personaInterview == null || "null".equals(personaInterview))) {

			RootPanel.get("main").add(
					new CustomerPersonaInterviewPage(personaInterview));

		} else if(persona != null) {

			RootPanel.get("main").add(new ProblemMatrixPanel());
			GetPersona.get(persona);

		} else {

			RootPanel.get("main").add(new ProblemMatrixPanel());
			InitializeApplication.initHome(uniqueID, companyID);
		}
	}

	public static void initHome(final String uniqueID, final String companyID) {

		new InitializeFacebookLogin(uniqueID, facebookAppID, REDIRECT_URL,
				companyID, true);

		ProblemMatrixPanel.vpMain.clear();
		ProblemMatrixPanel.hpButtons.clear();

		if (companyID != null) {

			ListProblemsInterviews.list();

		} else {

			ProblemMatrixPanel.vpMain.add(new ProblemMatrixTable());
			ProblemMatrixPanel.hpButtons.add(new AddProblemInterviewButton());
		}
	}

	public static void VerifyFacebookLogin(final String authenticationCode) {

		FacebookLoginVerifyer.authenticate(facebookAppID, authenticationCode,
				REDIRECT_URL, null, true);
	}
}
