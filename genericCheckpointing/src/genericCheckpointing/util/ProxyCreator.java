package genericCheckpointing.util;

import genericCheckpointing.server.StoreRestoreI;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyCreator
{
   /**
    * This method creates and returns a dynamic proxy.
    *
    * @param Class<?>[] - Array of interfaces for proxy
    * @param InvocationHandler - Invocation handler for proxy to use
    * @return StoreRestoreI - proxy returned
    */
    public StoreRestoreI createProxy(Class<?>[] interfaceArray, InvocationHandler handler)
    {
        StoreRestoreI storeRestoreRef = (StoreRestoreI) 
        								Proxy.newProxyInstance(
                                                              getClass().getClassLoader(),
                                                              interfaceArray,
                                                              handler
                                                              );
        return storeRestoreRef;
    }
}
