import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.FileProcI;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

import java.util.Vector;
import java.util.Random;

public class Driver
{
    public static void main(String[] args)
    {
        if(args.length == 3)
        {
            //Read command line arguments
            String mode = args[0];
            int NUM_OF_OBJECTS = Integer.parseInt(args[1]);
            String filename = args[2];
            
            //Create proxy
            ProxyCreator pc = new ProxyCreator();
            StoreRestoreHandler sr_handler = new StoreRestoreHandler();
            StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
                                                                    new Class[] {
                                                                                StoreI.class,
                                                                                RestoreI.class,
                                                                                FileProcI.class
                                                                                },
                                                                    sr_handler
            
                                                                    );
            MyAllTypesFirst myFirst;
            MyAllTypesSecond mySecond;
            
            //Process mode
            if(args[0].equals("serdeser"))
            {
                Vector<SerializableObject> serialize = new Vector<SerializableObject>();
                Vector<SerializableObject> deserialize = new Vector<SerializableObject>();
                boolean myBool = false;
                Random r = new Random();
                
                ((FileProcI) cpointRef).openResults(filename);                
	            for(int i=0; i<NUM_OF_OBJECTS; i++)
	            {
	                int myInt = 2*i - 1;
	                int myOtherInt = 4*i + 3;
	                long myLong = 1000*NUM_OF_OBJECTS*i;
	                long myOtherLong = 1000*NUM_OF_OBJECTS - 1000*i;
	                String myString = "Serial String " + i;
	                myBool = !myBool;	                
	                myFirst = new MyAllTypesFirst(myInt, myOtherInt, 
	                                              myLong, myOtherLong, 
	                                              myString, myBool);
	                                              
	                double myDouble = 0;
	                double myOtherDouble = 2.0 + 40.0-i;
	                float myFloat = (float)(40.0 + 2.0);
	                short myShort = (short)(i+10);
	                char myChar = (char)(r.nextInt(26) + 'a');                          
	                mySecond = new MyAllTypesSecond(myDouble, myOtherDouble,
	                                                myFloat, myShort,
	                                                myChar);
	                
	                //STORE MYFIRST AND MYSECOND IN THE DATA STRUCTURE
	                ((StoreI) cpointRef).writeObj(myFirst, i+1, "XML");
	                ((StoreI) cpointRef).writeObj(mySecond, i+2, "XML");
	                
	                serialize.add(myFirst);
	                serialize.add(mySecond);
	            }
                ((FileProcI) cpointRef).closeResults(); 
	            
	            SerializableObject myRecordRet;
	            
                ((FileProcI) cpointRef).openFP(filename);  
	            for(int j=0; j<2*NUM_OF_OBJECTS; j++)
	            {
	                myRecordRet = ((RestoreI) cpointRef).readObj("XML");
	                deserialize.add(myRecordRet);
	            }
                ((FileProcI) cpointRef).closeFP();
                
                int totalWrong=0;
                for(int k=0; k<serialize.size(); k++)
                {
                    System.out.println(serialize.elementAt(k).hashCode());
                    System.out.println(deserialize.elementAt(k).hashCode());
                    if(!(serialize.elementAt(k)).equals(deserialize.elementAt(k)))
                    {
                        totalWrong++;
                    }
                }
                System.out.println(totalWrong + " mismatched objects");
            }
            else
            {
	            SerializableObject myRecordRet;
                ((FileProcI) cpointRef).openFP(filename);  
	            for(int j=0; j<2*NUM_OF_OBJECTS; j++)
	            {
	                myRecordRet = ((RestoreI) cpointRef).readObj("XML");
	                System.out.println(myRecordRet.toString());
	            }
                ((FileProcI) cpointRef).closeFP();
            }
        }
        else
        {
            System.err.println("Incorrect number of arguments!");
        }
    }
}
