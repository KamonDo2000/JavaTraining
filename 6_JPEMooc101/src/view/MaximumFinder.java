package view;

public class MaximumFinder {
    public static Integer[] maximum(Integer[] list) {
        Integer[] result = new Integer[2];
        result[0] = Integer.MIN_VALUE; // Initialize max as the smallest possible integer
        result[1] = Integer.MIN_VALUE; // Initialize secondMax as the smallest possible integer
        
        for (Integer num : list) {
            if (num > result[0]) {
                result[1] = result[0]; // Shift the current max to second max
                result[0] = num; // Update max with the new maximum value
            } else if (num > result[1] && num < result[0]) {
                result[1] = num; // Update second max with the new second maximum value
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Integer[] list = {5, 9, 3, 7, 2, 8, 6, 1, 4};
        
        Integer[] maxValues = maximum(list);
        System.out.println("Max: " + maxValues[0]);
        System.out.println("Second Max: " + maxValues[1]);
    }
}