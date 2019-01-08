package com.testing.ahmed;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
			  	
			  long start = System.nanoTime();
			  	File source = new File("C:\\WebServer\\Outputfileexcelsheet.csv");
		        File dest = new File("C:\\WebServer\\Outputfileexcelsheetnew.xml");

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
				
				long tempmobilenumbers=0;
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
		        
		        //reading records and associating connecting with unsorted mobile numbers
		        //String records[]= {"hello","records"};
/*		        StringBuffer recordbuilder = new StringBuffer();
		        String records[]= {};
		        int recrdcntr=0;
		        
		        int arrcntr=0;
		        for(arrcntr=0;arrcntr<arraystart.length;arrcntr++) {
		        	
		        	System.out.println("chking arrays - positions arraystart arrayend" + arraystart[arrcntr] + " " + arrayend[arrcntr] );
		        	
		        }
		        while (recrdcntr<ifileend) 
		        {
		        	System.out.println("positions arraystart arrayend" + arraystart[recrdcntr] + " " + (arrayend[recrdcntr]-1) +" length -"+ outputdest_read_read.substring(arraystart[recrdcntr], (arrayend[recrdcntr]-1)).length());
	        		
		        	System.out.println("outputdest_read_read.substring at position -" + outputdest_read_read.substring(arraystart[recrdcntr], (arrayend[recrdcntr]-1)));

		        	if (recrdcntr==(ifileend-1))
		        	{
		        		//System.out.println("positions arraystart arrayend" + arraystart[recrdcntr] + " " + (arrayend[recrdcntr]-1) +" length -"+ outputdest_read_read.substring(arraystart[recrdcntr], arrayend[recrdcntr]-1).length());
		        	//	records[recrdcntr]=outputdest_read_read.substring(arraystart[recrdcntr], arrayend[recrdcntr]-1);
		        		recordbuilder.replace(arraystart[recrdcntr],outputdest_read_read.substring(arraystart[recrdcntr], arrayend[recrdcntr]-1).length(),outputdest_read_read.substring(arraystart[recrdcntr], arrayend[recrdcntr]-1));
		        	}
		        	else
		        	{
		        		//System.out.println("positions arraystart arrayend" + arraystart[recrdcntr] + " " + (arrayend[recrdcntr]-1) +" length -"+ outputdest_read_read.substring(arraystart[recrdcntr], arrayend[recrdcntr]-1).length());
		        	//	records[recrdcntr]=outputdest_read_read.substring(arraystart[recrdcntr], arrayend[recrdcntr]-1);
		        		recordbuilder.replace(arraystart[recrdcntr],outputdest_read_read.substring(arraystart[recrdcntr], arraystart[recrdcntr+1]-1).length(),outputdest_read_read.substring(arraystart[recrdcntr], arraystart[recrdcntr+1]-1));
		        	}
		        	records[recrdcntr]=recordbuilder.toString();
		        	//System.out.println(records[recrdcntr]);
		        	
		        	recrdcntr= recrdcntr+1;
		        }
*/		        
		        //i = 0;	
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

		        int recrdcntr=0;
		        
		        //make these ints as long
		        
		        int mobilephonerecordscntr1=0;
		        int mobilephonerecordscntr2=0;
		        int mobilephonerecordscntr3=0;
		        int mobilephonerecordscntr4=0;
		        
		        long mobilephonerecords[][][][]= new long[100][100][100][100];
		        
		        for(mobilephonerecordscntr4=0;mobilephonerecordscntr4<100;mobilephonerecordscntr4++) {
			        for(mobilephonerecordscntr3=0;mobilephonerecordscntr3<100;mobilephonerecordscntr3++) {
				        for(mobilephonerecordscntr2=0;mobilephonerecordscntr2<100;mobilephonerecordscntr2++) {
					        for(mobilephonerecordscntr1=0;mobilephonerecordscntr1<100;mobilephonerecordscntr1++) {
					        		mobilephonerecords[mobilephonerecordscntr4][mobilephonerecordscntr3][mobilephonerecordscntr2][mobilephonerecordscntr1]= 0;
					        	}
				        }
			        }
		        }

		        int mobilenumbercntr=0;

