package gr.open.marketplace.portlets;

import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.ControlPanelEntry;


public class AdminAllowedIPsControlPanelEntry implements ControlPanelEntry {

	public boolean isVisible(PermissionChecker checker, Portlet portlet)
		throws Exception {

		// TODO Auto-generated method stub
		return true;
	}

	public boolean isVisible(Portlet portlet, String category, ThemeDisplay themeDisplay)
		throws Exception {

		// TODO Auto-generated method stub
		return true;
	}

}
