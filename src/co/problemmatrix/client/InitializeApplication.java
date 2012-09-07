package co.problemmatrix.client;

import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.earlyadopters.ListEarlyAdoptersInterviews;
import co.problemmatrix.client.interviews.earlyadopters.customers.CustomerEarlyAdoptersInterviewPage;
import co.problemmatrix.client.interviews.persona.customers.CustomerPersonaInterviewPage;
import co.problemmatrix.client.interviews.problems.customers.CustomerProblemInterviewPage;
import co.problemmatrix.client.interviews.problems.edit.AddProblemInterviewButton;
import co.problemmatrix.client.interviews.solution.ListSolutionInterviews;
import co.problemmatrix.client.interviews.solution.customers.CustomerSolutionInterviewPage;
import co.problemmatrix.client.matrix.ListMatrixInterviews;
import co.problemmatrix.client.matrix.ProblemMatrixGeneric;
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

		final String persona = Location.getParameter("Persona");

		final String personaInterview = Location
				.getParameter("PersonaInterview");

		final String personaShortInterview = Location
				.getParameter("PersonaShortInterview");

		final String problemInterview = Location
				.getParameter("ProblemInterview");

		final String problemShortInterview = Location
				.getParameter("ProblemShortInterview");

		final String solution = Location.getParameter("Solution");

		final String solutionInterview = Location
				.getParameter("SolutionInterview");

		final String solutionShortInterview = Location
				.getParameter("SolutionShortInterview");
		
		final String earlyAdopters = Location.getParameter("EarlyAdopters");

		final String earlyAdoptersInterview = Location
				.getParameter("EarlyAdopterInterview");

		if (!(problemInterview == null || "null".equals(problemInterview))) {

			RootPanel.get("main").add(
					new CustomerProblemInterviewPage(problemInterview, false));

		} else if (!(problemShortInterview == null || "null"
				.equals(problemShortInterview))) {

			RootPanel.get("main").add(
					new CustomerProblemInterviewPage(problemShortInterview,
							true));

		} else if (!(solutionInterview == null || "null"
				.equals(solutionInterview))) {

			RootPanel.get("main")
					.add(new CustomerSolutionInterviewPage(solutionInterview,
							false));

		} else if (!(solutionShortInterview == null || "null"
				.equals(solutionShortInterview))) {

			RootPanel.get("main").add(
					new CustomerSolutionInterviewPage(solutionShortInterview,
							true));

		} else  if (!(earlyAdoptersInterview == null || "null"
				.equals(earlyAdoptersInterview))) {

			RootPanel.get("main")
					.add(new CustomerEarlyAdoptersInterviewPage(earlyAdoptersInterview,
							false));

		}  else if (!(personaInterview == null || "null"
				.equals(personaInterview))) {

			RootPanel.get("main").add(
					new CustomerPersonaInterviewPage(personaInterview, false));

		} else if (!(personaShortInterview == null || "null"
				.equals(personaShortInterview))) {

			RootPanel.get("main").add(
					new CustomerPersonaInterviewPage(personaShortInterview,
							true));

		} else if (persona != null) {

			RootPanel.get("main").add(new ProblemMatrixPanel());
			GetPersona.get(persona);

		} else if (solution != null) {

			RootPanel.get("main").add(new ProblemMatrixPanel());
			ListSolutionInterviews.list(solution);

		} else if (earlyAdopters != null) {

			RootPanel.get("main").add(new ProblemMatrixPanel());
			ListEarlyAdoptersInterviews.list(earlyAdopters);

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

			ListMatrixInterviews.list();

		} else {

			ProblemMatrixPanel.vpMain.add(new ProblemMatrixGeneric());
			ProblemMatrixPanel.hpButtons.add(new AddProblemInterviewButton());
		}
	}

	public static void VerifyFacebookLogin(final String authenticationCode) {

		FacebookLoginVerifyer.authenticate(facebookAppID, authenticationCode,
				REDIRECT_URL, null, true);
	}
}
