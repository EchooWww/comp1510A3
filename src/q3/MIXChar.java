package q3;

/**
 * Represents a single MIXChar character in the MIX computer table.
 * @author echo
 * @version 1.0
 */
public class MIXChar {
    
    /**
     * The MIX computer table.
     */
    public static final char[] MIXCOMPUTER = {' ', 'A', 'B', 'C', 'D', 'E', 
        'F', 'G', 'H', 'I', 'Δ', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
        'Σ', 'Π', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3',
        '4', '5', '6', '7', '8', '9', '.', ',', '(', ')', '+', '-', '*', '/',
        '=', '$', '<', '>', '@', ';', ':', '\''};
            
    /**
     * The char of MIXChar.
     */
    private char mChar;
    
    /**
     * The ordinal of MIXChar.
     */
    private int ordinal;
    
    /**
     * Constructs a MIXChar object.
     * @param c the character to be converted
     * @throws Exception if the conversion is not possible
     */
    public MIXChar(char c) {
        if (!isMIXChar(c)) {
            throw new ClassCastException("Invalid MIXChar");
        }
        mChar = c;
        for (int i = 0; i < MIXCOMPUTER.length; i++) {
            if (c == MIXCOMPUTER[i]) {
                ordinal = i;
                break;
            }
        }
    }
    
    /**
     * Returns true if c corresponds to a MIXChar character, false otherwise.
     * @param c the character to be checked
     * @return true or false according to whether it's a MIXChar character
     */
    static boolean isMIXChar(char c) {
        boolean isMIXChar = false;
        final int fiftySix = 56;
        for (int i = 0; i < fiftySix; i++) {
            if (MIXCOMPUTER[i] == c) {
                isMIXChar = true;
                break;
            }
        }
        return isMIXChar;
    }
    
    /**
     * Converts the MIXChar character to corresponding Java Char.
     * @return the Java char
     */
    public char toChar() {
        return mChar;
    }
    
    /**
     * returns String with characters 
     * corresponding to thos of the input array.
     * @param mixchars an array of MIXChar
     * @return the string concatenated by the MIXChars
     */
    static String toString(MIXChar[] mixchars) {
        String s1 = "";
        for (MIXChar mixchar:mixchars) {
            s1 += mixchar;
        }
        return s1;
    }
    
    /**
     * Returns array of MIXChar characters in string s.
     * @param s the string to be converted
     * @return the array of MIXChars
     */
    public static MIXChar[] toMIXChar(String s) {
        MIXChar[] mixChars = new MIXChar[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!isMIXChar(c)) {
                throw new ClassCastException(
                        "Invalid MIXChar character in input string"); 
            }
            try {
                mixChars[i] = new MIXChar(c);
            } catch (ClassCastException e) {
                System.out.println("Invalid MIXChar character in input string");
            }
        }
        return mixChars;
    }



    
    /**
     * returns numerical value of the MIXChar.
     * @return int as the ordinal of the MIXChar
     */
    int ordinal() {
        return ordinal;
    }
    
    /**
     * Returns string containing this MIXChar as a Java char.
     * @return string
     */
    public String toString() {
        return mChar + "";
    }

}
