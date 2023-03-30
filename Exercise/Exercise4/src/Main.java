import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        String subjectString1 = "Positive: https://www.example.com and Negative: http://www.example.com pattern.";

        Pattern pattern1 = Pattern.compile("https://\\w+.\\w{2,}.\\w{2,}");
        Matcher matcher1 = pattern1.matcher(subjectString1);

        System.out.println("Pattern 1: https://\\w+.\\w{2,}.\\w{2,}");
        System.out.println("subjectString1: " + subjectString1);
        while (matcher1.find()) {
            System.out.println("Found value: " + matcher1.group());
        }
        System.out.println();

        String subjectString2 = "Positive: 123-456-7890 and Negative: abc-def-ghij pattern.";

        Pattern pattern2 = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
        Matcher matcher2 = pattern2.matcher(subjectString2);

        System.out.println("Pattern 2: \\d{3}-\\d{3}-\\d{4}");
        System.out.println("subjectString2: " + subjectString2);
        while (matcher2.find()) {
            System.out.println("Found value: " + matcher2.group());
        }
        System.out.println();

        String subjectString3 = "Positive: fox food and Negative: dog pattern.";
        Pattern pattern3 = Pattern.compile("\\bf\\w+");
        Matcher matcher3 = pattern3.matcher(subjectString3);

        System.out.println("Pattern 3: \\bf\\w+");
        System.out.println("subjectString3: " + subjectString3);
        while (matcher3.find()) {
            System.out.println("Found value: " + matcher3.group());
        }
        System.out.println();

        String subjectString4 = "Positive: user@example.com and Negative: user@example pattern.";
        Pattern pattern4 = Pattern.compile("\\b\\w+@\\w+\\.\\w{2,}\\b");
        Matcher matcher4 = pattern4.matcher(subjectString4);

        System.out.println("Pattern 4: \\b\\w+@\\w+\\.\\w{2,}\\b");
        System.out.println("subjectString4: " + subjectString4);
        while (matcher4.find()) {
            System.out.println("Found value: " + matcher4.group());
        }
        System.out.println();

        String subjectString5 = "Positive: 2020-01-01 and Negative: 2020-01-32 pattern.";
        Pattern pattern5 = Pattern.compile("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))");
        Matcher matcher5 = pattern5.matcher(subjectString5);

        System.out.println("Pattern 5: ([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))");
        System.out.println("subjectString5: " + subjectString5);
        while (matcher5.find()) {
            System.out.println("Found value: " + matcher5.group());
        }
    }
}