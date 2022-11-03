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

    //By checking writing password we see that password has some
    // characters that are uppercase, lowercase, number or symbol.
    public int PasswordStrength() {
        String s = this.Value;
        boolean UsedUpper = false;
        boolean UsedLower = false;
        boolean UsedNumber = false;
        boolean UsedSymbol = false;
        int type;
        int Score = 0;


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            type = CharType(c);

            if (type == 1) UsedUpper = true;
            if (type == 2) UsedLower = true;
            if (type == 3) UsedNumber = true;
            if (type == 4) UsedSymbol = true;
        }

        if (UsedUpper) Score += 1;
        if (UsedLower) Score += 1;
        if (UsedNumber) Score += 1;
        if (UsedSymbol) Score += 1;

        if (s.length() >= 8) Score += 1;
        if (s.length() >= 16) Score += 1;

        //we return score that is increased by password's character
        //types.
        return Score;
    }

    //Prev. func. gives us the score. With this score we return messages.
    public String calculateScore() {
        int Score = this.PasswordStrength();

        if (Score == 6) {
            return "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
        } else if (Score >= 4) {
            return "This is a good password :) but you can still do better";
        } else if (Score >= 3) {
            return "This is a medium password :/ try making it better";
        } else {
            return "This is a weak password :( definitely find a new one";
        }
    }
}
