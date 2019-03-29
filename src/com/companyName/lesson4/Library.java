package com.companyName.lesson4;

import java.util.Arrays;

public class Library {
    Book[] books=new  Book[10];




 public void addBook(Book book){

     for (int i=0;i<this.books.length;i++) //свободное место
     {
         if(this.books[i]== null){ //если такой нет то добавляем
             this.books[i]=book;
             break;
         }
     }
 }

 public Book getBook(String bookTitle){

     Book result = null;
     for (int i=0;i<this.books.length;i++)
     {
         if(bookTitle.equals(books[i].getTitle())){
             result =books[i];
             break;
         }
     }
     return result;

 }


    @Override
    public String toString() {
        return "Library{" +
                "book=" + Arrays.toString(books) +
                '}';
    }
}
