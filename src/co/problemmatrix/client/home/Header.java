package co.problemmatrix.client.home;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.companies.CompanyIcon;
import co.uniqueid.authentication.client.login.facebook.FacebookLoginPanel;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Header extends HorizontalPanel {

	public Header() {

		this.setWidth("100%");

		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(10);

		String companyString = "";
		String companyID = ConvertJson.getStringValue(
				UniqueIDGlobalVariables.companyUniqueID, "ID");
		if (companyID != null) {

			companyString = "?company=" + companyID;
		}

		HTML title = new HTML(
				"<a href='http://custdevinterviews.co"
						+ companyString
						+ "'><h1><font color=black>Customer Dev Interviews</font></h1></a>");
		vp.add(title);

		HTML subtitle = new HTML(
				"&nbsp;&nbsp;&nbsp;&nbsp;<b>Your shortest path to Success.</b>");
		vp.add(subtitle);

		this.add(vp);

		HorizontalPanel hp2 = new HorizontalPanel();
		hp2.setWidth("100%");
		hp2.setSpacing(10);
		hp2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		hp2.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		hp2.add(new CompanyField());
		hp2.add(CompanyIcon.hpCompanyIcon);
		hp2.add(FacebookLoginPanel.hpFacebookLogin);
		FacebookLoginPanel.hpFacebookLogin
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		hp2.add(new BlogIcon());
		hp2.add(new FacebookFeedbackButton());

		this.add(hp2);
	}
}
