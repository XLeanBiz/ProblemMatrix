package co.problemmatrix.client.home;

import co.uniqueid.authentication.client.companies.CompanyIcon;
import co.uniqueid.authentication.client.login.facebook.FacebookLoginPanel;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Header extends HorizontalPanel {

	public Header() {

		this.setWidth("100%");

		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(10);

		HTML title = new HTML("<h1>Problem Matrix</h1>");
		vp.add(title);

		HTML subtitle = new HTML(
				"&nbsp;&nbsp;&nbsp;&nbsp;<b>Your shortest path to Customer Development</b>");
		vp.add(subtitle);

		this.add(vp);

		HorizontalPanel hp2 = new HorizontalPanel();
		hp2.setWidth("100%");
		hp2.setSpacing(10);
		hp2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		hp2.add(CompanyIcon.hpCompanyIcon);
		hp2.add(FacebookLoginPanel.hpFacebookLogin);
		hp2.add(new BlogIcon());
		hp2.add(new FacebookFeedbackButton());

		this.add(hp2);
	}
}
