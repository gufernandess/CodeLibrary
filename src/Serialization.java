import java.io.File;
import java.io.IOException;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {
    
    public static void writeBinaryFile(List<Object> list, String fileName) {
        File file = new File(fileName);
        try {
            file.delete();
            file.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
            objOutput.writeObject(list);
            objOutput.close();

        } catch(IOException e) {
            System.out.printf("Erro: %s", e.getMessage());
        }
    }
    
    public static List<Object> readBinaryFile(String fileName) {
        List<Object> list = null;
        try {
            File file = new File(fileName);
            if (file.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
                list = (List<Object>)objInput.readObject();
                objInput.close();
            }
        } catch(IOException firstError) {
            System.out.printf("Erro: %s", firstError.getMessage());
        } catch(ClassNotFoundException secondError) {
            System.out.printf("Erro: %s", secondError.getMessage());
        }

        return(list);
    }

}