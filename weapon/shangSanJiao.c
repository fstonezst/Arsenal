/*************************************************************************
    > File Name: shangSanJiao.c
    > Author: zst
    > Mail: fstone.zh@gmail.com 
    > Created Time: Fri 30 Sep 2016 09:34:25 PM CST
 ************************************************************************/

#include<stdio.h>
main(){
	int n;
	scanf("%d",&n);
	int a[n][n];
	int x,y;
	for(x =0;x<n;++x){
		for(y = 0;y<n;++y){
			if(x<=y)
				a[x][y] = y-x+1;
			else
				a[x][y] =1;
			printf("%d ",a[x][y]);
		}
		printf("\n");
	}
}
