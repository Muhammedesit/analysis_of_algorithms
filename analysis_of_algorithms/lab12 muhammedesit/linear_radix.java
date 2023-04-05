package lab12alg;

import java.util.Arrays;
import java.util.Random;

public class linear_radix
{
	public static void main(String [] args)
	{
		int array_size = 10;
		int [] array = new int[array_size];
		int [] array1 = new int[array_size];
		int [] array2 = new int[array_size];
		int [] array3 = new int[array_size];
		long start_time, end_time, elapsed_time, elapsed_time_insertion, elapsed_time_merge;

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		// b part
		
		for (int i = 0; i < array_size; i++)
			array[i] = rand.nextInt(89)+10;

		print_array(array);
		
		radix_sort(array, array_size);
		print_array(array);
		
		for(int j = 0; j < 7; j++) {
		
			 array = new int[array_size];
			  array1 = new int[array_size];
			  array2 = new int[array_size];
			 array3 = new int[array_size];

			//c part
		for (int i = 0; i < array_size; i++) {
			array[i] = rand.nextInt(899)+100;
			array1[i]=array[i];
			array2[i]=array[i];
			array3[i]=array[i];
		}
		
		start_time = System.nanoTime();
		heap_sort(array);
		end_time = System.nanoTime();
		elapsed_time = end_time - start_time;
                System.out.printf("(array size: %d) Elapsed time in nanoseconds for heap sort: %d\n", array_size, elapsed_time);

                start_time = System.nanoTime();
                merge_sort(array1, 0, array_size-1);
                end_time = System.nanoTime();
                elapsed_time = end_time - start_time;
                System.out.printf("(array size: %d) Elapsed time in nanoseconds for merge sort: %d\n",array_size, elapsed_time);
                
                start_time = System.nanoTime();
                radix_sort(array2, array_size);
                end_time = System.nanoTime();
                elapsed_time = end_time - start_time;
                System.out.printf("(array size: %d) Elapsed time in nanoseconds for radix sort: %d\n", array_size,elapsed_time);
                
                start_time = System.nanoTime();
                countSort(array3, array_size, array_size);
                end_time = System.nanoTime();
                elapsed_time = end_time - start_time;
                System.out.printf("(array size: %d) Elapsed time in nanoseconds for counting sort: %d\n", array_size,elapsed_time);
                
                array_size=array_size*10;
		}
		
		// d part
		array_size=100000000;
		array = new int[array_size];
		  array1 = new int[array_size];
		  array2 = new int[array_size];
		 array3 = new int[array_size];
		
		for (int i = 0; i < array_size; i++) {
			array[i] = rand.nextInt(899)+100;
			array1[i]=array[i];
			array2[i]=array[i];
			array3[i]=array[i];
		}
//		heap_sort(array);
//		merge_sort(array1, 0, array_size-1);
//		radix_sort(array2, array_size);
		countSort(array3, array_size, array_size);
	}
////////////////////////////////////
	
	// a part
	public static int getMax(int arr[], int n)
	    {
	        int mx = arr[0];
	        for (int i = 1; i < n; i++)
	            if (arr[i] > mx)
	                mx = arr[i];
	        return mx;
	    }
	  
	  public static void countSort(int arr[], int n, int exp)
	    {
	        int output[] = new int[n]; // output array
	        int i;
	        int count[] = new int[10];
	        Arrays.fill(count, 0);
	  
	         for (i = 0; i < n; i++)
	            count[(arr[i] / exp) % 10]++;
	  
	         for (i = 1; i < 10; i++)
	            count[i] += count[i - 1];
	  
	        for (i = n - 1; i >= 0; i--) {
	            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
	            count[(arr[i] / exp) % 10]--;
	        }
	  
	        for (i = 0; i < n; i++)
	            arr[i] = output[i];
	    }
	  //Implement radix sort algorithm below
	    public static void radix_sort(int arr[], int n)
	    {
	        // Find the maximum number to know number of digits
	        int m = getMax(arr, n);
	  
	         for (int exp = 1; m / exp > 0; exp *= 10)
	            countSort(arr, n, exp);
	    }	
////////////////////////////////////
	
	
	
	//assumes that index i starts from 1
	public static int parent(int i)
	{
		return (int)Math.floor(i/2);
	}

        //assumes that index i starts from 1
	public static int left(int i)
	{
		return 2*i;
	}

        //assumes that index i starts from 1
	public static int right(int i)
	{
		return (2*i+1);
	}

        //assumes that index i starts from 1
	public static void max_heapify(int [] A, int array_size, int i)
	{
		int left_index, right_index, index_of_largest;
		int temp;

		left_index = left(i);
                right_index = right(i);

		if ((left_index <= array_size) && (A[left_index-1] > A[i-1]))
			index_of_largest = left_index;
		else
			index_of_largest = i;

		if ((right_index <= array_size) && (A[right_index-1] > A[index_of_largest-1]))
			index_of_largest = right_index;

		if (index_of_largest != i)
		{
			temp = A[i-1];
			A[i-1] = A[index_of_largest-1];
			A[index_of_largest-1] = temp;
			max_heapify(A, array_size, index_of_largest);
		}
	}

	public static void build_max_heap(int [] A)
	{
		int middle_index = (int)Math.floor(A.length/2);
		int array_size = A.length;

		for (int i = middle_index; i >= 1; i--)
			max_heapify(A, array_size, i);
	}

	public static void heap_sort(int [] A)
	{
		int temp;
		int array_size = A.length;
		build_max_heap(A);
		
		for (int i = A.length; i >= 2; i--)
		{
			temp = A[0];
			A[0] = A[i-1];
			A[i-1] = temp;
			array_size--;
			max_heapify(A, array_size, 1);
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

