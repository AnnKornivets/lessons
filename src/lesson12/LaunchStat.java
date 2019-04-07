package lesson12;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.Date;

public class LaunchStat implements Serializable { //NotSerializibalException
    private  int launchCount;
    private Date lastLaunch;
    private String lastuser;


    public boolean isFirstLaunch(){
        return  launchCount==0&&lastLaunch==null;

    }
    public void update(){
        launchCount++;
        lastLaunch =new Date();
        lastuser = System.getProperty("user.name");

    }

    @Override
    public String toString() {
        return "LaunchStat{" +
                "launchCount=" + launchCount +
                ", lastLaunch=" + lastLaunch +
                ", lastuser='" + lastuser + '\'' +
                '}';
    }
}
