public class ShortestCommonSupersequence {

    // Function to find the shortest common supersequence of two strings
    public static String shortestCommonSupersequence(String str1, String str2) {
        // If either string is empty, the shortest common supersequence is the other string
        if (str1.length() == 0) {
            return str2;
        }
        if (str2.length() == 0) {
            return str1;
        }

        // If the last characters of the two strings are the same, the shortest common supersequence
        // is the last character of the two strings concatenated with the shortest common supersequence
        // of the two strings without the last character
        if (str1.charAt(str1.length() - 1) == str2.charAt(str2.length() - 1)) {
            return str1.charAt(str1.length() - 1) + shortestCommonSupersequence(str1.substring(0, str1.length() - 1), str2.substring(0, str2.length() - 1));
        }

        // If the last characters of the two strings are different, the shortest common supersequence
        // is the longer of the two strings concatenated with the shortest common supersequence
        // of the two strings without the last character of the longer string
        else {
            if (str1.length() > str2.length()) {
                return str1.charAt(str1.length() - 1) + shortestCommonSupersequence(str1.substring(0, str1.length() - 1), str2);
            } else {
                return str2.charAt(str2.length() - 1) + shortestCommonSupersequence(str1, str2.substring(0, str2.length() - 1));
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        String str1 = "brute";
        String str2 = "groot";
        System.out.println(shortestCommonSupersequence(str1, str2)); // Output: "ABCDEF"
    }
}