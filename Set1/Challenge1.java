import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Challenge1 {
    // Challenge 1: Convert hex to base64
    // The String: 49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d
    // Should produce: SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t

    public static byte[] hexStringToBytes(String hexString) {
        int len = hexString.length();
        byte[] byteArray = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            byteArray[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i + 1), 16));
        }
        return byteArray;
    }

    public static byte[] hexBytesToBase64(byte[] hexBytes) {
        return Base64.getEncoder().encode(hexBytes);
    }

    public static String hexBytesToString(byte[] hexBytes) {
        StringBuilder hexString = new StringBuilder();

        for (byte b : hexBytes) {
            hexString.append(String.format("%02x", b));
        }

        return hexString.toString();
    }

    

    public static void main(String[] args) {
        

        String hexStringInput = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";

        byte[] hexBytes = hexStringToBytes(hexStringInput);
        byte[] base64Bytes = hexBytesToBase64(hexBytes);
        System.out.println(new String(base64Bytes, StandardCharsets.UTF_8));
        
    }

}