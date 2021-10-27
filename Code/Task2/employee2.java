package lab02.emp2;

import java.io.IOException;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.conf.Configuration;

public class employee2{

	public static void main(String[] args) throws Exception,IOException {
		Configuration conf = new Configuration();
		Job job=Job.getInstance(conf,"Map reduce job");
		
		job.setJarByClass(employee2.class);
		job.setMapperClass(employee2Mapper.class);
		job.setReducerClass(employee2Reducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		Path outpath=new Path(args[1]);
		FileInputFormat.addInputPath(job,new Path(args[0]));
		FileOutputFormat.setOutputPath(job,outpath);
		
		outpath.getFileSystem(conf).delete(outpath,true);
		System.exit(job.waitForCompletion(true)?0:1);
	}
}