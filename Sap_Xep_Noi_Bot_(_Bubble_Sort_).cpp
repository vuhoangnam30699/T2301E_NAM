/**
Sap xep noi bot(Bubble Sort) mang 2 chieu
Tinh tong so le trong mang
**/

#include<stdio.h>

int main(){
    int m, n;
    do{
        printf("So hang : ");
        scanf("%d", &m);
        printf("So cot  : ");
        scanf("%d", &n);
    }while((m < 1 || n < 1) && printf("Kich thuoc khong hop le. Moi nhap gia tri khac!\n"));
    int i, j;
    int a[m][n];
    printf("\nKich thuoc cua mang la [%d][%d]\n\n",m ,n);
    for(i = 0; i < m; i++){
        for(j = 0; j < n; j++){
            printf("Hang %d, cot %d : ", i + 1, j + 1);
            scanf("%d", &a[i][j]);
        }
    }
// In mang truoc khi sap xep
    printf("\nMang truoc khi sap xep\n");
    printf("\n");
    for(i = 0; i < m; i++){
        for(j = 0; j < n; j++){
            printf("%d  ",a[i][j]);
        }
        printf("\n");
    }
    int b[m * n];
    for(i = 0; i < m; i++){
        for(j = 0; j < n; j++){
            b[i * n + j]= a[i][j];
        }
    }
    int x, y;
    for(x = 0; x < m * n; x++){
        for(y = x; y < m * n; y++){
            if(b[x] > b[y]){
                int temp = b[x];
                b[x] = b[y];
                b[y] = temp;
            }
        }
    }
    for(i = 0; i < m; i++){
        for(j = 0; j < n; j++){
            a[i][j] = b [i * n + j];
        }
    }
// Cho ra mang sau khi sap xep
    printf("\nMang sau khi sap xep\n");
    printf("\n");
    for(i = 0; i < m; i++){
        for(j = 0; j < n; j++){
            printf("%d  ", a[i][j]);
        }
        printf("\n");
    }
// Tinh tong so le
	int tongsole = 0;
	for(i = 0; i < m; i++){
		for(j = 0; j < n; j++){
			if(a[i][j] % 2 != 0){
				tongsole = tongsole + a[i][j];
			}
		}
	}
	printf("\nTong so le trong mang la %d\n", tongsole);
	
	return 0;
}
