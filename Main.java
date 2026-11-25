import java.io.IOException;
import java.util.Scanner;
import java.io.File;
public class Main {
    public static boolean[] getRow(String s) {
        Scanner scanner = new Scanner(s);
        int i = 0;
        boolean[] row = new boolean[60];
        while(scanner.hasNextBoolean()) {
            row[i] = scanner.nextBoolean();
            i++;
        }
        return row;
    }
    public static void main(String[] args) throws IOException {
        boolean[][] schedule = new boolean[8][60];
        AppointmentBook a = new AppointmentBook(schedule);
        for (int i =10; i < 15; i++) schedule[1][i] = true;
        for (int i = 25; i < 30; i++) schedule[1][i] = true;
        for (int i = 0; i < 15; i++) schedule[2][i] = true;
        for (int i = 41; i < 60; i++) schedule[2][i] = true;
        for (int i=5; i < 30; i++) schedule[3][i] = true;
        for (int i= 44; i < 60; i++) schedule[3][i] = true;
        AppointmentBook b = new AppointmentBook(schedule);
        AppointmentBook[] schedules = new AppointmentBook[100];
        File f = new File("Schedules.txt");
        Scanner s = new Scanner(f);
        int i = 0;
        while (s.hasNextLine()) {
            int j = 0;
            schedules[i] = new AppointmentBook(schedule);
            i++;
            while (j < schedule.length){
                 String line = s.nextLine();
                if (line.length() > 0) {
                     schedule[j] = getRow(line);
                     j++;
            }
        }
        f = new File("requests.txt");
        s = new Scanner(f);
        int meetings = 0;
        while (s.hasNextLine()) {
            int scheduleIndex = s.nextInt();
            int start = s.nextInt();
            int end = s.nextInt();
            int duration = s.nextInt();
            if (schedules[scheduleIndex].makeAppointment(start, end, duration)) meetings++;
        }
    
    }
}
