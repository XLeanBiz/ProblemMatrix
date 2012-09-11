package co.problemmatrix.client.home;

import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;

public class CompanyField extends HorizontalPanel {

	public CompanyField() {

		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		String companyID = ConvertJson.getStringValue(
				UniqueIDGlobalVariables.companyUniqueID, "ID");

		final TextBox companyField = new TextBox();
		companyField.setValue(companyID);
		this.add(FormField.getFormField("<b>Company</b>", companyField));
		companyField.setWidth("200px");

		Button enter = new Button("Enter");

		enter.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Window.Location.assign(GWT.getHostPageBaseURL() + "?company="
						+ companyField.getValue());
			}
		});

		this.add(enter);
	}
}
