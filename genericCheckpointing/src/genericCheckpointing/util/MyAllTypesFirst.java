package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject
{
    private int myInt, myOtherInt;
    private long myLong, myOtherLong;
    private String myString;
    private boolean myBool;
    
   /**
    * Constructor for the MyAllTypesFirst class
    * 
    * @param int - initial value for myInt
    * @param int - initial value for myOtherInt
    * @param long - initial value for myLong
    * @param long - initial value for myOtherLong
    * @param String - initial value for myString
    * @param boolean - initial value for myBool
    */
    public MyAllTypesFirst(int i, int i2, long l, long l2, String s, boolean b)
    {
        myInt = i;
        myOtherInt = i2;
        myLong = l;
        myOtherLong = l2;
        myString = s;
        myBool = b;
    }
    
   /**
    * Setter for myInt of MyAllTypesFirst
    *
    * @param int - new value of myInt
    */
    public void setMyInt(int i)
    {
        myInt = i;
    }
    
   /**
    * Setter for myOtherInt of MyAllTypesFirst
    *
    * @param int - new value of myOtherInt
    */
    public void setMyOtherInt(int i)
    {
        myOtherInt = i;
    }
   
   /**
    * Setter for myLong of MyAllTypesFirst
    *
    * @param long - new value of myLong
    */
    public void setMyLong(long l)
    {
        myLong = l;
    }
   
   /**
    * Setter for myOtherLong of MyAllTypesFirst
    *
    * @param long - new value of myOtherLong
    */
    public void setMyOtherLong(long l)
    {
        myOtherLong = l;
    }  
    
   /**
    * Setter for myString of MyAllTypesFirst
    *
    * @param String - new value of myString
    */
    public void setMyString(String s)
    {
        myString = s;
    } 
    
   /**
    * Setter for myBool of MyAllTypesFirst
    *
    * @param boolean - new value of myBool
    */
    public void setMyBool(boolean b)
    {
        myBool = b;
    }
    
   /**
    * Getter for myInt of MyAllTypesFirst
    *
    * @return int - myInt
    */
    public int getMyInt()
    {
        return myInt;
    }
    
   /**
    * Getter for myOtherInt of MyAllTypesFirst
    *
    * @return int - myOtherInt
    */
    public int getMyOtherInt()
    {
        return myOtherInt;
    }
    
   /**
    * Getter for myLong of MyAllTypesFirst
    *
    * @return long - myLong
    */
    public long getMyLong()
    {
        return myLong;
    }
    
   /**
    * Getter for myOtherLong of MyAllTypesFirst
    *
    * @return long - myOtherLong
    */
    public long getMyOtherLong()
    {
        return myOtherLong;
    }
    
   /**
    * Getter for myString of MyAllTypesFirst
    *
    * @return String - myString
    */
    public String getMyString()
    {
        return myString;
    }
    
   /**
    * Getter for myBool of MyAllTypesFirst
    *
    * @return boolean - myBool
    */
    public boolean getMyBool()
    {
        return myBool;
    }   

   /**
    * Calculates hashcode of a MyAllTypesFirst object
    *
    * @return int - hashcode
    */
    @Override public int hashCode()
    {
        return (3*myInt) + (5*myOtherInt) + (int)(7*myLong) 
                + (int)(11*myOtherLong) + (13*myString.hashCode()) + (17 * ((myBool)?1:0));
    }

   /**
    * Determines if another object is equal
    *
    * @param MyAllTypesFirst - comparing obj
    */
    public boolean equals(Object obj) 
    {
	    return (this.hashCode() == obj.hashCode());
    }  

    public String toString()
    {
	return "MyAllTypesFirst Object:\n" + "\n  MyInt: " + myInt + "\n  MyOtherInt: " + myOtherInt 
		+ "\n  MyLong: " + myLong + "\n  MyOtherLong: " + myOtherLong 
		+ "\n  MyString: " + myString + "\n  MyBool: " + myBool +'\n'; 
    }
}
