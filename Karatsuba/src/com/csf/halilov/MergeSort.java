package com.csf.halilov;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void bubbleSort(int[] x) {
        for(int i=1; i<x.length; i++) {
            int temp=0;
            if(x[i-1] > x[i]) {
                temp = x[i-1];
                x[i-1] = x[i];
                x[i] = temp;
            }
        }
    }

    public static boolean testArray(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }

    public static boolean equalArrays(int[] arrayA, int[] arrayB){
        for(int i = 0; i < arrayA.length; i++){
            if(arrayA[i] != arrayB[i]){
                return false;
            }
        } return true;
    }

    public static void mergeSortTest(){
        Random random = new Random();
        int n = random.nextInt(10000);
        int[] array = new int[n];
        int[] array2 = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = random.nextInt(10000);
            array2[i] = array[i];
        }
        mergeSort(array, n);
        Arrays.sort(array2);
        System.out.println("Совпадение массивов отсортированных MergeSort и библиотечным sort: " + equalArrays(array, array2));
    }
}
