import java.util.*;

public class IPClassifier {

    // Function to determine IP Class
    static void findClass(String ip) {
        String[] parts = ip.split("\\.");
        int firstOctet = Integer.parseInt(parts[0]);

        if (firstOctet >= 1 && firstOctet <= 126) {
            System.out.println("Class A");
        } else if (firstOctet >= 128 && firstOctet <= 191) {
            System.out.println("Class B");
        } else if (firstOctet >= 192 && firstOctet <= 223) {
            System.out.println("Class C");
        } else if (firstOctet >= 224 && firstOctet <= 239) {
            System.out.println("Class D (Multicast)");
        } else if (firstOctet >= 240 && firstOctet <= 255) {
            System.out.println("Class E (Experimental)");
        } else if (firstOctet == 127) {
            System.out.println("Loopback Address");
        } else {
            System.out.println("Invalid IP");
        }
    }

    // Function to convert IP to 32-bit binary
    static void toBinary(String ip) {
        String[] parts = ip.split("\\.");
        String binaryIP = "";

        for (String part : parts) {
            int num = Integer.parseInt(part);
            String bin = Integer.toBinaryString(num);

            // pad to 8 bits
            while (bin.length() < 8) {
                bin = "0" + bin;
            }

            binaryIP += bin + " ";
        }

        System.out.println("32-bit Binary: " + binaryIP.trim());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter IP Address: ");
        String ip = sc.nextLine();

        findClass(ip);
        toBinary(ip);
    }
}
