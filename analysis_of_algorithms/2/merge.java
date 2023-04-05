package lab2alg;
import java.util.Arrays;
import java.util.Random;

public class merge
{
	public static void main(String [] args)
	{
		int array_size = 1048576;
		int [] array = new int[array_size];
		long start_time, end_time, elapsed_time, elapsed_time_insertion, elapsed_time_merge;

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		for (int i = 0; i < array_size; i++)
			array[i] = rand.nextInt(100);
	
		//part 2(b) 
//		print_array(array);
//		long startTime = System.nanoTime();
//		merge_sort(array, 0, 15);
//		long endTime = System.nanoTime();
//		System.out.printf("merge sort took - " + (endTime - startTime) + " nanoseconds");
//		System.out.println();
//		print_array(array);
//		System.out.println();

		//part 3(a)	
		
//		long startTime = System.nanoTime();
//		merge_sort(array, 0, 1048575);
//		long endTime = System.nanoTime();
//		System.out.printf("merge sort took - " + (endTime - startTime) + " nanoseconds");
//		//print_array(array);
//		System.out.println();
		
		long startTime1 = System.nanoTime();
		insertion_sort(array);
		long endTime1 = System.nanoTime();
		System.out.printf("insertion sort took - " + (endTime1 - startTime1) + " nanoseconds");
		//print_array(array);
		System.out.println();

		//part 3(b)
		
		

	}

	//indices p and r can start from 0
	public static void merge_sort(int [] A, int p, int r)
	{

		if (p < r) {
			int q = (p + r) / 2;  // don't need floor b/c of integer div.
			merge_sort(A, p, q);
			merge_sort(A, q+1, r);
			merge(A, p, q, r);
		}
		
	}

	//Part 2(a)
	public static void merge(int [] A, int p, int q, int r)
	{
		
		int n1 = q - p + 1;
		int n2 = r - q;
		
		// in real merge sort these would be a single array with size equal to A
		// but this is the Cormen et. al implementation, so yeah.
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for (int i = 0; i < n1; i++) {
			L[i] = A[p + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = A[q + 1 + j];
		}
		
		int i = 0;
		int j = 0;
		int k = p;
		// without sentinels, need to do multiple passes
		while(i < L.length && j < R.length) {
			if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
				k++;
			} else {
				A[k] = R[j];
				j++;
				k++;
			}
		}
		// only one of these will get called
		for (int ii = i; ii < L.length; ii++) {
			A[k] = L[ii];
			k++;
		}
		for (int jj = j; jj < R.length; jj++) {
			A[k] = R[jj];
			k++;
		}

	}	

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

