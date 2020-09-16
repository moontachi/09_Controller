package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberCommand {
	void excute(HttpServletRequest request, HttpServletResponse response);
}

// 추상메서드만 들어간다.
//추상메서드 : 정의되지않은(미완성) 메서드

// 추상클래스, interface 차이


