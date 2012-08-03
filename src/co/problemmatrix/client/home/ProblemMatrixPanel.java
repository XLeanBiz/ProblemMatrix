package co.problemmatrix.client.home;

import co.problemmatrix.client.interviews.edit.AddInterviewButton;
import co.uniqueid.authentication.client.companies.CompanyIcon;
import co.uniqueid.authentication.client.login.facebook.FacebookLoginPanel;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProblemMatrixPanel extends VerticalPanel {

	public static VerticalPanel vpMain = new VerticalPanel();

	public ProblemMatrixPanel() {

		this.setSpacing(10);
		this.setSize("100%", "100%");

		HorizontalPanel hp = new HorizontalPanel();
		hp.setWidth("100%");

		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(10);

		HTML title = new HTML("<h1>Problem Matrix</h1>");
		vp.add(title);

		HTML subtitle = new HTML(
				"&nbsp;&nbsp;&nbsp;&nbsp;<b>Your shortest path to Customer Development</b>");
		vp.add(subtitle);

		hp.add(vp);

		HorizontalPanel hp2 = new HorizontalPanel();
		hp2.setWidth("100%");
		hp2.setSpacing(10);
		hp2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		hp2.add(CompanyIcon.hpCompanyIcon);
		hp2.add(FacebookLoginPanel.hpFacebookLogin);
		hp2.add(new BlogIcon());
		hp2.add(new FacebookFeedbackButton());

		hp.add(hp2);

		this.add(hp);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		this.add(new AddInterviewButton());
		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		vpMain.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vpMain.setSize("100%", "100%");

		FlexTable table = new FlexTable();
		table.setSize("100%", "100%");
		table.setCellPadding(0);
		table.setCellSpacing(0);
		table.setStyleName("flextable");
		table.setWidget(0, 0, vpMain);

		this.add(table);
	}
}