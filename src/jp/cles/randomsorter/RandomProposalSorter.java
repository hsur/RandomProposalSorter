package jp.cles.randomsorter;

import java.util.Random;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.ui.text.java.AbstractProposalSorter;
import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

/**
 * @author hsur
 */
public class RandomProposalSorter extends AbstractProposalSorter {

	static private ILog log;
	static {
		log = Activator.getDefault().getLog();
	}
	private void _info(String m){
		log.log(new Status(IStatus.INFO, Activator.PLUGIN_ID, m));
	}

	private Random r;
	public RandomProposalSorter() {
		super();
		r = new Random();
		_info("initialized");
	}

	@Override
	public void beginSorting(ContentAssistInvocationContext context) {
		_info("beginSorting()");
		super.beginSorting(context);
	}

	@Override
	public void endSorting() {
		super.endSorting();
		_info("endSorting()");
	}

	@Override
	public int compare(ICompletionProposal p1, ICompletionProposal p2) {
		return r.nextInt(2) - 2;
	}

}
