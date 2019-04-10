package patterns.comand;

public class ProcessCommand extends Command{


    public ProcessCommand(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return "ProcessCommand";
    }

    @Override
    boolean execute() {
        //запись данных
        System.out.println("реализация метода ProcessCommand");
        return false;
    }


}
