package lab2alg;

public class lab2alg3b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int i=0;
	while(true) {
		
		
		if(Math.pow(i, 2)<i*(Math.log10(i) / Math.log10(2)))
		break;
		
		i++;
		
	}
	//
	// no answer. 
	//n^2 is always bigger than nlogn 
	System.out.println(i);
	}

}
