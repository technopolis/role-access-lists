package gr.open.marketplace;

import java.text.SimpleDateFormat;


public interface Constants {

	public static final SimpleDateFormat DD_MM_YYYY_HH_MM_SS = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static final int ACTIVE_ALL = -1;
	public static final int ACTIVE_ONLY_INACTIVE = 0;
	public static final int ACTIVE_ONLY_ACTIVE = 1;
	
	public static final int DEBUG_MODE_ALL = -1;
	public static final int DEBUG_MODE_ONLY_INACTIVE = 0;
	public static final int DEBUG_MODE_ONLY_ACTIVE = 1;
	
	public static final int MODE_BOTH = 0;
	public static final int MODE_LOGIN = 1;
	public static final int MODE_CONTROL_PANEL = 2;
}
