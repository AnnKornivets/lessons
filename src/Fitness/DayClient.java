package Fitness;

import java.time.LocalDate;

@AccessMode(group="16",gym = "16",pool = "0")
public class DayClient extends Human {
    private LocalDate endOfReg;
    private Access group = new Access(8, 22, FitnessServiceEnumeration.GROUP);
    private Access gym = new Access(8, 16, FitnessServiceEnumeration.GYM);
    //    реализовать невозможность посещения бассейна
    private Access pool = null;

    public LocalDate getEndOfReg() {
        return endOfReg;
    }

    public void setEndOfReg(LocalDate endOfReg) {
        this.endOfReg = endOfReg;
    }

    public Access getGroup() {
        return group;
    }

    public void setGroup(Access group) {
        this.group = group;
    }

    @Override
    public Access getGym() {
        return gym;
    }

    @Override
    public void setGym(Access gym) {
        this.gym = gym;
    }

    public DayClient(String name, String surname, int bYear) {
        super(name, surname, bYear);
//        "12.04.2019";
        //TODO: подсчет даты окончания регистрации отдельным методом
        this.endOfReg = countEndOfReg(LocalDate.now(), 12);
    }

    public DayClient(String name, String surname, int bYear, LocalDate regDate, int end) {
        //TODO: подсчет даты окончания регистрации отдельным методом
        super(name, surname, bYear, regDate);
        this.endOfReg = countEndOfReg(regDate, end);
    }

    private LocalDate countEndOfReg(LocalDate dateOfReg, int months) {
        return dateOfReg.plusMonths(months);
    }
}
