/**
 * CountWordsInFile.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 14-May-2023 22:41
 */

package egorov.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

/*Напишите программу на Java для чтения содержимого текстового файла
        и подсчета количества слов в каждой строке.
        Однако, программа должна быть написана с использованием обработки исключений,
        чтобы обрабатывать ошибки, связанные с открытием файла,
        чтением содержимого файла и любыми другими исключениями,
        которые могут возникнуть при выполнении программы.
        В случае возникновения исключения, программа должна выводить
        соответствующее сообщение об ошибке и продолжать работу с другими строками файла.*/
public class CountWordsInFile {

    // чтение файла посимвольно
    public static void readFile() {
        // читает файл в корневой папке проекта C:\java\projects\javapro
        String fileName = "file2.txt";
        FileReader fReader = null;
        try {
            fReader = new FileReader(fileName);
        } catch (FileNotFoundException ex) {
            try {
                if (fReader != null) {
                    fReader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file '" + fileName + "'");
            }
            System.out.println("File '" + fileName + "' not found.");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        // читаем посимвольно
        int c = 0;
        int wordsNumber = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                c = fReader.read();
            } catch (IOException e) {
                System.out.println("Error reading line");
            }
            if (c != 13 && c != 10 && c != -1) {
                sb.append((char) c);
            }
            if (c == 10 || c == -1) {
                System.out.println(sb + " : " + sb.toString().split("\\s").length);
                sb = new StringBuilder();
            }
            if (c == -1) {
                break;
            }
        }


    }

    // вариант чтения файла стримами
    public static synchronized void readFileStream(String filePath) {
        try {
            Files
                    .lines(Paths.get(filePath), StandardCharsets.UTF_8)

                    .forEach(x -> System.out.println(x + ":" + x.split("\\s").length));

        } catch (FileNotFoundException e) {
            System.out.println("File '" + filePath + "' not found.");
        } catch (IOException e) {
            System.out.println("Error reading file '" + filePath + "'");
        }
    }

    public static void main(String[] args) {
        //readFile();
        readFileStream("file.txt");

    }

}
