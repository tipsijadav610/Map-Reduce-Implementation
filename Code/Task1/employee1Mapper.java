package lab02.emp1;

import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class employee1Mapper extends Mapper<LongWritable, Text, NullWritable, Text> {

public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
	
	String splitBy = ",";
	String line = value.toString();
	
	String[] temp = line.split(splitBy);
	int cond = Integer.parseInt(temp[4]);
	
	if(cond > 30000){
		String final_output = "";
		final_output = temp[0] + ", " + temp[1] + ", " + temp[3];
		context.write(NullWritable.get(), new Text(final_output));
	}
}
}
