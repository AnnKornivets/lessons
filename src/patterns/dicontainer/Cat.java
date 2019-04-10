package patterns.dicontainer;

import patterns.dicontainer.di.Config;

import java.lang.annotation.Retention;

@Config
public class Cat {
  private   String catName;

    public Cat() {
        System.out.println("cat init");
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "catName='" + catName + '\'' +
                '}';
    }
}
