package freecodecamp.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class CarFleetWithoutUsingStack {

    public static class Car {

        private int position;
        private double timeToReachTarget;

        public Car(){

        }

        public Car(int position, double timeToReachTarget){
            this.position = position;
            this.timeToReachTarget = timeToReachTarget;
        }
    }

    public static int countNoOfCarFleets(int target, int [] position, int [] speed){

        int noOfTotalFeet = 0;
        Car cars[] =  new Car[speed.length];

        for(int i = 0; i < speed.length ; i++){
            cars[i] = new Car(position[i], (target - position[i])*1.0/speed[i]);
        }

        Arrays.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.position - o2.position;
            }
        });

        for(int j = speed.length - 1; j >= 1; j--){

            if(cars[j-1].timeToReachTarget <= cars[j].timeToReachTarget){
                cars[j-1] = cars[j];
            }else{
                noOfTotalFeet++;
            }
        }

        return noOfTotalFeet + 1; // since we iterating till j = 1 so to add j = 0 if it's/it's not the part of combined fleet we add 1 to answer
    }

    public static void main(String[] args) {

        int positions []  = new int[]{10,8,0,5,3};
        int speeds []  = new int[]{2,4,1,1,3};
        int target = 12;

        System.out.println(countNoOfCarFleets(target,positions,speeds));

    }

}
