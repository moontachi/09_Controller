package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MInsertCommand implements MemberCommand{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		
		//MemberDao dao = new MemberDao();
		MemberDao dao = MemberDao.getInstance();
		dao.insertData(id,passwd,name);
				
	}
	
}









