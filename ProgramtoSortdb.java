package com.testing.ahmed;

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


public class ProgramtoSortdb {

	public static void main(String args[]) throws IOException {

	
	Scanner s = new Scanner(System.in);

	System.out.println("index by - name, contactnumbers, emailids");
	System.out.println("alternate contact number and email id will be provided");
	System.out.println("group by - position");
	System.out.println("User Input - 1, 2, 3, 4, 5");
	
	int option = 0;
	
	option = Integer.parseInt(s.nextLine().trim());
	System.out.println("option" + option);

	if (option == 1) // equals("name")) {
	{
		System.out.println("Program not ready");
		System.exit(0);
	} else if (option == 2) // equals("contactnumber")) {
	{
		System.out.println(
				"Enter file name with pattern at end for e.g Outputfileexcelsheetnew1441742121.xml or testOutputfileexcelsheetnew947119429741144254119.xml");
		String filenamedest = s.nextLine().trim();

		long start = System.nanoTime();
		// File source = new File("C:\\WebServer\\Outputfileexcelsheet9441742121.csv");

		File source = new File("C:\\WebServer\\Outputfileexcelsheetnew947119429741144254119.xml");
		// File dest = new File("C:\\WebServer\\Outputfileexcelsheetnew1441742121.xml");
		File dest = new File(filenamedest);
		File dest2 = new File("C:\\WebServer\\InfoXMLtempfileout94411471231.xml");

		// using Java 7 and 8 Files class
		// source = new File("C:\\WebServer\\Outputfileexcelsheet.csv");
		// dest = new File("C:\\WebServer\\Outputfileexcelsheetnew.xml");

		ProgramtoSortdb prgrmtosortdb = new ProgramtoSortdb();
		
		start = System.nanoTime();
		try {
			// copyFileUsingJava7and8Files(source, dest);
			// copyFileUsingChannel(source, dest);
			copyFileUsingStream(source, dest);

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Time taken by copyFileUsingStream Files Copy = " + (System.nanoTime() - start));

		// read the xml file
		// if the file is big we have to buffer it

		StringBuilder contentBuilder = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(dest));
		try {

			String sCurrentLine = null;
			while ((sCurrentLine = br.readLine()) != null) {
				contentBuilder.append(sCurrentLine);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		br.close();

		String outputdest_read_read = null;
		outputdest_read_read = contentBuilder.toString();
		System.out.println("outputdest_read_read -" + outputdest_read_read);
		// mobile numbers
		String contactnumbers = "";
		int cntr = 0;
		long unsortedmobilenumbers[] = new long[100];// number of mobile numbers or records
		long sortedmobilenumbers[] = new long[100];

		for (cntr = 0; cntr < 100; cntr++) {
			unsortedmobilenumbers[cntr] = 0;
			sortedmobilenumbers[cntr] = 0;
		}

		long tempmobilenumbers;
		tempmobilenumbers = 0;

		int i = 0;
		int x = 0;
		int y = 0;
		// contact numbers

		int arraystart[] = new int[100];
		String fileoutputdest_read_read = "";
		fileoutputdest_read_read = outputdest_read_read;

		String regexfile = "";
		regexfile = "<SOFDBRCRD>";
		Pattern filep = Pattern.compile(regexfile);
		Matcher mfile = filep.matcher(fileoutputdest_read_read);
		int ifile = 0;

		// possible error if length of string exceeds integer range

		int filepositionstartarray = 0;
//	        int filepositionendarray= 0;
		while (mfile.find()) {

			filepositionstartarray = mfile.start();
			System.out.println("filepositionstartarray -" + filepositionstartarray);
			System.out.println("Match - " + mfile.group() + " at positions " + mfile.start());

			System.out.println("filepositionstartarray - " + filepositionstartarray);
			arraystart[ifile] = filepositionstartarray;
			ifile = ifile + 1;
		}

		int arrayend[] = new int[100];
		String fileoutputdest_read_readend = "";
		fileoutputdest_read_readend = outputdest_read_read;
		String regexfileend = "";
		regexfileend = "</SOFDBRCRD>";
		Pattern fileendp = Pattern.compile(regexfileend);
		Matcher mfileend = fileendp.matcher(fileoutputdest_read_readend);
		int ifileend = 0;
		int filepositionendarray = 0;

		while (mfileend.find()) {

			System.out.println("Match - " + mfileend.group() + " at positions " + mfileend.end());

			filepositionendarray = mfileend.start() + 13;

			System.out.println("filepositionendarray -" + filepositionendarray);
			arrayend[ifileend] = filepositionendarray;

			ifileend = ifileend + 1;
		}

		int numberofrecords = 0;
		numberofrecords = ifileend;

		String regex = "";
		regex = "<contactnumbers>";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(outputdest_read_read);
		System.out.println("outputdest_read_read - " + outputdest_read_read);

        Hashtable<Integer,Integer> recrdstart = new Hashtable<Integer,Integer>();  
        Hashtable<Integer,Integer> recrdend = new Hashtable<Integer,Integer>();  
        Hashtable<Integer,Long> mobilenumberhashtable = new Hashtable<Integer,Long>();  
        
		int positionstartarray = 0;
		int positionendarray = 0;
		while (m.find()) {

			positionstartarray = m.start() + 16;
			System.out.println("positionstartarray -" + positionstartarray);
			positionendarray = m.end() + 10;
			System.out.println("positionendarray -" + positionendarray);
			System.out.println("Match - " + m.group() + " at positions " + m.start() + " - " + (m.end() - 1));

			System.out.println(
					"positionstartarray - positionstartarray" + positionstartarray + " - " + positionendarray);
			contactnumbers = outputdest_read_read.substring(positionstartarray, positionendarray);
			System.out.println("contactnumbers - " + contactnumbers);

			tempmobilenumbers = Long.parseLong(contactnumbers);
			System.out.println("tempmobilenumbers - " + tempmobilenumbers);
			unsortedmobilenumbers[i] = tempmobilenumbers;
			System.out.println("mobilenumbers - " + "[" + i + "]" + unsortedmobilenumbers[i]);
			  
	      try {

	    	  recrdstart.put(i, arraystart[i]);	
	    	  recrdend.put(i, arrayend[i]);	
	    	  mobilenumberhashtable.put(i,tempmobilenumbers);

	      } catch (Exception e) {
	    	  
			e.getStackTrace();   
			
		  }
	    	
			i = i + 1;
			x = x + 1;
			y = y + 1;

		}

		// make these ints as long

		int recrdcntr = 0;
		//recrdcntr = unsortedmobilenumbers.length;
		recrdcntr=i;
		
		// make these ints as long

		int mobilephonerecordscntr1 = 0;
		int mobilephonerecordscntr2 = 0;
		int mobilephonerecordscntr3 = 0;
		int mobilephonerecordscntr4 = 0;

		long mobilephonerecords[][][][] = new long[100][100][100][100];

		/*
		 * for (long[][][][] row: mobilephonerecords) { for (long[][][] innerRow: row) {
		 * for (long[][] innerInnerRow: innerRow) { for (long[] innerinnerInnerRow:
		 * innerInnerRow) { Arrays.fill(innerinnerInnerRow, 0); } } } }
		 * 
		 */
		int xcntr = 0;
		int arrcntr1 = 0;
		long temp1 = 0;

		int arrcntr2 = 0;
		long temp2 = 0;

		int arrcntr3 = 0;
		long temp3 = 0;

		int arrcntr4 = 0;
		long temp4 = 0;
		int ycntr = 0;
		int zcntr = 0;
		int icntr = 0;
		// StringBuilder sb2 = new StringBuilder();
		String sb2 = "";
		String sbstr = "";
		// Label Startbuildfilestr;

		try {

			sbstr = sbstr + "<xmlstart>";

			while ((xcntr < recrdcntr) && (ycntr < recrdcntr) && (zcntr < recrdcntr) && (icntr < recrdcntr)
					&& (unsortedmobilenumbers[arrcntr3] > 0)) {

				temp1 = arrayend[arrcntr1];
				mobilephonerecords[0][0][0][arrcntr1] = temp1;
				arrcntr1 = arrcntr1 + 1;
				sbstr = sbstr + "<rcrdstrt>";
				sbstr = sbstr + "<arrayend>" + temp1 + "</arrayend>";
				xcntr = xcntr + 1;

				temp2 = arraystart[arrcntr2];
				mobilephonerecords[0][0][arrcntr2][0] = temp2;
				arrcntr2 = arrcntr2 + 1;
				sbstr = sbstr + "<arraystart>" + temp2 + "</arraystart>";
				ycntr = ycntr + 1;

				temp3 = unsortedmobilenumbers[arrcntr3];
				mobilephonerecords[0][arrcntr3][0][0] = temp3;
				arrcntr3 = arrcntr3 + 1;
				sbstr = sbstr + "<mobilenonumber>" + temp3 + "</mobilenonumber>";
				zcntr = zcntr + 1;

				temp4 = icntr;
				mobilephonerecords[arrcntr4][0][0][0] = temp4;
				arrcntr4 = arrcntr4 + 1;
				sbstr = sbstr + "<Sno>" + temp4 + "</Sno>";
				sbstr = sbstr + "</rcrdstrt>";
				icntr = icntr + 1;

				// sb2.append(sbstr);
				sb2 = sb2 + sbstr;
			}

			sbstr = sbstr + "</xmlstart>";
			// sb2.append(sbstr);
			sb2 = sb2 + sbstr;
		} catch (Exception e) {
			e.printStackTrace();
		}

		long start2 = System.nanoTime();

		try {
			// copyFileUsingJava7and8Files(source, dest);
			// copyFileUsingChannel(source, dest);
			// copyFileUsingStream(source, dest);
			// writeFileUsingStream(sb2.toString().trim(),dest2);
			prgrmtosortdb.writeFileUsingStream(sb2, dest2);

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Time taken by copyFileUsingStream Files Copy = " + (System.nanoTime() - start2));

		int ixcntr = 0;
		int iycntr = 0;
		int izcntr = 0;
		int ikcntr = 0;
		// long [][][][] mobilephonerecords2= new long[100][100][100][100];

		/*
		 * for (long[][][] row: mobilephonerecords) { izcntr=0;
		 * //System.out.println("mobilephonerecords "+izcntr+" - "+mobilephonerecords[
		 * izcntr][0][0][0]); izcntr++;
		 * 
		 * for (long[][] innerRow: row) { iycntr=0;
		 * //System.out.println("mobilephonerecords "+iycntr+" - "+mobilephonerecords[0]
		 * [iycntr][0][0]); iycntr++;
		 * 
		 * for (long[] innerInnerRow: innerRow) { ixcntr=0;
		 * System.out.println("mobilephonerecords "+ixcntr+" - "+mobilephonerecords[0][0
		 * ][0][ixcntr]); ixcntr++;
		 * 
		 * } } }
		 */

		int mobilenumbercntrx = 0;
		int recrdcntrx = 0;

		while (recrdcntrx < numberofrecords) {
			System.out.println("mobilephonerecords[][][][] -"
					+ mobilephonerecords[recrdcntrx][recrdcntrx][recrdcntrx][recrdcntrx]);
			mobilenumbercntrx = mobilenumbercntrx + 1;
			recrdcntrx = recrdcntrx + 1;
		}

		recrdcntrx = 0;
		while (recrdcntrx < numberofrecords) {
			System.out.println("print mobilephonerecords as array-" + mobilephonerecords);
			mobilenumbercntrx = mobilenumbercntrx + 1;
			recrdcntrx = recrdcntrx + 1;
		}

		int unsortedarrcntr = 0;
		int l = 0;
		int mobilearrlen = unsortedmobilenumbers.length;
		System.out.println("unsorted mobilearrlen - " + mobilearrlen);

		/*
		 * int fncntr2=0; for (fncntr2=0;fncntr2<100; fncntr2++) {
		 * System.out.println("unsortedmobilenumbers[fncntr2] -" +
		 * unsortedmobilenumbers[fncntr2]); }
		 */
		
		File dest4 = new File("C:\\WebServer\\Sortednumberarray75479321431791.xml");
		File destsortedfileend = new File("C:\\WebServer\\Sortednumberarray94711942974114425411975479321431791.csv");
		
		//write the array start array end to a file
		File dest6 = new File("C:\\WebServer\\FilestartFileendindexsortednumberarray9471194297411442541197547932143179175479321431791.xml");

		int sortedmobilearrlen;
		int nxcntr2;
		String mobilenumbersb2;
		mobilenumbersb2="";
		
		int[] cntrindex= new int[100];
		int cntrindexcntr;
		cntrindexcntr=0;
		
		for (cntrindexcntr=0;cntrindexcntr<i;cntrindexcntr++) {
			cntrindex[cntrindexcntr]=cntrindexcntr;
		}
		
		nxcntr2=0;
		sortedmobilearrlen = 0;

		sortedmobilenumbers = prgrmtosortdb.ssr_SelectionSortRecursive(unsortedmobilenumbers,i,cntrindex);

		//write to a file
		try {
			while (nxcntr2<i) {
				mobilenumbersb2 = sortedmobilenumbers[nxcntr2] + "\n" + mobilenumbersb2;
				nxcntr2=nxcntr2+1;
			}	
		} catch (Exception e) {
				e.printStackTrace();
			}		
		
		
		long start3 = System.nanoTime();

		String sortedrecrd;
		String filestartfileendsortednumber;
		
		filestartfileendsortednumber="";
		sortedrecrd="";
		
		int iklmcntr;
		iklmcntr=0;
		int destfilelength=outputdest_read_read.length();
		
		try {
			// copyFileUsingJava7and8Files(source, dest);
			// copyFileUsingChannel(source, dest);
			// copyFileUsingStream(source, dest);
			// writeFileUsingStream(sb2.toString().trim(),dest2);
			
			prgrmtosortdb.writeFileUsingStream(mobilenumbersb2, dest4);
			System.out.println("Time taken by copyFileUsingStream Files Copy = " + (System.nanoTime() - start3));
			System.out.println("outputdest_read_read length- " + destfilelength);
			
			// get the records using the cntrindex and write to file in a sorted way
			while(iklmcntr<i) {
				System.out.println("cntrindex[iklmcntr] - "+ cntrindex[iklmcntr]);
				System.out.println("arraystart[cntrindex[iklmcntr]],arrayend[cntrindex[iklmcntr]] -"+ arraystart[cntrindex[iklmcntr]] + " - "+ arrayend[cntrindex[iklmcntr]]);
				filestartfileendsortednumber = "<sortedfilerecord>"+ "<cntrindex>"+ cntrindex[iklmcntr] + "</cntrindex>" + "<arraystartarrayindex>" + arraystart[cntrindex[iklmcntr]] + "</arraystartarrayindex>" + "<arrayendindex>" + arrayend[cntrindex[iklmcntr]] + "</arrayendindex>" + filestartfileendsortednumber + "</sortedfilerecord>";
				
				if (arrayend[cntrindex[iklmcntr]]<destfilelength) {
					sortedrecrd = outputdest_read_read.substring(arraystart[cntrindex[iklmcntr]],arrayend[cntrindex[iklmcntr]]) + sortedrecrd;
				}
				else
				{	
					System.out.println("last record - sorted files" + outputdest_read_read.substring(arraystart[cntrindex[iklmcntr]],destfilelength) );
					sortedrecrd = outputdest_read_read.substring(arraystart[cntrindex[iklmcntr]],destfilelength) + sortedrecrd;
				}
				
				
				System.out.println("sortedrecrd - " + sortedrecrd);
				iklmcntr=iklmcntr+1;
			}

			long start4 = System.nanoTime();
			prgrmtosortdb.writeFileUsingStream(filestartfileendsortednumber, dest6); 
			prgrmtosortdb.writeFileUsingStream(sortedrecrd, destsortedfileend);
			
			System.out.println("Time taken by copyFileUsingStream Files Copy = " + (System.nanoTime() - start4));
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		//sortedmobilenumbers = ssr_SelectionSortRecursive(unsortedmobilenumbers,i);

		sortedmobilearrlen = sortedmobilenumbers.length;

		int nxcntr;
		nxcntr = 0;
		
		for (nxcntr=0;nxcntr<sortedmobilearrlen;nxcntr++){
			if (sortedmobilenumbers[nxcntr]==0){
				break;
			}
			System.out.println("the sorted array is sortedmobilenumbers[nxcntr]" + sortedmobilenumbers[nxcntr]);
		}

	} else if (option == 3) // "emailids")) {
	{
		System.out.println("Program not ready");
		System.exit(0);
	} else if (option == 4) // equals("option")) {
	{
		System.out.println("Program not ready");
		System.exit(0);
	}  else if (option == 5) // equals("System exit")) {
	{
		System.out.println("System exit");
		s.close();
		System.exit(0);
	}
}
	
	private long[] ssr_SelectionSortRecursive(long[] a, int size, int[] cntr) {
		
		int maxIndex; 
		maxIndex=0;
		long t;
		int i;
		i=0;
		
		if (size>1) {
			maxIndex=getMaxIndex(a,size);
			t=a[size-1];
			a[size-1]=a[maxIndex];
			a[maxIndex]=t;
			
			cntr[i]=maxIndex;
			size=size-1;
			ssr_SelectionSortRecursive(a,size,cntr);
		} else {
			cntr[i]=maxIndex;						
		}
		
		//write sorted numbers to a file
		return a;
	}
	
	private int getMaxIndex(long[] a, int size) {

		long max;
		int maxIndex, i;
		max=a[0];
		maxIndex=0;
		for(i=0;i<size;i++) {
			if (max<a[i]) {
				max=a[i];
				maxIndex=i;
			}
			
		}
		
		return maxIndex;			
		
	}
	
	private static long[] SelectionSort(long mobilenumbers[]) {

		long tempk = 0;

		long min = 0;
		long max = 0;

		long min2 = 0;
		long max2 = 0;

		long tempmobilenumber = 0;
		long tempmobilenumber2 = 0;

		int mobilearrlen2 = 0;

		// selection sort
		// replace by long if db file is greater than 100 records
		int jmincntr = 0;
		int kmincntr = 0;

		// local var
		int fncntr = 0;
		long unsortedmobilenumbers2[] = new long[100];
		long sortedmobilenumbers[] = new long[100];
		long partialsortedminimummobilenumbers[] = new long[100];

		long tempsortedmobilenumbers[] = new long[100];

		for (fncntr=0; fncntr < 100; fncntr++) {
			unsortedmobilenumbers2[fncntr] = 0;
			sortedmobilenumbers[fncntr] = 0;
			partialsortedminimummobilenumbers[fncntr] = 0;
			tempsortedmobilenumbers[fncntr]=0;
		}

		int dynamiclength;
		dynamiclength=0;
		dynamiclength = mobilenumbers.length;
		System.out.println("dynamiclength - from var mobilenumbers passed to it from main method -"+dynamiclength);
		
		
		int fncntr3 = 0;
		int reallength=1;
		
		for (fncntr3 = 0; fncntr3 < dynamiclength; fncntr3++) {
			if (mobilenumbers[fncntr3]==0) {
				unsortedmobilenumbers2[fncntr3]=0;
				break;
			} else {
				unsortedmobilenumbers2[fncntr3] = mobilenumbers[fncntr3];
				reallength++;
			}
		}

		reallength=reallength-1;
//    unsortedmobilenumbers2=mobilenumbers;

		System.out.println("reallength -"+reallength);
		
		int fncntr2 = 0;

		for (fncntr2=0; fncntr2<reallength; fncntr2++) {
			if (unsortedmobilenumbers2[fncntr2]==0) {
				break;
			}
			System.out.println("unsortedmobilenumbers2[fncntr2] -" + unsortedmobilenumbers2[fncntr2]);
		}

		/*
		 * mobilearrlen2 = mobilenumbers.length; System.out.println("mobilearrlen -" +
		 * mobilearrlen2);
		 */
		
		// int dynamiclength=mobilearrlen2;
		int index;
		index = 1;

		int selectionsortcntr1;
		selectionsortcntr1 = 0;

		int selectionsortcntr2;
		selectionsortcntr2 = 0;

		int cntrProgramsecondpasscntr;
		cntrProgramsecondpasscntr = 1;

		int selectionsortcntrsortedmobilecntr;
		selectionsortcntrsortedmobilecntr = 0;

		int jkzmincntr;
		jkzmincntr = 0;

		int programcntr;
		programcntr = 0;

		int tempprogramcntr;
		tempprogramcntr = 0;

		int flagminchanged;
		int flagminchangedcntr;
		flagminchanged = 0;
		flagminchangedcntr = 0;

		int flagsortedarrayset;
		flagsortedarrayset = 0;

		int partialsortedminimummobilenumbersflag;
		partialsortedminimummobilenumbersflag = 0;

		min = unsortedmobilenumbers2[jmincntr];
		System.out.println("Initial minimum -" + min);

		int tempcopiedarraycntr;
		tempcopiedarraycntr = 0;

		int arrjuggledandexchangedflag;
		arrjuggledandexchangedflag = 0;

		int dynamiclengthflag;
		dynamiclengthflag = 0;

		int partialsortedminimummobilenumberscntr;
		partialsortedminimummobilenumberscntr = 0;

		int arrjuggledandexchangedflag2;
		arrjuggledandexchangedflag2 = 0;

		int arrjuggledandexchangedflag2cntr;
		arrjuggledandexchangedflag2cntr = 0;

		int tempsortedmobilenumbersflagset;
		tempsortedmobilenumbersflagset=0;
		
		int zmincntr;
		zmincntr=0;
		
		dynamiclength=reallength;
		
		while (cntrProgramsecondpasscntr<dynamiclength) { 
			
			System.out.println("------pass------jmincntr--------"+jmincntr+"----unsortedmobilenumbers2[jmincntr]-----"+unsortedmobilenumbers2[jmincntr]); 

			if (min==0) {
				System.out.println("min is 0 -"+min);
				break;
			}
			
			System.out.println("jmincntr - "+jmincntr);
			System.out.println("cntrProgramsecondpasscntr -"+cntrProgramsecondpasscntr);
			System.out.println("selectionsortcntr1 - "+selectionsortcntr1);
			

			if(jmincntr==dynamiclength) {
				System.out.println("jmincntr length reached"+jmincntr);
				break;
			} else { 
				
				if ((unsortedmobilenumbers2[jmincntr]==0) || (((flagminchanged==1)&&(flagminchangedcntr>0)) && (tempsortedmobilenumbers[jmincntr]==0))) {
					System.out.println("unsortedmobilenumbers[jmincntr] is 0 -"+unsortedmobilenumbers2[jmincntr]);
					break;
				}
				//sortedmobilenumbers[cntrProgramsecondpasscntr]= min;
				//jmincntr=jmincntr+1;
				//cntrProgramsecondpasscntr = cntrProgramsecondpasscntr + 1;
			}
			
			if (((flagminchanged==1)&&(flagminchangedcntr>0)) && (flagsortedarrayset==1)) { 
				System.out.println("min changed to - unsortedmobilenumbers2[jmincntr] - change min - do nothing as yet"+ unsortedmobilenumbers2[jmincntr]);
			} else {
				System.out.println("min unchanged");
			}
			
			System.out.println("min chking - min -" + min + "unsortedmobilenumbers2[programcntr]" + unsortedmobilenumbers2[programcntr] + " tempsortedmobilenumbers[selectionsortcntr1] -" + tempsortedmobilenumbers[selectionsortcntr1]);
			
			selectionsortcntr1 = index; //index=1

			if (min<=unsortedmobilenumbers2[programcntr]){
				System.out.println("min -" + min);
			} else {
				System.out.println("min is -" + unsortedmobilenumbers2[programcntr]);
			}
			
			// for
			// (selectionsortcntr1=index;selectionsortcntr1<dynamiclength;selectionsortcntr1++)
			// {
			partialsortedminimummobilenumbersflag=0;
			partialsortedminimummobilenumberscntr=0;
			
			while (selectionsortcntr1 <= dynamiclength)  {
				zmincntr = 0;
				
				if (min==0) {
					System.out.println("min is 0 - "+ min);
					break;
				}	
					if (flagminchangedcntr > 0) {
						while (zmincntr < dynamiclength) {
		
						if (((arrjuggledandexchangedflag>0) && functionmobilenumberpresentinarray(unsortedmobilenumbers2[jmincntr],partialsortedminimummobilenumbers)) 
								|| ((arrjuggledandexchangedflag2>0) && functionmobilenumberpresentinarray(tempsortedmobilenumbers[jmincntr],partialsortedminimummobilenumbers)))
								{
									System.out.println("dont need to sort - no need to sort");
									zmincntr = zmincntr + 1;
									// set partialsortedminimummobilenumbersflag=1;
									partialsortedminimummobilenumbersflag = 1;
									partialsortedminimummobilenumberscntr++;
									//break;
								} else {
									zmincntr = zmincntr + 1;
								}
						  	}		
					}
					else {
						System.out.println("wait till a number is added to partialsortedminimummobilenumbers");
					}
					

			if ((partialsortedminimummobilenumbersflag > 0) && (partialsortedminimummobilenumberscntr == jmincntr)) {
				System.out.println("dont need to sort - no need to sort");
			} else {
				/* if (cntrProgramsecondpasscntr>=0) { */
				
				if(tempsortedmobilenumbersflagset==1) {
					if(selectionsortcntr1==dynamiclength) { 
						if (min <= tempsortedmobilenumbers[dynamiclength]) {
							System.out.println("no change in min");
	//						selectionsortcntr1 = selectionsortcntr1 + 1;
	//						index = index + 1;
						} else {
							tempmobilenumber2 = min;
							min = tempsortedmobilenumbers[dynamiclength];
							tempsortedmobilenumbers[dynamiclength] = tempmobilenumber2;
							partialsortedminimummobilenumbers[kmincntr] = min;
							partialsortedminimummobilenumbersflag =0;
							partialsortedminimummobilenumberscntr++;
							// jmincntr=jmincntr+1;
							arrjuggledandexchangedflag = 1;
							flagminchanged = 1;
							flagminchangedcntr++;
							arrjuggledandexchangedflag2 = 0;
							tempsortedmobilenumbersflagset=0;
							
							for (tempcopiedarraycntr = 0; tempcopiedarraycntr < dynamiclength; tempcopiedarraycntr++) {
								unsortedmobilenumbers2[tempcopiedarraycntr] = tempsortedmobilenumbers[tempcopiedarraycntr];
							}
		
						}
						selectionsortcntr1 = selectionsortcntr1 + 1;
						index = index + 1;

						break;
					}
					else {
						if (min <= tempsortedmobilenumbers[selectionsortcntr1]) {
							System.out.println("no change in min");
	//						selectionsortcntr1 = selectionsortcntr1 + 1;
	//						index = index + 1;
						} else {
							tempmobilenumber2 = min;
							min = tempsortedmobilenumbers[selectionsortcntr1];
							tempsortedmobilenumbers[selectionsortcntr1] = tempmobilenumber2;
							partialsortedminimummobilenumbers[kmincntr] = min;
							partialsortedminimummobilenumbersflag =0;
							partialsortedminimummobilenumberscntr++;
							// jmincntr=jmincntr+1;
							arrjuggledandexchangedflag = 1;
							flagminchanged = 1;
							flagminchangedcntr++;
							arrjuggledandexchangedflag2 = 0;
							tempsortedmobilenumbersflagset=0;
							
							for (tempcopiedarraycntr = 0; tempcopiedarraycntr < dynamiclength; tempcopiedarraycntr++) {
								unsortedmobilenumbers2[tempcopiedarraycntr] = tempsortedmobilenumbers[tempcopiedarraycntr];
							}
		
						}
					}	
				}	
				
				System.out.println("min - " + min);
				System.out.println("programcntr  - " + programcntr );

				programcntr = selectionsortcntr1;
				System.out.println("programcntr  - " + programcntr );

				if (arrjuggledandexchangedflag == 1) {

						if (programcntr == dynamiclength) {
							// set dynamic flag
							dynamiclengthflag = 1;
							/*
							 * if (min<unsortedmobilenumbers2[programcntr-1]) {
							 * System.out.println("min unchanged -"+min); flagminchanged=0; } else {
							 */
							tempmobilenumber = min;
							min = unsortedmobilenumbers2[dynamiclength-1];
							unsortedmobilenumbers2[dynamiclength-1] = tempmobilenumber;
							partialsortedminimummobilenumbers[kmincntr] = min;
							flagminchanged = 1;
							flagminchangedcntr++;
							// }
							/*
							 * cntrProgramsecondpasscntr=cntrProgramsecondpasscntr+1; jmincntr=jmincntr+1;
							 * index=index+1;
							 * 
							 */ 
							selectionsortcntr1 = selectionsortcntr1 + 1;
							index = index + 1;
							// jmincntr=jmincntr+1;
							break;
						} else {
							if (min <= unsortedmobilenumbers2[programcntr]) {
								System.out.println("min unchanged -" + min);
								flagminchanged = 0;
								// selectionsortcntr1=programcntr;
							} else {
								// Set flag=1
								flagminchanged = 1;
								tempprogramcntr = programcntr;
								flagminchangedcntr++;
	
								// exchange
								tempmobilenumber = min;
								min = unsortedmobilenumbers2[programcntr];
								unsortedmobilenumbers2[programcntr] = tempmobilenumber;
								partialsortedminimummobilenumbers[kmincntr] = min;
								System.out.println("min changed -" + min);

								arrjuggledandexchangedflag = 0;
								flagminchanged = 1;
								flagminchangedcntr++;
								arrjuggledandexchangedflag2 = 1;
								tempsortedmobilenumbersflagset=1;

								for (tempcopiedarraycntr = 0; tempcopiedarraycntr < dynamiclength; tempcopiedarraycntr++) {
									unsortedmobilenumbers2[tempcopiedarraycntr] = tempsortedmobilenumbers[tempcopiedarraycntr];
								}

							}
						}
					
				} else if (arrjuggledandexchangedflag2 > 0) {

					if (programcntr == dynamiclength) {
						// set dynamic flag
						dynamiclengthflag = 1;
						/*
						 * if (min<unsortedmobilenumbers2[programcntr-1]) {
						 * System.out.println("min unchanged -"+min); flagminchanged=0; } else {
						 */
						System.out.println("programcntr -"+programcntr);
						tempmobilenumber = min;
						min = unsortedmobilenumbers2[programcntr];
						unsortedmobilenumbers2[programcntr] = tempmobilenumber;
						partialsortedminimummobilenumbers[kmincntr] = min;
						flagminchanged = 1;
						flagminchangedcntr++;

						selectionsortcntr1 = selectionsortcntr1 + 1;
						index = index + 1;

						break;
					} else {
						if (min<=unsortedmobilenumbers2[programcntr]) {
							System.out.println("min unchanged -" + min);
							flagminchanged = 0;

						} else {

							flagminchanged = 1;
							tempprogramcntr = programcntr;
							flagminchangedcntr++;

							// exchange
							tempmobilenumber=min;
							min = unsortedmobilenumbers2[programcntr];
							unsortedmobilenumbers2[programcntr] = tempmobilenumber;
							partialsortedminimummobilenumbers[kmincntr] = min;
							System.out.println("min changed -" + min);
							System.out.println("programcntr -"+programcntr);
						}
					}
					
					for (tempcopiedarraycntr = 0; tempcopiedarraycntr < dynamiclength; tempcopiedarraycntr++) {
						tempsortedmobilenumbers[tempcopiedarraycntr] = unsortedmobilenumbers2[tempcopiedarraycntr];
					}
					arrjuggledandexchangedflag = 1;
					arrjuggledandexchangedflag2 = 0;
					
				} else if (arrjuggledandexchangedflag==0)  {

					if (programcntr == dynamiclength) {
						// set dynamic flag
						dynamiclengthflag = 1;
						/*
						 * if (min<unsortedmobilenumbers2[programcntr-1]) {
						 * System.out.println("min unchanged -"+min); flagminchanged=0; } else {
						 */
						System.out.println("programcntr -"+programcntr);
						tempmobilenumber = min;
						min = unsortedmobilenumbers2[programcntr];
						unsortedmobilenumbers2[programcntr] = tempmobilenumber;
						partialsortedminimummobilenumbers[kmincntr] = min;
						flagminchanged = 1;
						flagminchangedcntr++;

						selectionsortcntr1 = selectionsortcntr1 + 1;
						index = index + 1;

						break;
					} else {
						if (min==0) {
							System.out.println("min end reached -" + min);
							break;
						}
						if (min<=unsortedmobilenumbers2[programcntr]) {
							System.out.println("min unchanged -" + min);
							flagminchanged = 0;

						} else {

							flagminchanged = 1;
							tempprogramcntr = programcntr;
							flagminchangedcntr++;

							// exchange
							tempmobilenumber=min;
							min = unsortedmobilenumbers2[programcntr];
							unsortedmobilenumbers2[programcntr] = tempmobilenumber;
							partialsortedminimummobilenumbers[kmincntr] = min;
							System.out.println("min changed -" + min);
							System.out.println("programcntr -"+programcntr);

							for (tempcopiedarraycntr = 0; tempcopiedarraycntr < dynamiclength; tempcopiedarraycntr++) {
								tempsortedmobilenumbers[tempcopiedarraycntr] = unsortedmobilenumbers2[tempcopiedarraycntr];
							}

						}
					}					
					
				}
			} //partialsortedminimummobilenumbersflag else

			System.out.println("----pass[" + kmincntr + "]---- unsortedmobilenumbers2 ------"+ unsortedmobilenumbers2[kmincntr]);			
			System.out.println("----pass[" + kmincntr + "]---- partialsortedminimummobilenumbers ------" + partialsortedminimummobilenumbers[kmincntr]);

			kmincntr=kmincntr+1;
			index = index + 1;
			
			programcntr = programcntr + 1;
			selectionsortcntr1 = selectionsortcntr1 + 1;
			
		} // selectionsortcntr1

//		selectionsortcntrsortedmobilecntr=selectionsortcntrsortedmobilecntr+1;

		if (min==0) {
			System.out.println("min is 0 - "+ min);
			break;
		}	
			
		long sortednumbermin;
		sortednumbermin=0;
		
		sortednumbermin=min;
		System.out.println("min after pass["+jmincntr+"] is -"+min);
		//sorted array
		sortedmobilenumbers[jmincntr] = sortednumbermin;
		System.out.println("set min sorted min - sortedmobilenumbers[jmincntr]"+sortedmobilenumbers[jmincntr]);

		
		tempsortedmobilenumbersflagset=1;
		
		if (arrjuggledandexchangedflag2>0) {
			System.out.println("min is -"+min);
		}
		else {
			flagsortedarrayset = 1;
		}
		System.out.println("----pass[" + cntrProgramsecondpasscntr + "]---- sortedmobilenumbers ------"+ sortedmobilenumbers[jmincntr]);
		
		jmincntr = jmincntr + 1;
		min = unsortedmobilenumbers2[jmincntr];
		System.out.println("set min - min="+unsortedmobilenumbers2[jmincntr]);
		
		if ((flagsortedarrayset == 1) && (jmincntr<=reallength)){
			for (tempcopiedarraycntr = 0; tempcopiedarraycntr < dynamiclength; tempcopiedarraycntr++) {
				tempsortedmobilenumbers[tempcopiedarraycntr] = unsortedmobilenumbers2[tempcopiedarraycntr];
			}
			arrjuggledandexchangedflag2 = 1;
			arrjuggledandexchangedflag2cntr++;
			arrjuggledandexchangedflag=0;

			min = tempsortedmobilenumbers[jmincntr];
			System.out.println("set min - min="+tempsortedmobilenumbers[jmincntr]);
		}
		
		cntrProgramsecondpasscntr = cntrProgramsecondpasscntr + 1;

		//index = index + 1;

		System.out.println("----pass[" + cntrProgramsecondpasscntr + "]----");

	} //cntrProgramsecondpasscntr

	int nxcntr=0;
	
		for (nxcntr=0;nxcntr<reallength;nxcntr++){
			System.out.println("from inside the sort function method - the sorted array is sortedmobilenumbers[nxcntr]" + sortedmobilenumbers[nxcntr]);
			if (sortedmobilenumbers[nxcntr]==0){
				break;
			}
		}
		
	return sortedmobilenumbers;
	}

	public static boolean functionmobilenumberpresentinarray(long number, long[] partialsortedminimummobilenumbers) {

		int partialarraydynamiclengthdynamiclength; 
		partialarraydynamiclengthdynamiclength = 0;
		
		if (partialsortedminimummobilenumbers.length>0) {
			partialarraydynamiclengthdynamiclength = partialsortedminimummobilenumbers.length;
		}
		System.out.println("partialarraydynamiclengthdynamiclength is -"+partialarraydynamiclengthdynamiclength);

		boolean numberpresent;
		numberpresent=false;
		int iterationnumber;
		iterationnumber=0;
		
		while (iterationnumber<partialarraydynamiclengthdynamiclength) {
			
			if(iterationnumber==partialarraydynamiclengthdynamiclength) {
				System.out.println("partialarraydynamiclengthdynamiclength coming out break -"+partialarraydynamiclengthdynamiclength);
				break;
			}
				if (number==partialsortedminimummobilenumbers[iterationnumber]) {
					//set flag numberpresent
					numberpresent=true;
				}
			iterationnumber=iterationnumber+1;
		}
		
		return numberpresent;
	}	
	
	
	public static long[] selectionSort(long[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index]) {
					index = j;// searching for lowest index
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
		} finally {
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

	// to write sno, mobilenumber, recrdstartarr, recrdendarray to String and then
	// to Printwriter out file
	private void writeFileUsingStream(String recrddatainput, File dest2) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			// is = new FileInputStream(source);
			StringBuffer strbuffer = new StringBuffer(recrddatainput);
			// os = new FileOutputStream(dest2);

			FileWriter fw = new FileWriter(dest2);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);

			byte[] buffer = new byte[1024];
			int length;
			// while ((length = strbuffer.toString().length()) > 0) {
			if ((length = strbuffer.toString().length()) > 0) {
				out.append(strbuffer.toString());

			}
			out.close();
		} finally {
			// is.close();
			// out.close();
			System.out.println("the file is closed in previous block");
		}
	}
	
	
	
}
