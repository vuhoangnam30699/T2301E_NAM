// Nhap n so tu ban phim, Tim gia tri Max, gia tri Min trong dãy so vua nhap.


#include <stdio.h>
#include <math.h>


int main(){
	int n, i, a[100], max, min;
	printf("Nhap so phan tu cua day N = ");
	scanf("%d", &n);
	for(i=1; i<=n; i++){
		printf("a[%d] : ", i);
		scanf("%d", &a[i]);
	}
	max=a[1];
	for(i=1; i<=n; i++){
		if(a[i]>max){
			max=a[i];
		}
	}
	printf("\nGia tri lon nhat la : %d", max);
	min=a[1];
	for(i=1; i<=n; i++){
		if(a[i]<min){
			min=a[i];
		}
	}
	printf("\nGia tri nho nhat la : %d", min);
	
	return 0;
}
