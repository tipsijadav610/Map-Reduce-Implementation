package lab02.http1;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Http1Mapper extends Mapper<LongWritable, Text, Text, Text> {
public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
	
	String request = value.toString();
	
	String temp1 = request.split(" ")[3];
	String year_months = temp1.substring(4, 12);
	
	String temp2 = request.split(" ")[9]; 
	
	if(!(temp2.equals("-"))){
		String value_of_key = temp2;
		context.write(new Text(year_months), new Text(value_of_key));
	}
}
}