package com.zhuanzhuan.base;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.google.gson.Gson;

import entity.User;

/*
 * JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；
 * 对于任意一个对象，都能够调用它的任意一个方法和属性；
 * 这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。
 */
public class InvokeTest {

	private static Gson gson = new Gson();
	
	//获取class对象的方式
	public static Class getClassObject(int type) {
		switch(type){
		case 1 : User user = new User(); return user.getClass();
		case 2 : return User.class;
		case 3 : try {
				return  Class.forName("User");
			} catch (ClassNotFoundException e) {				
				e.printStackTrace();
			}
		default : return null;
		}
	}
	
	public static void main(String[] arg) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
		Class userClass = getClassObject(1);
		Method[]  methods = userClass.getDeclaredMethods();
		for(int i = 0; i<methods.length; i++){
			System.out.println(methods[i]);
		}		
		Field[] fields = userClass.getDeclaredFields();
		for(int i = 0; i<fields.length; i++){
			System.out.println(fields[i]);
		}
		
		try {
			User user = (User) userClass.newInstance();
			user.setAge(1);
			user.setName("yinhui");
			user.setNickName("xiaohui");
			user.setSchool("北邮");
		
			System.out.println(user.toString());
			
			
			Field field = userClass.getDeclaredField("name");
			field.setAccessible(true);
			field.set(user, "殷慧");
			System.out.println(user.toString());
			
			
			Field publicfield  = userClass.getField("school"); 
			publicfield.set(user, "武理");
			System.out.println(user.toString());
			
			
			Method  method = userClass.getDeclaredMethod("addAge", Integer.class);
			method.invoke(user, 3);
			System.out.println(user.toString());
			
			
		} catch (InstantiationException e) {			
			e.printStackTrace();
		} catch (IllegalAccessException e) {			
			e.printStackTrace();
		}
		
	}
}
