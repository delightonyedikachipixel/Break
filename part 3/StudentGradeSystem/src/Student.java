 class Student {
   private  String studentName;
     private int[] scores;
     private int total;
     private double average;
     private int position;
     private int numberOfSubjects;
public Student (String studentName, int[]scores){

    this.studentName = studentName;
    this.scores = new int [numberOfSubjects] ;

}
     public void setScore(int subjectIndex, int score) {
         scores[subjectIndex] = score;
     }
     public int getScore(int subjectIndex) {
         return scores[subjectIndex];
     }

     public void calculateTotalAndAverage() {
         total = 0;
         for (int score : scores) {
             total += score;
         }
         average = (double) total / scores.length;
     }

     public int getTotal()        {
        return total;
}
     public double getAverage()   {
        return average;
}
     public String getName()      {
        return name;
}
     public int getPosition()     {
        return position;
}
     public void setPosition(int position) {
    this.position = position;
}
     public int getNumberSubjects()  {
    return scores.length;
}
 }

