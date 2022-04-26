import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static final String INSTALL_PATH = "E:\\Games\\";

    public static void main(String[] args) {
        String[][] installSteps = {
                {"src", "res", "savegames", "temp"},
                {"src\\main", "src\\test"},
                {"src\\main\\Main.java", "src\\main\\Utils.java"},
                {"res\\drawables", "res\\vectors", "res\\icons"},
                {"temp\\temp.txt"}
        };
        StringBuilder log = new StringBuilder();
        for (String[] step : installSteps) {
            for (String file : step) {
                log.append(install(file)).append("\n");
            }
        }
        try (FileWriter fileWriter = new FileWriter(INSTALL_PATH + "temp/temp.txt", true)) {
            fileWriter.append(log);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String install(String path) {
        boolean result;
        File file = new File(INSTALL_PATH + path);
        String log;
        if (path.contains(".")) {
            log = "Файл " + path;
            try {
                result = file.createNewFile();
            } catch (IOException e) {
                result = false;
            }
        } else {
            log = "Каталог " + path;
            result = file.mkdir();
        }
        return result ? log + " создан успешно" : " не создан";
    }

}
