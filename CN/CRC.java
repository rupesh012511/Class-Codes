import java.util.Scanner;

public class CRC {

    // XOR operation
    static String xor(String a, String b) {
        String result = "";
        for (int i = 1; i < b.length(); i++) {
            result += (a.charAt(i) == b.charAt(i)) ? '0' : '1';
        }
        return result;
    }

    // Division process
    static String mod2div(String dividend, String divisor) {
        int pick = divisor.length();
        String tmp = dividend.substring(0, pick);

        while (pick < dividend.length()) {
            if (tmp.charAt(0) == '1') {
                tmp = xor(divisor, tmp) + dividend.charAt(pick);
            } else {
                tmp = xor("0".repeat(pick), tmp) + dividend.charAt(pick);
            }
            pick++;
        }

        if (tmp.charAt(0) == '1') {
            tmp = xor(divisor, tmp);
        } else {
            tmp = xor("0".repeat(pick), tmp);
        }

        return tmp;
    }

    // Encode data
    static String encodeData(String data, String key) {
        int l_key = key.length();
        String appendedData = data + "0".repeat(l_key - 1);
        String remainder = mod2div(appendedData, key);
        return data + remainder;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter data (binary): ");
        String data = sc.next();

        System.out.print("Enter generator polynomial (binary): ");
        String key = sc.next();

        String encoded = encodeData(data, key);
        System.out.println("Encoded Data (with CRC): " + encoded);

        // Receiver side
        String remainder = mod2div(encoded, key);

        if (Integer.parseInt(remainder) == 0) {
            System.out.println("No Error Detected");
        } else {
            System.out.println("Error Detected");
        }
    }
}