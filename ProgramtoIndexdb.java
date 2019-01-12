package com.testing.ahmed;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

public class ProgramtoIndexdb {

	public static void main(String args[]) throws IOException {
		
		Scanner s = new Scanner(System.in);

		  //String name=""; 
		  //String position="";
	  
		  //String contactnumbers="";
		  //String emailids = "";
		  
			  
		  System.out.println("index by - name, contactnumbers, emailids"); 
		  System.out.println("alternate contact number and email id will be provided"); 
		  System.out.println("group by - position"); 
		  System.out.println("User Input - 1, 2, 3, 4");	
		  
		  int option = 0;
		  option = Integer.parseInt(s.nextLine().trim());
		  System.out.println("option" + option);

		  if (option==1) //equals("name")) {
		  {
			  System.out.println("Program not ready");
			  System.exit(0);
		  }
		  else if (option==2) //equals("contactnumber")) {
		  {
			  System.out.println("Enter file name with pattern at end for e.g Outputfileexcelsheetnew1441742121.xml or Outputfileexcelsheetnew741144254119.xml"); 	
			  String filenamedest = s.nextLine().trim();
			  
			  long start = System.nanoTime();
			  	//File source = new File("C:\\WebServer\\Outputfileexcelsheet9441742121.csv");
			  	
			  	File source = new File("C:\\WebServer\\Outputfileexcelsheet9441742121921.csv");
		        //File dest = new File("C:\\WebServer\\Outputfileexcelsheetnew1441742121.xml");
			  	File dest = new File(filenamedest);
			  	File dest2 = new File("C:\\WebServer\\InfoXMLtempfileout94411471231.xml");
			  	
			  //using Java 7 and 8 Files class
		        //source = new File("C:\\WebServer\\Outputfileexcelsheet.csv");
		        //dest = new File("C:\\WebServer\\Outputfileexcelsheetnew.xml");
		
		        start = System.nanoTime();
		        try {
		        	//copyFileUsingJava7and8Files(source, dest);
		        	//copyFileUsingChannel(source, dest);
		        	copyFileUsingStream(source, dest);
		        	
		        } catch (IOException e) {
		        	e.printStackTrace();
		        }
		        System.out.println("Time taken by copyFileUsingStream Files Copy = "+(System.nanoTime()-start));        
		        
		        //read the xml file
		        //if the file is big we have to buffer it
		        
			     StringBuilder contentBuilder = new StringBuilder();
				 BufferedReader br = new BufferedReader(new FileReader(dest));
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
		
				String outputdest_read_read =null;
				outputdest_read_read = contentBuilder.toString();
				System.out.println("outputdest_read_read -"+outputdest_read_read);
		        //mobile numbers
				String contactnumbers="";
				int cntr=0;
				long unsortedmobilenumbers[]= new long[100];//number of mobile numbers or records
				long sortedmobilenumber[] = new long[100];
				
				for (cntr=0;cntr<100; cntr++) {
					unsortedmobilenumbers[cntr]=0;
					sortedmobilenumber[cntr]=0;
				}
				
				long tempmobilenumbers;
				tempmobilenumbers=0;
				
				int i=0;
				int x=0;
				int y=0;
		        //contact numbers

		        int arraystart[] =new int[100];				
	        	String fileoutputdest_read_read = "";
	        	fileoutputdest_read_read = outputdest_read_read;

		        String regexfile="";
	        	regexfile="<SOFDBRCRD>";
	        	Pattern filep = Pattern.compile(regexfile);
	        	Matcher mfile = filep.matcher(fileoutputdest_read_read);
	        	int ifile=0;
		        
	        	//possible error if length of string exceeds integer range

	        	int filepositionstartarray= 0;
//		        int filepositionendarray= 0;
		        while(mfile.find()) {
		        	
		        	filepositionstartarray=mfile.start();
		        	System.out.println("filepositionstartarray -" + filepositionstartarray); 
		        	System.out.println("Match - " + mfile.group() + " at positions " + mfile.start());

		        	System.out.println("filepositionstartarray - " + filepositionstartarray );
		        	arraystart[ifile] = filepositionstartarray;
		        ifile=ifile+1;
		        }		        
		        
		        int arrayend[] =new int[100];
		        String fileoutputdest_read_readend="";
		        fileoutputdest_read_readend = outputdest_read_read;
	        	String regexfileend="";
	        	regexfileend="</SOFDBRCRD>";
	        	Pattern fileendp = Pattern.compile(regexfileend);
	        	Matcher mfileend = fileendp.matcher(fileoutputdest_read_readend);
	        	int ifileend=0;
		        int filepositionendarray = 0;
		        
		        while(mfileend.find()) {
		        	
		        	System.out.println("Match - " + mfileend.group() + " at positions " + mfileend.end());

		        	filepositionendarray=mfileend.start()+13;

		        	System.out.println("filepositionendarray -" + filepositionendarray); 
		        	arrayend[ifileend] = filepositionendarray;

		        	ifileend=ifileend+1;
		        }

		        int numberofrecords=0;
		        numberofrecords=ifileend;
		        

				String regex="";
				regex="<contactnumbers>";
		        Pattern p = Pattern.compile(regex);
		        Matcher m = p.matcher(outputdest_read_read);
	        	System.out.println("outputdest_read_read - " + outputdest_read_read);

		        int positionstartarray= 0;
		        int positionendarray= 0;
		        while(m.find()) {
		        	
		        	positionstartarray=m.start()+16;
		        	System.out.println("positionstartarray -" + positionstartarray); 
		        	positionendarray=m.end()+10;
		        	System.out.println("positionendarray -" + positionendarray); 
		        	System.out.println("Match - " + m.group() + " at positions " + m.start() + " - " + (m.end()-1));

		        	System.out.println("positionstartarray - positionstartarray"+positionstartarray + " - " + positionendarray);
		        	contactnumbers = outputdest_read_read.substring(positionstartarray, positionendarray);
		        	System.out.println("contactnumbers - " + contactnumbers);
		        	
		        	tempmobilenumbers=Long.parseLong(contactnumbers);
		        	System.out.println("tempmobilenumbers - " + tempmobilenumbers);
		        	unsortedmobilenumbers[i]=tempmobilenumbers;
		        	System.out.println("mobilenumbers - " + "[" +i+ "]" + unsortedmobilenumbers[i]);
		        	
		        	
		        i=i+1;
		        x=x+1;
		        y=y+1;
		        
		        }

		       //make these ints as long
		        
		        int recrdcntr=0;
		        recrdcntr=unsortedmobilenumbers.length;
		        
		        //make these ints as long
		        
		        int mobilephonerecordscntr1=0;
		        int mobilephonerecordscntr2=0;
		        int mobilephonerecordscntr3=0;
		        int mobilephonerecordscntr4=0;
		        
		        long mobilephonerecords[][][][]= new long[100][100][100][100];

/*		        for (long[][][][] row: mobilephonerecords)
		        {
		            for (long[][][] innerRow: row)
		            {
		                for (long[][] innerInnerRow: innerRow)
		                {
			                for (long[] innerinnerInnerRow: innerInnerRow)
			                {
			                	Arrays.fill(innerinnerInnerRow, 0);
			                }
		                }
		            }
		        }

*/		        
		        int xcntr=0;
		        int arrcntr1=0;
		        long temp1=0;

		        int arrcntr2=0;
		        long temp2=0;
		        
		        int arrcntr3=0;
		        long temp3=0;
		        
		        int arrcntr4=0;
		        long temp4=0;
		        int ycntr=0;
		        int zcntr=0;
		        int icntr=0;
		        //StringBuilder sb2 = new StringBuilder();
		        String sb2="";
		        String sbstr="";
		        //Label Startbuildfilestr;
		        
		        try {
		        	
			        sbstr=sbstr+"<xmlstart>";
		        
		        while ((xcntr<recrdcntr) && (ycntr<recrdcntr) && (zcntr<recrdcntr) && (icntr<recrdcntr) && (unsortedmobilenumbers[arrcntr3]>0))
		        {

		        	temp1=arrayend[arrcntr1];
		        	mobilephonerecords[0][0][0][arrcntr1] = temp1;
		        	arrcntr1=arrcntr1+1;
		        	sbstr=sbstr+"<rcrdstrt>";
		        	sbstr=sbstr+"<arrayend>"+temp1+"</arrayend>";
		        	xcntr=xcntr+1;

		        
		        	temp2=arraystart[arrcntr2];
		        	mobilephonerecords[0][0][arrcntr2][0] = temp2;
		        	arrcntr2=arrcntr2+1;
		        	sbstr=sbstr+"<arraystart>"+temp2+"</arraystart>";
		        	ycntr=ycntr+1;

		        	
		        	temp3=unsortedmobilenumbers[arrcntr3];
		        	mobilephonerecords[0][arrcntr3][0][0] = temp3;
		        	arrcntr3=arrcntr3+1;
		        	sbstr=sbstr+"<mobilenonumber>"+temp3+"</mobilenonumber>";
		        	zcntr=zcntr+1;
		        	
		        
		        	temp4=icntr;
		        	mobilephonerecords[arrcntr4][0][0][0] = temp4;
		        	arrcntr4=arrcntr4+1;
		        	sbstr=sbstr+"<Sno>"+temp4+"</Sno>";
		        	sbstr=sbstr+"</rcrdstrt>";
		        	icntr=icntr+1;
		        	
		        	//sb2.append(sbstr);
		        	sb2=sb2+sbstr;
		        }
		        
		        sbstr=sbstr+"</xmlstart>";
		        //sb2.append(sbstr);
		        sb2=sb2+sbstr;
	        }
			catch (Exception e)
			{
				e.printStackTrace();
	        }

			    long start2 = System.nanoTime();
			    
		        try {
		        	//copyFileUsingJava7and8Files(source, dest);
		        	//copyFileUsingChannel(source, dest);
		        	//copyFileUsingStream(source, dest);
		        	//writeFileUsingStream(sb2.toString().trim(),dest2);
		        	writeFileUsingStream(sb2,dest2);
		        	
		        } catch (IOException e) {
		        	e.printStackTrace();
		        }
		        System.out.println("Time taken by copyFileUsingStream Files Copy = "+(System.nanoTime()-start2));        
		        
		        
		        int ixcntr=0;
		        int iycntr=0;
		        int izcntr=0;
		        int ikcntr=0;
		        //long [][][][] mobilephonerecords2= new long[100][100][100][100];
		        
/*		        for (long[][][] row: mobilephonerecords)
		        {
		        	izcntr=0;
	                //System.out.println("mobilephonerecords "+izcntr+" - "+mobilephonerecords[izcntr][0][0][0]);
	                izcntr++;

		        	for (long[][] innerRow: row)
		            {
		                iycntr=0;
		            	//System.out.println("mobilephonerecords "+iycntr+" - "+mobilephonerecords[0][iycntr][0][0]);
		                iycntr++;
		                
		            	for (long[] innerInnerRow: innerRow)
		                {
		                ixcntr=0;
		                System.out.println("mobilephonerecords "+ixcntr+" - "+mobilephonerecords[0][0][0][ixcntr]);
		                ixcntr++;
		                
		                }
		            }
		        }
*/		        		        
		        
		        int mobilenumbercntrx=0;
		        int recrdcntrx=0;

		        while (recrdcntrx<numberofrecords)
		        {
		        	System.out.println("mobilephonerecords[][][][] -"+mobilephonerecords[recrdcntrx][recrdcntrx][recrdcntrx][recrdcntrx]);
		        	mobilenumbercntrx=mobilenumbercntrx+1;
		        	recrdcntrx=recrdcntrx+1;
		        }
		        
		        recrdcntrx=0;
		        while (recrdcntrx<numberofrecords)
		        {
		        	System.out.println("print mobilephonerecords as array-"+mobilephonerecords);
		        	mobilenumbercntrx=mobilenumbercntrx+1;
		        	recrdcntrx=recrdcntrx+1;
		        }
		        

		        
		        int unsortedarrcntr=0;
		        int l=0;
		        int mobilearrlen = unsortedmobilenumbers.length;
		        System.out.println("unsorted mobilearrlen - "+mobilearrlen);
		        
	/*	        int fncntr2=0;
		        for (fncntr2=0;fncntr2<100; fncntr2++) {
		    		System.out.println("unsortedmobilenumbers[fncntr2] -"  + unsortedmobilenumbers[fncntr2]);
		    	}
	*/	        
		        int sortedmobilearrlen;
		        sortedmobilearrlen=0;
		        
		        sortedmobilenumber = SelectionSort(unsortedmobilenumbers);
		        
		        sortedmobilearrlen=sortedmobilenumber.length;
		        
		        int nxcntr;
		        nxcntr=0;
		        
		        for(nxcntr=0;nxcntr<sortedmobilearrlen;nxcntr++) {
		        	System.out.println("the sorted array is sortedmobilenumber[nxcntr] - "+ nxcntr +" - " +sortedmobilenumber[nxcntr]);
		        	if (sortedmobilenumber[nxcntr]==0)
		        	{
			        	break; 
		        	}
		        }

		        
		  }
		  else if (option==3) //"emailids")) {
		  {
			  System.out.println("Program not ready");
			  System.exit(0);  
		  }
		  else if (option==4) //equals("option")) {
		  {
			  System.out.println("Program not ready");
			  System.exit(0);
		  }
		
	}

