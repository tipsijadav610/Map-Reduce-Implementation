package lab02.http2;

import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Http2Mapper extends Mapper<LongWritable, Text, NullWritable, Text> {

public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
	
	String request = value.toString();
	
	String cond = request.split(" ")[8];
	String temp1 = request.split(" ")[3];
	String temp2 = request.split(" ")[6];
	
	if (cond.equals("404")){
		String value_of_key = "";	
		value_of_key = temp1.substring(1) + ", " + temp2;
		context.write(NullWritable.get(), new Text(value_of_key));
	}
}
}
