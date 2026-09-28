class Invoice {
  private String partNo;
  private int quantity;
  private double perItem;

  public Invoice(String partNo, int quantity, double perItem) {
    this.partNo = partNo;
    this.quantity = quantity;
    this.perItem = perItem;
  }
  public String getPartNo() {
    return partNo;
  }
  public int getQuantity() {
    return quantity;
  }
  public double printPerItem() {
    return perItem;
  }
}

class J19B5d {
  public static void main(String[] args) {
    Invoice inv = new Invoice("2034", 2, 325.50);
    System.out.println(inv.getPartNo() + " " + inv.getQuantity() + " " + inv.printPerItem());
  }
}
