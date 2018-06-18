package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject
{
    private double myDoubleT, myOtherDoubleT;
    private float myFloatT;
    private short myShortT;
    private char myCharT;

   /**
    * Constructor for the MyAllTypesSecond class
    * 
    * @param double - initial value for myDoubleT
    * @param double - initial value for myOtherDoubleT
    * @param float - initial value for myFloatT
    * @param short - initial value for myShortT
    * @param char - initial value for myCharT
    */
    public MyAllTypesSecond(double d, double d2, float f, short s, char c)
    {
        myDoubleT = d;
        myOtherDoubleT = d2;
        myFloatT = f;
        myShortT = s;
        myCharT = c;
    }

   /**
    * Setter method for myDoubleT of MyAllTypesSecond
    *
    * @param double - new value of myDoubleT
    */
    public void setMyDoubleT(double d)
    {
        myDoubleT = d;
    }
    
   /**
    * Setter method for myOtherDoubleT of MyAllTypesSecond
    *
    * @param double - new value of myOtherDoubleT
    */
    public void setMyOtherDoubleT(double d)
    {
        myOtherDoubleT = d;
    }
    
   /**
    * Setter method for myFloatT of MyAllTypesSecond
    *
    * @param float - new value of myFloatT
    */
    public void setMyFloatT(float f)
    {
        myFloatT = f;
    }
   
   /**
    * Setter method for myShortT of MyAllTypesSecond
    *
    * @param short - new value of myShortT
    */ 
    public void setMyShortT(short s)
    {
        myShortT = s;
    }
   
   /**
    * Setter method for myCharT of MyAllTypesSecond
    *
    * @param char - new value of myCharT
    */ 
    public void setMyCharT(char c)
    {
        myCharT = c;
    }

   /**
    * Getter method for myDoubleT of MyAllTypesSecond
    *
    * @return double - myDoubleT
    */
    public double getMyDoubleT()
    {
        return myDoubleT;
    }
   
   /**
    * Getter method for myOtherDoubleT of MyAllTypesSecond
    *
    * @return double - myOtherDoubleT
    */ 
    public double getMyOtherDoubleT()
    {
        return myOtherDoubleT;
    }
   
   /**
    * Getter method for myFloatT of MyAllTypesSecond
    *
    * @return float - myFloatT
    */ 
    public float getMyFloatT()
    {
        return myFloatT;
    }
   
   /**
    * Getter method for myShortT of MyAllTypesSecond
    *
    * @return short - myShortT
    */ 
    public short getMyShortT()
    {
        return myShortT;
    }
   
   /**
    * Getter method for myCharT of MyAllTypesSecond
    *
    * @return char - myCharT
    */ 
    public char getMyCharT()
    {
        return myCharT;
    }

   /**
    * Calculates hashcode of a MyAllTypesSecond object
    *
    * @return int - hashcode
    */
    @Override public int hashCode()
    {
        return (int)((3*myDoubleT) + (5*myOtherDoubleT) + (7*myFloatT) 
                + (11*myShortT) + (13*myCharT));
    }

   /**
    * Determines if another object is equal
    *
    * @param MyAllTypesFirst - comparing obj
    */
    public boolean equals(Object obj) 
    {
	    return this.hashCode() == obj.hashCode();
    } 

    public String toString()
    {
	return "MyAllTypesSecond Object:\n" + "\n  MyDouble: " + myDoubleT
		+ "\n  MyOtherDouble: " + myOtherDoubleT + "\n  MyFloat: " + myFloatT 
		+ "\n  MyShort: " + myShortT + "\n  MyChar: " + myCharT +'\n'; 
    }
}