    private static long[] SelectionSort(long mobilenumbers[])  {
   
    long tempk=0;
    
    long min=0; 
    long max=0; 

    long min2=0; 
    long max2=0; 

    long tempmobilenumber=0; 
    long tempmobilenumber2=0;
    
    int mobilearrlen2=0;

    //selection sort
    // replace by long if db file is greater than 100 records
   	int jmincntr=0; 
    int	kmincntr=0;
    
    //local var
    int fncntr=0;
    long unsortedmobilenumbers2[] = new long[100];
    long sortedmobilenumbers[] = new long[100];
    long partialsortedminimummobilenumbers[] = new long[100];
    	
    
    for (fncntr=0;fncntr<100; fncntr++) {
		unsortedmobilenumbers2[fncntr]=0;
		sortedmobilenumbers[fncntr]=0;
		partialsortedminimummobilenumbers[fncntr]=0;
	}

    int dynamiclength;
    dynamiclength=mobilenumbers.length;
    
    int fncntr3=0;

    for (fncntr3=0;fncntr3<dynamiclength; fncntr3++) {
    	if (mobilenumbers[fncntr3]==0) {
    		unsortedmobilenumbers2[fncntr3]=0;
    		break;
    	}
    	else {
    		unsortedmobilenumbers2[fncntr3]=mobilenumbers[fncntr3];
    	}
	}
    
//    unsortedmobilenumbers2=mobilenumbers;
    
    int fncntr2=0;
    
    for (fncntr2=0;fncntr2<dynamiclength; fncntr2++) {
		System.out.println("unsortedmobilenumbers2[fncntr2] -"  + unsortedmobilenumbers2[fncntr2]);
		if (unsortedmobilenumbers2[fncntr2]==0) {
			break;
		}
	}

    mobilearrlen2=mobilenumbers.length;
    System.out.println("mobilearrlen -"+ mobilearrlen2);
    
    

    //int dynamiclength=mobilearrlen2;
    int index;
    index=1;
    
    int selectionsortcntr1;
    selectionsortcntr1=1;
    
    int selectionsortcntr2;
    selectionsortcntr2=0;
    
    int cntrProgramsecondpasscntr;
    cntrProgramsecondpasscntr=0;
    
    int selectionsortcntrsortedmobilecntr;
    selectionsortcntrsortedmobilecntr=0;

    int jkzmincntr;
    jkzmincntr=0;
    
    int programcntr;
    programcntr=1;
    
    int tempprogramcntr;
    tempprogramcntr=0;

    int flagminchanged;
    int flagminchangedcntr;
    flagminchanged=0;
    flagminchangedcntr=0;

    int flagsortedarrayset;
    flagsortedarrayset=1;
    
    int partialsortedminimummobilenumbersflag;
    partialsortedminimummobilenumbersflag=0;
    
    min=unsortedmobilenumbers2[jmincntr];
    System.out.println("Initial minimum "+ min);
    
    int tempcopiedarraycntr;
    tempcopiedarraycntr=0;
    
    long tempsortedmobilenumbers[]= new long[100];
    
    int arrjuggledandexchangedflag;
    arrjuggledandexchangedflag=0;
    
    int dynamiclengthflag;
    dynamiclengthflag=0;
    
    int partialsortedminimummobilenumberscntr;
    partialsortedminimummobilenumberscntr=0;
    
    int arrjuggledandexchangedflag2;
    arrjuggledandexchangedflag2=0;
    
    int arrjuggledandexchangedflag2cntr;
    arrjuggledandexchangedflag2cntr=0;
    
while (cntrProgramsecondpasscntr<dynamiclength) {

	if(unsortedmobilenumbers2[jmincntr]==0L) {
		jmincntr=jmincntr+1;
		cntrProgramsecondpasscntr=cntrProgramsecondpasscntr+1;
		break;
	}
	
	if ((flagminchanged==1) && (flagminchangedcntr>0) && (flagsortedarrayset==1)){
//		programcntr=1;
		jmincntr=jmincntr+1;
		min=unsortedmobilenumbers2[jmincntr];
	}
	else {
		System.out.println("min unchanged");
		//jmincntr=jmincntr+1;
		//min=unsortedmobilenumbers2[jmincntr];
	}
	
	System.out.println("min chking - min -"+ min + "unsortedmobilenumbers2[programcntr]" +  unsortedmobilenumbers2[programcntr]+ " tempsortedmobilenumbers[selectionsortcntr1] -" +tempsortedmobilenumbers[selectionsortcntr1]);
	selectionsortcntr1=index;
	
	    //for (selectionsortcntr1=index;selectionsortcntr1<dynamiclength;selectionsortcntr1++) {
	    while ((selectionsortcntr1<dynamiclength) && (cntrProgramsecondpasscntr<dynamiclength)) {
	    	kmincntr=0;
	    	
	    	if (partialsortedminimummobilenumbersflag==0) {
	    		System.out.println("avoid the partialsortedminimummobilenumbers setting as its not going through that path");
	    	} else {	    		
		    	while (kmincntr<dynamiclength) {
		    	
		    		if ((unsortedmobilenumbers2[kmincntr]==partialsortedminimummobilenumbers[kmincntr]) 
		    				|| (tempsortedmobilenumbers[kmincntr]==partialsortedminimummobilenumbers[kmincntr]))
		    		{
		    			System.out.println("dont need to sort - no need to sort");
		    			kmincntr=kmincntr+1;
		    			//set partialsortedminimummobilenumbersflag=1;
		    			partialsortedminimummobilenumbersflag=1;
		    			partialsortedminimummobilenumberscntr++;
	/*					selectionsortcntr1=selectionsortcntr1+1;
						index=index+1;
	*/	    			continue;
		    		}
		    		kmincntr=kmincntr+1;
		    		
		    	}	
	    	}
   
	     if ((partialsortedminimummobilenumbersflag>0) && (partialsortedminimummobilenumberscntr==jmincntr)) {
    			System.out.println("dont need to sort - no need to sort");
	    	}
	    	else {
		    	if (cntrProgramsecondpasscntr>0) {
			    	if ((min<tempsortedmobilenumbers[selectionsortcntr1]) && (flagsortedarrayset==1) ){
	/*					cntrProgramsecondpasscntr=cntrProgramsecondpasscntr+1;
	*/					//jmincntr=jmincntr+1;
						selectionsortcntr1=selectionsortcntr1+1;
						index=index+1;
			    		continue;
			    	} else {
			    		tempmobilenumber2=min;
			    		min=tempsortedmobilenumbers[selectionsortcntr1];
			    		tempsortedmobilenumbers[selectionsortcntr1]=tempmobilenumber2;
			    		partialsortedminimummobilenumbers[kmincntr]=min;
			    		//jmincntr=jmincntr+1;
			    		arrjuggledandexchangedflag=1;
			    		flagminchanged=1;
			    		flagminchangedcntr++;
			    		arrjuggledandexchangedflag2=0;
			    		
			    		for (tempcopiedarraycntr=0;tempcopiedarraycntr<dynamiclength;tempcopiedarraycntr++) {
			    			unsortedmobilenumbers2[tempcopiedarraycntr]=tempsortedmobilenumbers[tempcopiedarraycntr];
					    	}
			    		
			    	}
		    	}
		    	System.out.println("min - "+min);
		
				programcntr=selectionsortcntr1;
				
		    	if (arrjuggledandexchangedflag==1) {
					
		    	if (programcntr==dynamiclength) {
						//set dynamic flag
						dynamiclengthflag=1;
						if (min<unsortedmobilenumbers2[programcntr-1]) {
							System.out.println("min unchanged -"+min);	
							flagminchanged=0;
						}
						else
						{
							tempmobilenumber=min;
							min=unsortedmobilenumbers2[programcntr];
							unsortedmobilenumbers2[programcntr]=tempmobilenumber;
							partialsortedminimummobilenumbers[kmincntr]=min;
							flagminchanged=1;
							flagminchangedcntr++;
						}
	/*					cntrProgramsecondpasscntr=cntrProgramsecondpasscntr+1;
						jmincntr=jmincntr+1;
						index=index+1;
						
	*/					selectionsortcntr1=selectionsortcntr1+1;
						index=index+1;
						//jmincntr=jmincntr+1;
						break;
					}
					else {
						if (min<unsortedmobilenumbers2[programcntr]) {
							System.out.println("min unchanged -"+min);
							flagminchanged=0;
							//selectionsortcntr1=programcntr;
						}
						else
						{
							//Set flag=1
							flagminchanged=1;
							tempprogramcntr=programcntr;
							flagminchangedcntr++;
							
							//exchange
							tempmobilenumber=min;
							min=unsortedmobilenumbers2[programcntr];
							unsortedmobilenumbers2[programcntr]=tempmobilenumber;
							partialsortedminimummobilenumbers[kmincntr]=min;
							System.out.println("min changed -"+min);
						}
					}
		    	} else if (arrjuggledandexchangedflag2>0) {
//		    		continue FindMin2;

		    		
		    		
				    for (tempcopiedarraycntr=0;tempcopiedarraycntr<dynamiclength;tempcopiedarraycntr++) {
				    	tempsortedmobilenumbers[tempcopiedarraycntr]=unsortedmobilenumbers2[tempcopiedarraycntr];
				    	}	
				    arrjuggledandexchangedflag=0;
		    		
		    	}
		    	
		    	
    	}
	    	jmincntr=jmincntr+1;
			programcntr=programcntr+1;
		    selectionsortcntr1=selectionsortcntr1+1;

	    }

	    
//		selectionsortcntrsortedmobilecntr=selectionsortcntrsortedmobilecntr+1;
		
		//sorted array
		sortedmobilenumbers[cntrProgramsecondpasscntr]=min;
		flagsortedarrayset=1;
	    System.out.println("----pass["+cntrProgramsecondpasscntr+"]---- sortedmobilenumbers -"+sortedmobilenumbers[cntrProgramsecondpasscntr]);
	    
	    if (flagsortedarrayset==1) {
		    for (tempcopiedarraycntr=0;tempcopiedarraycntr<dynamiclength;tempcopiedarraycntr++) {
		    	tempsortedmobilenumbers[tempcopiedarraycntr]=unsortedmobilenumbers2[tempcopiedarraycntr];
		    	}	
		    arrjuggledandexchangedflag2=1;
		    arrjuggledandexchangedflag2cntr++;
	    }
		cntrProgramsecondpasscntr=cntrProgramsecondpasscntr+1;
	    
	    index=index+1;
	    
	    System.out.println("----pass["+cntrProgramsecondpasscntr+"]----");
	
	}

    return sortedmobilenumbers;
	
    }

