package ch27.b;

public class C extends B implements Calculator, Calculator2, Calculator3 {
  
  private int c_private_var;
  int c_default_var;
  protected int c_protected_var;
  public int c_public_var;
  
  private void c_private() {}
  void c_default() {}
  protected void c_protected() {}
  public void c_public() {}
  
  @Override
  public int plus(int a, int b) {return 0;}
  @Override
  public int minus(int a, int b) {return 0;}
  @Override
  public int multiple(int a, int b) {return 0;}
  @Override
  public int divide(int a, int b) {return 0;}
  @Override
  public int mod(int a, int b) {return 0;}
  
}
