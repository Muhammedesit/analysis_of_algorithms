import java.util.Arrays;
import java.util.Random;

public class selection
{
	public static void main(String [] args)
	{
		int array_size = 10;
		int n_repetitions = 1000;

		int array [] = new int[array_size];

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		//part(b) choosing one integer array and showing that the sort method works

		//initialize elements of array with random integers
		for (int i = 0; i < array.length; i++)
			array[i] = rand.nextInt(100);

		print_array(array);
		
		///////////////
		long startTime = System.nanoTime();
		selection_sort(array);
		long endTime = System.nanoTime();
		System.out.printf("selection sort took - " + (endTime - startTime) + " milliseconds");
		System.out.println();
		//////////////
		
		print_array(array);

		//part(c) min, average, max running times

		statistics(1000, 1000);
                statistics(10000, 1000);
	}

	//part(a) implementing selection sort algorithm as a method below
	public static void selection_sort(int [] A)
	{
////////////////////////////////////
		
		//long startTime = System.nanoTime();
		int n = A.length;

		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++)
				if (A[j] < A[min])
					min = j;
			double temp = A[i];
			A[i] = A[min];
			A[min] = (int) temp;
		}
		//long endTime = System.nanoTime();
		//System.out.printf("selection sort took - " + (endTime - startTime) + " milliseconds");
		//System.out.println();
		
//////////////////////////////////
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

	//part (c) compute min, average, max times for repeatedly sorting random arrays
	public static void statistics(int array_size, int n_repetitions)
	{
                long min_time, max_time, sum_time;
                double average_time;

                int array [] = new int[array_size];

                Random rand = new Random();
                rand.setSeed(System.currentTimeMillis());

                min_time = 0;
                max_time = 0;
                average_time = 0.0;
                sum_time = 0;

                for (int k = 0; k < n_repetitions; k++)
                {       
                        //initialize elements of array with random integers
                        
                        //call selection sort method
                	 long startTime = System.nanoTime();
                 	selection_sort(array);
                 	long endTime = System.nanoTime();
                 	
long elapsed = endTime - startTime;
            		
            		if (elapsed>max_time) {
            			max_time = elapsed;
            		}else {
            			min_time=elapsed;
            		}
            		sum_time += elapsed;
            		
            		double sum=0;
            		 sum += (double) (endTime - startTime);
            		 sum_time+=(long) sum;

			//compute min_time, max_time, sum_time

                }

                average_time = (double) sum_time / (double) n_repetitions;

                System.out.printf("Min time: %d\n", min_time);
                System.out.printf("Average time: %.2f\n", average_time);
                System.out.printf("Max time: %d\n", max_time);

	}

}

