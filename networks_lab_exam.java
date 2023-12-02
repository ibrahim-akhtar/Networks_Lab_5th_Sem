/*
 * Question:
 * Using transposition cipher, if the following text is recieved to the destination,
 * find the original message and key recovered at the reciever end.
 * HSMELSMX$TAEGPISLAMHIPSAIIEEE
 * 
 * (Answer: This is a simple message)
 */

import java.io.*;

public class networks_lab_exam {

    public static void main(String[] args) {
        String text = "HSMELSMXTAEGPISLAMHIPSAIIEEEE";
        /*int index;
        for (int i = 0; i < text.length(); i++)
        {
            if (text.charAt(i) == '$')
            {
                index = i;
            }
        }*/

        //text = text.substring(0, index) + text.substring(index+1);
        

        text = text.replaceAll("$", "");
        decrypt(text);
    }

    private static void decrypt(String text) {
        System.out.println("Original Message:");

        for (int columns = 2; columns < text.length()/2; columns++) {
            System.out.println("Key = " + columns + ": " + decryptWithColumns(text, columns));
        }
    }

    private static String decryptWithColumns(String text, int columns) {
        //int rows = (int) Math.ceil((double) text.length() / columns);
        int rows = text.length() / columns + (text.length() % columns != 0 ? 1 : 0);
        //System.out.println(rows + " - " + r);

        char[][] matrix = new char[rows][columns];

        int index = 0;
        StringBuilder decryptedMessage = new StringBuilder();
        
        //i = col & j = row
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (index < text.length()) {
                    matrix[j][i] = text.charAt(index++);
                }
            }
        }

        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < columns; i++) {
                decryptedMessage.append(matrix[j][i]);
            }
        }

        return decryptedMessage.toString();
    }
}