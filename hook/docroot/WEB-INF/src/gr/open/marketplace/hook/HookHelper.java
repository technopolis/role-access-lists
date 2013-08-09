package gr.open.marketplace.hook;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;

import java.util.List;


public class HookHelper {

	public static boolean hasUserRole(User user, String roleName) throws SystemException{
		if (user == null) {
			return false;
		}
		List<Role> roles = user.getRoles(); //ACS Loyalty Customer
		for (Role role:roles) {
			if (roleName.equals(role.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isValidAdminSession(String validIp, String remoteAddr, String remoteHost) {

		boolean result = false;
		if (remoteAddr.startsWith(validIp) && remoteHost.startsWith(validIp)) {
			result = true;
		}

		return result;
	}
}
