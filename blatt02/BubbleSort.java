public class BubbleSort {
	public static void sort(int[] a) {
		var x=0;
		for (int i=0; i<a.length; i++){
			for(int j=0;j<a.length-i-1;j++){
				if(a[j]>a[j+1]){
					x=a[j+1];
					a[j+1]=a[j];
					a[j]=x;
				}
			}
		}
	}
}