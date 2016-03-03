package sk.didimdol.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class DriverLoaderListener
 *
 */
@WebListener
public class DriverLoaderListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DriverLoaderListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	//static {
    		try {
    			Class.forName("oracle.jdbc.driver.OracleDriver");
    			System.out.println("드라이버가 로드드되었습니다.");
    		} catch (ClassNotFoundException e) {
    			System.out.println("드라이버 클래스가 없습니다.");
    		}
    	//}
    }
	
}
