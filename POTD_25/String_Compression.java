//https://leetcode.com/problems/string-compression/

import java.util.*;

public class String_Compression {
    public int compress(char[] chars) {
        int index=0;
        int start=0;
        while(start<chars.length){
            int end=start;
            while(end<chars.length && chars[start]==chars[end]){
                end++;
            }
            int count = end - start;
            chars[index++]=chars[start];
            if(count>=2){
                char []freq = Integer.toString(count).toCharArray();
                for(char ch:freq){
                    chars[index++]=ch;
                }
            }
            start=end;
        }
        return index;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        scanner.close();
        
        char[] chars = input.toCharArray();
        String_Compression obj = new String_Compression();
        int newLength = obj.compress(chars);

        System.out.println("Compressed String: " + new String(chars, 0, newLength));
        System.out.println("New Length: " + newLength);
    }
}
