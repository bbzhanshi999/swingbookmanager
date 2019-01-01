package edu.hyit.bm.util;

public class StringUtils {
	
	
	public static boolean isBlank(CharSequence target) {
		return null==target||"".equals(target);
	}
	
	public static boolean isNotBlank(CharSequence target) {
		return !isBlank(target);
	}
}
