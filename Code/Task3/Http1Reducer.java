package lab02.http1;

import java.io.IOException;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;

public class Http1Reducer extends Reducer<Text, Text, Text, Text>{
	public void reduce(Text key, Iterable<Text> values, Context c) throws IOException,InterruptedException{
		
		int sum1, sum2;
		
		sum1 = 0;
		sum2 = 0;
		for (Text value : values){	
			String temp = value.toString();
			
			sum1 += 1;
			sum2 += Integer.parseInt(temp);
	     }
		
		String final_ouput = " ";
		final_ouput = String.valueOf(sum1) + ", " + String.valueOf(sum2);
		c.write(key, new Text(final_ouput));
	}
}