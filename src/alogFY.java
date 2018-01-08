import java.util.Random;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class alogFY {

	public static int[] permut(int[] entree) {
		int[] ret = new int[entree.length];
		int i = 0;
		Random randomGenerator = new Random();
		while (entree.length > 1) {
			int randomIndex = randomGenerator.nextInt(entree.length);
			ret[i] = entree[randomIndex];
			entree = ArrayUtils.remove(entree, randomIndex);
			i++;
		}
		ret[i] = entree[0];
		return ret;
	}
	
	public static int[] quicksort(int[] entree) {
		if(entree.length <= 1) return entree;
		
		int pivot = entree[0];
		int[] R = {pivot};
		int p = 0;
		for(int i = 1; i < entree.length; i++) {
			if(entree[i] < pivot) {
				int[] beforeP = Arrays.copyOfRange(R, 0, p > 0 ? p : 0);
				int[] afterP = Arrays.copyOfRange(R, p, R.length > p ? R.length : p);
				beforeP = ArrayUtils.addAll(beforeP, new int[]{entree[i]});
				R = ArrayUtils.addAll(beforeP,afterP);
				p++;
			}
			else {
				R = ArrayUtils.addAll(R, new int[]{entree[i]});
			}
		}	
		return ArrayUtils.addAll(ArrayUtils.addAll(quicksort(Arrays.copyOfRange(R,0,p > 0 ? p : 0)), R[p]), quicksort(Arrays.copyOfRange(R, p+1, R.length > p+1 ? R.length : p+1)));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		int[] test = new int[] {1,2,3,4,5};
		int[] ret = permut(test);
		for(int i = 0; i < ret.length;i++) {
			System.out.println(ret[i]);
		}
		System.out.println("Resultat : ");
		int[] sort = quicksort(ret);
		for(int i = 0; i < sort.length;i++) {
			System.out.println(sort[i]);
		}
	}

}
