/**
Viet function nhap vao danh sach n nhan vien (ten, tuoi, luong) vao file.
Viet function doc file nhan vien, sap xep nhan vien theo do tuoi giam dan.
**/

#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>

struct nhanvien {
	char name[100];
	int age;
	float salary;	
};

void ghiFile(nhanvien a[], int n);
void sapXep(nhanvien a[], int n);
void docFile(nhanvien a[], int n);

int main(){
	nhanvien a[100];
	int n;
	do{
		printf("Nhap so nhan vien :  ");
		scanf("%d", &n);
	}while((n < 1) && printf("Khong hop le! Moi nhap lai.\n"));
	for(int i = 0; i < n; i++){
		printf("\nNhap thong tin nhan vien thu %d", i + 1);
		printf("\nHo va ten :  ");
		fflush(stdin);
		gets(a[i].name);
		do{
			printf("Tuoi :  ");
			scanf("%d", &a[i].age);
		}while((a[i].age < 18 || a[i].age > 65) && printf("Vui long nhap lai\n"));
		printf("Luong :  ");
		scanf("%f", &a[i].salary);
	}
	printf("\n-----Danh sach nhan vien-----\n");
	printf("Ten \t\t Tuoi \t\t Luong \n");
	for(int i = 0; i < n; i++){
		sapXep(a, n);
        printf("%s \t\t %d \t\t\ %6.0f \n", &a[i].name, a[i].age, a[i].salary);
	}
	ghiFile(a, n);
	docFile(a, n);
	return 0;
}

void ghiFile(nhanvien a[], int n){
	FILE *f;
	f = fopen("C:/Users/Admin/Downloads/C/Baitap.txt", "wt");
	if(f == NULL){
		printf("\nKhong tao duoc file!");
		return;
	}
	fprintf(f, "Ten \t\t Tuoi \t\t Luong \n");
	fprintf(f, "\n");
	for(int i = 0; i < n; i++){
		fprintf(f, "%s \t\t %d \t\t %6.0f \n", a[i].name, a[i].age, a[i].salary);
	}
	fclose(f);
}

void sapXep(nhanvien a[], int n){
	for(int i = 0; i < n; i++){
        for(int j = i + 1; j < n; j++){
            if(a[i].age < a[j].age){
                nhanvien tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;        
            }
        }
    }
}

void docFile(nhanvien a[], int n){
	FILE *f;
	f = fopen("C:/Users/Admin/Downloads/C/Baitap.txt", "rt");
	if(f == NULL){
		printf("\nKhong tao duoc file!");
		return;
	}
	for(int i = 0; i < n; i++){
        fscanf(f, "%s%d%f", &a[i].name, &a[i].age, &a[i].salary);
    }
}
