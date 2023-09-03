package com.stackquestions;

import java.util.ArrayList;

public class RainWaterTrapping {



    public static void main(String[] args) {

        int arr [] = {3,0,0,2,0,4};

        ArrayList<Integer>  list = new ArrayList<>();

        int maxl [] = new int [arr.length];
        int maxr [] = new int [arr.length];
        int water[] = new int [arr.length];

        int sumofWaterLevel = 0;
        int squareUnitsOfWater = 0;
        int widthOfEachBuilding = 1;

        maxl[0] = arr[0];
        for(int i = 1; i < arr.length ; i++){
             maxl[i] = Math.max(arr[i],maxl[i-1]);
        }

        maxr[arr.length-1] = arr[arr.length -1];
        for(int j = arr.length - 2; j >= 0 ; j-- ){
            maxr[j] = Math.max(arr[j],maxr[j+1]);
        }

        for(int k = 0 ; k < arr.length - 1 ; k++){
            water[k] = Math.min(maxl[k],maxr[k]) - arr[k];
        }

        for(int l = 0 ; l < arr.length-1 ; l++){
            sumofWaterLevel = water[l] + sumofWaterLevel;
        }

        squareUnitsOfWater = sumofWaterLevel*widthOfEachBuilding;

        System.out.println("Total sq units of water stored : " + squareUnitsOfWater);










    }
}
