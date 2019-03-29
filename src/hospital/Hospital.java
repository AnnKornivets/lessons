package hospital;

import lesson8.LinkedList;

public class Hospital {
    Reg[] regs = new Reg[15];
    LinkedList<Doctor> doctors=new LinkedList<>();

    public void AddDoctor(Doctor doctor){
       doctors.add(doctor);


    }

    public Reg[] getRegs() {
        return regs;
    }

    public void setRegs(Reg[] regs) {
        this.regs = regs;
    }
}
