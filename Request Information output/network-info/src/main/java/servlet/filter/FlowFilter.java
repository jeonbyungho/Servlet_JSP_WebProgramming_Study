package servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class FlowFilter implements Filter{
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		long startTime = System.currentTimeMillis();
		
		req.setCharacterEncoding("UTF-8");
		chain.doFilter(req, resp);
		
		long endTime = System.currentTimeMillis();
		long excuteTime = endTime - startTime;
		
		System.out.println("수행 시간 : " + excuteTime + "ms");
	}
	
}
