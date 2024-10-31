package examples.um_futures.account;

import com.binance.connector.futures.client.exceptions.BinanceClientException;
import com.binance.connector.futures.client.exceptions.BinanceConnectorException;
import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import examples.PrivateConfig;
import java.util.LinkedHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CurrentAllOpenOrders {
    private CurrentAllOpenOrders() {
    }

    private static final Logger logger = LoggerFactory.getLogger(CurrentAllOpenOrders.class);
    public static void main(String[] args) {
        // 创建一个LinkedHashMap对象，用于存储请求参数
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

        // 创建一个UMFuturesClientImpl对象，用于与Binance API进行交互
        UMFuturesClientImpl client = new UMFuturesClientImpl(PrivateConfig.TESTNET_API_KEY, PrivateConfig.TESTNET_SECRET_KEY, PrivateConfig.TESTNET_BASE_URL);

        try {
            // 调用currentAllOpenOrders方法获取当前所有未完成的订单，并将结果存储在result变量中
            String result = client.account().currentAllOpenOrders(parameters);
            // 打印结果
            logger.info(result);
        } catch (BinanceConnectorException e) {
            // 处理BinanceConnectorException异常
            logger.error("fullErrMessage: {}", e.getMessage(), e);
        } catch (BinanceClientException e) {
            // 处理BinanceClientException异常
            logger.error("fullErrMessage: {} \nerrMessage: {} \nerrCode: {} \nHTTPStatusCode: {}",
                    e.getMessage(), e.getErrMsg(), e.getErrorCode(), e.getHttpStatusCode(), e);
        }
    }
}
