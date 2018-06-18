package genericCheckpointing.xmlStoreRestore;

class SerializeTypes
{
   /**
    * This method serializes int parameters and returns a String.
    *
    * @param int - field value
    * @param String - field name
    */
    String serialize(int fieldVal, String fieldName)
    {
        if(fieldVal < 10) return "";
        return "  < " + fieldName + " xsi:type=\"xsi:int\">" + fieldVal + "</" + fieldName + ">\n";
    }
    
   /**
    * This method serializes long parameters and returns a String.
    *
    * @param long - field value
    * @param String - field name
    */
    String serialize(long fieldVal, String fieldName)
    {
        if(fieldVal < 10) return "";
        return "  < " + fieldName + " xsi:type=\"xsi:long\">" + fieldVal + "</" + fieldName + ">\n";
    }
    
   /**
    * This method serializes String parameters and returns a String.
    *
    * @param String - field value
    * @param String - field name
    */
    String serialize(String fieldVal, String fieldName)
    {
        return "  < " + fieldName + " xsi:type=\"xsi:string\">" + fieldVal + "</" + fieldName + ">\n";
    }
    
   /**
    * This method serializes bool parameters and returns a String.
    *
    * @param bool - field value
    * @param String - field name
    */
    String serialize(boolean fieldVal, String fieldName)
    {
        return "  < " + fieldName + " xsi:type=\"xsi:boolean\">" + fieldVal + "</" + fieldName 
									                                               + ">\n";
    }

   /**
    * This method serializes double parameters and returns a String.
    *
    * @param double - field value
    * @param String - field name
    */
    String serialize(double fieldVal, String fieldName)
    {
        if(fieldVal < 10) return "";
        return "  < " + fieldName + " xsi:type=\"xsi:double\">" + fieldVal + "</" + fieldName + ">\n";
    }

   /**
    * This method serializes float parameters and returns a String.
    *
    * @param float - field value
    * @param String - field name
    */
    String serialize(float fieldVal, String fieldName)
    {
        return "  < " + fieldName + " xsi:type=\"xsi:float\">" + fieldVal + "</" + fieldName + ">\n";
    }

   /**
    * This method serializes short parameters and returns a String.
    *
    * @param short - field value
    * @param String - field name
    */
    String serialize(short fieldVal, String fieldName)
    {
        return "  < " + fieldName + " xsi:type=\"xsi:short\">" + fieldVal + "</" + fieldName + ">\n";
    }
   
   /**
    * This method serializes char parameters and returns a String.
    *
    * @param char - field value
    * @param String - field name
    */
    String serialize(char fieldVal, String fieldName)
    {
        return "  < " + fieldName + " xsi:type=\"xsi:char\">" + fieldVal + "</" + fieldName + ">\n";
    }
}
