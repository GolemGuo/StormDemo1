import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.testing.TestWordSpout;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;

/**
 * Created by guo_l on 2016/3/31.
 */

public class Main {
    public static void main(String[] args)
    {
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("words",new TestWordSpout(),10);
        builder.setBolt("exclaim1",new ExclamationBolt(),3).shuffleGrouping("words");
        builder.setBolt("exclain2",new ExclamationBolt(),2).shuffleGrouping("exclaim1");

    }
}
