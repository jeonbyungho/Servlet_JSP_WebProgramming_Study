package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reqInfo")
public class RequestInfoServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.print("<!DOCTYPE html>");
		
		out.print("<html lang=\"ko\"><head>");
		out.print("<title>Request 정보 출력</title>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.print("</head>");
		
		out.print("<body>");
		
		// 네트워크 관련 요청 정보
		out.print("<h3>네트워크 관련 요청 정보</h3>");
		out.print("<ul>");
		out.print("<li> 요청 스킴 : " + req.getScheme() + "</li>");
		out.print("<li> 서버 이름 : " + req.getServerName() + "</li>");
		out.print("<li> 서버 주소 : " + req.getLocalAddr() + "</li>");
		out.print("<li> 서버 포트 : " + req.getServerPort() + "</li>");
		out.print("<li> 클라이언트 주소 : " + req.getRemoteAddr() + "</li>");
		out.print("<li> 클라이언트 호스트 : " + req.getRemoteHost() + "</li>");
		out.print("<li> 클라이언트 포트 : " + req.getRemotePort() + "</li>");
		out.print("</ul>");
		
		// URI, Method, Protocol 정보
		out.print("<h3>요청 방식과 프로토콜 정보</h3>");
		out.print("<ul>");
		out.print("<li> 요청 방식 : " + req.getMethod() + "</li>");
		out.print("<li> 요청 URI : " + req.getRequestURI() + "</li>");
		out.print("<li> 요청 URL : " + req.getRequestURL().toString() + "</li>");
		out.print("<li> 컨텍스트 경로 : " + req.getContextPath() + "</li>");
		out.print("<li> 요청 프로토콜 : " + req.getProtocol() + "</li>");
		out.print("<li> 서블릿 경로 : " + req.getServletPath() + "</li>");
		out.print("</ul>");
		
		// 요청 헤더의 모든 정보
		out.print("<h3>요청 헤더 정보</h3>");
		out.print("<ul>");
		
		Enumeration<String> em = req.getHeaderNames();
		while(em.hasMoreElements()) {
			String name = em.nextElement();
			out.print("<li>");
			out.print(name + " : " + req.getHeader(name));
			out.print("</li>");
		}
		
		out.print("</ul>");
		
		// 서블릿 컨텍스트 정보
		ServletContext sc = this.getServletContext();
		
		out.print("<h3>웹 애플리케이션 정보</h3>");
		out.print("<ul>");
		out.print("<li> 서블릿 버전 : " + sc.getMajorVersion() + "</li>");
		out.print("<li> 웹 애플레이케이션 이름 : " + sc.getServletContextName() + "</li>");
		out.print("<li> 웹 애플레이케이션 경로 : " + sc.getContextPath() + "</li>");
		out.print("</ul>");
		
		out.print("</bdoy></html>");
		
		out.close();
	}
	
}
