package lesson8;

public class Book {
    private String title;
    private int pageCount;


    public Book(String title,int pageCount){
            this.title=title;
            this.pageCount=pageCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }


    static class ChildBooks extends Book{

        public ChildBooks(String title, int pageCount) {
            super(title, pageCount);
        }
    }
}
