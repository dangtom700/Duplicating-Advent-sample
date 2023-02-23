package DuplicateSample_Calendar;

import java.time.LocalDate;
import java.util.Scanner;
import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AdventTemplateDup {
    private static final ArrayList<String> CollectSampleFiles(){
        Scanner scanFile= new Scanner(System.in);
        ArrayList<String> sampleFileList = new ArrayList<String>(3);
        System.out.println("Enter the name of all input files:");
        String sampleFileInput=scanFile.nextLine();
        while(sampleFileInput.length()!=0){
            sampleFileList.add(sampleFileInput);
            sampleFileInput=scanFile.nextLine();
        }
        scanFile.close();
        return sampleFileList;
    }
    private static final String[] getTails(final ArrayList<String> sampleFileList){
        String [] tails = new String[sampleFileList.size()];
        for(int i=0; i<sampleFileList.size(); i++){
            tails[i]=sampleFileList.get(i).substring(sampleFileList.get(i).lastIndexOf(".") + 1);
        }
        return tails;
    }
    public static void main(String[] args){
        final int currentYear = LocalDate.now().getYear();
        final String mainRoot="RootAndRoot";
        final ArrayList<String> sampleFileList=CollectSampleFiles();
        final String[] tails=getTails(sampleFileList);
        //create directories
        CalendarGenerator.DupplicateAllCalendars(currentYear, mainRoot, tails, sampleFileList);
    }
}
class CalendarGenerator{
    public static void DupplicateAllCalendars(final int currentYear, final String mainRoot, 
                                            final String[] tails, final ArrayList<String> SampleFiles){
        for(int year=2015; year<=currentYear; year++){
            String level1="Advent_of_code_"+String.valueOf(year);
            File dir1=new File(mainRoot+File.separator+level1);
            FileGenerator.CreateFolder(dir1);
            for(int date=1; date<=25; date++){
                String level2=level1+"_"+String.valueOf(date);
                File dir2=new File(mainRoot+File.separator+level1+File.separator+level2);
                FileGenerator.CreateFolder(dir2);
                for(int i=0; i<tails.length; i++){
                    String file1=level2+"_output."+tails[i];
                    FileGenerator.DuplicateFileInDirectories(SampleFiles.get(i),level1,level2,mainRoot,file1);
                    String file2=level2+"PuzzleInput.txt";
                    FileGenerator.CreateFile(mainRoot, level1, level2, file2);
                }
            }
        }
    }
    public static void DuplicateOneCalendar(final int year, final String mainRoot, 
                                            final String[] tails, final ArrayList<String> SampleFiles){
        String level1="Advent_of_code_"+String.valueOf(year);
        File dir1=new File(mainRoot+File.separator+level1);
        FileGenerator.CreateFolder(dir1);
        for(int date=1; date<=25; date++){
            String level2=level1+"_"+String.valueOf(date);
            File dir2=new File(mainRoot+File.separator+level1+File.separator+level2);
            FileGenerator.CreateFolder(dir2);
            for(int i=0; i<tails.length; i++){
                String file1=level2+"_output."+tails[i];
                FileGenerator.DuplicateFileInDirectories(SampleFiles.get(i),level1,level2,mainRoot,file1);
                String file2=level2+"PuzzleInput.txt";
                FileGenerator.CreateFile(mainRoot, level1, level2, file2);
            }
        }                                               
    }
}
class FileGenerator{
    public static void CreateFile(final String mainRoot, final String level1, final String level2, final String fileName){
        File ParentFile=new File(mainRoot+File.separator+level1+File.separator+level2);
        File file = new File(ParentFile, fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
        System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }
    public static void CreateFolder(final File directory) {
        if (!directory.exists()) {
            directory.mkdir();
        }
    }
    public static void DuplicateFileInDirectories(final String sourceFile, final String DirLevel1, final String DirLevel2, 
                                                final String mainRoot,final String filename){
        try {
            Path source = Paths.get(sourceFile);
            Path destination = Paths.get(mainRoot+"/"+DirLevel1+"/"+DirLevel2+"/"+filename);
            Files.copy(source, destination);
            System.out.println("File duplicated successfully.");
        } catch (IOException e) {
            System.out.println("Error duplicating file: " + e.getMessage());
        }
    }
}