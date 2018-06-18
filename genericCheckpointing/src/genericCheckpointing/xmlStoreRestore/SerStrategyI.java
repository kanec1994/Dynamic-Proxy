package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;

public interface SerStrategyI
{
    public String serializeInput(SerializableObject serObj);
}
