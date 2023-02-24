/**
Nhap vao mang 2 chieu vuong arr[3][3]
=> tinh tong cac so tren duong cheo chinh
VD	:	1	3	5
		4	2	7
		4	9	8
**/


#include <stdio.h>

int main(){
	int arr[3][3];
	int i, j;
// Nhap ma tran vuong
	for(i = 0; i < 3; i++){
		for(j = 0; j < 3; j++){
			printf("Hang %d, cot %d : ", i+1, j+1);
			scanf("%d", &arr[i][j]);
		}
	}
// Xem ma tran
	printf("\nMa tran co dang la\n\n", i+1, j+1);
	for(i = 0; i < 3; i++){
		for(j = 0; j < 3; j++){
			printf("%5d", arr[i][j]);
		}
		printf("\n\n");
	}
// Tinh tong duong cheo
	int total = 0;
	for(i = 0; i < 3; i++){
		for(j = 0; j < 3; j++){
			total = total + arr[i][j];// total+=arr[i][j]
		}
	}
	printf("Tong cac so tren duong cheo chinh cua ma tran nay la : %d", total);
	
	return 0;
}
