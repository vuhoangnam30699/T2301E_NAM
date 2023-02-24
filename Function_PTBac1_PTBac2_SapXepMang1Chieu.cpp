/**
Viet function giai phuong trình bac I
Viet function giai phuong trình bac II
Viet function sap xep mang 1 chieu theo thu tu tang dan
**/


#include <stdio.h>
#include <math.h>


void ptbac1(float b, float c);
void ptbac2(float a, float b, float c);
void sapxepTang(int x[], int n);
void swap(int &d, int &e);
void xuatMang(int x[], int n);

int main(){	
	float a, b, c;
	printf("Gia tri cua A la ");
	scanf("%f", &a);
	printf("Gia tri cua B la ");
	scanf("%f", &b);
	printf("Gia tri cua C la ");
	scanf("%f", &c);
	ptbac2(a, b, c);
	int T[100], n;
	do{
		printf("\nNhap vao so luong phan tu N = ");
		scanf("%d", &n);
	}while(n < 0 || n > 100);
	for(int i = 0; i < n; i++){
		printf("T[%d] = ", i);
		scanf("%d", &T[i]);
	}
	printf("Mang tang dan la ");
	sapxepTang(T, n);
	xuatMang(T, n);
	
	return 0;
}

// Giai PT bac 1
void ptbac1(float b, float c){
	if(b == 0){
		if(c == 0){
			printf("Phuong trinh co vo so nghiem");
		}else{
			printf("Phuong trinh vo nghiem");
		}
	}else{
		float d = - c / b;
		printf("Phuong trinh co nghiem la x = %f", d);
	}
}

// Giai PT bac 2
void ptbac2(float a, float b, float c){
	if(a == 0){
		ptbac1(b, c);
	}else{
		float delta = b * b - 4 * a * c;
		if(delta < 0){
			printf("Phuong trinh vo nghiem");
		}else if(delta == 0){
			float x = - b / (2 * a);
			printf("Phuong trinh co nghiem la x = %f", x);
		}else{	
			float x1 = ( - b + sqrt(delta) ) / (2 * a);
			float x2 = ( - b - sqrt(delta) ) / (2 * a);
			printf("Phuong trinh co 2 nghiem phan biet la\n");
			printf("x1 = %f\n", x1);
			printf("x2 = %f", x2);
		}
	}
}

// Sap xep mang 1 chieu tang dan
void sapxepTang(int x[], int n){
	for(int i = 0; i <= n - 1; i++){
		int vitrinhonhat = i;
		for(int j = i + 1; j < n; j++){
			if(x[j] < x[vitrinhonhat]){
				vitrinhonhat = j;
			}
		}
		swap(x[i], x[vitrinhonhat]);
	}
}
void swap(int &d, int &e){
	int temp = d;
	d = e;
	e = temp;
}
void xuatMang(int x[], int n){
	for(int i = 0; i < n; i++){
		printf("%d ", x[i]);
	}
}
