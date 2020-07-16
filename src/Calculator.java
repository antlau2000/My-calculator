import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static int inputNumber;

    public static void main(String[] args) throws Exception {
        System.out.println("My Calculator\n");

        while(true) {
            inputNumber = choose();
            switch (inputNumber) {
                case 1:
                    System.out.println("\n" + addition());
                    break;
                case 2:
                    System.out.println("\n" + subtraction());
                    break;
                case 3:
                    System.out.println("\n" + multiplication());
                    break;
                case 4:
                    System.out.println("\n" + diversion());
                    break;
                default:
                    System.out.println("\n" + "Wrong number - " + inputNumber);
                    System.out.println("Try again\n");
                    reader.readLine();
            }
            if (!(inputNumber >= 1 && inputNumber <= 4)) {
                continue;
            }
            if (finish()) {
                break;
            }
        }

    }

    public static int choose() {
        System.out.println("Choose operation\n" +
                "1) Addition(+)\n" +
                "2) Subtraction(-)\n" +
                "3) Multiplication(*)\n" +
                "4) Diversion(/)");
        return getNumber();
    }

    public static int addition() {
        int[] numbers = twoNumbers();
        return numbers[0] + numbers[1];
    }

    public static int subtraction() {
        int[] numbers = twoNumbers();
        return numbers[0] - numbers[1];
    }

    public static int multiplication() {
        int[] numbers = twoNumbers();
        return numbers[0] * numbers[1];
    }

    public static double diversion() {
        int[] numbers = twoNumbers();
        return (numbers[0] * 1.0) / numbers[1];
    }

    public static int[] twoNumbers() {
        int[] numbers = new int[2];

        System.out.println("First number");
        numbers[0] = getNumber();

        System.out.println("Second number");
        numbers[1] = getNumber();

        return numbers;
    }

    public static int getNumber() {
        int number = 0;
        boolean loop;
        do {
            try {
                number = Integer.parseInt(reader.readLine());
                loop = false;
            } catch (Exception e) {
                System.out.println("This is not a number. Try again");
                loop = true;
            }
        } while (loop);
        return number;
    }

    public static boolean finish() throws IOException {
        System.out.println("Do you want to finish(Y/N)");
        String input;
        while (true) {
            input = reader.readLine();
            if ("Y".equals(input.toUpperCase()) || "N".equals(input.toUpperCase())) {
                break;
            }
            System.out.println("\nType Y or N\n\"" + input + "\" is not the right letter");
        }
        return "Y".equals(input.toUpperCase());
    }
}
