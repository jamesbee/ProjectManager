import com.jamstudio.TCPtalker.Talker;
import com.jamstudio.util.JSonUtil;
import com.jamstudio.util.SampleLogger;
import com.pm.Data.RequestInfo;

import java.util.Date;
import java.util.Map;


public class TestJson{

    public static void main(String[] args){
        Talker tk = new Talker();
        String data = tk.QueryByJSON(new RequestInfo().toJsonString());
        SampleLogger.LogAsOK(data);
    }
}

// =================================s
class SampleData {
    public Date     time1    = null;
    public Date     time2    = null;
    public Integer  qId     = null;
    public SampleData(){
        time1 = new Date();
        time2 = new Date();
        qId   = 0;
    }

    @Override
    public String toString() {
        return "SampleData{" +
                "time1=" + time1 +
                ", time2=" + time2 +
                ", qId=" + qId +
                '}';
    }
}