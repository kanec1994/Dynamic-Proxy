package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.Results;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StoreRestoreHandler implements InvocationHandler
{
    private FileProcessor fp;
    private Results results;
   
   /**
    * Implementation of the invoke method of the InvocationHandler class.
    * Checks which method is called and acts appropriately.
    *
    * @param Object - dynamic proxy to use
    * @param Method - method called
    * @param Object[] - method arguments
    */    
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable
    {
        String methodName = m.getName();
        if(methodName.equals("writeObj"))
        {
            serializeData((SerializableObject) args[0], new XMLSerializationStrategy());
            return args[0];
        }
        else if(methodName.equals("readObj"))
        {
            String xml = "";
            String line = fp.readLine();
            while(line != null)
            {
                line = fp.readLine();
                if(line.equals(" </complexType>")) ;
                else if(line.equals("</DPSerialization>")) break;
                else xml += line + '\n';
            }
            return deserializeData(xml, new XMLDeserializationStrategy());
        }
        else if(methodName.equals("openFP"))
        {
            fp = new FileProcessor(args[0].toString());
            return null;
        }
        else if(methodName.equals("closeFP"))
        {
            fp.close();
            return null;
        }
	    else if(methodName.equals("openResults"))
        {
            results = new Results(args[0].toString());
            return null;
        }
        else if(methodName.equals("closeResults"))
        {
	        results.printResults();
            results.close();
            return null;
        }
        return null;
    }
    
   /**
    * Implements the strategy pattern to call the process input function of
    * the XMLSerialization Object
    *
    * @param SerializableObject - object to serialize into psuedoXML
    * @param SerStrategyI - Serializable Strategy
    */
    public void serializeData(SerializableObject serObj, SerStrategyI serStrat)
    {
        results.storeNewResult(serStrat.serializeInput(serObj));
    }
    
   /**
    * Implements the strategy pattern to call the process input function of
    * the XMLSerialization Object
    *
    * @param SerializableObject - object to serialize into psuedoXML
    * @param SerStrategyI - Serializable Strategy
    */
    public SerializableObject deserializeData(String xml, DeserStrategyI deserStrat)
    {
        return deserStrat.deserializeInput(xml);
    }
}
