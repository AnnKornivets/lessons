package nested;

public class Food {

    private final int portion;//обязательное свойство


    //дополнительные свойства
    private final int fat;
    private final int calories;
    String field;

    static class Builder{ //вложенный класс, конструирование объекта

      private final  int portion;//4
        private  int fat=0;
        private  int calories=0; //45


        public Builder(int portion){
            //обязательное свойство ,инициализация
            this.portion=portion;
        }



        public Builder calories(int calories){
            this.calories=calories;
            return this;

        }

        public Builder fat(int fat){
            this.fat=fat;
            return this;
        }

        public Food build(){//возвращает объект внешнего класса
            return new Food(this); }
    }
    private Food(Builder builder){ //инициализация класса Food, конструктор внешнего класса
        portion=builder.portion;
        calories=builder.calories;
        fat=builder.fat;
    }

    @Override
    public String toString() {
        return "Food{" +
                "portion=" + portion +
                ", fat=" + fat +
                ", calories=" + calories +
                '}';
    }
}
