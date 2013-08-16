
package gr.open.marketplace.comparators;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

public class CustomComparatorHelper {

	
	private static final Log logger = LogFactoryUtil.getLog(CustomComparatorHelper.class);
	
	public static OrderByComparator getDataOrderByComparator(String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equalsIgnoreCase("active")) {

			orderByComparator = new ActiveComparator(orderByAsc);
		}
		else if (orderByCol.equalsIgnoreCase("createDate")) {

			orderByComparator = new CreateDateComparator(orderByAsc);
		}
		else if (orderByCol.equalsIgnoreCase("modifiedDate")) {

			orderByComparator = new ModifiedDateComparator(orderByAsc);
		}
		else if (orderByCol.equalsIgnoreCase("userEmail")) {

			orderByComparator = new CreatedByComparator(orderByAsc);
		}

		return orderByComparator;
	}

}
