package lab9alg;

import java.util.Arrays;
import java.util.Random;

public class permute
{
	public static void main(String [] args)
	{
		int array_size = 4;
		int [] array = new int[array_size];
		int [] frequency_array = new int[24];
		int permutation_index = 0;

		Random rand = new Random();

		
		
		int array_size1 = 10;
		int[] array_2 = new int[array_size1];
		int[] array_3 = new int[array_size1];
		
		for (int i = 0; i < array_size1; i++) {
			array_2[i] = rand.nextInt(100);
			array_3[i] = array_2[i]; // make a copy of array_2
		}
		System.out.println("array:");
		print_array(array_2);

		for(int i=1;i<6;i++) {
			
			insertion_sort(array_2);
			randomizeInPlace(array_2);
			System.out.println("randomize sample"+i+":");
			print_array(array_2);
		}
		
		for(int i=1;i<6;i++) {
			insertion_sort(array_3);
			permuteWithAll(array_3);
			System.out.println("permute sample"+i+":");
			print_array(array_3);
		}
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		array[3] = 4;
		
		//3(a)-(b) short way
		
		for (int i = 0; i < 24000; i++) {
			insertion_sort(array);
			randomizeInPlace(array);
			permutation_index = compute_permutation_index(array);
			frequency_array[permutation_index]++;
				
		}
		for(int i=0;i<24;i++) {
			
			System.out.println(frequency_array[i]);
		}
		
		System.out.println("***********************");
		
for(int i=0;i<24;i++) {
			
		frequency_array[i]=0;
		}
		
		
		for (int i = 0; i < 24000; i++) {
			insertion_sort(array);
			permuteWithAll(array);
			permutation_index = compute_permutation_index(array);
			frequency_array[permutation_index]++;
				
		}
		for(int i=0;i<24;i++) {
			
			System.out.println(frequency_array[i]);
		}
		
		//3(a)-(b) long way
//		int n0 = 0, n1 = 0, n2 = 0, n3 = 0, n4 = 0, n5 = 0, n6 = 0, n7 = 0, n8 = 0, n9 = 0, n10 = 0, n11 = 0, n12 = 0, n13 = 0, n14 = 0, n15 = 0, n16 = 0, n17 = 0, n18 = 0, n19 = 0, n20 = 0, n21 = 0, n22 = 0, n23 = 0;
//
//		for (int i = 0; i < 24000; i++) {
//			insertion_sort(array);
//			randomizeInPlace(array);
//
//			if (array[0] == 1 && array[1] == 2 && array[2] == 3 && array[3] == 4)
//				n0++;
//			if (array[0] == 1 && array[1] == 2 && array[2] == 4 && array[3] == 3)
//				n1++;
//			if (array[0] == 1 && array[1] == 3 && array[2] == 2 && array[3] == 4)
//				n2++;
//			if (array[0] == 1 && array[1] == 3 && array[2] == 4 && array[3] == 2)
//				n3++;
//			if (array[0] == 1 && array[1] == 4 && array[2] == 2 && array[3] == 3)
//				n4++;
//			if (array[0] == 1 && array[1] == 4 && array[2] == 3 && array[3] == 2)
//				n5++;
//			if (array[0] == 2 && array[1] == 1 && array[2] == 3 && array[3] == 4)
//				n6++;
//			if (array[0] == 2 && array[1] == 1 && array[2] == 4 && array[3] == 3)
//				n7++;
//			if (array[0] == 2 && array[1] == 3 && array[2] == 1 && array[3] == 4)
//				n8++;
//			if (array[0] == 2 && array[1] == 3 && array[2] == 4 && array[3] == 1)
//				n9++;
//			if (array[0] == 2 && array[1] == 4 && array[2] == 1 && array[3] == 3)
//				n10++;
//			if (array[0] == 2 && array[1] == 4 && array[2] == 3 && array[3] == 1)
//				n11++;
//			if (array[0] == 3 && array[1] == 1 && array[2] == 2 && array[3] == 4)
//				n12++;
//			if (array[0] == 3 && array[1] == 1 && array[2] == 4 && array[3] == 2)
//				n13++;
//			if (array[0] == 3 && array[1] == 2 && array[2] == 1 && array[3] == 4)
//				n14++;
//			if (array[0] == 3 && array[1] == 2 && array[2] == 4 && array[3] == 1)
//				n15++;
//			if (array[0] == 3 && array[1] == 4 && array[2] == 1 && array[3] == 2)
//				n16++;
//			if (array[0] == 3 && array[1] == 4 && array[2] == 2 && array[3] == 1)
//				n17++;
//			if (array[0] == 4 && array[1] == 1 && array[2] == 2 && array[3] == 3)
//				n18++;
//			if (array[0] == 4 && array[1] == 1 && array[2] == 3 && array[3] == 2)
//				n19++;
//			if (array[0] == 4 && array[1] == 2 && array[2] == 1 && array[3] == 3)
//				n20++;
//			if (array[0] == 4 && array[1] == 2 && array[2] == 3 && array[3] == 1)
//				n21++;
//			if (array[0] == 4 && array[1] == 3 && array[2] == 1 && array[3] == 2)
//				n22++;
//			if (array[0] == 4 && array[1] == 3 && array[2] == 2 && array[3] == 1)
//				n23++;
//
//		}
//
//		System.out.println(n0);
//		System.out.println(n1);
//		System.out.println(n2);
//		System.out.println(n3);
//		System.out.println(n4);
//		System.out.println(n5);
//		System.out.println(n6);
//		System.out.println(n7);
//		System.out.println(n8);
//		System.out.println(n9);
//		System.out.println(n10);
//		System.out.println(n11);
//		System.out.println(n12);
//		System.out.println(n13);
//		System.out.println(n14);
//		System.out.println(n15);
//		System.out.println(n16);
//		System.out.println(n17);
//		System.out.println(n18);
//		System.out.println(n19);
//		System.out.println(n20);
//		System.out.println(n21);
//		System.out.println(n22);
//		System.out.println(n23);
//
//		System.out.println("********************************************************");
//		n0 = 0; n1 = 0; n2 = 0; n3 = 0; n4 = 0; n5 = 0; n6 = 0; n7 = 0; n8 = 0; n9 =0; n10 = 0; n11 = 0; n12 = 0; n13 = 0; n14 = 0; n15 = 0; n16 = 0; n17 = 0; n18 = 0; n19 = 0; n20 = 0; n21 = 0; n22 = 0; n23 = 0;
//		
//		for (int i = 0; i < 24000; i++) {
//			insertion_sort(array);
//			
//			permuteWithAll(array);
//
//			if (array[0] == 1 && array[1] == 2 && array[2] == 3 && array[3] == 4)
//				n0++;
//			if (array[0] == 1 && array[1] == 2 && array[2] == 4 && array[3] == 3)
//				n1++;
//			if (array[0] == 1 && array[1] == 3 && array[2] == 2 && array[3] == 4)
//				n2++;
//			if (array[0] == 1 && array[1] == 3 && array[2] == 4 && array[3] == 2)
//				n3++;
//			if (array[0] == 1 && array[1] == 4 && array[2] == 2 && array[3] == 3)
//				n4++;
//			if (array[0] == 1 && array[1] == 4 && array[2] == 3 && array[3] == 2)
//				n5++;
//			if (array[0] == 2 && array[1] == 1 && array[2] == 3 && array[3] == 4)
//				n6++;
//			if (array[0] == 2 && array[1] == 1 && array[2] == 4 && array[3] == 3)
//				n7++;
//			if (array[0] == 2 && array[1] == 3 && array[2] == 1 && array[3] == 4)
//				n8++;
//			if (array[0] == 2 && array[1] == 3 && array[2] == 4 && array[3] == 1)
//				n9++;
//			if (array[0] == 2 && array[1] == 4 && array[2] == 1 && array[3] == 3)
//				n10++;
//			if (array[0] == 2 && array[1] == 4 && array[2] == 3 && array[3] == 1)
//				n11++;
//			if (array[0] == 3 && array[1] == 1 && array[2] == 2 && array[3] == 4)
//				n12++;
//			if (array[0] == 3 && array[1] == 1 && array[2] == 4 && array[3] == 2)
//				n13++;
//			if (array[0] == 3 && array[1] == 2 && array[2] == 1 && array[3] == 4)
//				n14++;
//			if (array[0] == 3 && array[1] == 2 && array[2] == 4 && array[3] == 1)
//				n15++;
//			if (array[0] == 3 && array[1] == 4 && array[2] == 1 && array[3] == 2)
//				n16++;
//			if (array[0] == 3 && array[1] == 4 && array[2] == 2 && array[3] == 1)
//				n17++;
//			if (array[0] == 4 && array[1] == 1 && array[2] == 2 && array[3] == 3)
//				n18++;
//			if (array[0] == 4 && array[1] == 1 && array[2] == 3 && array[3] == 2)
//				n19++;
//			if (array[0] == 4 && array[1] == 2 && array[2] == 1 && array[3] == 3)
//				n20++;
//			if (array[0] == 4 && array[1] == 2 && array[2] == 3 && array[3] == 1)
//				n21++;
//			if (array[0] == 4 && array[1] == 3 && array[2] == 1 && array[3] == 2)
//				n22++;
//			if (array[0] == 4 && array[1] == 3 && array[2] == 2 && array[3] == 1)
//				n23++;

		}

//		System.out.println(n0);
//		System.out.println(n1);
//		System.out.println(n2);
//		System.out.println(n3);
//		System.out.println(n4);
//		System.out.println(n5);
//		System.out.println(n6);
//		System.out.println(n7);
//		System.out.println(n8);
//		System.out.println(n9);
//		System.out.println(n10);
//		System.out.println(n11);
//		System.out.println(n12);
//		System.out.println(n13);
//		System.out.println(n14);
//		System.out.println(n15);
//		System.out.println(n16);
//		System.out.println(n17);
//		System.out.println(n18);
//		System.out.println(n19);
//		System.out.println(n20);
//		System.out.println(n21);
//		System.out.println(n22);
//		System.out.println(n23);

