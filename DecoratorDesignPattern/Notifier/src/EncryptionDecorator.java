import java.util.Base64;

public class EncryptionDecorator extends DataSourceDecorator {

    public EncryptionDecorator(DataSource source) {
        super(source);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String readData() {
        // TODO Auto-generated method stub
        return decode(super.readData());
    }

    private String decode(String readData) {
        byte[] result = Base64.getDecoder().decode(readData);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }

    @Override
    public void writeData(String data) {
        // TODO Auto-generated method stub
        super.writeData(encode(data));
    }

    private String encode(String data) {
        byte[] result = data.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    
    
}
