package org.csu.mypetstore.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016103000778511";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCawN+Bg+7Nn1wloLC5uAzZ+Zv0s3BkxbCLKxBehBvdImTpCyXtOw03mbUtFp1XKOqcXo+yuxYphYwr0MI3Kj8EJRemHfvRVEKA5gkSOZ3Ki2+IUl0ttJf8T8TSwf1JaGKfBkCEFWeNRdm5SnPEZKNzvT/Y5JyqqaNoHRrGUT6yMsJQFZtBs+G3REqDh4kniHV0NaeLlm/FlKMrBKD8gSe3n0CDzjvHBvtvpQS0WxjGP2mZ2z4lGxPBcNm+V1eFV4wTtZZheq8piXUDY+jF95fLBdf8dIO1Aciw1ZkJ9yBCFLQjy5BTNRyIf9hOrSqN14SOfoytqoD7dxPSRxwmVTGbAgMBAAECggEAOUCd79aVpLEOcEVQ3ITBDGuSTSeNr1qMBBC8j5ski91LpAQh1fCA5U8Sfkndj/9tPMinNSKOAnKL9zHWiH4yrh/i7ewt27XmnLV+KaXzQJnxe2etXVlw2UHRuX9Xa68YvWicucEJfHSZJjnrNn9dEVa0plN9uo3kDIKoAzLPlTEo32TeXemvVLPQtCZPnIAYbvYEV6hi2G7VmPaiIUTlClSoy/z4FZKw5u0wYYZiDQVTxv9fdopwMdot0GxQ8b4C/xrMj4wl0EaYwc9Rixja1Up0HMQiwwM+Hg6xn5os0a+x+SUjneyAIraRL3yw4k8LvvSbK3q7IHNCAkR1I5qyEQKBgQDrkay199uAcVF0GHI3/d88Jm1sc8PHxorSkHA57vgAMDmGXNDPx7eD3119V20aP6mdVQ3Wthw1/aMoAuBvy6D7F3Hn3NaWyn5ljuSuBWdIxX4G/S5n+q9uzp83nMdzNoWdKXbfxjmz5W68tDTq5jWXZPZpAslII/gEKf9E3Q0nlQKBgQCoLNqSBC4Z9RneKybYuX3BZBkS2QN5IRUHEQAxVSHeUyhJRpVQml0PsZRsMvvEVXlNhZOqZWjYGjsgIAAmhsTlnC9JTR4CfVzbNSVB3Tx5soGoFLRy8xV1jdzuzQm0DrMunrFifdGjj7diHLLoTgjJQ3WpJXxG5KXpUGiJQjrobwKBgACt6d6YeWSUbxSzoVix/bvRrI0chFsGIo5a5kf0fXiaqv/NMrj2rXvO4BklcGYb+uQ+Q4zz937cXWUXJQiNgMhYl/aAN4o1yUmHsPcjgtm94BArGMAqA+mA5QqnBBg79wSuAu7ARphTOA+JQYHP6iWmn+NLo8L2f5ebe2X6cThFAoGAR77y9C4yWMKW6ZAxP25K9xE0HTVV5Pw3E0+ubF1sWIPTgQdKthtUrlhNAKfzfrwURv1AlQY0Z1UxejAMwGLoZyhth/ENZ3SCA8a1gVbX8Pc1lzZWEWAg/IisA3iXtig7Sx1KgcE5iXTLgGDL9o0r9GkCLkoercPoABRctIn7xaMCgYEAjx+pZH1swOJRXTvnHMwqSRcVcuhsJgv+fMAz+r2t5oI5VscibOctT15qLdAMbz3jPbWO/8xLiZ5XByL4QAKWpUt4w9PSwwhwjZGE1FjhQl8NcUNO0uxyDvstr1mM5F6m6x7BbRixDSNLMyrjuPTScpW1MFqJQ64yE0NYfvbqoF4=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgblCIF0NmdVAVvW/IoAX3+D6wmbSLceeD4/qekLM0ZOlFrGN4kVLfAAth5X4+x448WvTHSgOxxTdTYgYFIgO1a6vRUgiUVAQnVKAdpQuQrp2328V+IkBbf8zGPRnsGjtsCGzdbBYU9OiKhrnWkCVhRHdMiKfis1dQPi1IHBH2m6M7n3UD/F3XX6jSly1x6mz4k6/5KClQYJvqSFifKZ7TXq1PuOIMXWxAcv919y1j7z/oW/UBTsT8jfIonWd0GyUULF0GNxMfI7YpIcIgG6zvp/xoDrldA4G8y8boVmFWEt61GV7/0/XJQMBYtYxhSRLSyMFaVeMB6e2/vxjJ1M1GwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://free.idcfengye.com/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://free.idcfengye.com/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

