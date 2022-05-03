import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String baseDirPath = "C:\\Users\\frnkt\\Desktop\\Репозитории для гита\\Games\\";

        String[] directoriesofGames = {"src", "res", "savegames", "temp" };
        String[] directoriesofSrc = {"main", "test" };
        String[] filesofMain = {"Main.java", "Utils.java" };
        String[] directoriesofRes = {"drawables", "vectors", "icons" };
        String[] filesofTemp = {"temp.txt" };

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < directoriesofGames.length; i++) {
            String fullPath = baseDirPath + directoriesofGames[i];
            File dir = new File(fullPath);
            String message = "";
            if (dir.mkdir()) {
                message = "Каталог \"" + fullPath + "\" создан";
            } else {
                message = "Ошибка при создании каталога \"" + fullPath + "\"";
            }
            System.out.println(message);
            sb.append(message + "\n");
        }

        File src = new File(baseDirPath + directoriesofGames[0]);
        if (src.isDirectory()) {
            for (int i = 0; i < directoriesofSrc.length; i++) {
                String fullPath = baseDirPath + directoriesofGames[0] + "\\" + directoriesofSrc[i];
                File dir = new File(fullPath);
                String message = "";
                if (dir.mkdir()) {
                    message = "Каталог \"" + fullPath + "\" создан";
                } else {
                    message = "Ошибка при создании каталога \"" + fullPath + "\"";
                }
                System.out.println(message);
                sb.append(message + "\n");
            }
        }

        File res = new File(baseDirPath + directoriesofGames[1]);
        if (res.isDirectory()) {
            for (int i = 0; i < directoriesofRes.length; i++) {
                String fullPath = baseDirPath + directoriesofGames[1] + "\\" + directoriesofRes[i];
                File dir = new File(fullPath);
                String message = "";
                if (dir.mkdir()) {
                    message = "Каталог \"" + fullPath + "\" создан";
                } else {
                    message = "Ошибка при создании каталога \"" + fullPath + "\"";
                }
                System.out.println(message);
                sb.append(message + "\n");
            }
        }

        String fullDirectoryMainPath = baseDirPath + directoriesofGames[0] + "\\" + directoriesofSrc[0] + "\\";
        for (int i = 0; i < filesofMain.length; i++) {
            String message = "";
            String fullMainFileName = fullDirectoryMainPath + filesofMain[i];
            File myFile = new File(fullMainFileName);
            try {
                if (myFile.createNewFile())
                    message = "Файл \"" + fullMainFileName + "\" создан";
            } catch (IOException ex) {
                message = ex.getMessage();
            } finally {
                System.out.println(message);
                sb.append(message + "\n");
            }
        }

        String fullDirectoryTempPath = baseDirPath + directoriesofGames[3] + "\\";
        for (int i = 0; i < filesofTemp.length; i++) {
            String message = "";
            String fullFileTempName = fullDirectoryTempPath + filesofTemp[i];
            File myFile = new File(fullFileTempName);
            try {
                if (myFile.createNewFile())
                    message = "Файл \"" + fullFileTempName + "\" создан";
            } catch (IOException ex) {
                message = ex.getMessage();
            } finally {
                System.out.println(message);
                sb.append(message + "\n");
            }
        }

        String tempFileForLog = baseDirPath + directoriesofGames[3] + "\\" + filesofTemp[0];

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFileForLog))) {
            String log = sb.toString();
            String text = log;
            bw.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage(
            ));
        }
    }
}