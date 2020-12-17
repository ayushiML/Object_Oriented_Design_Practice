import javax.xml.crypto.Data;

public class DataSourceDecorator implements DataSource {
    private DataSource wrapee;
    public DataSourceDecorator(DataSource source)
    {
        wrapee = source;
    }
    @Override
    public void writeData(String data) {
        // TODO Auto-generated method stub
        wrapee.writeData(data);
    }

    @Override
    public String readData() {
       return wrapee.readData();
        // TODO Auto-generated method stub
       // return null;

    }
    
}
