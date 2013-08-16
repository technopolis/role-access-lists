package gr.open.marketplace.comparators;

import com.liferay.portal.kernel.util.OrderByComparator;

import gr.open.marketplace.model.AdminIPValidationData;


public class CreatedByComparator extends OrderByComparator {
	public static String ORDER_BY_ASC = "userName ASC";

	public static String ORDER_BY_DESC = "userName DESC";

	public CreatedByComparator() {

		this(false);
	}

	public CreatedByComparator(boolean asc) {

		_asc = asc;
	}

	public int compare(Object obj1, Object obj2) {

		AdminIPValidationData instance1 = (AdminIPValidationData) obj1;
		AdminIPValidationData instance2 = (AdminIPValidationData) obj2;

		int value = instance1.getUserName().toLowerCase().compareTo(instance2.getUserName().toLowerCase());

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
