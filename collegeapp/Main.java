package collegeapp;

import java.util.*;
import collegeapp.services.CollegeService;

class Main {
    public static void main(String args[]) {
        CollegeService collegeService = new CollegeService();
        collegeService.registerNewCollege();
        collegeService.displayMumbaiEnggColleges();
        collegeService.removeCollegeById();
    }
}