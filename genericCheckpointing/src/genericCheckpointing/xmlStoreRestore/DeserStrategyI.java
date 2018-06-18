package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;

public interface DeserStrategyI
{
    public SerializableObject deserializeInput(String xml);
}
