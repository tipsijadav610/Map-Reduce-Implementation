package lab02.emp2;

import java.io.IOException;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;

public class employee2Reducer extends Reducer<Text, Text, Text, Text>{
	public void reduce(Text key, Iterable<Text> values, Context c) throws IOException,InterruptedException{
		
		int a;
		int minVal,maxVal;
		float avgVal;
		int n;
		
		minVal = Integer.MAX_VALUE;
		maxVal = Integer.MIN_VALUE;
		avgVal = 0;
		n = 0;
		for (Text value : values){
			a = Integer.parseInt(value.toString());
			minVal = Math.min(minVal, a);
			maxVal = Math.max(maxVal, a);
			avgVal += a;
			n += 1;
			
	     }
		avgVal = avgVal/n;
		
		String final_ouput = "";
		final_ouput = String.valueOf(minVal) + ", " + String.valueOf(avgVal) + ", " + String.valueOf(maxVal);
		c.write(key, new Text(final_ouput));
	}
}