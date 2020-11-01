package org.example;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue(){

        SimpleDateFormat df = new SimpleDateFormat("mm:ss");

        try {
            Path input = Paths.get("Biathlon.csv");
            List<String> lines = Files.readAllLines(input, StandardCharsets.UTF_8);
            ArrayList<Athlete> al= new ArrayList<>();
            for(int i=1; i<lines.size(); i++){
                String[] str2 = lines.get(i).split(",");
                int count = StringUtils.countMatches(str2[4]+str2[5]+str2[6], "o");


                Date d = df.parse(str2[3]);
                Calendar cal = Calendar.getInstance();
                cal.setTime(d);
                cal.add(Calendar.SECOND, count*10);
                String newTime = df.format(cal.getTime());

                al.add(new Athlete(Integer.parseInt(str2[0]),str2[1],newTime));
            }



            Collections.sort(al);
            for(Athlete st:al){
                System.out.println(st.athleteNumber+" "+st.athleteName+" "+st.time );
            }
        }catch(IOException | ParseException ex){
            System.out.println(ex.getMessage());
        }
    }
}
