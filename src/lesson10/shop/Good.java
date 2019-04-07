package lesson10.shop;

public class Good {
   private String title;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Good)) return false;

        Good good = (Good) o;

        if (getPrice() != good.getPrice()) return false;
        return getTitle() != null ? getTitle().equals(good.getTitle()) : good.getTitle() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + getPrice();
        return result;
    }

    //    private int qty;
   private int price;


    public Good(String title,  int price) {
        this.title = title;
//        this.qty = qty;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

//    public int getQty() {
//        return qty;
//    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }


}
