package lab02.emp2;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class employee2Mapper extends Mapper<LongWritable, Text, Text, Text> {
public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
	String splitBy = ",";
	String line = value.toString();
	
	String[] temp = line.split(splitBy);
	
	context.write(new Text(temp[6]), new Text(temp[4]));
}
}