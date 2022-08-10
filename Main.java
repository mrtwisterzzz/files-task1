import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> folderList = Arrays.asList(
                new File("/home/aleksey/Рабочий стол/Java курс/Java core/Files/task 1/src/Games"),
                new File("/home/aleksey/Рабочий стол/Java курс/Java core/Files/task 1/src/Games/temp"),
                new File("/home/aleksey/Рабочий стол/Java курс/Java core/Files/task 1/src/Games/src"),
                new File("/home/aleksey/Рабочий стол/Java курс/Java core/Files/task 1/src/Games/res"),
                new File("/home/aleksey/Рабочий стол/Java курс/Java core/Files/task 1/src/Games/savegames"),
                new File("/home/aleksey/Рабочий стол/Java курс/Java core/Files/task 1/src/Games/src/main"),
                new File("/home/aleksey/Рабочий стол/Java курс/Java core/Files/task 1/src/Games/src/test"),
                new File("/home/aleksey/Рабочий стол/Java курс/Java core/Files/task 1/src/Games/res/drawables"),
                new File("/home/aleksey/Рабочий стол/Java курс/Java core/Files/task 1/src/Games/res/vectors"),
                new File("/home/aleksey/Рабочий стол/Java курс/Java core/Files/task 1/src/Games/res/icons")
        );
        List<File> fileList = Arrays.asList(
                new File("/home/aleksey/Рабочий стол/Java курс/Java core/Files/task 1/src/Games/src/main/Main.java"),
                new File("/home/aleksey/Рабочий стол/Java курс/Java core/Files/task 1/src/Games/src/main/Utils.java"),
                new File("/home/aleksey/Рабочий стол/Java курс/Java core/Files/task 1/src/Games/temp/temp.txt")
        );
        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) sb.append("Каталог " + folder + " создан\n");
            else sb.append("Каталог " + folder + " не создан\n");
        });
        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("Файл " + file + " создан\n");
                else sb.append("Файл " + file + " не создан\n");
            } catch (IOException ex) {
                sb.append(ex.getMessage() + '\n');
            }
        });
        try (FileWriter log = new FileWriter("/home/aleksey/Рабочий стол/Java курс/Java core/Files/task 1/src/Games/temp/temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }
        try (BufferedReader br = new BufferedReader(new FileReader("/home/aleksey/Рабочий стол/Java курс/Java core/Files/task 1/src/Games/temp/temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}