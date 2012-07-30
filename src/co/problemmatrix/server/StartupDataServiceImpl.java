package co.problemmatrix.server;

import co.problemmatrix.client.interviews.StartupDataService;
import co.problemmatrix.server.interviews.ListProblemInterviews;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class StartupDataServiceImpl extends RemoteServiceServlet implements
		StartupDataService {

	public String listProblemInterviews(final String company) {

		return ListProblemInterviews.list(company);
	}
}
