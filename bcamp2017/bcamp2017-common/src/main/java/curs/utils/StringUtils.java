package curs.utils;

public class StringUtils {
	public static String revert(String pArg) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i < pArg.length();i++) {
			sb.insert(0, pArg.charAt(i));
		}
		return sb.toString();
	}
}
