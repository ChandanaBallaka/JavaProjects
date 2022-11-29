package testing;

public class Grade {
    public char determineGrade(int number){

        if(number<60){
            return 'F';
        }
        else if(number<70){
            return 'E';
        }
        else if(number<80){
            return 'D';
        }
        else{
            return 'A';
        }
    }
}
