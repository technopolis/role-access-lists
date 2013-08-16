
package gr.open.marketplace.comparators;

import com.liferay.portal.kernel.util.OrderByComparator;

import gr.open.marketplace.model.AdminIPValidationData;

public class ActiveComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "active ASC";

	public static String ORDER_BY_DESC = "active DESC";

	public ActiveComparator() {

		this(false);
	}

	public ActiveComparator(boolean asc) {

		_asc = asc;
	}

	public int compare(Object obj1, Object obj2) {

		AdminIPValidationData instance1 = (AdminIPValidationData) obj1;
		AdminIPValidationData instance2 = (AdminIPValidationData) obj2;

		int value = new Boolean(instance1.isActive()).compareTo(instance2.isActive());

		if (_asc) {
			return value;
		}
		else {
			return -value;
		}

	}

	public String getOrderBy() {

		if (_asc) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	private boolean _asc;

}
