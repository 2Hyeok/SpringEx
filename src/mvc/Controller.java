package mvc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
	private Map<String, CommandHandler> handlerMap = new HashMap<String, CommandHandler> ();
	@Override
	public void init(ServletConfig config) throws ServletException {
		String configFile = config.getInitParameter( "configFile" );
		String path = config.getServletContext().getRealPath( "/" );
		String filename = path + configFile;
		FileInputStream fis = null;
		Properties prop = new Properties();		
		try {
			fis = new FileInputStream( filename );
			prop.load( fis );
			Iterator<Object> keys = prop.keySet().iterator();
			while( keys.hasNext() ) {
				String command = (String) keys.next();
				String handlerName = prop.getProperty( command );
				Class<?> handlerClass = Class.forName( handlerName );
				CommandHandler handler = (CommandHandler) handlerClass.newInstance();
				handlerMap.put( command, handler );				
			}			
		} catch( FileNotFoundException e ) {
			e.printStackTrace();
		} catch( IOException e ) {
			e.printStackTrace();
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		} catch( IllegalAccessException e ) {
			e.printStackTrace();
		} catch( InstantiationException e ) {
			e.printStackTrace();
		}
	}	
	public void doProcess( HttpServletRequest request, HttpServletResponse response )
		throws ServletException, IOException {
		String command = request.getRequestURI();
		if( command.indexOf(request.getContextPath()) == 0) {
			command = command.substring(request.getContextPath().length()); // ~.do ~.do 의 커멘드
		}
		CommandHandler handler = handlerMap.get(command);
		if(handler == null) {
			handler = new DefaultHandler();
		}
		
		String viewPage = null;
		try {
			viewPage = handler.process(request, response);
		} catch(Throwable t) {
			t.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess( req, resp );
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess( req, resp );
	}
}