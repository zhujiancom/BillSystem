/**
 * 
 */
package org.zj.framework.context;

/**
 * @Description
 * @author zj
 * @Date 2014年10月21日
 *	
 */
public class UserContextHolder{
	private static ThreadLocal<UserInfo> USER_CONTEXT = new ThreadLocal<UserInfo>();

	private UserContextHolder(){}

	@SuppressWarnings("unchecked")
	public static <T extends UserInfo>T getCurrentUser(Class<T> clazz){
		return (T) USER_CONTEXT.get();
	}

	public static UserInfo getCurrentUser(){
		return USER_CONTEXT.get();
	}

	public static <T extends UserInfo> void setCurrentUser(T user){
		if(user != null){
			USER_CONTEXT.set(user);
		}
	}

	public static void removeCurrentUser(){
		USER_CONTEXT.remove();
	}
}
