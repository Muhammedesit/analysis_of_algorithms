package lab2alg;
import java.util.Arrays;
import java.util.Random;

public class insertion
{
	public static void main(String [] args)
	{
		int array_size = 100000;
		long start_time, end_time, elapsed_time;

		int array [] = new int[array_size];

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		//initialize elements of array with random integers
		for (int i = 0; i < array.length; i++)
			array[i] = rand.nextInt(100);
		
		//print_array(array);

		long startTime = System.nanoTime();
		insertion_sort(array);
		long endTime = System.nanoTime();
		System.out.printf("insertion sort took - " + (endTime - startTime) + " nanoseconds");
		//print_array(array);
		System.out.println();
		
		long startTime2 = System.nanoTime();
		insertion_sort(array);
		long endTime2 = System.nanoTime();
		System.out.printf("insertion sort took (best case)- " + (endTime2 - startTime2) + " nanoseconds");
		//print_array(array);
		System.out.println();
		
		
		insertion_sort_reverse(array);
		
		
		long startTime1 = System.nanoTime();
		insertion_sort(array);
		long endTime1 = System.nanoTime();
		System.out.printf("insertion sort took (worst case) - " + (endTime1 - startTime1) + " nanoseconds");
		//print_array(array);
		System.out.println();
		
		
	}

        //part 1(a) implementing insertion sort algorithm as a method below
        public static void insertion_sort(int [] A)
        {
        	for (int j = 1; j < A.length; j++) {
    			int current = A[j];
    			int i = j - 1;
    			while ((i > -1) && (A[i] > current)) {
    				A[i + 1] = A[i];
    				--i;
    			}
    			A[i + 1] = current;
    		}
        }

        //part 1(b) implementing insertion sort algorithm that sorts in descending order as a method below
        public static void insertion_sort_reverse(int [] A)
        {
        	for (int j = 1; j < A.length; j++) {
    			int current = A[j];
    			int i = j - 1;
    			while ((i > -1) && (A[i] < current)) {
    				A[i + 1] = A[i];
    				--i;
    			}
    			A[i + 1] = current;
    		}
        }

	//prints the elements of the array A on the screen
	public static void print_array(int [] A)
	{
		System.out.printf("[");
		for (int i = 0; i < A.length-1; i++)
		{
			System.out.printf("%d, ", A[i]);
		}
		
		System.out.printf("%d]\n", A[A.length-1]);

	}
}

