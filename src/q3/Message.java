package q3;

/**
 * The Message class represents a packed string of MIXChars.
 * @author echo
 * @version 1.0
 *
 */
public class Message {
    
    /**
     * The long array stores messages.
     */
    private long[] msgInLong;
    
    /**
     * The count of characters in the message object.
     */
    private int count;

    /**
     * Contructs a Message Object with a MIXChar array.
     * @param m the MIXChar array
     */
    public Message(MIXChar[] m) {
        count = m.length;
        final int eleven = 11;
        final int fiftySix = 56;
        int numMessages = (count + eleven - 1) / eleven;
        this.msgInLong = new long[numMessages];
        for (int i = 0, j = 0; i < count; i += eleven, j++) {
            int end = Math.min(count, i + eleven);
            long sum = 0L;
            for (int p = i; p < end; p++) {
                sum = sum * fiftySix + m[p].ordinal();
            }
            this.msgInLong[j] = sum;
        } 
    }

    /**
     * Constructs a Message Objecet with a string.
     * @param s the string 
     */
    public Message(String s) {
        count = s.length();
        try {
            MIXChar[] m = MIXChar.toMIXChar(s);
            final int eleven = 11;
            final int fiftySix = 56;
            int numMessages = (count + eleven - 1) / eleven;
            this.msgInLong = new long[numMessages];
            for (int i = 0, j = 0; i < count; i += eleven, j++) {
                int end = Math.min(count, i + eleven);
                long sum = 0L;
                for (int p = i; p < end; p++) {
                    sum = sum * fiftySix + m[p].ordinal();
                }
                this.msgInLong[j] = sum;
            } 
        } catch (ClassCastException e) {
            System.out.println("Invalid MIXChar character in input string");
        }
        
    }
    
    /**
     * Returns a string corresponding to the characters in the message.
     * @return String the string of message 
     */
    public String toString() {
        final long fiftySix = 56L;
        String complete = "";
        String original = ""; 
        
        for (int i = 0; i < this.msgInLong.length; i++) {
            String reverse = "";
            
            for (Long li = this.msgInLong[i]; li != 0; 
                    li = Long.divideUnsigned(li, fiftySix)) {
                int remainder = (int) Long.remainderUnsigned(li, fiftySix);
                char charatI = MIXChar.MIXCOMPUTER[remainder];
                reverse = reverse.concat(String.valueOf(charatI));
            }
            
            StringBuilder sb = new StringBuilder(reverse);
            sb.reverse();
            original = sb.toString();
            complete += original;
        }
        
        return complete;
    }
    
    /**
     * Returns a string of unsigned integers seperated by spaces.
     * @return String the string of message 
     */
    public String toLongs() {
        String s1 = "";
        for (int i = 0; i < msgInLong.length; i++) {
            s1 += Long.toUnsignedString(msgInLong[i]) + " ";
        }
        return s1;
    }
    
    
}
