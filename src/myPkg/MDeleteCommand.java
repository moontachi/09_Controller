package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MDeleteCommand implements MemberCommand{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String num = request.getParameter("num");
		
		MemberDao dao = MemberDao.getInstance();
		
		int cnt = dao.deleteData(num);
		System.out.println("delete cnt : " + cnt );
		
	}

}
