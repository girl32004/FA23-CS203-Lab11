import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Encrypter {

    private int shift;
    private String encrypted;

    /**
     * Default Constructor
     */
   
    public Encrypter() {
        this.shift = 1;
        this.encrypted = "";
    }

    /**
     * Non-default Constructor
     * @param s - custom shift amount
     */

    public Encrypter(int s) {
        this.shift = s;
        this.encrypted = "";
    }

    /**
     * Encrypts the content of a file and writes the result to another file.
     *
     * @param inputFilePath      the path to the file containing the text to be encrypted
     * @param encryptedFilePath the path to the file where the encrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
  
    public void encrypt(String inputFilePath, String encryptedFilePath) throws Exception {
        //TODO: Call the read method, encrypt the file contents, and then write to new file
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

    /**
     * Decrypts the content of an encrypted file and writes the result to another file.
     *
     * @param messageFilePath    the path to the file containing the encrypted text
     * @param decryptedFilePath the path to the file where the decrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */

    public void decrypt(String messageFilePath, String decryptedFilePath) throws Exception {
        //TODO: Call the read method, decrypt the file contents, and then write to new file
    }
    	String message = readFile(messageFilePath);
 	    StringBuilder decryptedBuilder = new StringBuilder();

 	    for (char ch : message.toCharArray()) {
 	        if (Character.isLetter(ch)) {
 	            char base = Character.isLowerCase(ch) ? 'a' : 'A';
 	            ch = (char) (((ch - base - shift + 26) % 26) + base); // - shift for decrypting
 	        }
 	        decryptedBuilder.append(ch);
 	    }

    /**
     * Reads the content of a file and returns it as a string.
     *
     * @param filePath the path to the file to be read
     * @return the content of the file as a string
     * @throws Exception if an error occurs while reading the file
     */
    private static String readFile(String filePath) throws Exception {
        String message = "";
        //TODO: Read file from filePath
        return message;
    	
    
    private static String readFile(String filePath) throws IOException {
        byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
        return new String(fileBytes);
    }

    /**
     * Writes data to a file.
     *
     * @param data     the data to be written to the file
     * @param filePath the path to the file where the data will be written
     */
    private static void writeFile(String data, String filePath) {
        //TODO: Write to filePath
  
    private static void writeFile(String data, String filePath) throws IOException {
    	Files.write(Paths.get(filePath),data.getBytes()); 
   
    }

    /**
     * Returns a string representation of the encrypted text.
     *
     * @return the encrypted text
     */
    @Override
    public String toString() {
        return encrypted;
    }
}
