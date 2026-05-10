 class Classroom {

         private Student[] students;
         private int numberOfSubjects;

         public Classroom(int numberOfStudents, int numberOfSubjects) {
             this.numberOfSubjects = numberOfSubjects;
             students = new Student[numberOfStudents];
             for (int count = 0; count < numberOfStudents; count++) {
                 students[count] = new Student("Student " + (count + 1), numberOfSubjects);
             }
         }

         public Student getStudent(int index) {
             return students[index];
         }

         public int getNumberStudents() {
             return students.length;
         }
         public int getNumberSubjects() {
             return numberOfSubjects;
         }

         public void processResults() {
             for (Student student : students) {
                 student.calculateTotalAndAverage();
             }
             assignPositions();
         }

         private void assignPositions() {
             int number = students.length;
             int[] ranks = new int[number];
             for (int count = 0; count < number; count++) {
                 int rank = 1;
                 for (int counter = 0; counter < number; counter++) {
                     if (students[counter].getTotal() > students[count].getTotal()) {
                         rank++;
                     }
                 }
                 students[count].setPosition(rank);
             }
         }

         public void printClassTable() {
             System.out.println("======================================================================================================");
             System.out.printf("%-14s", "STUDENT");
             for (int counter = 1; counter <= numberOfSubjects; counter++) {
                 System.out.printf("%-10s", "SUBJECT" + counter);
             }
             System.out.printf("%-6s%-8s%-5s%n", "TOTAL", "AVERAGE", "POS");
             System.out.println("=====================================================================================================");

             for (Student student : students) {
                 System.out.printf("%-12s", student.getName());
                 for (int counter = 0; counter < numberOfSubjects; counter++) {
                     System.out.printf("%-12d", student.getScore(counter));
                 }
                 System.out.printf("%-6d%-8.2f%-5d%n",
                         student.getTotal(), student.getAverage(), student.getPosition());
             }
             System.out.println("=======================================================================================================");
         }

         public void printSubjectSummary() {
             System.out.println("\nSUBJECT SUMMARY");
             for (int counter = 0; counter < numberOfSubjects; counter++) {
                 int highest = -1, lowest = 101, total = 0, passes = 0, fails = 0;
                 Student highStudent = null, lowStudent = null;

                 for (Student student : students) {
                     int score = student.getScore(counter);
                     total += score;
                     if (score > highest) { highest = score; highStudent = student; }
                     if (score < lowest)  { lowest  = score; lowStudent  = student; }
                     if (score >= 50) passes++; else fails++;
                 }

                 System.out.println("\nSubject " + (counter + 1));
                 System.out.println("Highest scoring student is: "
                         + highStudent.getName() + " scoring " + highest);
                 System.out.println("Lowest Scoring student is: "
                         + lowStudent.getName() + " scoring " + lowest);
                 System.out.println("Total Score is: " + total);
                 System.out.printf("Average score is: %.2f%n", (double) total / students.length);
                 System.out.println("Number of passes: " + passes);
                 System.out.println("Number of Fails: " + fails);
             }
         }

         public void printClassSummary() {
             Student best = students[0], worst = students[0];
             int classTotal = 0;

             for (Student student : students) {
                 classTotal += student.getTotal();
                 if (student.getTotal() > best.getTotal())  best  = student;
                 if (student.getTotal() < worst.getTotal()) worst = student;
             }

             System.out.println("\n" + "==========================================================================================");
             System.out.println("CLASS SUMMARY");
             System.out.println("===================================================================================================");
             System.out.println("Best Graduating Student is: "
                     + best.getName() + " scoring " + best.getTotal());
             System.out.println("=========================================================================================================");
             System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
             System.out.println("Worst Graduating Student is: "
                     + worst.getName() + " scoring " + worst.getTotal());
             System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
             System.out.println("=========================================================================================================");
             System.out.println("Class total score is: " + classTotal);
             System.out.printf("Class Average score is: %.1f%n",
                     (double) classTotal / students.length);
             System.out.println("=====================================================================================================");
         }
     }

