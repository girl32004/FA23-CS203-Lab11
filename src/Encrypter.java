import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//test
public class Encrypter {

    private int shift;
    private String encrypted;

   
    public Encrypter() {
        this.shift = 1;
        this.encrypted = "";
    }


    public Encrypter(int s) {
        this.shift = s;
        this.encrypted = "";
    }

  
    public void encrypt(String inputFilePath, String encryptedFilePath) throws Exception {
    	String content = readFile(inputFilePath);
        StringBuilder encryptedBuilder = new StringBuilder();

        for (char ch : content.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A'; 
                ch = (char) (((ch - base + shift) % 26) + base); // + shift for encrypting
            }
            encryptedBuilder.append(ch);
        }

        this.encrypted = encryptedBuilder.toString();
        writeFile(this.encrypted, encryptedFilePath);
    }


    public void decrypt(String messageFilePath, String decryptedFilePath) throws Exception {
    	String message = readFile(messageFilePath);
 	    StringBuilder decryptedBuilder = new StringBuilder();

 	    for (char ch : message.toCharArray()) {
 	        if (Character.isLetter(ch)) {
 	            char base = Character.isLowerCase(ch) ? 'a' : 'A';
 	            ch = (char) (((ch - base - shift + 26) % 26) + base); // - shift for decrypting
 	        }
 	        decryptedBuilder.append(ch);
 	    }

 	    writeFile(decryptedBuilder.toString(), decryptedFilePath);
 	}  
    	
    
    private static String readFile(String filePath) throws IOException {
        byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
        return new String(fileBytes);
    }

  
    private static void writeFile(String data, String filePath) throws IOException {
    	Files.write(Paths.get(filePath),data.getBytes()); 
   
    }

  
    @Override
    public String toString() {
        return encrypted;
    }
}


