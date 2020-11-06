import java.util.Arrays;

public class Catalen {
	
	public static int cat(int i) {
		int a [] = new int[i+1];
		a[0]=a[1]=1;
		
		for (int j = 2; j <=i; j++) {
			System.out.println(j + "..i.."+ Arrays.toString(a));
			for (int j2 = 0; j2 < j; j2++) {
				
				a[j]+=a[j2]*a[j-j2-1];
				System.out.println(j2 + "..j.."+ Arrays.toString(a));
			}
		}
		
		
		return a[a.length-1];
		
	}
public static void main(String a[]) {
	
	System.out.println(cat(5));;
	
}
}
