package com.testing.ahmed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner; 

public class Testingdb {

	
	public static void main(String args[]) {
		
			System.out.println("Enter the parameters : " 
					+ "name, position, address, ccnum, cvv, pin, shippingaddress, objective, "
					+ "highlights, skills, certifications, experience, educationhistory, "
					+ "languagesknown, contactnumbers, emailids");
		
		  Scanner s = new Scanner(System.in);
		  
		  
		  String name=""; 
		  String position="";
		  String address=""; 
		  String ccnum=""; 
		  String cvv=""; 
		  String pin="";
		  String shippingaddress="";
		  
		  String objective=""; 
		  String highlights=""; 
		  String skills=""; 
		  String certifications=""; 
		  String experience=""; 
		  String educationhistory="";
		  String languagesknown=""; 
		  String contactnumbers="";
		  String emailids = "";
		  
		  //int i = 0;
		  //int len = args.length;
		  //System.out.println("len :"+ len);
		  
		  //for (i=0; i<len; i++) {
			  
			System.out.println("name -"); 
				name = s.nextLine().trim();
				System.out.println("name" + name);

				System.out.println("position -");				
				position=s.nextLine().trim();
				System.out.println("position :"+ position );

				System.out.println("address -");
				address=s.nextLine().trim();
				System.out.println("address :"+ address);
				
				System.out.println("ccnum -");
				ccnum=s.nextLine().trim();
				System.out.println("ccnum :"+ ccnum);
				
				System.out.println("cvv -");
				cvv=s.nextLine().trim();
				System.out.println("cvv :" + cvv);
				
				System.out.println("pin -");
				pin=s.nextLine().trim();
				System.out.println("pin :" + pin);
				
				System.out.println("shippingaddress -");
				shippingaddress=s.nextLine().trim();
				System.out.println("shippingaddress :"+ shippingaddress);
			
				System.out.println("objective -");
				objective=s.nextLine().trim();
				System.out.println("objective :"+ objective);
	
				System.out.println("highlights -");
				highlights=s.nextLine().trim();
				System.out.println("highlights :"+ highlights);
				
				System.out.println("skills -");
				skills=s.nextLine().trim();
				System.out.println("skills :"+ skills);
				
				System.out.println("certifications -");
				certifications=s.nextLine().trim();
				System.out.println("certifications :"+ certifications);
				
				System.out.println("experience -");
				experience=s.nextLine().trim();
				System.out.println("experience :"+ experience);
				
				System.out.println("educationhistory -");
				educationhistory=s.nextLine().trim();
				System.out.println("educationhistory :"+ educationhistory);
				
				System.out.println("languagesknown -");
				languagesknown=s.nextLine().trim();
				System.out.println("languagesknown :" + languagesknown);
				
				System.out.println("contactnumbers -");
				contactnumbers=s.nextLine().trim();
				System.out.println("contactnumbers :" + contactnumbers);
				
				System.out.println("emailids -");
				emailids=s.nextLine().trim();
				System.out.println("emailids :"+ emailids);
			
				s.close();
		  //}
		  
		  int flagdbstr=0;
		  Testingdb testingdb = new Testingdb();
		  
		  int flagheaderstr=0;
		  flagheaderstr = testingdb.headerorfooterwritedb("SOFDBRCRD","header");
		  
		  if (flagheaderstr==1) {
			  System.out.println("Wrote header in db, updated in db");
		  }

		  flagdbstr = testingdb.writedb(name, position, address, ccnum, cvv, pin, shippingaddress,
				  objective, highlights, skills, certifications, experience, educationhistory,
				  languagesknown, contactnumbers, emailids);

		  if (flagdbstr==1)
		  {
			  System.out.println("Wrote in db, updated in db");
		  }

		  flagheaderstr=0;
		  flagheaderstr = testingdb.headerorfooterwritedb("SOFDBRCRD","footer");
		  if (flagheaderstr==1) {
			  System.out.println("Wrote in footer in db, updated in db");
		  }
		  

	}

