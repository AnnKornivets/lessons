package lambda;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        //ссылку на конструктор через нотацию ClassName::name, где ClassName не может быть абстрактным классом или интерфейсом
        ButtonFActory<Button> factory= Button::new;
        Button button= factory.set("grey","Cancel");

        System.out.println(button);

        Consumer<Button> makeBtn=(button1 -> {button1.setColor("blue");
        button1.setValuse("Reset");});
        makeBtn.accept(button);
        System.out.println(button);
    }

}


interface ButtonFActory<T extends Button>{
    T set (String color,String value);
    //T Some(String color);
}
class Button {
   private String color;
   private String valuse;


    public Button(String color, String valuse) {
        this.color = color;
        this.valuse = valuse;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValuse() {
        return valuse;
    }

    public void setValuse(String valuse) {
        this.valuse = valuse;
    }

    @Override
    public String toString() {
        return "Button{" +
                "color='" + color + '\'' +
                ", valuse='" + valuse + '\'' +
                '}';
    }
}