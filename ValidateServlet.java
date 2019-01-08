package com.testing.ahmed;

import java.util.*;  
import java.io.*; 

//import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ValidateServlet" })
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//PrintWriter out = response.getWriter();
		//out.println("Hello World"+ "Saif Ahmed mitti ke makan mein rehne wale");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("Name").toString();
		String position = request.getParameter("position").toString();
		String address = request.getParameter("address").toString();
		
		String ccnum = request.getParameter("ccnum").toString();
		String cvv = request.getParameter("cvv").toString();
		String pin = request.getParameter("pin").toString();
		String shippingaddress = request.getParameter("shippingaddress").toString();


		String objective = request.getParameter("objective").toString();
		String highlights = request.getParameter("highlights").toString();
		String skills = request.getParameter("skills").toString();
		String certifications = request.getParameter("certifications").toString();
		String experience = request.getParameter("experience").toString();
		String educationhistory = request.getParameter("educationhistory").toString();
		String languagesknown = request.getParameter("languagesknown").toString();
		String contactnumbers = request.getParameter("contactnumbers").toString();
		String emailids = request.getParameter("emailids").toString();
		
		PrintWriter out = response.getWriter();
		out.println("Hello World"+ "Saif Ahmed mitti ke makan mein rehne wale");
		out.println("Hello "+ name);
		out.println("position "+ position);
		out.println("address "+ address);
		out.println("ccnum "+ ccnum);
		out.println("cvv "+ cvv);
		out.println("pin "+ pin);
		out.println("shippingaddress "+ shippingaddress);

		out.println("objective "+ objective);
		out.println("highlights "+ highlights);
		out.println("skills "+ skills);
		out.println("certifications "+ certifications);
		out.println("experience "+ experience);
		out.println("educationhistory "+ educationhistory);
		out.println("languagesknown "+ languagesknown);
		out.println("contactnumbers "+ contactnumbers);
		out.println("emailids "+ emailids);

