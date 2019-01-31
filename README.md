# Javaxmldbmstest
A java dbms which is in xml files and basic CRUD operations. Input is through index.html in Apache tomcat examples HelloWorld folder.
These will also be added soon...

ProgramtoIndexdb.java - A function in Selection sort - Find the min in each iteration and assign it to a new array - sortedarray till all the mins are sorted out. The sorted file Sortednumberarray94711942974114425411975479321431791.xml is having a '<' character at the end. The last iteration is being done on th basis of file length. This has to be checked. The CV's are being uploaded. The max size is 100 records. Bufferring and insert and delete functionality has to be added soon.

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
