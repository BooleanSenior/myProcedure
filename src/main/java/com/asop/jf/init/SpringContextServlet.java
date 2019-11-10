package com.asop.jf.init;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.asop.jf.job.dyupdate.IndexCountJob;
import com.asop.jf.util.PropertiUtil;


/**
 * Servlet implementation class SpringContextServlet
 */
public class SpringContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static WebApplicationContext wc;
    private static Logger logger=Logger.getLogger(SpringContextServlet.class);   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpringContextServlet() {
        super();
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		wc=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
//		IndexCountJob indexJon=new IndexCountJob();
//		new Thread(indexJon).start();
	}
	

	public static WebApplicationContext getWc() {
		return wc;
	}
	public static void setWc(WebApplicationContext wc) {
		SpringContextServlet.wc = wc;
	}
	
	
}