	private int headerorfooterwritedb(String headerorfooter, String headerorfooterchoice) {

		int	strheaderdbflag=0; 			
		String optionchoicestrheaderorfooter="";
		optionchoicestrheaderorfooter=headerorfooterchoice;
		
		String strfileheaderorfooter="";
		String strheaderorfooter=headerorfooter;
		
		synchronized(this) {
		
			try {
			
		  //String strfileheaderorfooter = "";
		  if (optionchoicestrheaderorfooter.equals("header")) {
			  strfileheaderorfooter= strfileheaderorfooter + "<"+ strheaderorfooter +">"; //"<SOFDBRCRD>";
		  } else if (optionchoicestrheaderorfooter.equals("footer")) {
			  strfileheaderorfooter = strfileheaderorfooter + "</"+ strheaderorfooter +">"; //"<SOFDBRCRD>";
		  } 
		  
		  String workoutputfilestr = "C:\\Webserver\\Outputfileexcelsheetnew947119429741144254119.xml";

		  File f = new File(workoutputfilestr);
		  
		  PrintWriter outtest= null;
		  
			
			if (  ( f.exists() && !f.isDirectory() ) ){
				outtest = new PrintWriter(new FileOutputStream(new File(workoutputfilestr), true));
			}
			else {
				outtest = new PrintWriter(workoutputfilestr);
			}
			
			System.out.println("strfileheaderorfooter - "+strfileheaderorfooter);
			outtest.append(strfileheaderorfooter);
			strheaderdbflag =1;
			outtest.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			}
			
		}
			
			return strheaderdbflag;
	}
	
	
	private int writedb(String name, String position, String address, String ccnum, String cvv, 
			String pin, String shippingaddress, String objective, String highlights, String skills, 
			String certifications, String experience, String educationhistory,
			String languagesknown, String contactnumbers, String emailids) {
		
		int	strdbflag=0; 			

		synchronized(this) {
		
			
		try {
		
		  String strfile = "";
/*		  String name, position, address, ccnum, cvv, pin, shippingaddress,
		  objective, highlights, skills, certifications, experience, educationhistory,
		  languagesknown, contactnumbers, emailids = "";
*/		  
		  //String startcounterfile_cntrfile = "--STRTCNTR--STRT--";
		  //String counterfile_cntrfile = "--CNTR--";
		  
		  int cntr_ctr = 0;
		  
		  //counterfile_cntrfile = cntr_ctr;
		  
		  //strfile = (cntr_ctr + 1) + " - " + strfile;
		  
		  //strfile = strfile + "<SOFDBRCRD>";
		  strfile = strfile + "<SOFRCRD>" ;

/**
 * 				System.out.println("name" + args[0]);
				System.out.println("position :"+ args[1] );
				System.out.println("address :"+ args[2]);
				
				System.out.println("ccnum :"+ args[3]);
				System.out.println("cvv :" + args[4]);
				System.out.println("pin :" + args[5]);
				System.out.println("shippingaddress :"+ args[6]);
			
				System.out.println("objective :"+ args[7]);
				System.out.println("highlights :"+ args[8]);
				System.out.println("skills :"+ args[9]);
				System.out.println("certifications :"+ args[10]);
				System.out.println("experience :"+ args[11]);
				System.out.println("educationhistory :"+ args[12]);
				System.out.println("languagesknown :" + args[13]);
				System.out.println("contactnumbers :" + args[14]);
				System.out.println("emailids :"+ args[15]);

 **/		  
		  strfile = strfile + "<STRTOFRCDTOENDOFRCD>";
		  strfile = strfile + "<STRTOFSCTNENDOFSCTN>";
		  strfile = strfile + "<name>" + name + "</name>";
		  strfile = strfile + "<position>" + position + "</position>"; 
		  strfile = strfile + "<address>" + address + "<address>"; 
		  strfile = strfile + "<ccnum>" + ccnum + "</ccnum>";
		  strfile = strfile + "<cvv>" + cvv + "</cvv>" ;
		  strfile = strfile + "<pin>" + pin + "</pin>" ;
		  strfile = strfile + "<shippingaddress>" +  shippingaddress + "</shippingaddress>"; 
		  strfile = strfile + "</STRTOFSCTNENDOFSCTN>";
			  
		  strfile = strfile + "<objective>" + objective + "</objective>";
		  strfile = strfile + "<highlights>" + highlights + "</highlights>" ;
		  strfile = strfile + "<skills>" + skills + "</skills>" ;
		  strfile = strfile + "<certifications>" + certifications + "</certifications>" ;
		  strfile = strfile + "<experience>" + experience + "</experience>" ;
		  strfile = strfile + "<educationhistory>" + educationhistory + "</educationhistory>";
		  strfile = strfile + "<languagesknown>" + languagesknown + "</languagesknown>" ;
		  strfile = strfile + "<contactnumbers>"  + contactnumbers + "</contactnumbers>";
		  strfile = strfile +  "<emailids>" + emailids + "</emailids>" ;
		  
		//  strfile = strfile + " ---complete recordbreak full--- ";
		  
		
		  /** String localLangoutputFilename = "C:\\Saif\\CVjobsiteupdater\\Outputfileexcelsheettest.csv";
		  **/

			String workoutputfilestr = "C:\\Webserver\\Outputfileexcelsheetnew947119429741144254119.xml";
			String counterfilecntr = "C:\\Webserver\\cntrfile_cntrfile.txt";
			String tempfiletmp = "C:\\Webserver\\tempfile_tmpfile.txt";
			
/*			String workoutputfilestr = "C:\\Webserver\\apache-tomcat-8.5.35\\apache-tomcat-8.5.35\\webapps\\examples\\WEB-INF\\classes\\Outputfileexcelsheet.csv";
			String counterfilecntr = "C:\\Webserver\\apache-tomcat-8.5.35\\apache-tomcat-8.5.35\\webapps\\examples\\WEB-INF\\classes\\cntrfile_cntrfile.txt";
			String tempfiletmp = "C:\\Webserver\\apache-tomcat-8.5.35\\apache-tomcat-8.5.35\\webapps\\examples\\WEB-INF\\classes\\tempfile_tmpfile.txt";
*/			
			
			File f = new File(workoutputfilestr);
			File cntr_f = new File(counterfilecntr);
		
		  
			PrintWriter outtest= null;
			//PrintWriter outcntrtest = null;

			Integer counter_read_read_Int=null;
			int int_counter_read_read = 0;
			int cntr_cntrfilflag=0;
		  try {
			  
			     StringBuilder contentBuilder = new StringBuilder();
				 BufferedReader br = new BufferedReader(new FileReader(counterfilecntr));
			    try
			        {
			 
			            String sCurrentLine=null;
			            while ((sCurrentLine = br.readLine()) != null)
			            {
			            	System.out.println("sCurrentLine - "+sCurrentLine);
			                contentBuilder.append(sCurrentLine);
			                System.out.println("contentBuilder - "+contentBuilder.toString());
			                cntr_cntrfilflag=1;
			            }
			        }
			        catch (IOException e)
			        {
			            e.printStackTrace();
			        }
						
			    br.close();
		
				String counter_read_read =null;
				if(cntr_cntrfilflag==0)
						{
							int_counter_read_read=0;
							counter_read_read = "1";
							System.out.println("counter_read_read is null so set to 1 - "+ counter_read_read);
							
						}
				else
				{
					int_counter_read_read=1;
					counter_read_read = contentBuilder.toString().trim();
					System.out.println("counter_read_read read from file - "+ counter_read_read);
				}
				//System.out.println("counter_read_read :"+counter_read_read);
				
				System.out.println("counter_read_read - "+ counter_read_read);
				
			
				//int_counter_read_read =	Integer.parseInt(counter_read_read);
		
		  } catch (Exception e) {
			  e.printStackTrace();
		  }  
		
		int cntrflag = 0;
		
/*			if (  ( f.exists() && !f.isDirectory() ) ){
				outtest = new PrintWriter(new FileOutputStream(new File(workoutputfilestr), true));
				//outcntrtest = new PrintWriter(new FileOutputStream(new File(counterfilecntr), true));
*/			    
		  File file = new File("C:\\Webserver\\Outputfileexcelsheetnew947119429741144254119.xml");
		  try {
	    	  
			      if(file.exists() && !file.isDirectory()){
			  	 	file.createNewFile();
			  	  }
		  	  
		  	    FileWriter fw = new FileWriter(file,true);
			    BufferedWriter bw = new BufferedWriter(fw);
			  	PrintWriter outtestpw = new PrintWriter(bw);
					    
				if (int_counter_read_read>0) { 
					cntr_ctr=int_counter_read_read+1;
				}
				else {
					cntr_ctr = cntr_ctr + 1;
				}
				cntrflag =1;
				
		
				if (int_counter_read_read>0) { 
					cntr_ctr=int_counter_read_read+1;
				}
				else {
					cntr_ctr = cntr_ctr + 1;
				}
				cntrflag =1;
				//counterfile_cntrfile = counterfile_cntrfile + cntr_ctr;
				//find pattern and seek to end of file, contains and make a hashmap like in locallangprogram k 

				outtestpw.print(strfile);
				//outtest.append(System.lineSeparator());
				strdbflag = 1;
				
				outtestpw.close();
			} catch (IOException e){
				e.printStackTrace();
			}

				
			strfile = strfile + "</STRTOFRCDTOENDOFRCD>";
			strfile = strfile + "<cntr_ctr>" + cntr_ctr + "</cntr_ctr>" ;
		
			strfile = strfile + "</SOFRCRD>";
	//		strfile = strfile + "</SOFDBRCRD>";

			
			//strfile = strfile + "/n";
			//outtest.append(strfile);
			//outtest.append(System.lineSeparator());
			strdbflag = 1;
			
			if ((cntrflag == 0) && (cntr_ctr<1)) {
				cntr_ctr = cntr_ctr +1;
			}

			int cntr_read_readflag;
			cntr_read_readflag=0;
			
			//File f = new File(workoutputfilestr);
			//File cntr_f = new File(counterfilecntr);
			File tempfile_tmpfile = new File(tempfiletmp);
			File cntrNew_f = new File(counterfilecntr);
			
			PrintWriter tmpfile_out = new PrintWriter(tempfile_tmpfile);
			
			if (cntr_f.exists()) {
				
				try {
					StringBuilder cntrcontentBuilder = new StringBuilder();
					BufferedReader br = new BufferedReader(new FileReader(counterfilecntr));
					try {

						String scntrCurrentLine = null;
						while ((scntrCurrentLine = br.readLine()) != null) {
							cntrcontentBuilder.append(scntrCurrentLine);
							cntr_read_readflag=1;
						}
					} catch (IOException e) {
						e.printStackTrace();
					}

					br.close();

					String cntr_read_read = null;
					int int_cntr_read_read =0;
					cntr_read_read = cntrcontentBuilder.toString();
					System.out.println("cntr_read_read -" + cntr_read_read);
					
					if (cntr_read_readflag==1) {
						int_cntr_read_read= Integer.parseInt(cntr_read_read);						
					}else {
						int_cntr_read_read =0;
					}
					int_cntr_read_read=int_cntr_read_read+1;
					//read cntr_cntr file and write it - the counter in tmp file, increment it and then again in cntr_cntr file
					tmpfile_out.print(int_cntr_read_read);
					
					if (cntr_f.delete()) {
						if(cntrNew_f.createNewFile()) {
							PrintWriter outcntrtestfile2 = new PrintWriter(counterfilecntr);
							outcntrtestfile2.print(int_cntr_read_read);
							outcntrtestfile2.close();
						}
						if(tempfile_tmpfile.delete()) {
							System.out.println("clean delete");
						}
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			tmpfile_out.close();

			//outtest.close();
			//outcntrtest.close();
			
		//	out.println("clean exit after closing files");
			
		/*		f.close();
			cntr_f.close();
		*/		
		//out.println("Hello Printed in file, wrote in file Outputfileexcelsheet.csv test completed, cntr fclose");
		
			
		
		} catch(Exception e) {
		e.printStackTrace();
		}
		
		}
		
		return strdbflag;
		
		}
	
	
	
	
}
