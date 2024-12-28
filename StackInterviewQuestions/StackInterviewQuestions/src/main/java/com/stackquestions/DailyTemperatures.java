package freecodecamp.Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class DailyTemperatures {

    public ArrayList<Integer> findNearestNextWarmerDay(int [] dailyTempArr){

        Stack <Integer> stack = new Stack<>();
        ArrayList<Integer> nextWarmerDayWillBe = new ArrayList<>();

        for(int i = dailyTempArr.length-1; i >= 0; i-- ){

            if(stack.isEmpty()){
                stack.push(i);   // Current element will be considered as higher temp
                nextWarmerDayWillBe.add(0); // There will be no next warmer day to right as stack is empty
            }
            else {
                while (!stack.isEmpty() && dailyTempArr[i] >= dailyTempArr[stack.peek()]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    stack.push(i);   // Current element will be considered as higher temp
                    nextWarmerDayWillBe.add(0); // There will be no next warmer day to right as stack is empty
                } else {
                    nextWarmerDayWillBe.add(stack.peek() - i);
                    stack.push(i);
                }
            }
        }

        Collections.reverse(nextWarmerDayWillBe);
        return nextWarmerDayWillBe;
    }

    public static void main(String[] args) {

        int [] dailyTempArr =  {73,74,75,71,69,72,76,73};
        DailyTemperatures nextWarmerDayIsDaysAway = new DailyTemperatures();
        ArrayList<Integer> result = nextWarmerDayIsDaysAway.findNearestNextWarmerDay(dailyTempArr);

        for(int a : result){
            System.out.printf(" %d ,", a);
        }
    }
}
