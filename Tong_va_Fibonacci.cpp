// Tinh tong sau: s = 1 + 2/(1+2)! + 3/(1+3)! +…..+ n/(1+n)! , voi n nhap tu ban phim.
// Tìm so fibonacci thu n, voi n nhap vào tu ban phim



#include <stdio.h>
#include <math.h>

int main(){
	float S = 1;
	int n, i;
	int f1 = 0, f2 = 1, f;
	printf("Nhap so n : ");
	scanf("%d", &n);
	for(int i = 2; i <= n; i++){
		int M = 1;
		for(int j = 1; j <= (1 + i); j++){
			M = M * j;
		}
		S = S + (float)(i / (float)M);
	}
	printf("\nTong giai thua = %f", S);
	if(n == 0){
		f = 0;
	}else if(n == 1){
		f = 1;
	}else{
		for(i = 2; i <= n; i++){
			f = f1 + f2;
			f1 = f2;
			f2 = f;
		}
	}
	printf("\nSo fibonacci thu %d la : %d", n, f);
	
	return 0;
}
