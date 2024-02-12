import java.util.Random;

public class Main {

  // Bubble sort
  public static void bubbleSort(Integer[] data) {
    int size = data.length;
    long startTime = System.nanoTime();
    for (int i = 0; i < size - 1; i++)  // loop to access each array element
      for (int j = 0; j < size - i - 1; j++) // loop to compare array elements
    	  if (data[j] > data[j + 1]) {  // compare two adjacent elements
          int temp = data[j];  // the swapping 
          data[j] = data[j + 1];
          data[j + 1] = temp;
        }
    long endTime = System.nanoTime();
    System.out.println("Bubble Sort: " + (endTime - startTime));
  }
  
  
//Insertion sort
public static void insertionSort(Integer[] data) {
   int size = data.length;
   long startTime = System.nanoTime();
   for (int step = 1; step < size; step++) {
     int key = data[step];
     int j = step - 1;
     while (j >= 0 && key < data[j]) { // Compare key with each element on the left of it until an element smaller than it is found.
       data[j + 1] = data[j];
       --j;
     }
     data[j + 1] = key;   //Place key at after the element just smaller than it.
   }
   long endTime = System.nanoTime();
   System.out.println("Insertion Sort: " + (endTime - startTime));
 }

//Quick sort

// method to find the partition position
static int partition(Integer array[], int low, int high) {
	
 // choose the rightmost element as pivot
 Integer pivot = array[high];
 
 // pointer for greater element
 int i = (low - 1);

 // traverse through all elements
 // compare each element with pivot
 for (int j = low; j < high; j++) {
   if (array[j] <= pivot) {

     // if element smaller than pivot is found
     // swap it with the greatr element pointed by i
     i++;

     // swapping element at i with element at j
     Integer temp = array[i];
     array[i] = array[j];
     array[j] = temp;
   }

 }

 // swapt the pivot element with the greater element specified by i
 Integer temp = array[i + 1];
 array[i + 1] = array[high];
 array[high] = temp;

 // return the position from where partition is done
 return (i + 1);
}

static void quickSortWrapper(Integer array[]) {
    long startTime = System.nanoTime();
    quickSort(array, 0, array.length - 1);
    long endTime = System.nanoTime();
    System.out.println("Quick Sort: " + (endTime - startTime));
}

static void quickSort(Integer array[], int low, int high) {
    if (low < high) {
        int pi = partition(array, low, high);
        quickSort(array, low, pi - 1);
        quickSort(array, pi + 1, high);
    }
}


public static void main(String args[]) {
    int[] sizes = {
        5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 60, 70, 80, 90, 100, 120, 150, 200
    };
    
    Random rand = new Random();

    for (int size : sizes) {
        System.out.println("Testing for size: " + size);
        
        Integer[] dataForBubbleSort = new Integer[size];
        Integer[] dataForInsertionSort = new Integer[size];
        Integer[] dataForQuickSort = new Integer[size];
        
        for (int i = 0; i < size; i++) {
            int randomNum = rand.nextInt(); 
            dataForBubbleSort[i] = randomNum;
            dataForInsertionSort[i] = randomNum;
            dataForQuickSort[i] = randomNum;
        }
        
        bubbleSort(dataForBubbleSort);
        insertionSort(dataForInsertionSort);
        quickSortWrapper(dataForQuickSort);
       
        System.out.println("-----------------------------");
    }
}
}
