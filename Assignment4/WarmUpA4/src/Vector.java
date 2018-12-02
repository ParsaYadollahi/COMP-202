package WarmUpA4.src;
import java.util.Arrays;

public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double vX, double vY, double vZ){
        this.x = vX;
        this.y = vY;
        this.z = vZ;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getZ(){
        return this.z;
    }
    public void setX(double sX){
        this.x = sX;
    }
    public void setY(double sY){
        this.y = sY;
    }
    public void setZ(double sZ){
        this.y = sZ;
    }

    public double calcuateMagnitude(){
        double magnitudeVector = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        return magnitudeVector;
    }
    public void scalarMultiply(double[] a, double scale){
        for(int i = 0; i< a.length; i++){
            a[i] = a[i]*scale;
        }
    }
    public static int[] deleteElement(int[] a, int target) {
        int freq = 0;
        for( int k = 0; k < a.length; k++){
            if(a[k] == target){
                freq++;
            }
        }
        int b[] = new int[a.length-freq];
        int j = 0;
        for(int i = 0; i < a.length; i++){
            if (a[i] != target){
                b[j] = a[i];
                j++;
            }
        }
        return b;
    }

    public static String[] deleteElementSt(String[] a, String s){
        int freq = 0;
        for( int i = 0; i < a.length; i++){
            if (a[i].equalsIgnoreCase(s)){
                freq++;
            }
        }
        String[] b = new String[a.length-freq];
        int k = 0;
        for(int j = 0; j < a.length; j++){
            if(a[j] != s){
                b[k] = a[j];
                k++;
            }
        }
        return b;
    }

    public static void main(String[] args){
        Vector v1 = new Vector(2, 3, 4);
        int[] arr = {1,2,3,4,5,4,6,7};
        String[] array = {"Hello", "Hi", "hey", "allo", "hey"};
        System.out.println(Arrays.toString(deleteElementSt(array, "hey")));
    }
}
