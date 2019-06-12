package com.piggymetrics.notification.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-06-08 18:17
 **/
@FeignClient(name = "account-service") // 使用@FeignClient为本应用声明一个简单的能调用的客户端
public interface AccountServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountName}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String getAccount(@PathVariable("accountName") String accountName);

}
