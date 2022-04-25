import java.time.LocalDateTime;

public class Test3 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.plusHours(2L).plusMinutes(2L);
        LocalDateTime localDateTime1 = now.plusMinutes(2L);
        System.out.println("now"+now);
        System.out.println("plushour"+localDateTime);
        System.out.println("plusmin"+localDateTime1);
    }
}
