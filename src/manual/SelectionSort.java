package manual;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2, 9, 5, 4, 0, 1, 15, 7, 8, 6, 3};
        SortBySelection(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    
    static void SortBySelection(int[] list) {
        int currentMax;
        int currentMaxIndex;
        
        for (int i = list.length - 1; i >= 1; i--) {
            currentMax = list[i];
            currentMaxIndex = i;
            
            for (int j = i - 1; j >= 0; j--) {
                if (currentMax < list[j]) {
                    currentMax = list[j];
                    currentMaxIndex = j;
                }
            }
            
            if (currentMaxIndex != i) {
                list[currentMaxIndex] = list[i];
                list[i] = currentMax;
            }
        }
    }
}
