// Ve hinh tam giac can bang dau *


#include <stdio.h>
int main(){
	int n, i, j;
	printf("Nhap chieu cao cua tam giac : ");
	scanf("%d", &n);
	printf("\n");
	
// Tam giac can
	for(i = 1; i <= n; i++){
		for(j = 1; j <= n - i; j++){
			printf(" ");
		}
		for(j = 1; j <= 2 * i - 1; j++){
			printf("*");
		}
		printf("\n");
	}
	
/**
	Tam giac can dao nguoc
	for(i = n; i >= 1; i--){
		for(j = n; j > i; j--){
			printf(" ");
		}
		for(j = 1; j < 2 * i; j++){
			printf("*");
		}
		printf("\n");
	} 
**/
	
	return 0;
}
