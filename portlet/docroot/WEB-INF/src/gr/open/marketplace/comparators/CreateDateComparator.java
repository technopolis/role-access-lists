package gr.open.marketplace.comparators;

import com.liferay.portal.kernel.util.OrderByComparator;

import gr.open.marketplace.model.AdminIPValidationData;


public class CreateDateComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "createDate ASC";

	public static String ORDER_BY_DESC = "createDate DESC";

	public CreateDateComparator() {

		this(false);
	}

	public CreateDateComparator(boolean asc) {

		_asc = asc;
	}

	public int compare(Object obj1, Object obj2) {

		AdminIPValidationData instance1 = (AdminIPValidationData) obj1;
		AdminIPValidationData instance2 = (AdminIPValidationData) obj2;

		int value = instance1.getCreateDate().compareTo(instance2.getCreateDate());

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
