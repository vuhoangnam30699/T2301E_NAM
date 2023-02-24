#include <stdio.h>
#include <math.h>

int isPrime(int number){

    if (number < 2){
		return 0;	
	}
    for(int i = 2; i <= number / 2; i++){
    	if(number % i == 0){
    		return 0;
		}
	}
    return 1;
}

int main(){
    int n, m;
    printf("Nhap vao 2 so nguyen duong n va m voi n < m hoac n = m \n\n");
    do{
    printf("n = ");
    scanf("%d", &n);
    printf("m = ");
    scanf("%d", &m);
	}while((n < 0 || m < 0) && printf("Vui long nhap lai!\n"));
	printf("\n");
	if(n <= m){
		printf("Cac so nguyen to trong khoang [%d, %d] la\n\n", n, m);
		for(n; n <= m; n++){
			if(isPrime(n)){
				printf("%d ", n);
			}
		}
	}else{
		printf("Khong hop le! Moi nhap n < m hoac n = m");
	}
    getchar();
}
