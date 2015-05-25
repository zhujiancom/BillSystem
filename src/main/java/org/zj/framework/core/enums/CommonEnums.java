package org.zj.framework.core.enums;

public final class CommonEnums {
	private CommonEnums(){}
	
	public enum YOrN{
		/*是*/
		Y,
		/*否*/
		N;
		public static YOrN getYN(boolean flag){
			return flag ? Y : N;
		}
		public static YOrN getYN(String flag){
			return Boolean.TRUE.toString().equals(flag) ? Y : N;
		}
		public static boolean isY(YOrN yn){
			return Y.equals(yn);
		}
	}
	
	/**
	 * 
	 * remark (备注): 有效性
	 *
	 * @author zj
	 *	
	 * 项目名称：BillSystem
	 *
	 * 类名称：Validity
	 *
	 * 包名称：org.zj.framework.core.enums
	 *
	 * Create Time: 2015年4月29日 下午3:50:37
	 *
	 */
	public enum Validity{
		Valid,Invalid
	}
}
