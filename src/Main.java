import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int ostatok = 0;

    public static void main(String[] args) throws IOException {
        List<String> journal = new ArrayList<String>();
        String[] rasxodi = {
                "1 - Еда",
                "2 - Бытовая химия",
                "3 - Коммуналка",
                "4 - Ремонт",
                "5 - Игрушки Марку",
                "6 - Расходы на авто",
                "7 - Одежда",
                "0 - Остаток на счету"
        };
        String[] doxodi = {
                "1 - Аванс",
                "2 - З/п",
                "3 - Прочее",
                "0 - Остаток на счету"
        };
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите текущий остаток средств");
        try {
            ostatok = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //если Расходы то b= false
        while (true) {
            System.out.println("Выберите : Расходы или Доходы");
            String viborStr = reader.readLine();
            if (viborStr.equals("Расходы")) {
                rasx(rasxodi, journal, reader);
                showOstatok(journal);
            }
            if (viborStr.equals("Доходы")) {
                dox(doxodi, journal, reader);
                showOstatok(journal);
            }
            if (!viborStr.equals("Доходы") && !viborStr.equals("Расходы"))
                System.out.println("Ты ввел какую-то хуйню. Попробуй заново");
            if (viborStr.equals("Exit"))
                break;
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showOstatok(journal);
    }

    public static void showOstatok(List<String> list) {
        for (String s : list
        ) {
            System.out.println(s);
        }
    }

    public static void dox(String[] doxodi, List<String> journal, BufferedReader reader) throws IOException {
        System.out.println("Введите сумму дохода");
        int plus = 0;

        plus = Integer.parseInt(reader.readLine());

        ostatok += plus;
        System.out.println("Выберите категорию");
        for (String s : doxodi) {
            System.out.println(s);
        }
        int vibor = Integer.parseInt(reader.readLine());
        switch (vibor) {
            case (1):
                journal.add("Аванс +" + plus + " ," + "Остаток " + ostatok);
                break;
            case 2:
                journal.add("З/п +" + plus + " ," + "Остаток " + ostatok);
                break;
            case 3:
                journal.add("Прочее +" + plus + " ," + "Остаток " + ostatok);
                break;
            case 0:
                showOstatok(journal);
                break;
        }
    }

    public static void rasx(String[] rasxodi, List<String> journal, BufferedReader reader) throws IOException {
        System.out.println("Введите сумму расходов");
        int minus = 0;
        minus = Integer.parseInt(reader.readLine());
        ostatok -= minus;
        System.out.println("Выберите категорию");
        for (String s : rasxodi) {
            System.out.println(s);
        }
        int vibor = 0;
        vibor = Integer.parseInt(reader.readLine());
        switch (vibor) {
            case 1:
                journal.add("Еда -" + minus + " ," + "Остаток " + ostatok);
                break;
            case 2:
                journal.add("Бытовая химия -" + minus + " ," + "Остаток " + ostatok);
                break;
            case 3:
                journal.add("Коммуналка -" + minus + " ," + "Остаток " + ostatok);
                break;
            case 4:
                journal.add("Ремонт -" + minus + " ," + "Остаток " + ostatok);
                break;
            case 5:
                journal.add("Игрушки Марку -" + minus + " ," + "Остаток " + ostatok);
                break;
            case 6:
                journal.add("Расходы на авто -" + minus + " ," + "Остаток " + ostatok);
                break;
            case 7:
                journal.add("Одежда -" + minus + " ," + "Остаток " + ostatok);
                break;
            case 0:
                showOstatok(journal);
                break;
        }
    }
}
