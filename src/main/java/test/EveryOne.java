package test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName EveryOne
 * @Description: best wishes
 * @Author LiMinghua
 * @Date 2021/2/11
 **/
public class EveryOne {

    public Integer happy;
    public Integer beauty;
    public Integer money;
    public Integer health;

    private EveryOne(){
        this.happy = Integer.MAX_VALUE;
        this.beauty = Integer.MAX_VALUE;
        this.money = Integer.MAX_VALUE;
        this.health = Integer.MAX_VALUE;
    }

    public void wish(){
        int year = LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai"))).getYear();
        int newYear = 2021;
        while (year == newYear){
            this.happy++;
            this.beauty++;
            this.money++;
            this.health++;
        }
    }
}