    public static long[] selectionSort(long[] arr){  
        for (int i = 0; i < arr.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < arr.length; j++){  
                if (arr[j] < arr[index]){  
                    index = j;//searching for lowest index  
                }  
            }  
            long smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;  
        }  
        
        return arr;
    }  
    
    
	 private static void copyFileUsingJava7and8Files(File source, File dest) throws IOException {
		    Files.copy(source.toPath(), dest.toPath());
		}
	 
	 private static void copyFileUsingChannel(File source, File dest) throws IOException {
		    FileChannel sourceChannel = null;
		    FileChannel destChannel = null;
		    try {
		        sourceChannel = new FileInputStream(source).getChannel();
		        destChannel = new FileOutputStream(dest).getChannel();
		        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
		       }finally{
		           sourceChannel.close();
		           destChannel.close();
		   }
		}
	 private static void copyFileUsingStream(File source, File dest) throws IOException {
		    InputStream is = null;
		    OutputStream os = null;
		    try {
		        is = new FileInputStream(source);
		        os = new FileOutputStream(dest);
		        byte[] buffer = new byte[1024];
		        int length;
		        while ((length = is.read(buffer)) > 0) {
		            os.write(buffer, 0, length);
		            
		        }
		    } finally {
		        is.close();
		        os.close();
		    }
		}
	 // to write sno, mobilenumber, recrdstartarr, recrdendarray to String and then to Printwriter out file
	 private static void writeFileUsingStream(String recrddatainput, File dest2) throws IOException {
		    InputStream is = null;
		    OutputStream os = null;
		    try {
		        //is = new FileInputStream(source);
		    	StringBuffer strbuffer=new StringBuffer(recrddatainput);
		        //os = new FileOutputStream(dest2);
		        
		    	FileWriter fw = new FileWriter(dest2);
		        BufferedWriter bw = new BufferedWriter(fw);
		        PrintWriter out = new PrintWriter(bw);
		        
		        byte[] buffer = new byte[1024];
		        int length;
		        //while ((length = strbuffer.toString().length()) > 0) {
		        if ((length = strbuffer.toString().length()) > 0) {
		            out.append(strbuffer.toString());
		            
		        }
		        out.close();
		    } finally {
		        //is.close();
		        //out.close();
		    	System.out.println("the file is closed in previous block");
		    }
		}
	 
}
