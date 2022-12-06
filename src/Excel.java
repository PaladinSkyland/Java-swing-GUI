
import java.util.*;
import java.util.List;

    public class Excel {
        private ArrayList<Double> list = new ArrayList<>();
        private ArrayList<Double> numbers = new ArrayList<>();

        public Excel(ArrayList<Double> list){
            this.list = list;
        }

        public Excel(String stringofnumber) {

            String[] strNumArray = stringofnumber.trim().split(" +");

            List<String> strNumList = Arrays.asList(strNumArray);

            ArrayList<String> strNumArrayList = new ArrayList<>(strNumList);

            ArrayList<Double> number = new ArrayList<>();
            this.numbers=number;
            strNumArrayList.forEach(i->{
                try {
                    number.add(Double.parseDouble(i));
                }catch (NumberFormatException error){}
            });
        }

        public Double findTotal(){
            double sum = 0;
            for(Double d : numbers)
                sum += d;
            return sum;
        }
        public Double findAvg(){
            double avg = 0;
            for(Double d : numbers)
                avg += d;
            return avg/numbers.size();
        }
        public Double findMax(){
            double Max = numbers.get(0);
            for(Double d : numbers) {
                if (Max < d) Max = d;
            }
            return Max;
        }

        public Double findMin(){
            double Min = numbers.get(0);
            for(Double d : numbers) {
                if (Min > d) Min = d;
            }
            return Min;
        }
}
