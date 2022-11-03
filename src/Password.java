public class Password {

    String Value;

    int Length;

    public Password(String str) {
        Value = str;
        Length = str.length();
    }

    // in CharType func. we use ASCII Codes to get characters
    // for password validation.
    public int CharType(char C) {
        int value;

        // Char is Uppercase Letter
        if ((int) C >= 65 && (int) C <= 90)
            value = 1;

            // Char is Lowercase Letter
        else if ((int) C >= 97 && (int) C <= 122) {
            value = 2;
        }

        // Char is Numbers
        else if ((int) C >= 48 && (int) C <= 57) {
            value = 3;
        }

        // Char is Symbol
        else {
            value = 4;
        }

        return value;
    }

}