/*		        while (recrdcntr<numberofrecords)
		        {
		        	mobilephonerecords[recrdcntr][recrdcntr][recrdcntr][recrdcntr]= {mobilenumbercntr,unsortedmobilenumbers[mobilenumbercntr],arraystart[mobilenumbercntr],arrayend[mobilenumbercntr]};
		        	mobilenumbercntr=mobilenumbercntr+1;
		        	recrdcntr=recrdcntr+1;
		        }
*/		        
		        int l=0;
		        int mobilearrlen = unsortedmobilenumbers.length;
		        for(l=0;l<mobilearrlen;l++) {
		        	System.out.println("the unsorted array is mobilenumbers[l] - "+ l +" - " +unsortedmobilenumbers[l]);
		        	//mobilephonerecords[l][l][l]= {unsortedmobilenumbers[l],arraystart[l],arrayend[l]);
		        	if (unsortedmobilenumbers[l]==0)
		        	{
			        	System.out.println("---completed---"); 
//		        		break;
		        	}
		        }
		        
		        sortedmobilenumber = SelectionSort(unsortedmobilenumbers);

		        int n=0;
		        
		        for(n=0;n<mobilearrlen;n++) {
		        	System.out.println("the sorted array is mobilenumbers[n] - "+ n +" - " +sortedmobilenumber[n]);
/*		        	if (sortedmobilenumber[n]==0)
		        	{
			        	System.out.println("---completed---"); 
		        		//System.exit(0);
		        	}
*/		        }

		        
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
    int jmincntr=0; 
    int	kmincntr=0;
    long tempk=0;
    
    long min=0; 
    long max=0; 

    long min2=0; 
    long max2=0; 

    long tempmobilenumber=0; 
    long tempmobilenumber2=0;
    
    int mobilearrlen2=0;

    //selection sort
    
    //local var
    int fncntr=0;
    long unsortedmobilenumbers2[] = new long[100];
    long sortedmobilenumbers[]=new long[100];

    for (fncntr=0;fncntr<100; fncntr++) {
		unsortedmobilenumbers2[fncntr]=0;
		sortedmobilenumbers[fncntr]=0;
	}

    unsortedmobilenumbers2=mobilenumbers;
    
    mobilearrlen2=mobilenumbers.length;
    System.out.println("mobilearrlen -"+ mobilearrlen2);
    
    
    min=unsortedmobilenumbers2[jmincntr];

    int length=mobilearrlen2-1;
    int selectionsortcntr=0;
    for (selectionsortcntr=0;selectionsortcntr<length;selectionsortcntr++) {
    while (jmincntr<length) {

    		System.out.println("min -"+ min);
    		kmincntr=jmincntr+1;

        	//while(k<=length) {
        	if (kmincntr==length) {
    			System.out.println("--last iteration--");
    			if(min<unsortedmobilenumbers2[kmincntr]) 
    			{
    				System.out.println("min checking"+min);
    			}
    			else {

    				tempmobilenumber=unsortedmobilenumbers2[jmincntr];
    				unsortedmobilenumbers2[jmincntr]=unsortedmobilenumbers2[kmincntr];
    				unsortedmobilenumbers2[kmincntr]=tempmobilenumber;
            		min=unsortedmobilenumbers2[kmincntr];
            		System.out.println("min checking"+min);
            		System.out.println("unsortedmobilenumbers2[j]"+unsortedmobilenumbers2[jmincntr]);
            		System.out.println("unsortedmobilenumbers2[k]"+unsortedmobilenumbers2[kmincntr]);

    			}
        	}
        	if (jmincntr==length) {
        		if (min<unsortedmobilenumbers2[length]) {
        			System.out.println("--last element reached--");
        			System.out.println("min checking"+min);
        		}
        		else {
	        		
    				tempmobilenumber=unsortedmobilenumbers2[jmincntr];
    				unsortedmobilenumbers2[jmincntr]=unsortedmobilenumbers2[length];
    				unsortedmobilenumbers2[length]=tempmobilenumber;
            		min=unsortedmobilenumbers2[kmincntr];
            		System.out.println("min checking"+min);
            		System.out.println("unsortedmobilenumbers2[j]"+unsortedmobilenumbers2[jmincntr]);
            		System.out.println("unsortedmobilenumbers2[k]"+unsortedmobilenumbers2[kmincntr]);
            		
        		}
        	}
        	else {
		        	if (min<unsortedmobilenumbers2[kmincntr]) {
	    				System.out.println("min checking"+min);    		
		        	}
		        	else {

	    				tempmobilenumber=unsortedmobilenumbers2[jmincntr];
	    				unsortedmobilenumbers2[jmincntr]=unsortedmobilenumbers2[kmincntr];
	    				unsortedmobilenumbers2[kmincntr]=tempmobilenumber;
	            		//find and set min
	            		min=unsortedmobilenumbers2[kmincntr];
	            		System.out.println("unsortedmobilenumbers2[j]"+unsortedmobilenumbers2[jmincntr]);
	            		System.out.println("unsortedmobilenumbers2[k]"+unsortedmobilenumbers2[kmincntr]);
	            		
	            		
	            		System.out.println("min checking"+min);
		        	}
	        }
	
        	//mobilenumbers[j]=min;
        	//k=k+1;
//        	//}	
        	sortedmobilenumbers[jmincntr]=min;
    		System.out.println("sortedmobilenumbers[j]"+sortedmobilenumbers[jmincntr]);        	
    		jmincntr=jmincntr+1;
    	}
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
}
