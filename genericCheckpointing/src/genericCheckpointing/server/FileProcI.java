package genericCheckpointing.server;

public interface FileProcI extends StoreRestoreI
{
    void openFP(String filename);
    void closeFP();
    void openResults(String filename);
    void closeResults();
}
