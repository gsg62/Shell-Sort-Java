
package shellsort;

/**
 * class for shell sort
 * @author ggear
 */
public class ShellSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create and load sample array
        int[] testArray;
        int numValues = 25, lowLimit = 10, highLimit = 99;
        String resultString;                    
        testArray = loadRands( numValues, lowLimit, highLimit );
        resultString = arrayToString( testArray, numValues );
        
        // test shell sort
        System.out.println( "\nArray before Shell's Sort: " + resultString );
        runShellSort( testArray, numValues );
        resultString = arrayToString( testArray, numValues );
        System.out.println( "Array after Shell's Sort: " + resultString );        

    }
    
    /**
     * Uses Shell's sorting algorithm to sort an array of integers
     * <p>
     * Shell's sorting algorithm is an optimized insertion algorithm
     * 
     * @param localArray integer array holding unsorted values
     * 
     * @param size integer number of items in array
     */
    public static void runShellSort( int[] localArray, int size )
       {
        int gap, gapPassIndex, insertionIndex, temp;
    
        for( gap = size / 2; gap > 0; gap /= 2 )
           {
            for( gapPassIndex = gap; gapPassIndex < size; gapPassIndex++ )
               {
                temp = localArray[ gapPassIndex ];

               for( insertionIndex = gapPassIndex; insertionIndex >= gap && localArray[ insertionIndex - gap] > temp; insertionIndex -= gap )
                  {
                   localArray[ insertionIndex ] = localArray[ insertionIndex - gap ];
                  }

               localArray[ insertionIndex ] = temp;                 
              }
           }    
       }
    /**
     * Method to load a given integer array with random values
     * 
     * @param numRands integer identifies number of values to generate
     * 
     * @param lowLimit integer identifies low limit of generated randoms
     * 
     * @param highLimit integer identifies high limit of generated randoms
     * 
     * @return integer array with data loaded
     */
    public static int[] loadRands( int numRands, int lowLimit, int highLimit )
       {
        int index;
        int[] localArray = new int[ numRands ];
       
        for( index = 0; index < numRands; index++ )
           {
            localArray[ index ] = generateRandBetween( lowLimit, highLimit );
           }

        return localArray;
       }

    /**
     * Generate random value between the lowest and highest
     * specified limits inclusive
     * 
     * @param lowLimit specified integer low limit of random value range
     * 
     * @param highLimit specified integer high limit of random value range
     * 
     * @return random integer value generated between the inclusive limits
     */
    public static int generateRandBetween( int lowLimit, int highLimit )
       {
        int randVal, range;
       
        if( highLimit > lowLimit )
           {
            // create range of numbers
            range = highLimit - lowLimit + 1;
           
            // find random integer value from value between 0 and 1
            randVal = (int)( Math.random() * 1000000 );
           
            return randVal % range + lowLimit;
           }
       
        return 0;
       }

    /**
     * Converts array of integers into string for output or display
     * 
     * @param localArray integer array of values
     * 
     * @param size number of values in the array
     * 
     * @return String holding a list of all values, comma-delimited
     */
    public static String arrayToString( int[] localArray, int size )
       {
        int index;
        String outString ="";
        
        for( index = 0; index < size; index++ )
           {
            if( index > 0 )
               {
                outString += ", ";
               }
            
            outString += localArray[ index ];
           }
        
        return outString;
       }
    
    /**
     * Swaps values within given array
     * 
     * @param localArray array of Objects used for swapping
     * 
     * @param indexOne integer partIndex for one of the two items to be swapped
     * 
     * @param indexOther integer partIndex for the other of the two items 
 to be swapped
     */
    public static void swapValues( int[] localArray, int indexOne, int indexOther )
       {
        int temp = localArray[ indexOne ];
        
        localArray[ indexOne ] = localArray[ indexOther ];
        
        localArray[ indexOther ] = temp;        
       }           
}

