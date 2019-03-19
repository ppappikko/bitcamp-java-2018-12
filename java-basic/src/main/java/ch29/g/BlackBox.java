package ch29.g;

public class BlackBox {
  private String maker;
  private String model;
  
  public BlackBox() {
    System.out.println("BlackBox()");
  }
  
  @Override
  public String toString() {
    return "BlackBox [maker=" + maker + ", model=" + model + "]";
  }
  
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    this.maker = maker;
  }
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  
  public static BlackBox valueOf(String value) {
    
    BlackBox blackBox = new BlackBox();
    String[] values = value.split(",");
    
    blackBox.setMaker(values[0]);
    blackBox.setModel(values[1]);
    
    return blackBox;
  }
}
