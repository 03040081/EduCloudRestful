package com.zsc.edu.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTools {
	// ����cookie�����ƻ�ȡcookie��ֵ
		public static String getCookieValue(String cookieName,
				HttpServletRequest request) {
			String value = null; //
			// ��ȡ��ǰ�ͻ���cookie,����ΪCookie����
			Cookie[] cookies = request.getCookies();
			// ���cookies��Ϊ��
			if (cookies != null) {
				// ��������,Ѱ����Ӧ�������Ƿ����
				for (int i = 0; i < cookies.length; i++) {
					Cookie cookie = cookies[i];
					if (cookie.getName().equals(cookieName)) {
						value = cookie.getValue();
					}
				}
			}
			return value;
		}

		// ��cookieд��ͻ���
		public static void writeCookie(String name, String value,
				HttpServletResponse response) {
			// ����key-value�ķ�ʽ����һ��cookie
			Cookie cookie = new Cookie(name, value);
			// ����cookie��������
			cookie.setMaxAge(24 * 3600 * 7); // ʱ��Ϊһ������
			// ����cookie��λ��,����Ϊ'/'·����ʾ��Ŀ¼�������ļ����ܶ�ȡ��
			cookie.setPath("/");
			// ��cookieд��ͻ���
			response.addCookie(cookie);
		}

		// ������Ϊname��cookieɾ��
		public static void removeCookie(String name, HttpServletRequest request,
				HttpServletResponse response) {
			Cookie[] cookies = request.getCookies();
			// ���cookies��Ϊ��
			if (cookies != null) {
				// ��������,Ѱ����Ӧ�������Ƿ����
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().equals(name)) {
						Cookie cookie = cookies[i];
						// ����cookie��������Ϊ0
						cookie.setMaxAge(0); // ʱ��Ϊһ������
						// ����cookie��λ��,����Ϊ'/'·����ʾ��Ŀ¼�������ļ����ܶ�ȡ��
						cookie.setPath("/");
						// ��cookieд��ͻ���
						response.addCookie(cookie);
					}
				}
			}

		}
}
