package lab8alg;

import java.util.Arrays;
import java.util.Random;

public class heap
{
	public static void main(String [] args)
	{
		int array_size = 67108864;
		int [] array = new int[array_size];
		long start_time, end_time, elapsed_time, elapsed_time_insertion, elapsed_time_merge;

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		for (int i = 0; i < array_size; i++)
			array[i] = rand.nextInt(100);
		
		// I put part b and c for calculate part d and e
		
		//part 1(b)
//		System.out.println("random array");
//		print_array(array);
//		heap_sort(array);
//		System.out.println("Part1(b) sorted array with heap sort");
//		print_array(array);
	
		//part 3(a)	
//		array_size = 4;
//		while(true) {
//			
//			
//		int [] array_2 = new int[array_size]; //will be used for insertion sort
//                int [] array_3 = new int[array_size]; //will be used for merge sort
//		
//		for (int i = 0; i < array_size; i++)
//		{
//                        array_2[i] = rand.nextInt(100);
//			array_3[i] = array_2[i]; //make a copy of array_2 
//		}
//
//		start_time = System.nanoTime();
//		merge_sort(array_3, 0, array_size-1);
//		end_time = System.nanoTime();
//		elapsed_time = end_time - start_time;
//                System.out.printf("Elapsed time in nanoseconds for merge sort when %d integers are sorted: %d\n",array_size, elapsed_time);
//                
//                start_time = System.nanoTime();
//        		heap_sort(array_2);
//        		end_time = System.nanoTime();
//        		elapsed_time = end_time - start_time;
//                        System.out.printf("Elapsed time in nanoseconds for heap sort when %d integers are sorted: %d\n",array_size, elapsed_time);
//                
//                array_size=array_size*4;
//                
//                if(array_size==67108864)
//                	break;
//                
//                
//		}
		
		//part 1(d)
		
	//	merge_sort(array, 0, array_size-1);
		heap_sort(array);
	}
	
	


	//Implement heap sort algorithm below
	public static void heap_sort(int arr[]) {
		int N = arr.length;

		// Build heap (rearrange array)
		for (int i = N / 2 - 1; i >= 0; i--)
			heapify(arr, N, i);

		// One by one extract an element from heap
		for (int i = N - 1; i > 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	public static void heapify(int arr[], int N, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < N && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < N && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, N, largest);
		}
	}

	//indices p and r can start from 0
	public static void merge_sort(int [] A, int p, int r)
	{
		int q;

		if (p < r)
		{
			q = (int)Math.floor((p+r)/2);
			merge_sort(A, p, q);
			merge_sort(A, q+1, r);
			merge(A, p, q, r);
		}
	}

	//Part 2(a)
	public static void merge(int [] A, int p, int q, int r)
	{
		int n1, n2;
		int i, j;

		n1 = q-p+1;
		n2 = r-q;

		int [] L = new int[n1];
		int [] R = new int[n2];

		for (i = 0; i < n1; i++)
			L[i] = A[p+i];

                for (i = 0; i < n2; i++)
                        R[i] = A[q+i+1];		

		i = 0;
		j = 0;
		
		for (int k=p; k <= r; k++)
		{
			if (i >= n1) //the left array finished, copy from right array
			{
				A[k] = R[j];
				j++;
				continue;
			}
			
			if (j >= n2) //the right array finished, copy from left array
			{
				A[k] = L[i];
				i++;
				continue;
			}
	
			if (L[i] <= R[j])
			{
				A[k] = L[i];
				i++;
			}
			else
			{
				A[k] = R[j];
				j++;
			}
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

