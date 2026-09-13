import java.util.*;

public class FramingMethods {

    // Character Count Method
    static void characterCount(String data) {
        int count = data.length();
        String frame = count + data;

        System.out.println("Frame: " + frame);

        int receivedCount = Character.getNumericValue(frame.charAt(0));
        String extracted = frame.substring(1, 1 + receivedCount);

        System.out.println("Extracted Data: " + extracted);
    }

    // Character Stuffing
    static void characterStuffing(String data) {
        char FLAG = 'F';
        char ESC = 'E';

        String stuffed = "";

        for (char ch : data.toCharArray()) {
            if (ch == FLAG || ch == ESC) {
                stuffed += ESC;
            }
            stuffed += ch;
        }

        String frame = FLAG + stuffed + FLAG;
        System.out.println("Stuffed Frame: " + frame);

        // Destuffing
        String destuffed = "";
        for (int i = 1; i < frame.length() - 1; i++) {
            if (frame.charAt(i) == ESC) {
                i++;
            }
            destuffed += frame.charAt(i);
        }

        System.out.println("Destuffed Data: " + destuffed);
    }

    // Bit Stuffing
    static void bitStuffing(String data) {
        String stuffed = "";
        int count = 0;

        // Stuffing
        for (int i = 0; i < data.length(); i++) {
            char bit = data.charAt(i);
            stuffed += bit;

            if (bit == '1') {
                count++;
                if (count == 5) {
                    stuffed += '0';
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        System.out.println("Stuffed Data: " + stuffed);

        // Destuffing
        String destuffed = "";
        count = 0;

        for (int i = 0; i < stuffed.length(); i++) {
            char bit = stuffed.charAt(i);
            destuffed += bit;

            if (bit == '1') {
                count++;
                if (count == 5) {
                    i++; // skip stuffed 0
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        System.out.println("Destuffed Data: " + destuffed);
    }

    // 🔥 Main Menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean go = true;

        while(go){
            System.out.println("1. Character Count");
            System.out.println("2. Character Stuffing");
            System.out.println("3. Bit Stuffing");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            sc.nextLine(); // consume newline
            System.out.print("Enter data: ");
            String data = sc.nextLine();

        
            switch (choice) {
                case 1:
                    characterCount(data);
                    break;
                case 2:
                    characterStuffing(data);
                    break;
                case 3:
                    bitStuffing(data);
                    break;
                case 4:
                    go=false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}