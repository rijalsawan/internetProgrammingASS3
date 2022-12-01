import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileSorter {
    public static void main(String[] args) throws FileNotFoundException {
        sortFile("src/names.xml");
    }
    public static void sortFile(String fileName) throws FileNotFoundException {
        XMLDecoder decoder = new XMLDecoder(new FileInputStream(fileName));
        String[] file = (String[]) decoder.readObject();
        decoder.close();
        String temp;
        for (int i = 0; i < file.length; i++) {
            for (int j = 0; j < file.length - 1; j++) {
                if (file[j].compareTo(file[j + 1]) < 0) {
                    temp = file[j];
                    file[j] = file[j + 1];
                    file[j + 1] = temp;
                }
            }
        }
        XMLEncoder encoder = new XMLEncoder(new FileOutputStream(fileName));
        for (String s : file) {
            encoder.writeObject(s);
        }
        encoder.close();
    }
}
