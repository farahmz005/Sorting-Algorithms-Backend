
package hw1;
import java.io.PrintStream;
import java.util.*;
public class HW1 {
    public static void selectionSort(int[]data,int n)
    {
        if(n<2)
            return;
        for (int i=0;i<n-1;i++){
            int smallest=1;
            for(int j=i+1;j<n;j++){
                if(data[smallest]>data[j])
                    smallest=j;
            }
            int temp=data[i];
            data[i]=data[smallest];
            data[smallest]=temp;
        }
            
    }
    public static void InsertionSort(int[]data,int n)
    {
        if(n<2)
            return;
        int j;
        for(int i=1;i<n;i++){
            int temp=data[i];
            for(j=i;j>0&&data[j-1]>temp;--j)
            {
                data[j]=data[j-1];   
            }
            data[j]=temp;
        }
    }
    public static void BubbleSort(int[]data,int n)
    {
        if(n<2)
            return;
        for(int i=0;i<n-1;i++){
    
    for(int j=0;j<n-1;j++)
    {
        if(data[j]>data[j+1])
        {
            int temp=data[j];
            data[j]=data[j+1];
            data[j+1]=temp;
        }
    }
        }
    }
    public static void MergeSort(int[]A,int left,int right)
    {
        if(left>=right)
            return;
        else
        {
            int middle=(left+right)/2;
            MergeSort(A,left,middle);
            MergeSort(A,middle+1,right);
            Merge(A,left,right,middle);
                    
        }
    }
    public static void Merge(int []A,int left,int right,int middle){
        int n1=middle-left+1;
        int n2=right-middle;
        int[]l=new int[n1];
        int[]R=new int[n2];
        for(int i=0;i<n1;i++){
            l[i]=A[left+i];
        }
        for(int j=0;j<n2;j++){
            R[j]=A[middle+j+1];
        }
        int i=0;
        int j=0;
        int k=left;
        while(i<n1&&j<n2)
        {
            if(l[i]<R[j])
            {
                A[k++]=l[i++];
            }
            else
            {
                A[k++]=R[j++];
            }
        }
        while(i<n1){
            A[k++]=l[i++];
        }
        while (j<n2)
        {
            A[k++]=R[j++];
        }
    }
    public static void QuickSort(int[]A,int left,int right){
        if(left>=right)
            return;
        else
        {
            int middle=parition(A,left,right);
            QuickSort(A,left,middle-1);
            QuickSort(A,middle+1,right);   
        }    
    }
    public static int parition (int[]A,int left,int right)
    {
        int randomIndex=left+(int)
        (Math.random()*(right-left+1));
        int x=A[randomIndex];
        int temp=A[randomIndex];
        A[randomIndex]=A[right];
        A[right]=temp;
        int i=left-1;
        for(int j=left;j<right;j++){
            if(A[j]<x)
            {
                i++;
                int temp2=A[i];
                A[i]=A[j];
                A[j]=temp2;
            }
        }
        int temp3=A[i+1];
        A[i+1]=A[right];
        return i+1;
        
    }
    
           
    public static void main(String[] args) {
        int size =100000;
        int []A=new int[size];
        for(int i=0;i<size;i++){
            A[i]=(int)(Math.random()*100000);
        }
        int[]b=new int[size];
        for(int i=0;i<size;i++ ){
            b[i]=size-i;
            
        }
        int[]c=new int[size];
        for(int i=0;i<size;i++){
            c[i]=i+1;  
        }
        int[]d=new int[size];
        for(int i=0;i<size;i++)
        {
            d[i]=i+1;
        }
        for(int j=0;j<size*20/100;j++)
        {
            int  index =(int)
            (Math.random()*size);
            d[index]=(int)
            (Math.random()*100000);  
        }
        String[]algorithms={"Selection Sort","Insertion Sort","Bubble Sort","Merge Sort","Quick Sort"};
        long[][] results=new long[5][4];
        int[] As=Arrays.copyOf(A, A.length);
        long startS=System.nanoTime();
        selectionSort(As,As.length);
        long endS=System.nanoTime();
        long durationS=(endS-startS)/1000;
        results[0][0]=durationS;
        int[]bS=Arrays.copyOf(b,b.length);
        long startSS=System.nanoTime();
        selectionSort(bS,bS.length);
        long endSS=System.nanoTime();
        long durationSS=(endSS-startSS)/1000;
        results[0][1]=durationSS;
        int[]cS=Arrays.copyOf(c,c.length);
        long startSSS=System.nanoTime();
        selectionSort(cS,cS.length);
        long endSSS=System.nanoTime();
        long durationSSS=(endSSS-startSSS)/1000;
        results[0][2]=durationSSS;
        int[]dS=Arrays.copyOf(d, d.length);
        long startSSSS=System.nanoTime();
        selectionSort(d,d.length);
        long endSSSS=System.nanoTime();
        long durationSSSS=(endSSSS-startSSSS/1000);
        results[0][3]=durationSSSS;
        int[]AI=Arrays.copyOf(A, A.length);
        long startI=System.nanoTime();
        InsertionSort(AI,AI.length);
        long endI=System.nanoTime();
        long durationI=(endI-startI)/1000;
        results[1][0]=durationI;
        int[]bI=Arrays.copyOf(b, b.length);
        long startII=System.nanoTime();
        InsertionSort(bI,bI.length);
         long endII=System.nanoTime();
         long durationII=(endII-startII)/1000;
         results[1][1]=durationII;
         int[]CI=Arrays.copyOf(c, c.length);
         long startIII=System.nanoTime();
         InsertionSort(CI,CI.length);
         long endIII=System.nanoTime();
         long durationIII=(endIII-startIII)/1000;
         results[1][2]=durationII;
         int[]dI=Arrays.copyOf(d,d.length);
         long startIIII=System.nanoTime();
         long endIIII=System.nanoTime();
         long durationIIII=(endIIII-startIIII)/1000;
         results[1][3]=durationIII;
         int []Ab=Arrays.copyOf(A, A.length);
         long startB=System.nanoTime();
         BubbleSort(Ab,Ab.length);
         long endB=System.nanoTime();
         long durationB=(endB-startB)/1000;
        results[2][0]=durationB;
        int[]BB=Arrays.copyOf(b,b.length);
        long startBB=System.nanoTime();
        BubbleSort(BB,BB.length);
        long endBB=System.nanoTime();
        long durationBB=(endBB-startBB)/1000;
        results[2][1]=durationBB;
        int[]cb=Arrays.copyOf(c,c.length);
        long startBBB=System.nanoTime();
        BubbleSort(cb,cb.length);
        long endBBB=System.nanoTime();
        long durationBBB=(endBBB-startBBB)/1000;
        results[2][2]=durationBBB;
        int[] DB=Arrays.copyOf(d,d.length);
        long startBBBB=System.nanoTime();
        BubbleSort(DB,DB.length);
        long endBBBB=System.nanoTime();
        long durationBBBB=(endBBBB-startBBBB)/1000;
        results[2][3]=durationBBBB;
        int[]Ac=Arrays.copyOf(A, A.length);
        long startime=System.nanoTime();
        MergeSort(Ac,0,A.length-1);
        long endtime=System.nanoTime();
        long durationInMicroseconds=(endtime-startime)/1000;
        results[3][0]=durationInMicroseconds;
        int[]BC=Arrays.copyOf(b,b.length);
        long startimee=System.nanoTime();
        MergeSort(BC,0,b.length-1);
        long endtimee=System.nanoTime();
        long durationInMicrosecondss=(endtimee-startimee)/1000;
        results[3][1]=durationInMicrosecondss;
        int[]cc=Arrays.copyOf(c, c.length);
        long startimeee=System.nanoTime();
        MergeSort(cc,0,c.length-1);
        long endtimeee=System.nanoTime();
        long durationInMicrosecondsss=(endtimeee-startimeee)/1000;
        results[3][2]=durationInMicrosecondsss;
        int[] DC=Arrays.copyOf(d,d.length);
        long startimeeee=System.nanoTime();
        MergeSort(DC,0,d.length-1);
        long endtimeeee=System.nanoTime();
        long durationInMicrosecondssss=(endtimeeee-startimeeee)/1000;
        results[3][3]=durationInMicrosecondssss;
        int[] AQ=Arrays.copyOf(A, A.length);
        long startQ=System.nanoTime();
        QuickSort(AQ,0,AQ.length-1);
        long endQ=System.nanoTime();
        long durationQ=(endQ-startQ)/1000;
        results[4][0]=durationQ;
        int[]BQ=Arrays.copyOf(b, b.length);
        long startQQ=System.nanoTime();
       QuickSort(BQ,0,BQ.length-1);
       long endQQ=System.nanoTime();
       long durationQQ=(endQQ-startQQ)/1000;
       results[4][1]=durationQQ;
       int[]CQ=Arrays.copyOf(c, c.length);
       long startQQQ=System.nanoTime();
       QuickSort(CQ,0,CQ.length-1);
       long endQQQ=System.nanoTime();
       long durationQQQ=(endQQQ-startQQQ)/1000;
       results[4][2]=durationQQQ;
       int[]DQ=Arrays.copyOf(d,d.length);
       long startQQQQ=System.nanoTime();
       QuickSort(DQ,0,DQ.length-1);
       long endQQQQ=System.nanoTime();
       long durationQQQQ=(endQQQQ-startQQQQ);
       results[4][3]=durationQQQQ;
       System.out.println("\n================================================= SORTING RESULTS ================================================");
       System.out.printf("%-22s | %18s | %18s | %20s | %22s%n","Algorithm","Random","Reverse","Fully Sorted","Partially Sorted");
       System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
       for(int i=0;i<5;i++){
      System.out.printf("%-22s | %15d ms | %15d ms | %17d ms | %19d ms\n",algorithms[i], results[i][0],results[i][1],results[i][2],results[i][3]);
       }
       System.out.println("================================================================================================================================");
    }
       }
       
       
        
        
        
        
        
    }
    
}
