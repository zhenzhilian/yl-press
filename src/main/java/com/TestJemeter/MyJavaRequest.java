//package com.TestJemeter;
//import org.apache.jmeter.config.Arguments;
//import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
//import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
//import org.apache.jmeter.samplers.SampleResult;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.Serializable;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//
//public class MyJavaRequest extends AbstractJavaSamplerClient implements Serializable {
//    private static final long serialVersionUID = 1L;
//
//    private String sUrl;//存储用户输出的url
//
//    private static final String URL_NAME="URL" ;//设置GUI页面显示的变量名称
//    //设置GUI页面默认显示的变量值,默认值就是访问百度
//    private static final String URLVALUE_DEFAULT="http://www.baidu.com";
//    //resultData变量用来存储响应的数据，目的是显示到查看结果树中。
//    private String resultData;
//
//    StringBuilder sbResultData = new StringBuilder();
//
//    /*
//     * 这个方法用来控制显示在GUI页面的属性，由用户来进行设置。
//     * 此方法不用调用，是一个与生命周期相关的方法，类加载则运行。
//     * (non-Javadoc)
//     * @see org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient#getDefaultParameters()
//     */
//    @Override
//    public Arguments getDefaultParameters() {
//        Arguments arguments = new Arguments();
//        arguments.addArgument(URL_NAME, String.valueOf(URLVALUE_DEFAULT));
//        return arguments;
//    }
//
//
//
//    @Override
//    public void setupTest(JavaSamplerContext context) {
//        sUrl = context.getParameter(URL_NAME, URLVALUE_DEFAULT);
//        if(sUrl.length()==0){
//            sUrl="http://www.baidu.com";//假如用户没有设置url，那么就让他访问百度，哈哈。
//        }
//
//    }
//
//    @Override
//    public SampleResult runTest(JavaSamplerContext context) {
//
//
//        /*
//         * SampleResult这个类是用来将测试结果输出到查看结果树中的。
//         * 并且也是用来控制事务的开始和结束的。
//         */
//        SampleResult results = new SampleResult();
//        results.setSampleLabel("测试"+sUrl+"网站访问速度了啊！！");
//
//        try{
//
//            URL url = new URL(sUrl);
//            URLConnection conn = url.openConnection();
//            InputStream in = conn.getInputStream();
//
//            byte[] buffer = new byte[1024];
//            int len;
//            //事务开始标记
//            results.sampleStart();
//            while((len=in.read(buffer))!=-1){
//                resultData =  new String(buffer,"UTF-8");//将每次读到的页面返回信息存储到resultData中
//                sbResultData.append(resultData);//每读到一次，添加到sb中。
//
//            }
//            in.close();
//
//        }catch (MalformedURLException e) {
//            results.setSuccessful(false);
//            e.printStackTrace();
//        }catch (IOException e) {
//            results.setSuccessful(false);
//            e.printStackTrace();
//        }catch(Exception e){//如果发生异常，则捕捉，并且发送事务失败的消息。
//            results.setSuccessful(false);
//            e.printStackTrace();
//        }finally{
//            //标记事务结束
//            results.sampleEnd();
//        }
//
//        results.setSuccessful(true);
//        resultData = sbResultData.toString();//将所有读到的数据转换为字符串
//        results.setResponseData(resultData,null);//将数据打印到查看结果树当中
//        results.setDataType(SampleResult.TEXT);
//        return results;
//    }
//}
