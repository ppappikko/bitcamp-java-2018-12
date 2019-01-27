// Object 클래스 - getClass() 와 배열
package ch15;

public class Test13 {

  public static void main(String[] args) {
    // 객체의 클래스 정보
    String obj1 = new String();
    
    Class classInfo = obj1.getClass();
    System.out.println(classInfo.getName()); // java.lang.String
    
    // 배열의 클래스 정보
    String[] obj2 = new String[10];
    
    classInfo = obj2.getClass();
    System.out.println(classInfo.getName()); // [Ljava.lang.String;
    
    int[] obj3 = new int[10];
    classInfo = obj3.getClass();
    System.out.println(classInfo.getName()); // [I
    
    float[] obj4 = new float[10];
    classInfo = obj4.getClass();
    System.out.println(classInfo.getName()); // [F
    
    double[] obj5 = new double[10];
    classInfo = obj5.getClass();
    System.out.println(classInfo.getName()); // [D
    
  }

}