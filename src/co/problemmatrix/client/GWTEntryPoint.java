package co.problemmatrix.client;

import co.problemmatrix.client.utilities.UseTracking;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.EncryptText;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTEntryPoint implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		new UseTracking(this.getClass().getName());

		RootPanel.get("main").clear();
		RootPanel.get("main").setWidth("100%");
		VerticalPanel vpMain = new VerticalPanel();
		RootPanel.get("main").add(vpMain, 0, 0);

		String uniqueID = EncryptText.decrypt(Cookies.getCookie("UniqueID"));
		// uniqueID = "AllineWatkins_1332886062783";

		final String company = Location.getParameter("company");
		if (company != null) {

			JSONObject json = new JSONObject();
			json.put("ID", new JSONString(company));

			UniqueIDGlobalVariables.companyUniqueID = json;
		}

		if (uniqueID == null || uniqueID.equals("null")) {

			String authenticationCode = Location.getParameter("code");

			final String error = Location.getParameter("error_reason");

			if (!((null != error && error.equals("user_denied")) || (authenticationCode == null || ""
					.equals(authenticationCode)))) {

				InitializeApplication.VerifyFacebookLogin(authenticationCode);

			}
		}

		InitializeApplication.verifyParameters(vpMain, uniqueID, company);

	}
}
