package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class XMLSerializationStrategy implements SerStrategyI
{
   /**
    * Implementation of the processInput method of the 
    * SerStrategyI interface. This method takes and object
    * and Serializes it in pseudoXML format.
    *
    * @param SerializableObject - object to serialize in XML format
    */
    public String serializeInput(SerializableObject serObj)
    {
        String serStr = "<DPSerialization>\n <complexType xsi:type=\"";
        SerializeTypes serializeTypes = new SerializeTypes();
        Class<?> cls = serObj.getClass();
        String className = cls.getName();
        serStr += className + "\">\n";
        Field fieldList[] = cls.getDeclaredFields();
        for(int i=0; i<fieldList.length; i++)
        {
            try
            {
                String capsFieldName = fieldList[i].getName().substring(0,1).toUpperCase()
                                     + fieldList[i].getName().substring(1);
                String methodName = "get" + capsFieldName;
                Method getterMethod = cls.getMethod(methodName);
                Object obj = getterMethod.invoke(serObj);
                
                if(obj instanceof Integer)
                {
                    serStr += serializeTypes.serialize((int) obj,
                                                       fieldList[i].getName());
                }
                else if(obj instanceof Long)
                {
                    serStr += serializeTypes.serialize((long) obj,
                                                       fieldList[i].getName());
                }
                else if(obj instanceof String)
                {
                    serStr += serializeTypes.serialize((String) obj,
                                                       fieldList[i].getName());
                }
                else if(obj instanceof Boolean)
                {
                    serStr += serializeTypes.serialize((boolean) obj,
                                                       fieldList[i].getName());
                }
                else if(obj instanceof Double)
                {
                    serStr += serializeTypes.serialize((double) obj,
                                                       fieldList[i].getName());
                }
                else if(obj instanceof Float)
                {
                    serStr += serializeTypes.serialize((float) obj,
                                                       fieldList[i].getName());
                }
                else if(obj instanceof Short)
                {
                    serStr += serializeTypes.serialize((short) obj,
                                                       fieldList[i].getName());
                }
                else if(obj instanceof Character)
                {
                    serStr += serializeTypes.serialize((char) obj,
                                                       fieldList[i].getName());
                }
            }
            catch(Exception e)
            {
                System.out.println("Exception occured!");
                e.printStackTrace();
            }
        }
        serStr += " </complexType>\n</DPSerialization>";
        return serStr;
    }
}
