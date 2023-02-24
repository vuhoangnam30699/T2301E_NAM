// Viet function nhap vào 1 mang string n phan tu, moi chuoi trong mang có do dai m.
// Tim chuoi có do dai lon nhat trong mang
// Sap xep mang theo thu tu tang dan (su dung strcmp de so sanh)


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void allocate_string_array(char ***array, int &n, int &m);
void get_string_array(char **array, int n, int m);
void display_string_array(char **array, int n, int m);
void Longest(char **array, int n, int m);
void Sort(char** array, int n, int m);


int main(){
	int n, m;
	char **array;
	allocate_string_array(&array, n, m);
	printf("\n");
	get_string_array(array, n, m);
	printf("\nThe array we have\n");
	display_string_array(array, n, m);
	Longest(array, n, m);
    printf("\nThe array after sorting\n");
    Sort(array, n, m);
    display_string_array(array, n, m);
    for (int i = 0; i < n; i++) {
        free(array[i]);
    }
    free(array);
    
	return 0;
}


void allocate_string_array(char ***array, int &n, int &m){
	do{
		printf("Enter the number of rows     :  ");
		scanf("%d", &n);
		printf("Enter the number of columns  :  ");
		scanf("%d", &m);
	}while((n < 1 || m < 1) && printf("The size is not suitable. Please enter other value!\n"));
	*array = (char **) malloc(n * sizeof(char *));
	for (int i = 0; i < n; i++){
        (*array)[i] = (char *) malloc(m * sizeof(char));
    }
}


void get_string_array(char **array, int n, int m){
	printf("Enter strings into the array \n");
    for (int i = 0; i < n; i++){
    	printf("Array %d : ",i + 1);
        scanf("%s", array[i]);
    }
}


void display_string_array(char **array, int n, int m){
    for (int i = 0; i < n; i++) {
        printf("Array %d : ",i + 1);
        printf("%s\n", array[i]);
    }
    printf("\n");
}


void Longest(char **array, int n, int m){
    char a[m];
    strcpy(a, array[0]);
    for(int i = 0; i < n; i++){
        if(strlen(a) < strlen (array[i])){
            strcpy(a, array[i]);
        }
    }
    printf("\n%s is the longest string in the array\n", a);
}


void Sort(char** array, int n, int m){
    int i;
    for(i = 0; i < n; i++){
        for(int j = i + 1; j < n; j++){
            int h = strlen(array[i]), k = strlen(array[j]);
            if(h > k || (h == k && strcmp(array[i], array[j]) > 0)){
                char a[m];
                strcpy(a, array[i]);
                strcpy(array[i], array[j]);
                strcpy(array[j], a);
            }
        }
    }
}
