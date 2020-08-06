package collegeapp.services;

import java.util.*;

import collegeapp.models.College;

import java.io.*;

public class CollegeService {
	int collegeID;
    String collegeName;
    String courseType;
    String city;
    double fees;
    int pincode;

    CsvFileService csvFileService;
    Scanner sc;

    public void registerNewCollege() {
        sc = new Scanner(System.in);

        System.out.println("Enter college ID: ");
        collegeID = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter college name: ");
        collegeName = sc.nextLine();
        System.out.println("Enter course type: ");
        courseType = sc.nextLine();
        System.out.println("Enter city: ");
        city = sc.nextLine();
        System.out.println("Enter fees: ");
        fees = sc.nextDouble();
        System.out.println("Enter pincode: ");
        pincode = sc.nextInt();

        College collegeObj = new College();

        collegeObj.setCollegeID(collegeID);
        collegeObj.setCollegeName(collegeName);
        collegeObj.setCourseType(courseType);
        collegeObj.setCity(city);
        collegeObj.setFees(fees);
        collegeObj.setPincode(pincode);

        this.csvFileService = new CsvFileService();
        csvFileService.writeToFile(collegeObj);
    }

    public void displayMumbaiEnggColleges() {
        try {
            File csvFile = csvFileService.getCsvFile();

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));

            System.out.println("\n\nDisplay Mumbai Engineering colleges: \n");

            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] C = line.split(",");

                Boolean m1 = false, m2 = false;

                for (String e : C) {
                    if (e.trim().toLowerCase().equals("mumbai")) {
                        m1 = true;
                    }

                    if (e.trim().toLowerCase().equals("engineering")) {
                        m2 = true;
                    }

                    if (m1 && m2) {
                        System.out.println(C[0] + ", " + C[1] + ", " + C[2] + ", " + C[3] + ", " + C[4] + ", " + C[5]);
                        break;
                    }
                }
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeCollegeById() {
        System.out.println("\n\nEnter college ID to remove: ");
        sc.nextLine();
        String ID = sc.nextLine();

        try {
            File csvFile = csvFileService.getCsvFile();
            File tempCsv = new File("temp.csv");

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempCsv, true));

            String line = null;

            while ((line = reader.readLine()) != null) {
                if(!line.startsWith(ID)) {
                    writer.write(line + "\n");
                }
            }

            reader.close();
            writer.close();
            csvFile.delete();
            tempCsv.renameTo(csvFile);
            tempCsv.delete();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class CsvFileService {
    private File csvFile;
    private FileWriter fileWriter;
    private BufferedWriter writer;

    public CsvFileService() {
        try {
            this.csvFile = new File("colleges.csv");
            this.fileWriter = new FileWriter(csvFile, true);
            this.writer = new BufferedWriter(fileWriter);

            writer.write("111, K.J. Somaiya College, Engineering, Mumbai, 10000, 400077\n");
            writer.write("222, Dr. Vasantrao Pawar College, Medical, Nashik, 20000, 422207\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(College co) {
        try {
            writer.write(co.getCollegeID() + ", " + co.getCollegeName() + ", " + co.getCourseType() + ", "
                    + co.getCity() + ", " + co.getFees() + ", " + co.getPincode());
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getCsvFile() {
        return csvFile;
    }
}