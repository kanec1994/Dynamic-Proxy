package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class XMLDeserializationStrategy implements DeserStrategyI
{
   /**
    * Implementation of the processInput method of the 
    * SerStrategyI interface. This method takes and object
    * and Serializes it in pseudoXML format.
    *
    * @param String - string in XML format
    * @return SerializableObject - object created
    */
    public SerializableObject deserializeInput(String xml)
    {
        DeserializeTypes deserializeTypes = new DeserializeTypes();
        String[] lines = xml.split("\n");
        for(int i=0; i<lines.length; i++)
        {
            String subStr = "", value = "";
            if(i != 0)
            {
                String rmLeadWS = lines[i].substring(lines[i].indexOf('<')+1, lines[i].length()-1);
                String cutStr = rmLeadWS.substring(1, 16);
                if(cutStr.indexOf(' ') != -1)
                {
                    subStr = cutStr.substring(0, cutStr.indexOf(' '));
                }
                if(rmLeadWS.indexOf('<') != -1)
                {
                    value = rmLeadWS.substring(rmLeadWS.indexOf('>')+1, rmLeadWS.indexOf('<'));
                }
                lines[i] = subStr + " " + value;
            }
            else
            {
                String type = lines[i].substring(lines[i].indexOf('"')+1, lines[i].length()-2);
                lines[0] = type;
            }
        }
        return deserializeTypes.deserialize(lines);
    }
}
