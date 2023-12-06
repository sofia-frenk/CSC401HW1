import java.util.*;
import java.lang.Math;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Enter an input string: ");
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        int[] inputArray = new int[input.length()];
        int individualChar;
        for (int i=0; i<input.length(); i++)
        {
            individualChar = input.charAt(i);
            if(individualChar!=',')
                inputArray[i] = Character.getNumericValue(individualChar);
        }
        inputArray = CleanArray(inputArray);

        int[] outputArray = RandomizeInPlace(inputArray);
        String printOut = printArray(outputArray);
        System.out.println(printOut);
    }

    public static String printArray(int[] randomizedArray)
    {
        //int[] printArray = new int[randomizedArray.length];
        String printOut = "";
        for (int j=0; j<randomizedArray.length; j++)
        {
            if (j< randomizedArray.length-1)
                printOut += randomizedArray[j] +",";
            else
                printOut += randomizedArray[j];
        }
        printOut += "\n";
        return printOut;
    }

    static int[] CleanArray(int[] intArray)
    {
        int targetIndex = 0;
        //int intLength = intArray.length;
        int[] newArray = new int[intArray.length/2 +1];
        for( int sourceIndex = 0;  sourceIndex < intArray.length;  sourceIndex++ )
            if( intArray[sourceIndex] != 0 )
                newArray[targetIndex++] = intArray[sourceIndex];
        //System.arraycopy( intArray, 0, newArray, 0, targetIndex );
        return newArray;
    }

    //RANDOMIZE-IN-PLACE(A)
    //1. n=A.length
    //2. for i = 1 to n
    //3. swap A[i] with A[Random(i,n)]
    //    Input: An array of numbers.
    //    Output: Random permutation of the array.
    //    The auxiliary function in the pseudocode Random(i,n) returns a random
    //    integer between i and n.

    public static int[] RandomizeInPlace(int[] inputArray)
    {
        int i, temp, randomInteger, regularInteger, randomIndex;
        int arrayLength = inputArray.length;
        //int[] randomizedArray = new int[arrayLength];
        for(i=0; i<arrayLength; i++)
        {
            randomIndex=Random(i, (arrayLength-1));
            regularInteger = inputArray[i];
            randomInteger = inputArray[randomIndex];
            temp=regularInteger;
            inputArray[i]= randomInteger;
            inputArray[randomIndex]=temp;
        }
        return inputArray;
    }

    public static int Random(int startValue, int endValue)
    {
        int range = (endValue-startValue)+1;
        int randomInteger = (int)(Math.random() * range)+startValue;
        return randomInteger;
    }
}
