package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;

class DeserializeTypes
{
   /**
    * This method constructs a SerializeableObject from a String[].
    *
    * @param String[] - arguments for obj
    * @param SerializableObject - either MyAllTypesFirst or MyAllTypesSecond
    */
    SerializableObject deserialize(String[] args)
    {
        if(args[0].equals("genericCheckpointing.util.MyAllTypesFirst"))
        {
            int myInt = 0, myOtherInt = 0;
            long myLong = 0, myOtherLong = 0;
            String myString = null;
            boolean myBool = false;            
            for(int i=1; i<args.length; i++)
            {
                String[] vals = args[i].split(" ");
                if(vals[0].equals("myInt")) myInt = Integer.parseInt(vals[1]);
                else if(vals[0].equals("myOtherInt")) myOtherInt = Integer.parseInt(vals[1]);
                else if(vals[0].equals("myLong")) myLong = Long.parseLong(vals[1]);
                else if(vals[0].equals("myOtherLong")) myOtherLong = Long.parseLong(vals[1]);
                else if(vals[0].equals("myString")) 
                {
                    myString = String.join(" ", vals);
                    myString = myString.substring(myString.indexOf(" ")+1, myString.length());
                }
                else if(vals[0].equals("myBool")) myBool = Boolean.parseBoolean(vals[1]);
            }
            return new MyAllTypesFirst(myInt, myOtherInt, 
                                       myLong, myOtherLong, 
                                       myString, myBool);
        }
        else if(args[0].equals("genericCheckpointing.util.MyAllTypesSecond"))
        {
            double myDoubleT = 0, myOtherDoubleT = 0.0;
            float myFloatT = 0.0f;
            short myShortT = 0;
            char myCharT = '0';
            for(int i=1; i<args.length; i++)
            {
                String[] vals = args[i].split(" ");
                if(vals[0].equals("myDoubleT")) myDoubleT = Double.parseDouble(vals[1]);
                else if(vals[0].equals("myOtherDoubleT")) myOtherDoubleT = Double.parseDouble(
                                                                                             vals[1]
                                                                                             );
                else if(vals[0].equals("myFloatT")) myFloatT = Float.parseFloat(vals[1]);
                else if(vals[0].equals("myShortT")) myShortT = Short.parseShort(vals[1]);
                else if(vals[0].equals("myCharT")) myCharT = vals[1].charAt(0);
            }
            return new MyAllTypesSecond(myDoubleT, myOtherDoubleT,
                                        myFloatT, myShortT,
                                        myCharT);
        }
        else
        {      
            return null;
        }
    }
}
