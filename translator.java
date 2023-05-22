import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import java.util.Scanner;

public class TranslationApp {

    public static void main(String[] args) {
        Translate translate = TranslateOptions.getDefaultInstance().getService();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the text to translate (or 'q' to quit): ");
            String text = scanner.nextLine();

            if (text.equals("q")) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter the target language (e.g., 'en' for English): ");
            String targetLanguage = scanner.nextLine();

            Translation translation = translate.translate(text, Translate.TranslateOption.targetLanguage(targetLanguage));

            System.out.println("Translation: " + translation.getTranslatedText());
            System.out.println("--------------------");
        }

        scanner.close();
    }
}