	//	permutation_index = compute_permutation_index(array);
		
	//	System.out.printf("permutation index = %d\n", permutation_index);
		
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	}


	public static void randomizeInPlace(int[] A) {
		Random rand = new Random();
		int n = A.length;
		for (int i = 0; i < n; i++) {

			swap(A, i, rand.nextInt(n - i) + i);

		}
	}

	public static void permuteWithAll(int[] A) {
		Random rand = new Random();
		int n = A.length;
		for (int i = 0; i < n; i++) {

			swap(A, i, rand.nextInt(n));

		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public static int compute_permutation_index(int [] A)
	{
		int permutation_index = 0;
		int next_number = 0;
		int index_next_number = 0;

		for (int starting_index = 0; starting_index < A.length-1; starting_index++)
		{	
			int [] remaining_numbers = new int [A.length-starting_index];
                        int [] remaining_numbers_sorted = new int [A.length-starting_index];

			for (int i = 0; i < remaining_numbers.length; i++)
			{
				remaining_numbers[i] = A[starting_index+i];
				remaining_numbers_sorted[i] = remaining_numbers[i];
			}

			insertion_sort(remaining_numbers_sorted);

			next_number = A[starting_index];

			for (int i = 0; i < remaining_numbers_sorted.length; i++)
			{
				if (remaining_numbers_sorted[i] == next_number)
				{
					index_next_number = i;
					break;
				}
			}

			permutation_index += index_next_number*factorial(remaining_numbers.length-1);	
		}	

		return permutation_index;
		
	}

	public static int factorial(int x)
	{	
		int product = 1;

		for (int i = x; i >= 1; i--)
			product *= i;

		return product;
	}

        public static void insertion_sort(int [] A)
        {
                int key;
                int i;

                for (int j = 1; j < A.length; j++)
                {
                        key = A[j];

                        //insert A[j] into the sorted sequence A[1..j-1]
                        i = j-1;

                        while ((i >= 0) && (A[i] > key))
                        {
                                A[i+1] = A[i];
                                i = i-1;
                        }

                        A[i+1] = key;
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

