package collegeapp;

import collegeapp.services.CollegeService;

public class Main {
	public static void main(String args[]) {
        CollegeService collegeService = new CollegeService();
        collegeService.registerNewCollege();
        collegeService.displayMumbaiEnggColleges();
        collegeService.removeCollegeById();
    }
}
