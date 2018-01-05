import java.util.Random;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[] {1,2,3,4,5};
		int[] ret = permut(test);
		for(int i = 0; i < ret.length;i++) {
			System.out.println(ret[i]);
		}
	}

}
