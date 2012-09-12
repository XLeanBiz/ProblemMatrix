package co.problemmatrix.client.home;

import co.problemmatrix.client.interviews.earlyadopters.ListEarlyAdoptersInterviews;
import co.problemmatrix.client.interviews.persona.ListPersonaInterviews;
import co.problemmatrix.client.interviews.problems.ListProblemsInterviews;
import co.problemmatrix.client.interviews.solution.ListSolutionInterviews;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SideBar extends VerticalPanel {

	public SideBar() {

		this.setWidth("100%");
		this.setSpacing(50);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		String company = ConvertJson.getStringValue(
				UniqueIDGlobalVariables.companyUniqueID, "ID");

		this.add(personaLinks(company));

		this.add(problemsLinks(company));

		this.add(solutionsLinks(company));

		this.add(earlyAdoptersLinks(company));
	}

	private VerticalPanel personaLinks(final String company) {

		VerticalPanel vp = new VerticalPanel();

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		HTML personaLink = new HTML("<b>Persona</b>");

		vp.add(personaLink);

		HorizontalPanel hpPersonaLinks = new HorizontalPanel();

		hpPersonaLinks.setSpacing(5);

		HTML personaInterviewsLink = new HTML(
				"<a href=#><img src=images/listIcon.jpg alt='List Interviews' height='20px'></a>");
		personaInterviewsLink.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ListPersonaInterviews.list();
			}
		});
		hpPersonaLinks.add(personaInterviewsLink);

		HTML personaCustomerInterviewLink = new HTML(
				"<a href='"
						+ GWT.getHostPageBaseURL()
						+ "?company="
						+ company
						+ "&PersonaInterview=Persona Name Here'  target='_blank'>"
						+ "<img src=images/CustomerIcon.jpg alt='Add Interview' height='20px'>");
		hpPersonaLinks.add(personaCustomerInterviewLink);

		vp.add(hpPersonaLinks);

		return vp;
	}

	private VerticalPanel problemsLinks(final String company) {

		VerticalPanel vp = new VerticalPanel();

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		HTML titleLink = new HTML("<b>Problems</b>");

		vp.add(titleLink);

		HorizontalPanel hpIcons = new HorizontalPanel();

		hpIcons.setSpacing(5);

		HTML listInterviewsLink = new HTML(
				"<a href=#><img src=images/listIcon.jpg alt='List Interviews' height='20px' ></a>");
		listInterviewsLink.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ListProblemsInterviews.list();
			}
		});
		hpIcons.add(listInterviewsLink);

		HTML customerInterviewLink = new HTML(
				"<a href='"
						+ GWT.getHostPageBaseURL()
						+ "?company="
						+ company
						+ "&ProblemInterview=Problem Name Here' target='_blank'>"
						+ "<img src=images/CustomerIcon.jpg alt='Add Interview' height='20px' >");
		hpIcons.add(customerInterviewLink);

		vp.add(hpIcons);

		return vp;
	}

	private VerticalPanel solutionsLinks(final String company) {

		VerticalPanel vp = new VerticalPanel();

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		HTML titleLink = new HTML("<b>Solutions</b>");

		vp.add(titleLink);

		HorizontalPanel hpIcons = new HorizontalPanel();

		hpIcons.setSpacing(5);

		HTML listInterviewsLink = new HTML(
				"<a href=#><img src=images/listIcon.jpg alt='List Interviews' height='20px' ></a>");
		listInterviewsLink.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ListSolutionInterviews.list();
			}
		});
		hpIcons.add(listInterviewsLink);

		HTML customerInterviewLink = new HTML(
				"<a href='"
						+ GWT.getHostPageBaseURL()
						+ "?company="
						+ company
						+ "&SolutionInterview=Your Value Proposition  Here' target='_blank'>"
						+ "<img src=images/CustomerIcon.jpg alt='Add Interview' height='20px' >");
		hpIcons.add(customerInterviewLink);

		vp.add(hpIcons);

		return vp;
	}

	private VerticalPanel earlyAdoptersLinks(final String company) {

		VerticalPanel vp = new VerticalPanel();

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		HTML titleLink = new HTML("<b>Early Adopters</b>");

		vp.add(titleLink);

		HorizontalPanel hpIcons = new HorizontalPanel();

		hpIcons.setSpacing(5);

		HTML listInterviewsLink = new HTML(
				"<a href=#><img src=images/listIcon.jpg alt='List Interviews' height='20px' ></a>");
		listInterviewsLink.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ListEarlyAdoptersInterviews.list();
			}
		});
		hpIcons.add(listInterviewsLink);

		HTML customerInterviewLink = new HTML(
				"<a href='"
						+ GWT.getHostPageBaseURL()
						+ "?company="
						+ company
						+ "&EarlyAdopterInterview=Your Solution Here' target='_blank'>"
						+ "<img src=images/CustomerIcon.jpg alt='Add Interview' height='20px' >");
		hpIcons.add(customerInterviewLink);

		vp.add(hpIcons);

		return vp;
	}
}