synchronized(this) {

try {

      String strfile = "";
	  //String startcounterfile_cntrfile = "--STRTCNTR--STRT--";
	  //String counterfile_cntrfile = "--CNTR--";
	  
	  int cntr_ctr = 0;
	  
	  //counterfile_cntrfile = cntr_ctr;
	  
	  //strfile = (cntr_ctr + 1) + " - " + strfile;
	  
	  strfile = "<SOFDBRCRD>" + strfile;
	  strfile = "<SOFRCRD>" + strfile;
	  
	  strfile = strfile + "<STRTOFRCDTOENDOFRCD>";
	  strfile = strfile + "<STRTROFSCTNENDOFSCTN>";
	  strfile = strfile + "<name>" + name + "</name>";
	  strfile = strfile + "<position>" + position + "</position>"; 
	  strfile = strfile + "<address>" + address + "<address>"; 
	  strfile = strfile + "<ccnum>" + ccnum + "</ccnum>";
	  strfile = strfile + "<cvv>" + cvv + "</cvv>" ;
	  strfile = strfile + "<pin>" + pin + "</pin>" ;
	  strfile = strfile + "<shippingaddress>" +  shippingaddress + "</shippingaddress>"; 
	  strfile = strfile + "<STRTROFSCTNENDOFSCTN>";
		  
	  strfile = strfile + "<objective>" + objective + "</objective>";
	  strfile = strfile + "<highlights>" + highlights + "</highlights>" ;
	  strfile = strfile + "<skills>" + skills + "</skills>" ;
	  strfile = strfile + "<certifications>" + certifications + "</certifications>" ;
      strfile = strfile + "<experience>" + experience + "</experience>" ;
      strfile = strfile + "<educationhistory>" + educationhistory + "</educationhistory>";
      strfile = strfile + "<languagesknown>" + languagesknown + "</languagesknown>" ;
      strfile = strfile + "<contactnumbers>"  + contactnumbers + "</contactnumbers>";
      strfile = strfile +  "<emailids>" + emailids + "</emailids>" ;
	  
//	  strfile = strfile + " ---complete recordbreak full--- ";
	  

	  /** String localLangoutputFilename = "C:\\Saif\\CVjobsiteupdater\\Outputfileexcelsheettest.csv";
	  **/

		PrintWriter outtest= null;
		PrintWriter outcntrtest = null;
		String workoutputfilestr = "C:\\Webserver\\apache-tomcat-8.5.35\\apache-tomcat-8.5.35\\webapps\\examples\\WEB-INF\\classes\\Outputfileexcelsheet.csv";
		String counterfilecntr = "C:\\Webserver\\apache-tomcat-8.5.35\\apache-tomcat-8.5.35\\webapps\\examples\\WEB-INF\\classes\\cntrfile_cntrfile.txt";
		String tempfiletmp = "C:\\Webserver\\apache-tomcat-8.5.35\\apache-tomcat-8.5.35\\webapps\\examples\\WEB-INF\\classes\\tempfile_tmpfile.txt";

		File f = new File(workoutputfilestr);
		File cntr_f = new File(counterfilecntr);

		Integer counter_read_read_Int=null;
		int int_counter_read_read = 0;
		
	  try {

		     StringBuilder contentBuilder = new StringBuilder();
			 BufferedReader br = new BufferedReader(new FileReader(counterfilecntr));
		    try
		        {
		 
		            String sCurrentLine=null;
		            while ((sCurrentLine = br.readLine()) != null)
		            {
		                contentBuilder.append(sCurrentLine);
		                
		            }
		        }
		        catch (IOException e)
		        {
		            e.printStackTrace();
		        }
					
		    br.close();

			String counter_read_read =null;
			counter_read_read = contentBuilder.toString();

			if (counter_read_read!=null) {
			    counter_read_read_Int = Integer.parseInt(counter_read_read);
				int_counter_read_read =	counter_read_read_Int.intValue();
		       }
			out.println("Hello int_counter_read_read after read file - cntrfile_cntrfile.txt"+ int_counter_read_read);
	

	  } catch (Exception e) {
		  e.printStackTrace();
	  }  

		if (  ( f.exists() && !f.isDirectory() ) ){
			outtest = new PrintWriter(new FileOutputStream(new File(workoutputfilestr), true));
			//outcntrtest = new PrintWriter(new FileOutputStream(new File(counterfilecntr), true));
		    
			if (int_counter_read_read>0) { 
				cntr_ctr=int_counter_read_read+1;
			}
			else {
				cntr_ctr = cntr_ctr + 1;
			}

			//counterfile_cntrfile = counterfile_cntrfile + cntr_ctr;
			//find pattern and seek to end of file, contains and make a hashmap like in locallangprogram k 
			
/**		outtest.append(strfile);
		outcntrtest.write(cntr_ctr);
**/			
		}
		else {
			outtest = new PrintWriter(workoutputfilestr);
			//outcntrtest = new PrintWriter(counterfilecntr);
			cntr_ctr = cntr_ctr + 1;
			//counterfile_cntrfile = counterfile_cntrfile + cntr;		
			
		}
		strfile = strfile + "</STRTOFRCDTOENDOFRCD>";
		strfile = strfile + "<cntr_ctr>" + cntr_ctr + "</cntr_ctr>" ;

		strfile = strfile + "</SOFRCRD>";
		strfile = strfile + "</SOFDBRCRD>";
		
		outtest.append(strfile);

		//File f = new File(workoutputfilestr);
		//File cntr_f = new File(counterfilecntr);
		File tempfile_tmpfile = new File(tempfiletmp);
		File cntrNew_f = new File(counterfilecntr);
		
		PrintWriter tmpfile_out = new PrintWriter(tempfile_tmpfile);
		
		if (cntr_f.exists()) {
			
			try {
				tmpfile_out.print(cntr_ctr);
			
				if (cntr_f.delete()) {
					if(cntrNew_f.createNewFile()) {
						PrintWriter outcntrtestfile2 = new PrintWriter(counterfilecntr);
						outcntrtestfile2.print(cntr_ctr);
						outcntrtestfile2.close();
					}
					if(tempfile_tmpfile.delete()) {
						out.println("clean delete");
					}
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		tmpfile_out.close();
		outtest.close();
		outcntrtest.close();
		
		out.println("clean exit after closing files");
		
/*		f.close();
		cntr_f.close();
*/		
	out.println("Hello Printed in file, wrote in file Outputfileexcelsheet.csv test completed, cntr fclose");
	
		
/*		try {
           // Set the attribute and Forward to hello.jsp
           request.setAttribute ("servletName", "servletTofowardChkoutJsp");
           getServletConfig().getServletContext().getRequestDispatcher(
                   "../../jsp/jsptohellochkoutserv/hellochkout.jsp").forward(request, response);
       } catch (Exception ex) {
           ex.printStackTrace ();
       }
*/

	} catch(Exception e) {
	e.printStackTrace();
 }
	
}

	}

	
}
