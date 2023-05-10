import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите URL: ");
        String url = scanner.nextLine();
        String file = "links.txt";

        try {
            Document doc = Jsoup.connect(url).get();

            Elements links = doc.select("a[href]");

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            int count = 1;

            for (Element link : links) {
                String href = link.attr("abs:href");
                writer.write(count + ") " + href);
                writer.newLine();
                count++;
            }

            writer.close();
            System.out.println("Данные успешно записаны в файл " + file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
