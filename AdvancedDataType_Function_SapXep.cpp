// Nhap vao mang n struct staff
// char name[20]; int age; float salary;
// Viet function nhap vao n staff
// Sap xep luong nhan vien theo thu tu tang dan

#include <stdio.h>
#include <string.h>


struct nhanvien{
	char name[100];
	int age;
	float salary;
};

void nhap(nhanvien a[], int n);
void tang(nhanvien a[], int n);
void xuat(nhanvien a[], int n);


int main(){
	nhanvien a[20];
	int n;
	do{
	printf("Nhap so nhan vien :  ");
	scanf("%d", &n);
	}while((n <= 0 || n >= 20) && printf("Vui long nhap lai\n"));
	nhap(a, n);
	xuat(a, n);
	
	return 0;
}


void nhap(nhanvien a[], int n){
	for(int i = 0; i < n; i++){
		printf("\nNhap thong tin nhan vien thu %d", i + 1);
		printf("\nNhap ten nhan vien :  ");
		fflush(stdin);
		gets(a[i].name);
		do{
			printf("Nhap tuoi cua nhan vien :  ");
			scanf("%d", &a[i].age);
		}while((a[i].age < 18 || a[i].age > 65) && printf("Vui long nhap lai\n"));
		do{
			printf("Nhap luong cua nhan vien :  ");
			scanf("%f", &a[i].salary);
		}while((a[i].salary <= 4800000) && printf("Vui long nhap lai\n"));
	}
}


void tang(nhanvien a[], int n){
	nhanvien tmp;
	for(int i = 0; i < n ; i++){
		for(int j = i + 1; j < n; j++){
			if(a[i].salary > a[j].salary){
				nhanvien tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}
	}
}


void xuat(nhanvien a[], int n){
	printf("\n-----Danh sach nhan vien-----\n\n");
	printf("Ten \t\t\t Tuoi \t\t\t Luong \n");
	for(int i = 0; i < n; i++){
		tang(a, n);
		printf("%s \t\t %d \t\t\t %6.0f \n", a[i].name, a[i].age, a[i].salary);
	}
}
